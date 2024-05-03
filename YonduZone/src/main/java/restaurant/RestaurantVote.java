package restaurant;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;

import common.SearchVO;

@WebServlet("/restaurant/vote")
public class RestaurantVote extends HttpServlet {
	private RestaurantService service;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		SqlSession session = (SqlSession) servletContext.getAttribute("sqlSession");
		this.service = new RestaurantService(session);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userNoParam = request.getParameter("userNo");
		String rstNoParam = request.getParameter("rstNo");
		String boomParam = request.getParameter("boom");
		String type = request.getParameter("type");
		String msg = "";

		if (rstNoParam != null && userNoParam != null) {
			int result = 0;
			int userNo = Integer.parseInt(userNoParam);
			int rstNo = Integer.parseInt(rstNoParam);
			int boom = Integer.parseInt(boomParam);
			int voteCnt = 0;
			int voteResult = 0;

			// view 에서 전달받은 userNo, rstNo 가 DB 에 유효한 data 인지 check
			SearchVO voteCheck = service.voteCheck(new SearchVO(userNo, rstNo));
			System.out.println("stanby 에서 선택된 <a> data 가 DB 에 있는지 check");
			System.out.println(voteCheck);

			if (voteCheck == null) {
				// USERS 와 RESTAURANT 의 BRIDGE 인 STANBY 에 새로운 data 추가
				int makeBoom = service.makeBoom(new SearchVO(userNo, rstNo));
				System.out.println("STANBY table 에 User 가 선택한 data 저장 성공!");
			}
			
			if (type.equals("like")) {
				result = service.doLike(new SearchVO(userNo, rstNo));
				voteResult = service.voteUp(rstNo); // Restaurant 의 vote 를 UP
				voteCnt = service.countVote(rstNo); // Restaurant 의 vote 개수 check
				System.out.println("좋아요 처리 완료");

				int updateLog = 0;
				int deleteLog = 0;

				if (voteCnt >= 3) {
					// Restaurant 의 vote 개수가 3개 이상이면 STATE 가 STANBY 인 매장을 ADMIT 으로 변경
					updateLog = service.changeState(rstNo);
				}
			} else {
				result = service.doDislike(new SearchVO(userNo, rstNo));
				voteResult = service.voteDown(rstNo);
				System.out.println("싫어요 처리 완료");
			}

			if (result > 0 && voteResult > 0) {
				response.sendRedirect("/restaurant/stanby?userNo=" + userNo);
			} else {
				msg = URLEncoder.encode("이미 투표하셨습니다.", "UTF-8");
				response.sendRedirect("/restaurant/stanby?msg=" + msg);
			}

		} else {
			msg = "요청하신 정보가 없습니다.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/WEB-INF/views/restaurant/stanby.jsp").forward(request, response);
		}
	}
}
