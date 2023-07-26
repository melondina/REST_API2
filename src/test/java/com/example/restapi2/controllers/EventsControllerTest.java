package com.example.restapi2.controllers;

import com.example.restapi2.models.Event;
import com.example.restapi2.repositories.EventsRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @Nested
    class AddEventTests {
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

    }

    @Nested
    class GetEventsTests {
        @Test
        void getAllUsers() throws Exception {
            eventsRepository.save(Event.builder().passed(Event.Passed.NOT_PASSED).build());
            eventsRepository.save(Event.builder().passed(Event.Passed.NOT_PASSED).build());

            mockMvc.perform(get("/api/events"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.count", is(2)));

        }
        @Test
        void getExistEventTest() throws Exception {
            eventsRepository.save(Event.builder().passed(Event.Passed.NOT_PASSED).build());

            mockMvc.perform(get("/api/events/0")
                            .header("Content-Type", "application/json")
                            .content("{\n" +
                                    "  \"title\": \"Lecture\",\n" +
                                    "  \"date\": \"23.07.23\",\n" +
                                    "  \"passed\": \"NOT_PASSED\"\n" +
                                    "}"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(0)))
                    .andExpect(jsonPath("$.passed", is("NOT_PASSED")));
        }

        @Test
        void getNotExistEventTest() throws Exception {
            mockMvc.perform(get("/api/events/1"))
                    .andExpect(status().isNotFound());

        }
    }

    @Nested
    class DeleteEventTests {
        @Test
        void deleteExistEvent() throws Exception {
            eventsRepository.save(Event.builder().passed(Event.Passed.NOT_PASSED).build());

            mockMvc.perform(delete("/api/events/0"))
                    .andExpect(status().isOk());
        }

        @Test
        void deleteNotExistEvent() throws Exception {
            eventsRepository.save(Event.builder().passed(Event.Passed.NOT_PASSED).build());

            mockMvc.perform(delete("/api/events/1"))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    class UpdateUserTests {
        @Test
        void updateExistEvent() throws Exception {
            eventsRepository.save(Event.builder().passed(Event.Passed.NOT_PASSED).build());

            mockMvc.perform(put("/api/events/0")
                    .header("Content-Type", "application/json")
                    .content("" +
                            "{\n" +
                            "  \"newTitle\": \"Party\",\n" +
                            "  \"newDate\": \"10.07.2010\",\n" +
                            "  \"newPassed\": \"IS_PASSED\"\n" +
                            "}"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(0)))
                    .andExpect(jsonPath("$.title", is("Party")))
                    .andExpect(jsonPath("$.date", is("10.07.2010")))
                    .andExpect(jsonPath("$.passed", is("IS_PASSED")));
        }

        @Test
        void updateNotExistEvent() throws Exception {

            mockMvc.perform(put("/api/events/1")
                    .header("Content-Type", "application/json")
                    .content("" +
                    "{\n" +
                    "  \"newTitle\": \"Party\",\n" +
                    "  \"newDate\": \"10.07.2010\",\n" +
                    "  \"newPassed\": \"IS_PASSED\"\n" +
                    "}"))
                    .andExpect(status().isNotFound());

        }
    }
}

