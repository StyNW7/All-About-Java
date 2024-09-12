package model;

public class Player {
	
	private Integer x;
	private Integer y;
	private Integer move;
	private Integer level;
	private Integer chestFound;
	private Integer point;
	private Integer protection;
	private Integer multiplier;
	
	
	
	public Player(Integer x, Integer y, Integer move, Integer level, Integer chestFound, Integer point,
			Integer protection, Integer multiplier) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
		this.level = level;
		this.chestFound = chestFound;
		this.point = point;
		this.protection = protection;
		this.multiplier = multiplier;
	}
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getMove() {
		return move;
	}

	public void setMove(Integer move) {
		this.move = move;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getChestFound() {
		return chestFound;
	}

	public void setChestFound(Integer chestFound) {
		this.chestFound = chestFound;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getProtection() {
		return protection;
	}

	public void setProtection(Integer protection) {
		this.protection = protection;
	}

	public Integer getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Integer multiplier) {
		this.multiplier = multiplier;
	}

}
