package com.marcosene.productpricer.api.controller;

import com.marcosene.productpricer.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllerTests {

    @Autowired
    protected MockMvc mvc;

    protected MockHttpServletResponse postJson(String uri, Object request) throws Exception {
        return mvc.perform(
                MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(Utils.mapToJson(request)))
                .andReturn().getResponse();
    }
}
