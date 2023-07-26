package com.example.restapi2.controllers;

import com.example.restapi2.controllers.api.EventsApi;
import com.example.restapi2.dto.EventDto;
import com.example.restapi2.dto.EventsDto;
import com.example.restapi2.dto.NewEventDto;
import com.example.restapi2.dto.UpdateEventDto;
import com.example.restapi2.services.EventsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController

public class EventsController implements EventsApi {

    private final EventsService eventsService;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }

    @Override
    public EventsDto getAllEvents() {
        return eventsService.getAllEvents();
    }

    @Override
    public EventDto deleteEvent(Long eventId) {
        return eventsService.deleteEvent(eventId);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return eventsService.updateEvent(eventId, updateEvent);
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return eventsService.getEvent(eventId);
    }

}
