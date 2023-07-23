package com.example.restapi2.services;

import com.example.restapi2.dto.EventDto;
import com.example.restapi2.dto.EventsDto;
import com.example.restapi2.dto.NewEventDto;
import com.example.restapi2.models.Event;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);

    EventsDto getAllEvents();
}
