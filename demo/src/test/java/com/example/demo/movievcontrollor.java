package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class movievcontrollor {
    @Mock
    private movieserives movieserive;

    @InjectMocks
    private controller moviecontroller;


    private MockMvc mockmvc;

    private movieapp moiveapp;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockmvc = MockMvcBuilder.standaloneSetup(moviecontroller).build();
    }

}