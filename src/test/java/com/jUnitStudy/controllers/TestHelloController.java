package com.jUnitStudy.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestHelloController {

    @Autowired
    private HelloController helloController;

    @Test
    void testHello(){
        assertEquals("Hello Puneet", helloController.getHelloMessage());
        assertTrue(true, (Supplier<String>) new HelloController());
    }
}
