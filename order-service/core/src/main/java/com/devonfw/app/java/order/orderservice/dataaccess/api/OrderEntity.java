package com.devonfw.app.java.order.orderservice.dataaccess.api;

import com.devonfw.app.java.order.orderservice.common.api.Order;
import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.general.dataaccess.api.ApplicationPersistenceEntity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="OrderSummary")
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

	private static final long serialVersionUID = 1L;
	
	private Double price;
	private CustomerEntity owner;
	private Long ownerId;
	private LocalDate creationDate;
	private OrderStatus status;
	private Set<ItemEntity> orderPositions;
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	public CustomerEntity getOwner() {
		return owner;
	}
	public void setOwner(CustomerEntity owner) {
		this.owner = owner;
	}
	@Transient
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Enumerated(EnumType.STRING)
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "OrderPosition", joinColumns = @JoinColumn(name = "orderId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "itemId", referencedColumnName = "id"))
	public Set<ItemEntity> getOrderPositions() {
		return orderPositions;
	}
	public void setOrderPositions(Set<ItemEntity> orderPositions) {
		this.orderPositions = orderPositions;
	}
	

}
