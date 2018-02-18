package com.didspringboot.chapter1;

import com.didspringboot.web.HelloController1;
import com.didspringboot.web.UserController;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

	private MockMvc mvc;

	@Autowired
	private WebProperties webProperties;

	@Test
	public void contextLoads() {
	}


	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/users/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));


		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/")
				.param("id", "10000")
				.param("name", "tom")
				.param("age", "24");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("success")));

		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":10000,\"name\":\"tom\",\"age\":24}]")));


		request = MockMvcRequestBuilders.get("/users/10000");
		mvc.perform(request).andExpect(content().string(equalTo("{\"id\":10000,\"name\":\"tom\",\"age\":24}")));

		request = MockMvcRequestBuilders.put("/users/10000")
				.param("name", "ludashi")
				.param("age", "35");

		mvc.perform(request).andExpect(content().string(equalTo("success")));

		request = MockMvcRequestBuilders.delete("/users/10000");
		mvc.perform(request).andExpect(content().string(equalTo("success")));

		request = MockMvcRequestBuilders.get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}


}
