package menu;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SearchVO;
import restaurant.RestaurantVO;

public class MenuService {
	
	private final MenuMapper mapper;
	
	public MenuService(SqlSession session) {
		this.mapper = session.getMapper(MenuMapper.class);
	}
	
	public RestaurantVO getNewRestaurantInfo(int no) {
		return mapper.getNewRestaurantInfo(no);
	}
	
	public int insertMenuInfo(MenuVO vo){
		return mapper.insertMenuInfo(vo);
	}
	
	public int insertMenu(MenuVO vo) {
		return mapper.insertMenu(vo);
	}
	
	public int updateMenu(MenuVO vo) {
		return mapper.updateMenu(vo);
	}
	
}
