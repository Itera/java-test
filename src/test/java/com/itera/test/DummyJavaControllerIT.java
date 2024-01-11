package com.itera.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DummyJavaControllerIT {
    @Autowired
    private MockMvc mvc;

    @Test
    void testStatus() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/java/").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("OK")));
    }

}
