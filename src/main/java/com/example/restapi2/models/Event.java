package com.example.restapi2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    public enum Passed {
        IS_PASSED,
        NOT_PASSED
    }

    public enum Interest {
        IS_INTERESTING,
        NOT_INTERESTING
    }

    private Long id;
    private String title;
    private String date;
    private Passed passed;
    private Interest interest;


}
