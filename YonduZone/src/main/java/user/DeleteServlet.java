//package member;
//
//import java.io.IOException;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.ibatis.session.SqlSession;
//
//@WebServlet("/user/delete")
//public class MemberDeleteServlet extends HttpServlet {
//	private MemberService service;
//	
//	@Override
//	public void init() throws ServletException {
//		ServletContext servletContext = getServletContext();
//		SqlSession session = (SqlSession)servletContext.getAttribute("sqlSession");
//		this.service = new MemberService(session);
//	}
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String deleteId = request.getParameter("id");
//		int executeUpdate = service.deleteMember(deleteId);
//		if(executeUpdate > 0) {
//			response.sendRedirect("/member/list");
//		}
//	}
//
//}
package user;


