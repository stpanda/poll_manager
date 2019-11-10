package com.example.poll.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PollRequest {
    //@JsonProperty(value = "Наименование")
    private String name;
    //@JsonProperty(value = "Дата начала(yyyy-MM-dd)")
    private LocalDate startDate;
    //@JsonProperty(value = "Дата окончания(yyyy-MM-dd)")
    private LocalDate endDate;
    //@JsonProperty(value = "Активность(true/false)")
    private Boolean isActivity;
    //@JsonProperty(value = "Список id вопросов")
    private List<Long> questions;
}
