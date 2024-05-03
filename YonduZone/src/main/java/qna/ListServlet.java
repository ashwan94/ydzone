package qna;

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

@WebServlet("/qna/list")
public class ListServlet extends HttpServlet {
	private QNAService service;
	
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		service = new QNAService(session);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String searchType = request.getParameter("searchType");
	String searchWord = request.getParameter("searchWord");
	
//	// 페이징 관련 코드
//	String pageNo = request.getParameter("currentPageNo");
//	int currentPageNo = pageNo == null ? 1 : Interger.parseInt(pageNo);
	
	SearchVO vo = new SearchVO(searchType, searchWord);
	
//	int totalCount = service.getBoardListCount(vo);
	
	List<QNAVO> list = service.getQNAList(vo);
	request.setAttribute("qnas", list);
	request.getRequestDispatcher("/WEB-INF/views/qna/list.jsp").forward(request, response);
	
	}
}
