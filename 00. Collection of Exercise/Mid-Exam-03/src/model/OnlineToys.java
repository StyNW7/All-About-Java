package model;

public class OnlineToys extends Toys{

	private Double fileSize;
	private String link;
	
	public OnlineToys(String toyName, Double fileSize, String link) {
		super(toyName);
		this.fileSize = fileSize;
		this.link = link;
	}

	public Double getFileSize() {
		return fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
