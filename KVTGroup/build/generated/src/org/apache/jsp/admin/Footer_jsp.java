package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<footer id=\"footer\"><!--Footer-->\n");
      out.write("    <div class=\"footer-top\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-2\">\n");
      out.write("                    <div class=\"companyinfo\">\n");
      out.write("                        <h2><span>KVT</span>Group</h2>\n");
      out.write("                        <p>Address: 600, Nguyen Van Cu street, An Binh ward, Ninh Kieu district, Can Tho city\n");
      out.write("                            Phone: +84 35.373.8125\n");
      out.write("                            Email:KTV_Group6@gmail.com</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-7\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"address\">\n");
      out.write("                        <img src=\"../images/home/map.png\" alt=\"\" />\n");
      out.write("                        <p>VietNam , CanTho</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"footer-bottom\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <p class=\"pull-left\">FPT University</p>\n");
      out.write("                <p class=\"pull-right\">Designed by <span><a target=\"_blank\" href=\"https://www.facebook.com/profile.php?id=100007033081682\">KVT</a></span> | Developed By KVT Team </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</footer><!--/Footer-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"js/jquery.js\"></script>\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.scrollUp.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.prettyPhoto.js\"></script>\n");
      out.write("<script src=\"js/price-range.js\"></script>\n");
      out.write("<script src=\"js/main.js\"></script>\n");
      out.write("<script src=\"js/myLoginValidation.js\"></script>\n");
      out.write("<script src=\"js/bootstrap-notify.min.js\"></script>\n");
      out.write("<script src=\"js/notify.js\"></script>\n");
      out.write("<script src=\"js/addtocart.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
