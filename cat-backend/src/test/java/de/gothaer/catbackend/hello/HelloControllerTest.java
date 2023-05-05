package de.gothaer.catbackend.hello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {


    private HelloController classUnderTest =new HelloController();


    @Test
    void hello() {
        String result = classUnderTest.hello();
        assertEquals("Hello World", result);

    }

    @Test
    void helloName()
    {
        String result = classUnderTest.helloName("Adrian");
        assertEquals("Hello Adrian",result);

    }
}