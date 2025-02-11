package com.professional.backend.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserFileProcessorTest {

    @Test
    public void getFileExtensionTest() {
        String filename = "hello.pdf";
        
        assertEquals("pdf", UserFileProcessor.getExtensionName(filename));
    }
    
    @Test
    public void getFilenameWithoutExtension() {
        String filename = "hello.pdf";
        
        assertEquals("hello", UserFileProcessor.getFileNameWithoutExtension(filename));
    }
    
}
