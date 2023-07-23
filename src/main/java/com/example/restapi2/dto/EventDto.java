package com.example.restapi2.dto;

import com.example.restapi2.models.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private Long id;
    private String title;
    private String date;
    private String passed;

    public static EventDto from(Event event) {

        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .date(event.getDate())
                .passed(event.getPassed().name())
                .build();
    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());

    }

}
