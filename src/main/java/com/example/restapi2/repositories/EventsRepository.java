package com.example.restapi2.repositories;

import com.example.restapi2.models.Event;

import java.util.List;

public interface EventsRepository {
    void save(Event event);

    List<Event> findAll();

    void clear();
}
