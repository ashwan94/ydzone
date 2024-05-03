package user;

import java.time.LocalDate;

public class UserVO {
	private int no;
	private String id;
	private String nickName;
	private String pw;
	private String email;
	private LocalDate createDate;
	private LocalDate modifyDate;
	private String delyn;
	private String role;
	
	public UserVO() {
	}
	
	
	// 로그인 전용 생성자
	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// 회원가입 전용 생성자
	public UserVO(String id, String nickName, String pw, String email) {
		this.id = id;
		this.nickName = nickName;
		this.pw = pw;
		this.email = email;
	}

	// 모든 회원 정보 조회할 생성자
	public UserVO(int no, String id, String nickName, String pw, String email, LocalDate createDate, LocalDate modifyDate,
			String delyn, String role) {
		this.no = no;
		this.id = id;
		this.nickName = nickName;
		this.pw = pw;
		this.email = email;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.delyn = delyn;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", id=" + id + ", nickName=" + nickName + ", pw=" + pw + ", email=" + email
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", delyn=" + delyn + ", role=" + role
				+ "]";
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getnickName() {
		return nickName;
	}

	public void setnickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDelyn() {
		return delyn;
	}

	public void setDelyn(String delyn) {
		this.delyn = delyn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
