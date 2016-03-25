package com.algaworks.webnario.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.algaworks.webinario.restful.WebinarioRestfulApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebinarioRestfulApplication.class)
@WebAppConfiguration
public class WebnarioRestfulApplicationTests {

	@Test
	public void contextLoads() {
	}

}
