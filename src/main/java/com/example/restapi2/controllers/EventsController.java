package com.example.restapi2.controllers;

import com.example.restapi2.dto.EventDto;
import com.example.restapi2.dto.EventsDto;
import com.example.restapi2.dto.NewEventDto;
import com.example.restapi2.models.Event;
import com.example.restapi2.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventsController {

    private final EventsService eventsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto addEvent(@RequestBody NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }

    @GetMapping
    public EventsDto getAllEvents() {
        return eventsService.getAllEvents();
    }

}
