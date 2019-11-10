package com.example.poll.rest.controller;

import com.example.poll.model.Poll;
import com.example.poll.rest.BaseResponse;
import com.example.poll.rest.request.PollRequest;
import com.example.poll.rest.response.PollResponse;
import com.example.poll.service.PollService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PollController extends BaseController{

    private final PollService pollService;

    @GetMapping
    public BaseResponse<List<PollResponse>> getAll(
            @QuerydslPredicate(root = Poll.class) Predicate predicate, Pageable pageable) {
        return new BaseResponse<>(pollService.getAll(predicate, pageable).getContent());
    }

    @PostMapping
    public BaseResponse add(@RequestBody PollRequest pollRequest) {
        return new BaseResponse<>(pollService.create(pollRequest));
    }

    @PutMapping
    public void update(@RequestParam Long id, @RequestBody PollRequest pollRequest) {
        pollService.update(id, pollRequest);
    }

    @DeleteMapping
    public void delete(Long id) {
        pollService.delete(id);
    }
}
