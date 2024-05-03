package common;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import user.UserService;
import user.UserVO;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private UserService service;
	
	@Override
		public void init() throws ServletException {
			ServletContext servletContext = getServletContext();
			SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
			this.service = new UserService(session);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/common/signUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String nickName = request.getParameter("nickName");
		
		UserVO checkUser = service.getUser(new UserVO(id, pw));
		
		if(checkUser == null) {
			int insertUser = service.insertUser(new UserVO(id, pw, email, nickName));
			
			if(insertUser > 0) {
				String msg = URLEncoder.encode("회원가입이 완료되었습니다!", "UTF-8");
				response.sendRedirect("/login?msg=" + msg);
			}
			
		}else {
			request.setAttribute("msg", "이미 존재하는 계정입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/signUp.jsp").forward(request, response);
		}
		
		
	}

}
