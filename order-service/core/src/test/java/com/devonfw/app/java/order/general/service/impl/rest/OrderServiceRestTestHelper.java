package com.devonfw.app.java.order.general.service.impl.rest;

import java.util.HashSet;
import java.util.Set;

import com.devonfw.app.java.order.orderservice.common.api.Order;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;

public class OrderServiceRestTestHelper {

	public OrderCto createDummyOrderCTO() {
		OrderCto orderCto = new OrderCto();
		OrderEto orderEto = new OrderEto();
		orderCto.setOrder(orderEto);
		CustomerEto customerEto = new CustomerEto();
		orderCto.setOwner(customerEto);
		Set<ItemEto> itemEtos = new HashSet<>();
		ItemEto itemEto = new ItemEto();
		itemEtos.add(itemEto);
		orderCto.setOrderPositions(itemEtos);
		return orderCto;
	}

}
