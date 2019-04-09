package com.devonfw.app.java.order.orderservice.dataaccess.api;

import com.devonfw.app.java.order.orderservice.common.api.Item;
import com.devonfw.app.java.order.general.dataaccess.api.ApplicationPersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity(name="Item")
public class ItemEntity extends ApplicationPersistenceEntity implements Item {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	

}
