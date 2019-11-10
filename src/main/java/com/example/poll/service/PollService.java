package com.example.poll.service;

import com.example.poll.rest.request.PollRequest;
import com.example.poll.rest.response.PollResponse;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PollService {

    Page<PollResponse> getAll(Predicate predicate, Pageable pageable);

    Long create(PollRequest pollRequest);

    void update(Long id, PollRequest pollRequest);

    void delete(Long id);
}
