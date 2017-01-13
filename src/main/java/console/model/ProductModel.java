package console.model;

import java.io.Serializable;
import java.util.List;

import console.product.ImageModel;

public class ProductModel implements Serializable{


	private static final long serialVersionUID = -6192307143353009204L;

	private String name;
    private String brand;
	private String type;
	private int price;
	private int discount;
	private String status;
	private String description;
	private String color;
	private String size;
	private List<ImageModel> images;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public List<ImageModel> getImages() {
		return images;
	}
	public void setImages(List<ImageModel> images) {
		this.images = images;
	}

	
	
}
