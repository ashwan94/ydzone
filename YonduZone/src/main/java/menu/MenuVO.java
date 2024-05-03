package menu;

public class MenuVO {
	private int no;
	private int newRstNo;		// 새로 추가된 음식점 번호
	private String menuName;		// 메뉴 이름
	private int price;		    	// 가격
	private String category;		// 카테고리
	
	public MenuVO() {
	}

	// 신규 음식점에 메뉴 정보 등록할 때
	public MenuVO(int newRstNo, String menuName, int price, String category) {
		this.newRstNo = newRstNo;
		this.menuName = menuName;
		this.price = price;
		this.category = category;
	}

	
	// DB Table 의 data 를 JOIN 할 때
	public MenuVO(int no, int newRstNo, String menuName, int price, String category) {
		this.no = no;
		this.newRstNo = newRstNo;
		this.menuName = menuName;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return "MenuVO [no=" + no + ", newRstNo=" + newRstNo + ", menuName=" + menuName + ", price=" + price
				+ ", category=" + category + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNewRstNo() {
		return newRstNo;
	}

	public void setNewRstNo(int newRstNo) {
		this.newRstNo = newRstNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

	
}
