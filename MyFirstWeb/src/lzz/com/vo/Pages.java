package lzz.com.vo;

public class Pages {
	private int id;
	private String title;
	private String imgname;
	private String destination;
	private String maintxt;

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMaintxt() {
		return maintxt;
	}

	public void setMaintxt(String maintxt) {
		this.maintxt = maintxt;
	}

}
