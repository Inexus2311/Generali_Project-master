package de.gothaer.catbackend.cat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class CatControllerTest  {

    @MockBean
    private CatService catService;
    @Autowired
    private MockMvc mockMvc; // Objekt
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll() {

    }

    @Test
    void findOne() throws Exception {
        Cat mock = new Cat("Mauzi","red");
        when(catService.findById(1L)).thenReturn(mock);
        //Methode von mockMvc
        mockMvc.perform(get("/api/cats/1")).andExpect(status().isOk()).andExpect(content().string(containsString("Mauzi")));
    }


    @Test

    void create() throws Exception {
        Cat mock = new Cat("Picachu", "yellow");
        mockMvc.perform(post("/api/cats").content(objectMapper.writeValueAsString(mock)));
        when(catService.findById(1L)).thenReturn(mock);
        //Vergleich
        //assertEquals("Peggy",one.getBody());
    }
}