package com.zakrzewski.intentionsbook.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class IntentionResponse {

    private LocalDate dateOfMass;
    private LocalTime timeOfMass;
    private String descriptionOfIntention;
    private String priestOfMassName;

    public static class IntentionResponseBuilder {
        private LocalDate dateOfMass;
        private LocalTime timeOfMass;
        private String descriptionOfIntention;
        private String priestOfMassName;

        public IntentionResponse.IntentionResponseBuilder dateOfMass(LocalDate dateOfMass){
            this.dateOfMass = dateOfMass;
            return this;
        }

        public IntentionResponse.IntentionResponseBuilder timeOfMass(LocalTime timeOfMass){
            this.timeOfMass = timeOfMass;
            return this;
        }
        public IntentionResponse.IntentionResponseBuilder descriptionOfIntention(String descriptionOfIntention){
            this.descriptionOfIntention = descriptionOfIntention;
            return this;
        }
        public IntentionResponse.IntentionResponseBuilder priestOfMassName(String priestOfMassName){
            this.priestOfMassName = priestOfMassName;
            return this;
        }

        public IntentionResponse build(){
            IntentionResponse intentionResponse = new IntentionResponse();
            intentionResponse.dateOfMass = this.dateOfMass;
            intentionResponse.timeOfMass = this.timeOfMass;
            intentionResponse.descriptionOfIntention = this.descriptionOfIntention;
            intentionResponse.priestOfMassName = this.priestOfMassName;
            return intentionResponse;
        }
    }

    public LocalDate getDateOfMass() {
        return dateOfMass;
    }

    public LocalTime getTimeOfMass() {
        return timeOfMass;
    }

    public String getDescriptionOfIntention() {
        return descriptionOfIntention;
    }

    public String getPriestOfMassName() {
        return priestOfMassName;
    }
}
