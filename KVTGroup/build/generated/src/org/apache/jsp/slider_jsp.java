package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class slider_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write(" ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/SliderIndex", out, false);
      out.write("\r\n");
      out.write(" \r\n");
      out.write("<section id=\"slider\"><!--slider-->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty slides}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                <div class=\"col-sm-12\">\r\n");
      out.write("                <!-- include slides-->\r\n");
      out.write("               \r\n");
      out.write("                <div id=\"slider-carousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("                    <ol class=\"carousel-indicators\">\r\n");
      out.write("                        <c:forEach var=\"i\" begin=\"0\" end=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn:length(slides)-1}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write("\" >\r\n");
      out.write("                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i==0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                <li data-target=\"#slider-carousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("                            </c:if>\r\n");
      out.write("                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i!=0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                <li data-target=\"#slider-carousel\" data-slide-to=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></li>\r\n");
      out.write("                            </c:if>\r\n");
      out.write("                        </c:forEach>\r\n");
      out.write("                    </ol>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"carousel-inner\">\r\n");
      out.write("                        <c:forEach var=\"slide\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${slides}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" varStatus=\"loop\">\r\n");
      out.write("                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loop.index == 0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                <c:set var=\"classActive\" value=\"active\" />\r\n");
      out.write("                            </c:if>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"item ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${classActive}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                <div class=\"col-sm-6 slide-height\">\r\n");
      out.write("                                    <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${slide.sTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("                                    <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${slide.sSubtitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <a href=\"ProductController?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${slide.pId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-default get\">Get it now</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-sm-6\">\r\n");
      out.write("                                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${slide.sImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"girl img-responsive \" alt=\"\" />\r\n");
      out.write("\r\n");
      out.write("                                </div>  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <c:set var=\"classActive\" value=\"\" />\r\n");
      out.write("                        </c:forEach>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <a href=\"#slider-carousel\" class=\"left control-carousel hidden-xs\" data-slide=\"prev\">\r\n");
      out.write("                        <i class=\"fa fa-angle-left\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a href=\"#slider-carousel\" class=\"right control-carousel hidden-xs\" data-slide=\"next\">\r\n");
      out.write("                        <i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            </c:if>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section><!--/slider-->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
