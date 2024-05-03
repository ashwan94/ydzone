package restaurant;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SearchVO;

public class RestaurantService {
	
	private final RestaurantMapper mapper;

	public RestaurantService(SqlSession session) {
		this.mapper = session.getMapper(RestaurantMapper.class);
	}
	
	public int getRestaurantListCount(SearchVO vo) {
		return mapper.getRestaurantListCount(vo);
	}
	
	public List<RestaurantVO> getRestaurantList(SearchVO vo) {
		return mapper.getRestaurantList(vo);
	}
	
	List<RestaurantVO> getRestaurantStanby(SearchVO vo){
		return mapper.getRestaurantStanby(vo);
	}
	
	public int countVote(int rstNo) {
		return mapper.countVote(rstNo);
	}

	public RestaurantVO getRestaurant(int searchNo) {
		return mapper.getRestaurant(searchNo);
	}
	
	public List<RestaurantVO> getCategorySearchList(SearchVO vo) {
		return mapper.getCategorySearchList(vo);
	}
	
	public int changeState(int cnt) {
		return mapper.changeState(cnt);
	}
	
	public SearchVO voteCheck(SearchVO vo) {
		return mapper.voteCheck(vo);
	}
	
	public int makeBoom(SearchVO vo) {
		return mapper.makeBoom(vo);
	}
	
	public List<SearchVO> getBoom(SearchVO vo) {
		return mapper.getBoom(vo);
	}
	
	public List<SearchVO> getVoteList() {
		return mapper.getVoteList();
	}
	
	public int voteUpdate(SearchVO vo) {
		return mapper.voteUpdate(vo);
	}
	
	public int voteUp(int rstNo) {
		return mapper.voteUp(rstNo);
	}
	
	public int voteDown(int rstNo) {
		return mapper.voteDown(rstNo);
	}
	
	public int deleteStanby(int rstNo) {
		return mapper.deleteStanby(rstNo);
	}
	
	public int doLike(SearchVO vo) {
		return mapper.doLike(vo);
	}
	
	public int doDislike(SearchVO vo) {
		return mapper.doDislike(vo);
	}
	
	// 새로 추가된 음식점에 대해 PK 인 no 값을 가져옴
	public int insertRestaurant(RestaurantVO vo) {
		mapper.insertRestaurant(vo);
		// Query 는 insert 로 작동시키고 result 는 rstVO 의 no 에 담아서 servlet 으로 return
		return vo.getNo();
	}
	
	public int updateRestaurant(RestaurantVO vo) {
		return mapper.updateRestaurant(vo);
	}
	
	public int deleteRestaurant(int deleteNo) {
		return mapper.deleteRestaurant(deleteNo);
	}
	
}
