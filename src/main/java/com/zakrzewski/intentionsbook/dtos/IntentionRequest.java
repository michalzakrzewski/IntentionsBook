package com.zakrzewski.intentionsbook.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class IntentionRequest {

    private LocalDate dateOfMass;
    private LocalTime timeOfMass;
    private String descriptionOfIntention;
    private String otherComment;
    private int payment;
    private Long churchWorkerId;

    public static class IntentionRequestBuilder {
        private LocalDate dateOfMass;
        private LocalTime timeOfMass;
        private String descriptionOfIntention;
        private String otherComment;
        private int payment;
        private Long churchWorkerId;

        public IntentionRequest.IntentionRequestBuilder dateOfMass(LocalDate dateOfMass){
            this.dateOfMass = dateOfMass;
            return this;
        }

        public IntentionRequest.IntentionRequestBuilder timeOfMass(LocalTime timeOfMass){
            this.timeOfMass = timeOfMass;
            return this;
        }
        public IntentionRequest.IntentionRequestBuilder descriptionOfIntention(String descriptionOfIntention){
            this.descriptionOfIntention = descriptionOfIntention;
            return this;
        }
        public IntentionRequest.IntentionRequestBuilder otherComment(String otherComment){
            this.otherComment = otherComment;
            return this;
        }
        public IntentionRequest.IntentionRequestBuilder payment(int payment){
            this.payment = payment;
            return this;
        }
        public IntentionRequest.IntentionRequestBuilder churchWorkerId(Long churchWorkerId){
            this.churchWorkerId = churchWorkerId;
            return this;
        }

        public IntentionRequest build(){
            IntentionRequest intentionRequest = new IntentionRequest();
            intentionRequest.dateOfMass = this.dateOfMass;
            intentionRequest.timeOfMass = this.timeOfMass;
            intentionRequest.descriptionOfIntention = this.descriptionOfIntention;
            intentionRequest.otherComment = this.otherComment;
            intentionRequest.payment = this.payment;
            intentionRequest.churchWorkerId = this.churchWorkerId;

            return intentionRequest;
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


    public String getOtherComment() {
        return otherComment;
    }


    public int getPayment() {
        return payment;
    }


    public Long getChurchWorkerId() {
        return churchWorkerId;
    }

}
