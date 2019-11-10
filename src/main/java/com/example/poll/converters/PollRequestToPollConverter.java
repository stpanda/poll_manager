package com.example.poll.converters;

import com.example.poll.convertservice.Converter;
import com.example.poll.model.Poll;
import com.example.poll.rest.request.PollRequest;
import org.springframework.stereotype.Component;

@Component
public class PollRequestToPollConverter  implements Converter<PollRequest, Poll> {

    @Override
    public Poll convert(PollRequest source) {
        Poll target = new Poll();
        target.setName(source.getName());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        target.setIsActivity(source.getIsActivity());
        return target;
    }

    @Override
    public Class<PollRequest> getSource() {
        return PollRequest.class;
    }

    @Override
    public Class<Poll> getTarget() {
        return Poll.class;
    }
}
