package console.product;

import java.io.Serializable;
import java.util.Date;

public class ImageModel implements Serializable{

	private static final long serialVersionUID = -8849426557173566575L;
	
	private String imgId;
	private Date date;
	private String filename;
	private String fileUrl;
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public ImageModel(String imgId, Date date, String filename, String fileUrl) {
		super();
		this.imgId = imgId;
		this.date = date;
		this.filename = filename;
		this.fileUrl = fileUrl;
	}
	
	
	
}
