/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.oodt.opendapps;

//JDK imports
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//OPeNDAP/THREDDS imports
import opendap.dap.DConnect;

//APACHE imports
import org.apache.oodt.cas.metadata.Metadata;
import org.apache.oodt.opendapps.config.DapRoot;
import org.apache.oodt.opendapps.config.OpendapConfig;
import org.apache.oodt.opendapps.config.OpendapConfigReader;
import org.apache.oodt.opendapps.util.ProfileUtils;
import org.apache.oodt.profile.Profile;
import org.apache.oodt.profile.ProfileException;
import org.apache.oodt.profile.handlers.ProfileHandler;
import org.apache.oodt.xmlquery.XMLQuery;

/**
 * 
 * 
 * A generic reusable OODT {@link ProfileHandler} for use in extracting metadata
 * from OPeNDAP and THREDDS-accessible datasets.
 * 
 */
public class OpendapProfileHandler implements ProfileHandler {

  private static final String PROFILE_HANDLER_ID = "OODT OPeNDAP Profile Handler";

  private static Logger LOG = Logger.getLogger(OpendapProfileHandler.class
      .getName());

  private OpendapConfig conf;

  public OpendapProfileHandler(){
  }

  public List<Profile> findProfiles(XMLQuery xmlQuery) throws ProfileException {
    String configFileLoc = null;
    String q = xmlQuery.getKwdQueryString();
    if (q.contains("ConfigUrl=")){
    	Pattern parameterPattern = Pattern.compile("ConfigUrl=(.+?)( .*)?$");
    	Matcher fileMatch = parameterPattern.matcher(q);
    	while (fileMatch.find()) {
    		configFileLoc = fileMatch.group(1);
    	}
    } else {
    	configFileLoc = System.getProperty("org.apache.oodt.opendap.config.filePath");
    }
    
    if (configFileLoc.isEmpty()){
    	throw new ProfileException(
    		"Configuration file not found. Please specify in System property opendap.config.filePath or as URL parameter ConfigUrl");
    } else {
    	try {
    		this.conf = OpendapConfigReader.read(configFileLoc);
    	} catch (FileNotFoundException e) {
    		throw new ProfileException("FileNotFoundException: File not found!");
    	} catch (MalformedURLException e) {
    		throw new ProfileException("MalformedURLException: please fix file URL");
    	}
    }
    
    List<Profile> profiles = new Vector<Profile>();
    List<DapRoot> roots = this.conf.getRoots();
	  
    for (DapRoot root : roots) {
      DatasetExtractor d = new DatasetExtractor(xmlQuery, root.getCatalogUrl()
          .toExternalForm(), root.getDatasetUrl().toExternalForm());
      if (d.getDapUrls() != null) {
        for (String opendapUrl : d.getDapUrls()) {
          Profile profile = new Profile();
          DConnect dConn = null;
          try {
            dConn = new DConnect(opendapUrl, true);
          } catch (FileNotFoundException e) {
            LOG.log(Level.WARNING, "Opendap URL not found: [" + opendapUrl
                + "]: Message: " + e.getMessage());
            throw new ProfileException("Opendap URL not found: [" + opendapUrl
                + "]: Message: " + e.getMessage());
          }

          Metadata datasetMet = d.getDatasetMet(opendapUrl);
          profile.setResourceAttributes(ProfileUtils.getResourceAttributes(
              this.conf, opendapUrl, dConn, datasetMet));
          profile.setProfileAttributes(ProfileUtils
              .getProfileAttributes(this.conf, datasetMet));
          profile.getProfileElements().putAll(
              ProfileUtils.getProfileElements(this.conf, dConn, datasetMet, profile));
          profiles.add(profile);
        }
      }
    }
    return profiles;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.oodt.profile.handlers.ProfileHandler#get(java.lang.String)
   */
  public Profile get(String id) throws ProfileException {
    throw new ProfileException("method not implemented yet!");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.oodt.profile.handlers.ProfileHandler#getID()
   */
  public String getID() {
    return PROFILE_HANDLER_ID;
  }

}