package com.company.system;

import com.company.system.utlis.HttpClientHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class SystemApplicationTests {
	@Autowired
	HttpClientHelper httpClientHelper;


	@Test
	void contextLoads() {
		httpClientHelper.post("localhost:8080/",new HashMap<String, Object>(),null);
	}

}
