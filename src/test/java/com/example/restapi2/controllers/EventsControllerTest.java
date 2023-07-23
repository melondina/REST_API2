package com.example.restapi2.controllers;

import com.example.restapi2.models.Event;
import com.example.restapi2.repositories.EventsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;


@SpringBootTest
@AutoConfigureMockMvc
public class EventsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventsRepository eventsRepository;

    @BeforeEach
    public void setUp() {
        eventsRepository.clear();
    }


    @Test
    void addEvent() throws Exception {
        mockMvc.perform(post("/api/events")
                        .header("Content-Type", "application/json")
                .content("" +
                        "{\n" +
                        "  \"title\": \"Concert\",\n" +
                        "  \"date\": \"28.07.23\",\n" +
                        "  \"passed\": \"NOT_PASSED\"\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(0)))
                .andExpect(jsonPath("$.title", is("Concert")))
                .andExpect(jsonPath("$.date", is("28.07.23")))
                .andExpect(jsonPath("$.passed", is("NOT_PASSED")));

    }

    @Test
    void getAllUsers() throws Exception {
        eventsRepository.save(Event.builder().id(0L).passed(Event.Passed.NOT_PASSED).build());
        eventsRepository.save(Event.builder().id(1L).passed(Event.Passed.NOT_PASSED).build());

        mockMvc.perform(get("/api/events"))
                .andExpect(jsonPath("$.count", is(2)));

    }

}
