package com.zakrzewski.intentionsbook.mappers;

import com.zakrzewski.intentionsbook.dtos.IntentionDTO;
import com.zakrzewski.intentionsbook.entity.Intention;
import org.springframework.stereotype.Component;

@Component
public class IntentionMapper {

    public IntentionDTO mapToIntentionDTO(Intention intention){
        IntentionDTO intentionDTO = new IntentionDTO();
        intentionDTO.setDateOfMass(intention.getDateOfMass());
        intentionDTO.setTimeOfMass(intention.getTimeOfMass());
        intentionDTO.setDescriptionOfIntention(intention.getDescriptionOfIntention());
        intentionDTO.setPriestOfMass(intention.getPriestOfMass().getFullName());
        intentionDTO.setOtherComment(intention.getOtherComment());
        intentionDTO.setPayment(intention.getPayment());
        return intentionDTO;
    }

    public Intention mapToIntention(IntentionDTO intentionDTO){
        Intention intention = new Intention();
        intention.setDateOfMass(intentionDTO.getDateOfMass());
        intention.setTimeOfMass(intentionDTO.getTimeOfMass());
        intention.setOtherComment(intentionDTO.getOtherComment());
        intention.setDescriptionOfIntention(intentionDTO.getDescriptionOfIntention());
        intention.setPayment(intentionDTO.getPayment());
        return intention;
    }
}
