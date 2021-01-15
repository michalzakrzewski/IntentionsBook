package com.zakrzewski.intentionsbook.validators;

import com.zakrzewski.intentionsbook.dtos.IntentionRequest;
import org.springframework.stereotype.Component;

@Component
public class IntentionValidator {

    public void checkSaveIntentionCorrectly(IntentionRequest intentionRequest){
        if (intentionRequest.getDateOfMass() == null){
            throw new IllegalArgumentException("Date time of mass cannot be empty");
        }
        if (intentionRequest.getTimeOfMass() == null){
            throw new IllegalArgumentException("Time of mass cannot be empty");
        }
        if ("".equals(intentionRequest.getDescriptionOfIntention())){
            throw new IllegalArgumentException("Description of mass cannot be empty");
        }
        if (intentionRequest.getChurchWorkerId() == null){
            throw new IllegalArgumentException("Intention must have assign Priest");
        }
        if (intentionRequest.getPayment() <= 0){
            throw new NumberFormatException("Payment cannot be equal or less than 0");
        }
    }
}
