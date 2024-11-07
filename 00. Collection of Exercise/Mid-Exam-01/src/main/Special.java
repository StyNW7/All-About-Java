package main;

public class Special extends Menu {
	
	private Integer menuDiscount;

	public Special(String menuCode, String menuName, Integer menuPrice, Integer menuDiscount) {
		super(menuCode, menuName, menuPrice);
		this.menuDiscount = menuDiscount;
	}

	public Integer getMenuDiscount() {
		return menuDiscount;
	}

	public void setMenuDiscount(Integer menuDiscount) {
		this.menuDiscount = menuDiscount;
	}

}
