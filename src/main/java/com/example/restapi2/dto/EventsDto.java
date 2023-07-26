package com.example.restapi2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "Список событий")
public class EventsDto {

    @Schema(description = "События")
    private List<EventDto> events;

    @Schema(description = "Общее количество событий", example = "1")
    private Integer count;
}
