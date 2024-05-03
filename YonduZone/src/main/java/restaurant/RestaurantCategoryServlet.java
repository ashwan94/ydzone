package restaurant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.SearchVO;

@WebServlet("/restaurant/category")
public class RestaurantCategoryServlet extends HttpServlet {
	private RestaurantService service;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new RestaurantService(session);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("category");
		String searchWord = request.getParameter("searchWord");
		
		SearchVO vo = new SearchVO(searchType, searchWord);
		List<RestaurantVO> list = service.getCategorySearchList(vo);
		System.out.println(list);
		
		request.setAttribute("categoryInfo", list);
		request.getRequestDispatcher("/WEB-INF/views/restaurant/category.jsp").forward(request, response);
	}

}
