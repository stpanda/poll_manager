package com.example.poll.converters;

import com.example.poll.convertservice.ConversionService;
import com.example.poll.convertservice.Converter;
import com.example.poll.model.Poll;
import com.example.poll.rest.response.PollResponse;
import com.example.poll.rest.response.QuestionResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PollToPollResponseConverter implements Converter<Poll, PollResponse> {

    private final ConversionService conversionService;

    @Override
    public PollResponse convert(Poll source) {
        PollResponse target = new PollResponse();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        target.setIsActivity(source.getIsActivity());
        target.setQuestions(conversionService.convertToList(source.getQuestions(), QuestionResponse.class));
        return target;
    }

    @Override
    public Class<Poll> getSource() {
        return Poll.class;
    }

    @Override
    public Class<PollResponse> getTarget() {
        return PollResponse.class;
    }
}
