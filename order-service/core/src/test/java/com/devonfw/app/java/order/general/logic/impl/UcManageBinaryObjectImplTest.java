package com.devonfw.app.java.order.general.logic.impl;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.devonfw.app.java.order.general.dataaccess.api.BinaryObjectEntity;
import com.devonfw.app.java.order.general.dataaccess.api.dao.BinaryObjectRepository;
import com.devonfw.app.java.order.general.logic.api.to.BinaryObjectEto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.devonfw.module.test.common.base.ModuleTest;

public class UcManageBinaryObjectImplTest extends ModuleTest {
	
	@Mock
	private BinaryObjectRepository binaryObjectRepository;
	
	@InjectMocks
	private UcManageBinaryObjectImpl ucManageBinaryObjectImpl;
	
	@Mock
	private BeanMapper beanMapper;	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldSaveBinaryObject() {		
		
		BinaryObjectEto binaryObjectEto = new BinaryObjectEto();
		BinaryObjectEntity entity = new BinaryObjectEntity();
//		binaryObjectEto.setMimeType("test");
		
		when(beanMapper.map(binaryObjectEto, BinaryObjectEntity.class)).thenReturn(entity);
		when(beanMapper.map(entity, BinaryObjectEto.class)).thenReturn(binaryObjectEto);
		
		BinaryObjectEto result = ucManageBinaryObjectImpl.saveBinaryObject(null, binaryObjectEto);
		
		assertThat(result).isEqualTo(binaryObjectEto);
	}

}
