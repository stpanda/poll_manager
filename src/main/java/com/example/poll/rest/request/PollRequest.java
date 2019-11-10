package com.example.poll.rest.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PollRequest {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActivity;
    private List<Long> questions;
}
