package com.didspringboot.chapter1;

import com.didspringboot.web.HelloController1;
import com.didspringboot.web.WebProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter1ApplicationTests {

	private MockMvc mvc;

	@Autowired
	private WebProperties webProperties;

	@Test
	public void contextLoads() {
	}


	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController1()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello world!")));
	}

	@Test
	public void getHello2() {
		Assert.assertEquals(webProperties.getName(), "programmer");
		Assert.assertEquals(webProperties.getTitle(), "spring boot");
		Assert.assertEquals(webProperties.desc, "programmer is writing spring boot");
	}
}
