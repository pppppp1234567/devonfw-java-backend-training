package com.devonfw.app.java.order.orderservice.service.impl.rest;

import java.time.LocalDate;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

import ch.qos.logback.core.status.Status;

@Named("OrderserviceRestService")
public class OrderserviceRestServiceImpl implements OrderserviceRestService {

	@Inject
	private Orderservice orderservice;

	@Override
	public ItemEto findItemById(long id) {
		// TODO Auto-generated method stub
		return this.orderservice.findItem(id);
	}

	@Override
	public OrderEto findOrderById(long id) {
		// TODO Auto-generated method stub
		return this.orderservice.findOrder(id);
	}

	@Override
	public CustomerEto findCustomerById(long id) {
		// TODO Auto-generated method stub
		return this.orderservice.findCustomer(id);
	}

	@Override
	public Set<ItemEto> findItemByName(String name) {
		// TODO Auto-generated method stub
		return this.orderservice.findByName(name);
	}

	@Override
	public Set<OrderEto> findOrdersByCrationDateAndStatus(OrderStatus status, LocalDate creationDate) {
		// TODO Auto-generated method stub
		return this.orderservice.findOrdersByCreationDateAndStatus(creationDate, status);
	}

	@Override
	public Set<CustomerEto> findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEto saveOrder(OrderEto order) { ///saveOrderCto??????????
		// TODO Auto-generated method stub
		return this.orderservice.saveOrder(order);
	}

	@Override
	public ItemEto saveItem(ItemEto item) {
		// TODO Auto-generated method stub
		return this.orderservice.saveItem(item);
	}

	@Override
	public CustomerEto saveCustomer(CustomerEto customer) {
		// TODO Auto-generated method stub
		return this.orderservice.saveCustomer(customer);
	}

}
