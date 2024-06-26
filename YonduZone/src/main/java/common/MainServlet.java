package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import restaurant.RestaurantService;
import restaurant.RestaurantVO;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private RestaurantService service;
	
	
	@Override
		public void init() throws ServletException {
			ServletContext servletContext = getServletContext();
			SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
			this.service = new RestaurantService(session);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		String searchWord = request.getParameter("searchWord");
		
		SearchVO vo = new SearchVO(searchType, searchWord);
		
		List<RestaurantVO> list = service.getRestaurantList(vo);
		
		request.setAttribute("restaurants", list);
		request.getRequestDispatcher("/WEB-INF/views/common/main.jsp").forward(request, response);
	}

}
