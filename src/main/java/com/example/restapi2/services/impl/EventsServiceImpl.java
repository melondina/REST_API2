package com.example.restapi2.services.impl;

import com.example.restapi2.dto.EventDto;
import com.example.restapi2.dto.EventsDto;
import com.example.restapi2.dto.NewEventDto;
import com.example.restapi2.models.Event;
import com.example.restapi2.repositories.EventsRepository;
import com.example.restapi2.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.restapi2.dto.EventDto.from;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;
    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .title(newEvent.getTitle())
                .date(newEvent.getDate())
                .passed(Event.Passed.NOT_PASSED)
                .build();

        eventsRepository.save(event);

        return from(event);

    }

    @Override
    public EventsDto getAllEvents() {
        List<Event> events = eventsRepository.findAll();

        return EventsDto.builder()
                .events(from(events))
                .count(events.size())
                .build();
    }
}
