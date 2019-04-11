package com.devonfw.app.java.order.general.service.impl.rest;

import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devonfw.app.java.order.SpringBootApp;
import com.devonfw.app.java.order.general.common.base.test.DbTestHelper;
import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.common.base.CustomerTestData;
import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.common.base.OrderTestData;
import com.devonfw.app.java.order.orderservice.dataaccess.api.repo.CustomerRepository;
import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringBootApp.class, OrderServiceRestTestConfig.class })
public class OrderServiceRestTest extends AbstractRestServiceTest {

	@Inject
	private OrderServiceRestTestHelper helper;

	@Inject
	private OrderserviceRestService service;

	@Inject
	private DbTestHelper dbTestHelper;

	@Inject
	private Orderservice orderservice;

	@Inject
	private CustomerRepository customerRepository;

	@Override
	public void doSetUp() {
		super.doSetUp();
		dbTestHelper.resetDatabase();
	}

	@Override
	public void doTearDown() {
		this.service = null;
		super.doTearDown();
	}


	@Test
	public void shouldFindItemById() {
		//given
		ItemEto itemEto = ItemTestData.FROG.build();
		ItemEto savedItemEto = this.service.saveItem(itemEto);

		//when
		ItemEto item = this.service.findItemById(savedItemEto.getId());

		//then
		assertThat(item).isNotNull();
		assertThat(item.getName()).isEqualTo(ItemTestData.FROG_NAME);
	}

	@Test
	public void shouldFindOrderById() {
		//given
		CustomerEto customerEto = CustomerTestData.MICKEY_MOUSE.build();
		CustomerEto savedCustomerEto = this.service.saveCustomer(customerEto);
		OrderEto orderEto = OrderTestData.ORDER_NEW.build();
		orderEto.setOwnerId(savedCustomerEto.getId());
		OrderEto savedOrder = this.service.saveOrder(orderEto);

		//when
		OrderEto order = this.service.findOrderById(savedOrder.getId());

		//then
		assertThat(order).isNotNull();
		assertThat(order.getStatus()).isEqualTo(OrderStatus.NEW);
		assertThat(order.getCreationDate()).isEqualTo(OrderTestData.CREATION_DATE);
	}

	@Test
	public void shouldFindCustomerById() {
		//given
		CustomerEto customerEto = CustomerTestData.MICKEY_MOUSE.build();
		CustomerEto savedCustomerEto = this.service.saveCustomer(customerEto);

		//when
		CustomerEto customer = this.service.findCustomerById(savedCustomerEto.getId());

		//then
		assertThat(customer).isNotNull();
		assertThat(customer.getFirstname()).isEqualTo("Mickey");
		assertThat(customer.getLastname()).isEqualTo("Mouse");
	}

	@Test
	public void shouldFindItemByName() {
		// given
		OrderCto order = this.helper.createDummyOrderCTO();
		ItemEto itemEto = ItemTestData.CAT.build();
		this.service.saveItem(itemEto);


//		this.service.saveOrder(order);
		// when
		Set<ItemEto> items = this.service.findItemByName(ItemTestData.CAT_NAME);
		// then
		assertThat(items).hasSize(1);
		assertThat(items.iterator().next().getName()).isEqualTo(ItemTestData.CAT_NAME);
	}

	@Test
	public void shouldFindOrdersByCrationDateAndStatus () {
		//given
		CustomerEto customerEto = CustomerTestData.MICKEY_MOUSE.build();
		CustomerEto savedCustomerEto = this.service.saveCustomer(customerEto);
		OrderEto orderEto = OrderTestData.ORDER_NEW.build();
		orderEto.setOwnerId(savedCustomerEto.getId());
		OrderEto savedOrder = this.service.saveOrder(orderEto);

		//when
		Set<OrderEto> orders = this.service.findOrdersByCrationDateAndStatus(OrderStatus.NEW, OrderTestData.CREATION_DATE);

		//then
		assertThat(orders).isNotNull();
		assertThat(orders).isNotEmpty();
		assertThat(orders).hasSize(1);
		assertThat(orders.iterator().next().getStatus()).isEqualTo(OrderStatus.NEW);
		assertThat(orders.iterator().next().getCreationDate()).isEqualTo(OrderTestData.CREATION_DATE);
	}
}
