package de.gothaer.catbackend.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class HelloControllerprintTest {

    @Autowired
   private MockMvc mockMvc;



    @Test
    void hello() throws Exception{
    mockMvc.perform(get("/api/hello")).andExpect(status().isOk())
            .andExpect(content().string("Hello World"));

    }

    @Test
    void helloName ()throws Exception {
        mockMvc.perform(get("/api/hello/Adrian")).andExpect(status().isOk())
                .andExpect(content().string("Hello Adrian"));

    }

}