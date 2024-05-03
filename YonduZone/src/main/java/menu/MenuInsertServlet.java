package menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import common.SearchVO;
import restaurant.RestaurantService;
import restaurant.RestaurantVO;
import user.UserVO;

@WebServlet("/menu/add")
public class MenuInsertServlet extends HttpServlet {
	private MenuService service;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new MenuService(session);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새로 등록된 음식점의 no 값 가져오기
		HttpSession session = request.getSession();
		int newRstNo = (int) session.getAttribute("newRstNo");
		
		RestaurantVO vo = service.getNewRestaurantInfo(newRstNo);
		
		request.setAttribute("newRstInfo", vo);
		request.getRequestDispatcher("/WEB-INF/views/menu/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int newRstNo = (int) session.getAttribute("newRstNo");
		
		// 사용자가 입력한 menu 정보 가져오기
		String menuName = request.getParameter("menuName");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");

		
		int result = service.insertMenuInfo(new MenuVO(newRstNo, menuName, price, category));
		
		if(result > 0) {
			Object userInfo = session.getAttribute("user");
			int userNo = ((UserVO) userInfo).getNo();
			
			System.out.println("로그인된 유저의 no");
			System.out.println(userNo);
			session.removeAttribute("newRstNo");
			response.sendRedirect("/restaurant/stanby?userNo=" + userNo);
			
		}else {
			request.setAttribute("msg","올바른 data 가 아닙니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/main.jsp").forward(request, response);
		}
	}

}
