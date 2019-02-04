package com.tcs.fresco;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;

// Make necessary annotations.
//Write annotations here
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class AuthControllerTest {

    //write necessary mockmvc objects and autowired context
	
    //Write your code here
	
	@Autowired
	private WebApplicationContext context;
	
	
	MockMvc mockmvc;
	
     @InjectMocks
 private AuthenticationController authenticationController;
     @InjectMocks
 private AuthenticationCheck AuthenticationCheck;
	    
		@Before
		public void setup() {
			// Make necessary mockmvc instance
            // Write your code here
			mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
			
		}
		
		
		@Test
		public void validateUser() throws Exception{
			
			// Create test case to validate user "Dave".
			// Write your code here
			String user="Dave";
			
			mockmvc.perform(MockMvcRequestBuilders.get("/validate/"+user)
		 			.contentType(MediaType.TEXT_PLAIN)
					.accept(MediaType.TEXT_PLAIN))
					.andExpect(status().isOk())
					.andExpect(content().string("Valid"));
			

		}
		
    @Configuration
 public static class TestConfiguration {
  @Bean
  public AuthenticationController authenticationController() {
   return new AuthenticationController();
  }
  @Bean
  public AuthenticationCheck authenticationCheck() {
   return new AuthenticationCheck();
  }
 }
}