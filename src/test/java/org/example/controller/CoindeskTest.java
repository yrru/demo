package org.example.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Xie Ya Ru
 */
@SpringBootTest
@AutoConfigureMockMvc
class CoindeskTest {

  @Autowired
  MockMvc mvc;

  @Test
  public void coindesk() throws Exception {
    MvcResult response = mvc.perform(MockMvcRequestBuilders.get("/coindesk")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    System.out.println(response.getResponse().getContentAsString(Charset.defaultCharset()));
  }

  @Test
  public void newCoindesk() throws Exception {
    MvcResult response = mvc.perform(MockMvcRequestBuilders.get("/newCoindesk")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    System.out.println(response.getResponse().getContentAsString(Charset.defaultCharset()));
  }
}