package com.example.restapi2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Данные для добавления пользователя")
@Data
public class NewUserDto {
    @Schema(description = "Email пользователя", example = "simple@mail.com")
    private String email;
    @Schema(description = "Пароль пользователя", example = "123456789")
    private String password;
}
