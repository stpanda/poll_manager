package com.example.poll.rest.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PollResponse {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActivity;
    private List<QuestionResponse> questions;
}
