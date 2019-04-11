package com.devonfw.app.java.order.general.service.impl.rest;

import javax.inject.Inject;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.devonfw.app.java.order.SpringBootApp;
import com.devonfw.app.java.order.general.common.base.test.DbTestHelper;
import com.devonfw.module.test.common.base.SubsystemTest;

@SpringBootTest(classes = { OrderServiceRestTestConfig.class,
SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AbstractRestServiceTest extends SubsystemTest {

	  @LocalServerPort
	  protected int port;


	  @Inject
	  private DbTestHelper dbTestHelper;

	  @Override
	  protected void doSetUp() {

	    super.doSetUp();
	  }

	  @Override
	  protected void doTearDown() {

	    super.doTearDown();
	  }

	  public DbTestHelper getDbTestHelper() {

	    return this.dbTestHelper;
	  }
}
