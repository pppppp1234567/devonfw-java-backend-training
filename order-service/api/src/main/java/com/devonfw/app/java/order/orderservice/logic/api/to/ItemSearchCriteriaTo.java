package com.devonfw.app.java.order.orderservice.logic.api.to;

import com.devonfw.app.java.order.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.app.java.order.orderservice.common.api.Customer}s.
 */
public class ItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String name;
	private StringSearchConfigTo nameOption;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StringSearchConfigTo getNameOption() {
		return nameOption;
	}
	public void setNameOption(StringSearchConfigTo nameOption) {
		this.nameOption = nameOption;
	}
	
	



}
