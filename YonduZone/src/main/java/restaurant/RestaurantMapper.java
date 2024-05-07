package restaurant;

import java.util.List;

import common.SearchVO;
import menu.MenuVO;

public interface RestaurantMapper {
	int getRestaurantListCount(SearchVO vo);
	List<RestaurantVO> getRestaurantList(SearchVO vo);
	List<RestaurantVO> getRestaurantStanby(SearchVO vo);
	RestaurantVO getRestaurant(int searchNo);
	List<RestaurantVO> getCategorySearchList(SearchVO vo);
	SearchVO voteCheck(SearchVO vo);
	List<SearchVO> getVoteList();
	List<MenuVO> getMenuList(int no);
	int deleteStanby(int rstNo);
	int countVote(int rstNo);
	int changeState(int cnt);
	int voteUpdate(SearchVO vo);
	List<SearchVO> getBoom(SearchVO vo);
	int makeBoom(SearchVO vo);
	int voteUp(int rstNo);
	int voteDown(int rstNo);
	int doLike(SearchVO vo);
	int doDislike(SearchVO vo);
	int insertRestaurant(RestaurantVO vo);
	int updateRestaurant(RestaurantVO vo);
	int deleteRestaurant(int deleteNo);

}
