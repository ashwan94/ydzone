package common;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import user.UserService;
import user.UserVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserService service;
	
	@Override
		public void init() throws ServletException {
			ServletContext servletContext = getServletContext();
			SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
			this.service = new UserService(session);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String savedId = request.getParameter("saveId");
		
		UserVO vo = service.getUser(new UserVO(id, pw));
		
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);

			response.sendRedirect("/main");
		}else {
			request.setAttribute("msg", "잘못된 정보입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/login.jsp").forward(request, response);
			
		}
		
	}

}