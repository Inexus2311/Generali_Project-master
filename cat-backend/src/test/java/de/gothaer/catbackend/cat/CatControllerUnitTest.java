package de.gothaer.catbackend.cat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CatControllerUnitTest {

   private CatService catService = mock(CatService.class);
   private CatController classUnderTest = new CatController(catService);

    @Test
    void getAll() {

    }

    @Test
    void findOne() {
        Cat mock = new Cat("Mauzi","red");
        when(catService.findById(1L)).thenReturn(mock);
        ResponseEntity<Cat> one = classUnderTest.findOne(1L);
        assertEquals("Mauzi", one.getBody().getName());

    }



}