package com.example.poll.rest.controller;

import com.example.poll.config.ApiPageable;
import com.example.poll.model.Poll;
import com.example.poll.rest.BaseResponse;
import com.example.poll.rest.request.PollRequest;
import com.example.poll.rest.response.PollResponse;
import com.example.poll.service.PollService;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiPageable
    @ApiOperation(value = "Получение списка опросов", notes = "Для фильтрации отправить запрос с подобными параметрами " +
            "?size=10&page=0&sort=endDate%2Casc&sort=startDate%2Casc&name=Second&isActivity=true")
    public BaseResponse<List<PollResponse>> getAll(
            @QuerydslPredicate(root = Poll.class) Predicate predicate, Pageable pageable) {
        return new BaseResponse<>(pollService.getAll(predicate, pageable).getContent());
    }

    @PostMapping
    @ApiOperation(value = "Добавление опроса", notes = "Формат дат: yyyy-MM-dd. Поле question принимает массив из id вопросов")
    public BaseResponse add(@RequestBody PollRequest pollRequest) {
        return new BaseResponse<>(pollService.create(pollRequest));
    }

    @PutMapping
    @ApiOperation(value = "Обновление опроса по id", notes = "Формат дат: yyyy-MM-dd. Поле question принимает массив из id вопросов")
    public void update(@ApiParam(value = "id опроса") @RequestParam Long id, @RequestBody PollRequest pollRequest) {
        pollService.update(id, pollRequest);
    }

    @DeleteMapping
    @ApiOperation(value = "Удаление опроса по id")
    public void delete(@ApiParam(value = "id опроса") Long id) {
        pollService.delete(id);
    }
}
