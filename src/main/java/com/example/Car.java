package com.example;


public class Car {
	 
    private String color;
    private String type;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [color=");
		builder.append(color);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
 
	
    // standard getters setters
    
    
}