package com.example.restapi2.models;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "events")
public class User {

    public enum Role {
        ADMIN,
        USER,
        MANAGER

    }

    public enum State {
        NOT_CONFIRMED,
        CONFIRMED,
        BANNED,
        DELETED
    }


    private Long id;

    private String email;
    private String password;
    private Role role;
    private State state;

    private List<Event> events;

}
