package org.example.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import org.example.common.TypeConversion;
import org.example.controller.requery.InsertReq;
import org.example.controller.requery.UpdateReq;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
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
class CurrencyControllerTest {

  @Autowired
  MockMvc mvc;

  TypeConversion tc = new TypeConversion();

  @Test
  @Order(1)
  public void insert() throws Exception {
    InsertReq req = new InsertReq();
    req.setCode("USD");
    req.setName("美園");

     mvc.perform(MockMvcRequestBuilders.post("/currency/insert")
            .contentType(MediaType.APPLICATION_JSON)
            .content(tc.pojoToStr(req))
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  @Order(2)
  public void update() throws Exception {
    UpdateReq req = new UpdateReq();
    req.setCode("USD");
    req.setName("美元");

    MvcResult response = mvc.perform(
        MockMvcRequestBuilders.put("/currency/update/{id}", "USD")
            .contentType(MediaType.APPLICATION_JSON)
            .content(tc.pojoToStr(req))
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    System.out.println(response.getResponse().getContentAsString(Charset.defaultCharset()));
  }

  @Test
  @Order(3)
  public void delete() throws Exception {
     mvc.perform(MockMvcRequestBuilders.delete("/currency/delete/{id}", "USD")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  @AfterEach
  public void query() throws Exception {
    MvcResult response = mvc.perform(MockMvcRequestBuilders.get("/currency/query")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

    System.out.println(response.getResponse().getContentAsString(Charset.defaultCharset()));
  }
}