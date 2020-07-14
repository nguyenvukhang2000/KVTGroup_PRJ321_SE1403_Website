package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class slidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\n");
      out.write("<section>\n");
      out.write("   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/AdsController", out, false);
      out.write(" \n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-3\">\n");
      out.write("                <div class=\"left-sidebar\">\n");
      out.write("                    <h2>Category</h2>\n");
      out.write("                    <div class=\"panel-group category-products\" id=\"accordian\"><!--category-productsr-->\n");
      out.write("\n");
      out.write("                        <myCate:CartCategory/>\n");
      out.write("                    </div><!--/category-products-->\n");
      out.write("                    <form action=\"SearchForProduct\" method=\"get\">\n");
      out.write("                    <div class=\"price-range\"><!--price-range-->\n");
      out.write("                        <h2>Price Range</h2>\n");
      out.write("                        <div class=\"well text-center\">\n");
      out.write("                            <input type=\"text\" class=\"span2\" value=\"\" data-slider-min=\"0\" data-slider-max=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" data-slider-step=\"5\" data-slider-value=\"[0,");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("]\" id=\"sl2\" ><br />\n");
      out.write("                            <b class=\"pull-left\">$ 0</b> <b class=\"pull-right\">$");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("                            <br>\n");
      out.write("                             <input type=\"hidden\" id=\"downValue\" name=\"down\" value=\"0\"/>\n");
      out.write("                             <input type=\"hidden\" id=\"upValue\" name=\"up\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${maxPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                             <input type=\"submit\"  class=\"btn btn-default\">\n");
      out.write("                        </div>\n");
      out.write("                    </div><!--/price-range-->\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <div class=\"shipping text-center\">\n");
      out.write("                        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty ads}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ads.aURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" target=\"_blank\">\n");
      out.write("                                <img class=\"ads\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ads.aImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\" />\n");
      out.write("                            </a>\n");
      out.write("                        </c:if>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>");
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
