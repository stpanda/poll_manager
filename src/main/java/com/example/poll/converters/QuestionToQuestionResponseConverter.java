package com.example.poll.converters;

import com.example.poll.convertservice.Converter;
import com.example.poll.model.Question;
import com.example.poll.rest.response.QuestionResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionToQuestionResponseConverter implements Converter<Question, QuestionResponse> {

    @Override
    public QuestionResponse convert(Question source) {
        QuestionResponse target = new QuestionResponse();
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        return target;
    }

    @Override
    public Class<Question> getSource() {
        return Question.class;
    }

    @Override
    public Class<QuestionResponse> getTarget() {
        return QuestionResponse.class;
    }
}
