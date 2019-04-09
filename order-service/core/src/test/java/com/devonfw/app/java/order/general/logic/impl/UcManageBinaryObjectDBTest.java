package com.devonfw.app.java.order.general.logic.impl;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.app.java.order.general.logic.api.to.BinaryObjectEto;
import com.devonfw.module.test.common.base.ComponentTest;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UcManageBinaryObjectDBTest extends ComponentTest {
	
	@Autowired
	private UcManageBinaryObjectImpl ucManageBinaryObjectImpl;

	@Test
	public void shouldSaveBinaryObjectToDB() {		
		BinaryObjectEto eto = new BinaryObjectEto();		
		eto.setMimeType("test2");
		
		eto = ucManageBinaryObjectImpl.saveBinaryObject(null, eto);
		BinaryObjectEto result = ucManageBinaryObjectImpl.findBinaryObject(eto.getId());
		
		assertThat(result).isNotNull();
		assertThat(result.getMimeType()).isEqualTo(eto.getMimeType());

	}

}
