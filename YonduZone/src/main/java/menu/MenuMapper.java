package menu;

import java.util.List;

import common.SearchVO;
import restaurant.RestaurantVO;

public interface MenuMapper {
	RestaurantVO getNewRestaurantInfo(int no);
	int insertMenuInfo(MenuVO vo);
	int insertMenu(MenuVO vo);
	int updateMenu(MenuVO vo);
	
}
