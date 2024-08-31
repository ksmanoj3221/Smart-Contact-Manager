package com.scm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.scm.services.EmailService;

@SpringBootTest
class ScmApplicationTests {

	@Autowired
	private EmailService service;

	@Test
	void contextLoads() {
	}

}
