package com.zakrzewski.intentionsbook.mappers;

import com.zakrzewski.intentionsbook.dtos.IntentionRequest;
import com.zakrzewski.intentionsbook.dtos.IntentionResponse;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntentionMapper {

    private ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public IntentionMapper(ChurchWorkerRepository churchWorkerRepository) {
        this.churchWorkerRepository = churchWorkerRepository;
    }

    public IntentionResponse mapToIntentionResponse(Intention intention){
        IntentionResponse intentionResponse = new IntentionResponse.IntentionResponseBuilder()
                .dateOfMass(intention.getDateOfMass())
                .timeOfMass(intention.getTimeOfMass())
                .descriptionOfIntention(intention.getDescriptionOfIntention())
                .priestOfMassName(intention.getChurchWorker().getFullName())
                .build();
        return  intentionResponse;
    }

    public Intention mapToIntentionFromRequest(IntentionRequest intentionRequest){
        Intention intention = new Intention();
        intention.setDateOfMass(intentionRequest.getDateOfMass());
        intention.setTimeOfMass(intentionRequest.getTimeOfMass());
        intention.setOtherComment(intentionRequest.getOtherComment());
        intention.setDescriptionOfIntention(intentionRequest.getDescriptionOfIntention());
        intention.setPayment(intentionRequest.getPayment());
        intention.setChurchWorker(churchWorkerRepository.findById(intentionRequest.getChurchWorkerId()).orElseThrow(() -> new IllegalArgumentException(String.format("Church worker id %s not found", intentionRequest.getChurchWorkerId()))));
        return intention;

    }
}
