/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-05-01 11:50:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("회원가입", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("center", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("코딩하기 좋은 날씨네", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("content", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("- 강성구 -", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("<style>\n");
      out.write("	label{\n");
      out.write("		display:block;\n");
      out.write("		margin-bottom:3%;\n");
      out.write("	}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<div class=\"row my-5\">\n");
      out.write("	<div class=\"col-4\"></div>\n");
      out.write("	<div class=\"col-4 border py-3 text-center\">\n");
      out.write("		<form action=\"/signUp\" method=\"post\" id=\"signUpForm\">\n");
      out.write("		<h3>넥스트 욘두 가입 신청서</h3>\n");
      out.write("		<label>\n");
      out.write("			<div>ID</div>\n");
      out.write("			<input type=\"text\" name=\"id\">\n");
      out.write("		</label>\n");
      out.write("		<label>\n");
      out.write("			<div>비번</div>\n");
      out.write("			<input type=\"password\" name=\"pw\">\n");
      out.write("		</label>\n");
      out.write("		<label>\n");
      out.write("			<div>EMAIL</div>\n");
      out.write("			<input type=\"email\" name=\"email\">\n");
      out.write("		</label>\n");
      out.write("		<label>\n");
      out.write("			<div>닉네임</div>\n");
      out.write("			<input type=\"text\" name=\"nickName\">\n");
      out.write("		</label>\n");
      out.write("		<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" id=\"msg\">\n");
      out.write("		<div class=\"text-center mt-2\">\n");
      out.write("			<button type=\"submit\" id=\"submitBtn\" class=\"btn btn-dark me-5\">완료</button>\n");
      out.write("			<button type=\"button\" id=\"backBtn\" class=\"btn btn-dark\">취소</button>\n");
      out.write("		</div>\n");
      out.write("		</form>\n");
      out.write("	</div>\n");
      out.write("	<div class=\"col-4\"></div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("<script src=\"/Bootstrap/js/scripts.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("	const msgEl = document.querySelector(\"#msg\");\n");
      out.write("	if(msgEl.value != \"\"){\n");
      out.write("		alert(msgEl.value);\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	const submitBtn = document.querySelector(\"#submitBtn\");\n");
      out.write("	const backBtn = document.querySelector(\"#backBtn\");\n");
      out.write("	\n");
      out.write("	submitBtn.addEventListener(\"click\", function(e) {\n");
      out.write("		e.preventDefault();\n");
      out.write("		\n");
      out.write("		const idEl = document.querySelector(\"[name='id']\");\n");
      out.write("		const pwEl = document.querySelector(\"[name='pw']\");\n");
      out.write("		const emailEl = document.querySelector(\"[name='email']\");\n");
      out.write("		const nickNameEl = document.querySelector(\"[name='nickName']\");\n");
      out.write("		\n");
      out.write("		if(idEl.value == \"\" || pwEl.value == \"\" || emailEl.value == \"\" || nickNameEl.value == \"\") {\n");
      out.write("			alert(\"누락된 정보가 있습니다.\");\n");
      out.write("		}else{\n");
      out.write("			const form = document.querySelector(\"#signUpForm\");\n");
      out.write("			form.submit();\n");
      out.write("		}\n");
      out.write("	})\n");
      out.write("	\n");
      out.write("	backBtn.addEventListener(\"click\", function() {\n");
      out.write("		history.back();\n");
      out.write("	});\n");
      out.write("</script>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
