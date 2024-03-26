package net.vino9.vino.base.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BaselibTestApplication.class)
public class ModelMapperTests {

    @Autowired(required = false)
    ModelMapper modelMapper;

    @Test
    public void modelmapper_is_initialized() {
        assertNotNull(modelMapper);
    }
}
