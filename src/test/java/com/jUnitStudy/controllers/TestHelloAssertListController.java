package com.jUnitStudy.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Request builder import
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// Result matcher imports
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HelloAssertListController.class)
public class TestHelloAssertListController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addItemTest() throws Exception{
        String jsonTestLink = "{\"name\":\"laptop\",\"quantity\":50}";

        mockMvc.perform(post("/item/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTestLink))
                .andExpect(status().isOk())
                .andExpect(content().string("Item added successfully: Laptop"));
    }
}
