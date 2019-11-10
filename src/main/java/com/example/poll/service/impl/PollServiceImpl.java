package com.example.poll.service.impl;

import com.example.poll.convertservice.ConversionService;
import com.example.poll.exceptions.ResourceNotFoundException;
import com.example.poll.model.Poll;
import com.example.poll.model.Question;
import com.example.poll.repository.PollRepository;
import com.example.poll.repository.QuestionRepository;
import com.example.poll.rest.request.PollRequest;
import com.example.poll.rest.response.PollResponse;
import com.example.poll.service.PollService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;
    private final ConversionService conversionService;
    private final QuestionRepository questionRepository;

    @Override
    public Page<PollResponse> getAll(Predicate predicate, Pageable pageable) {
        if(predicate == null) {
            return conversionService.convertToPage(pageable, pollRepository.findAll(pageable), PollResponse.class);
        }
        return conversionService.convertToPage(pageable, pollRepository.findAll(predicate, pageable), PollResponse.class);
    }

    @Override
    public Long create(PollRequest request) {
        Poll poll = conversionService.convert(request, Poll.class);
        poll.setQuestions(questionRepository.findAllById(request.getQuestions()));
        pollRepository.saveAndFlush(poll);
        return poll.getId();
    }

    @Override
    @Transactional
    public void update(Long id, PollRequest request) {
        Poll poll = getPollByIdOrThrowException(id);
        pollRepository.saveAndFlush(updatePollFields(poll, request));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pollRepository.deleteById(id);
    }

    private Poll getPollByIdOrThrowException(Long id) {
        return Optional.of(pollRepository.getOne(id))
                .orElseThrow(() -> new ResourceNotFoundException("Poll not found"));
    }

    private Poll updatePollFields(Poll poll, PollRequest request) {
        List<Question> questions = request.getQuestions().stream()
                .map(Question::new)
                .collect(Collectors.toList());
        Optional.ofNullable(request.getName())
                .ifPresent(poll::setName);
        Optional.ofNullable(request.getStartDate())
                .ifPresent(poll::setStartDate);
        Optional.ofNullable(request.getEndDate())
                .ifPresent(poll::setEndDate);
        Optional.ofNullable(request.getIsActivity())
                .ifPresent(poll::setIsActivity);
        Optional.ofNullable(request.getQuestions())
                .ifPresent(question -> poll.setQuestions(questions));
        return poll;
    }
}
