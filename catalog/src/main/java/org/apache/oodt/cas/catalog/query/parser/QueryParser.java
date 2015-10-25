/* Generated By:JJTree&JavaCC: Do not edit this line. QueryParser.java */
        package org.apache.oodt.cas.catalog.query.parser;

        import org.apache.oodt.cas.catalog.query.*;
import org.apache.oodt.cas.catalog.term.Term;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Vector;

    public class QueryParser/*@bgen(jjtree)*/implements QueryParserTreeConstants, QueryParserConstants {/*@bgen(jjtree)*/
  protected JJTQueryParserState jjtree = new JJTQueryParserState();
        public static QueryExpression parseQueryExpression(String queryExpressionString) throws ParseException, TokenMgrError {
                return new QueryParser(new ByteArrayInputStream(queryExpressionString.getBytes())).parseInput();
        }

        public static void main( String[] args ) throws ParseException, TokenMgrError {
                System.out.println(new QueryParser( System.in ).parseInput());
        }

  final public QueryExpression parseInput() throws ParseException {
 /*@bgen(jjtree) parseInput */
        SimpleNode jjtn000 = new SimpleNode(JJTPARSEINPUT);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);QueryExpression qe = null;
    try {
      qe = Query(null);
      jj_consume_token(0);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          {if (true) return qe;}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public QueryExpression Query(Vector<String> bucketNames) throws ParseException {
 /*@bgen(jjtree) Query */
        SimpleNode jjtn000 = new SimpleNode(JJTQUERY);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);QueryExpression qe1 = null;
        QueryExpression qe2 = null;
        Token operator = null;
    try {
      qe1 = QueryExpression(bucketNames);
      label_1:
      while (true) {
        if (jj_2_1(2147483647)) {
        } else {
          break label_1;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          operator = jj_consume_token(AND);
          break;
        case OR:
          operator = jj_consume_token(OR);
          break;
        default:
          jj_la1[0] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        qe2 = Query(bucketNames);
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        if (qe2 == null) {
                {if (true) return qe1;}
        }else {
                QueryLogicalGroup queryLogicalGroup = new QueryLogicalGroup();
                if (bucketNames != null)
                        queryLogicalGroup.setBucketNames(new HashSet<String>(bucketNames));
                queryLogicalGroup.setOperator(QueryLogicalGroup.Operator.valueOf(operator.image.trim().toUpperCase()));
                queryLogicalGroup.addExpression(qe1);
                queryLogicalGroup.addExpression(qe2);
                {if (true) return queryLogicalGroup;}
        }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public QueryExpression QueryExpression(Vector<String> bucketNames) throws ParseException {
 /*@bgen(jjtree) QueryExpression */
        SimpleNode jjtn000 = new SimpleNode(JJTQUERYEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);QueryExpression qe = null;
    try {
      if (jj_2_2(2147483647)) {
        qe = PriorityQueryExpression(bucketNames);
      } else if (jj_2_3(2147483647)) {
        qe = StdQueryExpression();
      } else if (jj_2_4(2147483647)) {
        qe = CustomQueryExpression(bucketNames);
      } else if (jj_2_5(2147483647)) {
        qe = ComparisonQueryExpression(bucketNames);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return qe;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public QueryExpression StdQueryExpression() throws ParseException {
 /*@bgen(jjtree) StdQueryExpression */
        SimpleNode jjtn000 = new SimpleNode(JJTSTDQUERYEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);QueryExpression qe = null;
        Vector<String> bucketNames = new Vector<String>();
    try {
      jj_consume_token(OPEN_BRACES);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(BUCKET_NAME_KEY);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(EQUALS);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_4;
        }
        jj_consume_token(SPACE);
      }
      getValues(bucketNames);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_5;
        }
        jj_consume_token(SPACE);
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMI_COLON:
        jj_consume_token(SEMI_COLON);
        label_6:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case SPACE:
            break;
          default:
            jj_la1[5] = jj_gen;
            break label_6;
          }
          jj_consume_token(SPACE);
        }
        qe = Query(bucketNames);
        break;
      default:
        jj_la1[6] = jj_gen;
      }
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_7;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(CLOSE_BRACES);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        if (qe == null) {
                {if (true) return new StdQueryExpression(new HashSet<String>(bucketNames));}
        }else {
                {if (true) return qe;}
        }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public QueryExpression ComparisonQueryExpression(Vector<String> bucketNames) throws ParseException {
 /*@bgen(jjtree) ComparisonQueryExpression */
        SimpleNode jjtn000 = new SimpleNode(JJTCOMPARISONQUERYEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token termName = null;
        Token operator = null;
        Vector<String> values = new Vector<String>();
    try {
      termName = jj_consume_token(TERM);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_8;
        }
        jj_consume_token(SPACE);
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQ:
        operator = jj_consume_token(EQ);
        break;
      case GT:
        operator = jj_consume_token(GT);
        break;
      case GE:
        operator = jj_consume_token(GE);
        break;
      case LT:
        operator = jj_consume_token(LT);
        break;
      case LE:
        operator = jj_consume_token(LE);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[10] = jj_gen;
          break label_9;
        }
        jj_consume_token(SPACE);
      }
      getValues(values);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        Term term = new Term(termName.image);
        term.setValues(values); //Arrays.asList(termValues.image.split(",")));
        ComparisonQueryExpression comparisonQueryExpression = new ComparisonQueryExpression();
        if (bucketNames != null)
                comparisonQueryExpression.setBucketNames(new HashSet<String>(bucketNames));
        comparisonQueryExpression.setTerm(term);
        comparisonQueryExpression.setOperator(ComparisonQueryExpression.Operator.getOperatorBySign(operator.image));
        {if (true) return comparisonQueryExpression;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public QueryExpression PriorityQueryExpression(Vector<String> bucketNames) throws ParseException {
 /*@bgen(jjtree) PriorityQueryExpression */
        SimpleNode jjtn000 = new SimpleNode(JJTPRIORITYQUERYEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);QueryExpression qe = null;
    try {
      jj_consume_token(OPEN_PARENS);
      qe = Query(bucketNames);
      jj_consume_token(CLOSE_PARENS);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return qe;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public QueryExpression CustomQueryExpression(Vector<String> bucketNames) throws ParseException {
 /*@bgen(jjtree) CustomQueryExpression */
        SimpleNode jjtn000 = new SimpleNode(JJTCUSTOMQUERYEXPRESSION);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token customNameToken = null;
        Properties p = new Properties();
    try {
      jj_consume_token(OPEN_BRACES);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_10;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(CUSTOM_NAME_KEY);
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_11;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(EQUALS);
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[13] = jj_gen;
          break label_12;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(QUOTE);
      customNameToken = jj_consume_token(TERM);
      jj_consume_token(QUOTE);
      if (jj_2_6(2147483647)) {
        label_13:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case SPACE:
            break;
          default:
            jj_la1[14] = jj_gen;
            break label_13;
          }
          jj_consume_token(SPACE);
        }
        jj_consume_token(SEMI_COLON);
        getProperties(p);
      } else {
      }
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[15] = jj_gen;
          break label_14;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(CLOSE_BRACES);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                CustomQueryExpression cqe = new CustomQueryExpression(customNameToken.image, p);
        if (bucketNames != null)
                cqe.setBucketNames(new HashSet<String>(bucketNames));
        {if (true) return cqe;}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public void getValues(Vector<String> values) throws ParseException {
 /*@bgen(jjtree) getValues */
        SimpleNode jjtn000 = new SimpleNode(JJTGETVALUES);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token value = null;
    try {
      value = jj_consume_token(VALUE);
      label_15:
      while (true) {
        if (jj_2_7(2147483647)) {
        } else {
          break label_15;
        }
        jj_consume_token(COMMA);
        getValues(values);
      }
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                values.add(0, value.image.replaceAll("'", ""));
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void getProperties(Properties p) throws ParseException {
 /*@bgen(jjtree) getProperties */
        SimpleNode jjtn000 = new SimpleNode(JJTGETPROPERTIES);
        boolean jjtc000 = true;
        jjtree.openNodeScope(jjtn000);Token propertyKey = null;
        Token propertyVal = null;
    try {
      propertyKey = jj_consume_token(P_KEY);
      label_16:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_16;
        }
        jj_consume_token(SPACE);
      }
      jj_consume_token(EQUALS);
      label_17:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SPACE:
          break;
        default:
          jj_la1[17] = jj_gen;
          break label_17;
        }
        jj_consume_token(SPACE);
      }
      propertyVal = jj_consume_token(VALUE);
      label_18:
      while (true) {
        if (jj_2_8(2147483647)) {
        } else {
          break label_18;
        }
        jj_consume_token(COMMA);
        getProperties(p);
      }
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                p.put(propertyKey.image.substring(2), propertyVal.image.replaceAll("'", ""));
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_3_8() {
    if (jj_scan_token(COMMA)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(OPEN_BRACES)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_scan_token(4)) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(BUCKET_NAME_KEY)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(OPEN_PARENS)) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(COMMA)) return true;
    return false;
  }

  private boolean jj_3_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(5)) {
    jj_scanpos = xsp;
    if (jj_scan_token(6)) return true;
    }
    return false;
  }

  private boolean jj_3_5() {
    if (jj_scan_token(TERM)) return true;
    return false;
  }

  private boolean jj_3_6() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_scan_token(4)) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(SEMI_COLON)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(OPEN_BRACES)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_scan_token(4)) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(CUSTOM_NAME_KEY)) return true;
    return false;
  }

  public QueryParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  public boolean lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[18];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x60,0x10,0x10,0x10,0x10,0x10,0x200,0x10,0x10,0x7c0000,0x10,0x10,0x10,0x10,0x10,0x10,0x10,0x10,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[8];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  public QueryParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public QueryParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new QueryParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public QueryParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new QueryParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public QueryParser(QueryParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(QueryParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector<int[]> jj_expentries = new java.util.Vector<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[28];
    for (int i = 0; i < 28; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 18; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 8; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

    }
