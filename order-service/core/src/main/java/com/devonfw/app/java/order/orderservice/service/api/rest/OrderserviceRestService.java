package com.devonfw.app.java.order.orderservice.service.api.rest;

import java.time.LocalDate;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.format.annotation.DateTimeFormat;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.module.rest.common.api.RestService;

import net.sf.cglib.core.Local;

@Path("/orderservice/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OrderserviceRestService extends RestService {

	@GET
	@Path("/item/{id}")
	public ItemEto findItemById(@PathParam("id") long id);

	@GET
	@Path("/order/{id}")
	public OrderEto findOrderById(@PathParam("id") long id);

	@GET
	@Path("/customer/{id}")
	public CustomerEto findCustomerById(@PathParam("id") long id);

	@GET
	@Path("/items/{name}")
	public Set <ItemEto> findItemByName(@PathParam("name") String name);

	@GET
	@Path("/orders/find/")
	public Set <OrderEto> findOrdersByCrationDateAndStatus(OrderStatus status, LocalDate creationDate);

	@GET
	@Path("/customers/{name}")
	public Set <CustomerEto> findCustomerByName(@PathParam("name") String name);

	@PUT
	@Path("/item/save/")
	public ItemEto saveItem(ItemEto item);

	@PUT
	@Path("/order/save/")	//saveOrderCto?????????????
	public OrderEto saveOrder(OrderEto order);

	@PUT
	@Path("/customer/save/")
	public CustomerEto saveCustomer(CustomerEto customer);



}
