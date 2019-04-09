package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

import com.devonfw.app.java.order.orderservice.common.api.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest( webEnvironment = WebEnvironment.DEFINED_PORT)
public class ItemRepositoryTest extends ComponentTest {
	
	  @Inject
	  private ItemRepository itemRepository;

	  @Test
	  public void shouldFindAllItems() {
	    // when
	    List<ItemEntity> foundItems = itemRepository.findAll();

	    // then
	    assertThat(foundItems).hasSize(1);
	  }
	  
	  @Test
	  public void shouldFindItemsByCriteria() {
		//given
		ItemSearchCriteriaTo criteriaTo = new ItemSearchCriteriaTo();
		criteriaTo.setName("spaghetti bolognese");
		criteriaTo.setDescription("Italy");
		criteriaTo.setPrice(250.0);
		criteriaTo.setPageable(new QPageRequest(0, 20));
		  
	    // when
	    Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteriaTo);

	    // then
	    assertThat(foundItems).hasSize(1);
	  }
	  
	  @Test
	  public void shouldFindItemsByName() {
		//given
		com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo criteriaTo = new com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo();
		criteriaTo.setName("TTI");
		criteriaTo.setPageable(new QPageRequest(0, 20));
		  
	    // when
	    Page<ItemEntity> foundItems = itemRepository.findByName(criteriaTo);

	    // then
	    assertThat(foundItems).hasSize(1);
	  }

	  
}
