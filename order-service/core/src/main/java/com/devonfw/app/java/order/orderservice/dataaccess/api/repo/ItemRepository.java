package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;

import static com.querydsl.core.alias.Alias.$;

import com.devonfw.app.java.order.orderservice.common.api.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.basic.common.api.query.LikePatternSyntax;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.core.alias.Alias;
import com.querydsl.jpa.impl.JPAQuery;

public interface ItemRepository extends DefaultRepository<ItemEntity> {

	default Page<ItemEntity> findByCriteria(ItemSearchCriteriaTo criteria) {

		  ItemEntity alias = newDslAlias();
		  JPAQuery<ItemEntity> query = newDslQuery(alias);

		  String name = criteria.getName();
		  if (name != null && !name.isEmpty()) {
		    QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		  }

		  // TODO: implement also expression for description and price
		  String description = criteria.getDescription();
		  if (description != null && !description.isEmpty()) {
		    QueryUtil.get().whereString(query, $(alias.getDescription()), description, criteria.getDescriptionOption());
		  }
		  
		  Double price = criteria.getPrice();
		  if (price != null) {
		        query.where(Alias.$(alias.getPrice()).eq(price));
		  }

		  // TODO: implement also sorting using addOrderBy
		  query.orderBy(Alias.$(alias.getPrice()).asc());
	//	  addOrderBy(query, alias, criteria.getPageable().getSort());
		  
		  // TODO: return found items using QueryUtil
		  return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);

		}
	
	default Page<ItemEntity> findByName(com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo criteria) {

		  ItemEntity alias = newDslAlias();
		  JPAQuery<ItemEntity> query = newDslQuery(alias);

		  String name = criteria.getName();
		  if (name != null && !name.isEmpty()) {
			  QueryUtil.get().whereLike(query, $(alias.getName()), name, LikePatternSyntax.SQL, true, true);
//			  QueryUtil.get().whereString(query, expression, value, config);
//		    QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		  }

		  // TODO: implement also sorting using addOrderBy
		  query.orderBy(Alias.$(alias.getName()).asc());
	//	  addOrderBy(query, alias, criteria.getPageable().getSort());
		  
		  // TODO: return found items using QueryUtil
		  return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);

		}
	
}
