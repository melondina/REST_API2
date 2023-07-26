package com.example.restapi2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Данные для добавления события")
public class NewEventDto {

    @Schema(description = "Название события", example = "Концерт")
    private String title;

    @Schema(description = "Дата проведения события. Формат даты: дд.мм.гггг", example = "23.12.2023")
    private String date;
}
