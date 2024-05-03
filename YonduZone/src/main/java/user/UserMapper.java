package user;

import java.util.List;

public interface UserMapper {

	public List<UserVO> getUserList();
	public UserVO getUser(UserVO vo);
	public int insertUser(UserVO vo);
	public int updateUser(UserVO vo);
	public int deleteUser(String id);
	public UserVO currentPassword(UserVO vo);
	public int changePassword(UserVO vo);
}
