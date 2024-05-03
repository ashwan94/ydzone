package restaurant;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

@WebServlet("/restaurant/add")
@MultipartConfig(location = "/Users/na/workspace/YonduZone/YonduZone/src/main/webapp/Source/Restaurant_images/")
public class RestaurantInsert extends HttpServlet {
	private RestaurantService service;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new RestaurantService(session);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/restaurant/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자의 parameter 입력 받기
		String restaurantName = request.getParameter("restaurantName");
		String intro = request.getParameter("intro");
		String open = request.getParameter("open");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String details = request.getParameter("details");
		String fileName = "";
		long fileSize = 0;
		
		// TODO 운영체제, PC 환경에 따라 저장 경로가 달라질 수 있도록 환경별 경로 값 가져오기
		String path = "/Users/na/workspace/YonduZone/YonduZone/src/main/webapp/Source/Restaurant_images/";
		File folder = new File(path);
		
		if(!folder.exists()) {
			boolean result = folder.mkdirs();
			if(result) {
				System.out.println("Restaurant_imags 폴더가 생성되었습니다.");
			}else {
				System.out.println("폴더 생성 실패했습니다.");
			}
		}else {
			System.out.println("폴더가 이미 존재합니다.");
		}
		
		// 사용자가 업로드한 첨부파일 image Client PC 에 저장하기
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			
			String contentType = part.getContentType();
			System.out.println("파일 유형/확장자 : " + contentType);
			
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				fileName = part.getSubmittedFileName();
				System.out.println("파일명 : " + fileName);
				
				fileSize = part.getSize();
				System.out.println("파일 크기 : " + fileSize);
				
				if(part.getSize() > 0) {
					part.write("/Users/na/workspace/YonduZone/YonduZone/src/main/webapp/Source/Restaurant_images/" + fileName);
					part.delete();
				}
			}else {
				String value = request.getParameter(part.getName());
			}
		}
		
		int newRstNo = service.insertRestaurant(new RestaurantVO(restaurantName, intro, open, addr, tel, details, fileName, fileSize));
		
		// 사용자로부터 입력받은 음식점 정보의 no 는 0 이므로, 만약 DB 에서 가져온 음식점 data 의 no 이 0 이 아니라면 다음 동작 수행
		if(newRstNo > 0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("newRstNo", newRstNo);
			response.sendRedirect("/menu/add");
		}else {
			request.setAttribute("msg", "등록 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/restaurant/add.jsp");
		}
		
	}

}
