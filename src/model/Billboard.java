package model;

import java.io.Serializable;

public class Billboard implements Serializable{
	
	/**
	 * serial version code
	 */
	private static final long serialVersionUID = 1L;
	private double height; 
	private double width; 
	private double area;
	private boolean inUse; 
	private String brand; 
	
	public Billboard(double height, double width,double area, boolean inUse, String brand) {
		this.height=height;
		this.width=width; 
		this.area = area;
		this.inUse=inUse; 
		this.brand=brand;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height=height; 
	}
	public double getWidth() {
		return width; 
	}
	public void setWidth(double width){
		this.width=width; 
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public boolean getInUse(){
		return inUse;
	}
	public void setInUse(boolean inUse) {
		this.inUse=inUse; 
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public String toString() {
		String out = ""; 
		
		out += "height: " + height + "\n";
		out += "width:  " + width + "\n";
		out += "Area:   " + area + "\n";
		out += "InUse:  " + inUse + "\n";
		out += "Brand:  " + brand + "\n";
		
		return out; 
	}
}
