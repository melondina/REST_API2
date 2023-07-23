package com.example.restapi2.repositories.impl;

import com.example.restapi2.models.Event;
import com.example.restapi2.repositories.EventsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventsRepositoryListImpl implements EventsRepository {
    private static List<Event> events = new ArrayList<>();

    @Override
    public void save(Event event) {
        event.setId((long) events.size());
        events.add(event);
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events) ;
    }

    @Override
    public void clear() {
        events.clear();
    }
}
