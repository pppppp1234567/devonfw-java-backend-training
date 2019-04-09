package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.dataaccess.api.OrderEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest( webEnvironment = WebEnvironment.DEFINED_PORT)
public class OrderRepositoryTest extends ComponentTest{

	@Inject
	private OrderRepository orderRepository;
	
	@Test
	public void shouldFindOrdersByDateAndStatus() {
		//given
		LocalDate localDate = LocalDate.parse("2019-03-15");
		OrderStatus status = OrderStatus.SERVED;
		
		//when
		Set<OrderEntity> foundOrders = orderRepository.findByCreationDateAndStatus(localDate, status);
		
		//then
	    assertThat(foundOrders).hasSize(1);
	    assertThat(foundOrders).extracting("status").containsExactly(OrderStatus.SERVED);
	    assertThat(foundOrders).extracting("creationDate").containsExactly(LocalDate.parse("2019-03-15"));
//	    assertThat(foundOrders).anyMatch(predicate)
//	    assertThat(foundOrders.stream().findFirst().get().getStatus()).isEqualTo(OrderStatus.SERVED);
	}
}
