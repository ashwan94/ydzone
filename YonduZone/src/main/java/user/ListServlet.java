package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/user/list")
public class ListServlet extends HttpServlet {
	private UserService service;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession)servletContext.getAttribute("sqlSession");
		this.service = new UserService(session);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserVO> list = service.getUserList();
		request.setAttribute("member", list);
		request.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(request, response);
	}
}
