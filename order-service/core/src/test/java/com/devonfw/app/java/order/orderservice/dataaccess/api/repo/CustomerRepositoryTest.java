package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

import com.devonfw.app.java.order.orderservice.common.api.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.dataaccess.api.CustomerEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest( webEnvironment = WebEnvironment.DEFINED_PORT)
public class CustomerRepositoryTest extends ComponentTest {
	
	  @Inject
	  private CustomerRepository customerRepository;

	  @Test
	  public void shouldDeleteCustomerById() {
		  
		List<CustomerEntity> customersBeforeDeletion = customerRepository.findAll();
	    customerRepository.deleteCustomerById(31L);
	    List<CustomerEntity> customersAfterDeletion = customerRepository.findAll();

	    assertThat(customersBeforeDeletion).hasSize(1);
	    assertThat(customersAfterDeletion).hasSize(0);
	  }	  


	  
}
