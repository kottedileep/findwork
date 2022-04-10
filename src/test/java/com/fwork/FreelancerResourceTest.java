package com.fwork;

import com.fwork.controllers.FreelancerController;
import com.fwork.model.Freelancer;
import com.fwork.repository.FreelancerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class FreelancerResourceTest {
    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    @Autowired
    private FreelancerController freelancerController;
    
    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
      }

      @Test
      void FreelacerByIdTestMethod() throws Exception {
        String JSON_OBJECT ="{\"userId\":\"dileepkotte\",\"firstName\":\"Dileep\",\"lastName\":\"kotte\",\"emailId\":\"dileepkotte45298@gmail.com\", \"passwd\":\"dileep@123\"}";
      }
}
