package com.example.restapi2.dto;

import com.example.restapi2.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Событие")
public class EventDto {

    @Schema(description = "Идентификатор события", example = "1")
    private Long id;

    @Schema(description = "Название события", example = "Концерт")
    private String title;

    @Schema(description = "Дата проведения события", example = "23.12.2023")
    private String date;

    @Schema(description = "Состоялось событие или нет. IS_PASSED - событие состоялось, NOT_PASSED - событие не состоялось", example = "NOT_PASSED")
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
