package com.example.restapi2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Данные для обновления")
public class UpdateEventDto {

    @Schema(description = "Название события", example = "Lecture")
    private String newTitle;

    @Schema(description = "Дата события", example = "25.05.2021")
    private String newDate;

    @Schema(description = "Прошло или нет IS_PASSED - прошло, NOT_PASSED - не прошло)", example = "IS_PASSED")
    private String newPassed;

}
