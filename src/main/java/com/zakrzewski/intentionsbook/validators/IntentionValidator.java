package com.zakrzewski.intentionsbook.validators;

import com.zakrzewski.intentionsbook.dtos.IntentionRequest;
import com.zakrzewski.intentionsbook.exceptions.IntentionException;
import org.springframework.stereotype.Component;

@Component
public class IntentionValidator {

    public void checkSaveIntentionCorrectly(IntentionRequest intentionRequest){
        if (intentionRequest.getDateOfMass() == null){
            throw new IntentionException("Date time of mass cannot be empty");
        }
        if (intentionRequest.getTimeOfMass() == null){
            throw new IntentionException("Time of mass cannot be empty");
        }
        if ("".equals(intentionRequest.getDescriptionOfIntention())){
            throw new IntentionException("Description of mass cannot be empty");
        }
        if (intentionRequest.getChurchWorkerId() == null){
            throw new IntentionException("Intention must have assign Priest");
        }
        if (intentionRequest.getPayment() <= 0){
            throw new IntentionException("Payment cannot be equal or less than 0");
        }
    }
}
