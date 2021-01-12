package com.zakrzewski.intentionsbook.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class IntentionDTO {


    private LocalDate dateOfMass;

    private LocalTime timeOfMass;

    private String descriptionOfIntention;

    private String priestOfMass;

    private String otherComment;

    private int payment;


    public IntentionDTO() {
    }

    public IntentionDTO(LocalDate dateOfMass, LocalTime timeOfMass, String descriptionOfIntention, String priestOfMass, String otherComment, int payment) {
        this.dateOfMass = dateOfMass;
        this.timeOfMass = timeOfMass;
        this.descriptionOfIntention = descriptionOfIntention;
        this.priestOfMass = priestOfMass;
        this.otherComment = otherComment;
        this.payment = payment;
    }

    public LocalDate getDateOfMass() {
        return dateOfMass;
    }

    public void setDateOfMass(LocalDate dateOfMass) {
        this.dateOfMass = dateOfMass;
    }

    public LocalTime getTimeOfMass() {
        return timeOfMass;
    }

    public void setTimeOfMass(LocalTime timeOfMass) {
        this.timeOfMass = timeOfMass;
    }

    public String getDescriptionOfIntention() {
        return descriptionOfIntention;
    }

    public void setDescriptionOfIntention(String descriptionOfIntention) {
        this.descriptionOfIntention = descriptionOfIntention;
    }

    public String getPriestOfMass() {
        return priestOfMass;
    }

    public void setPriestOfMass(String priestOfMass) {
        this.priestOfMass = priestOfMass;
    }

    public String getOtherComment() {
        return otherComment;
    }

    public void setOtherComment(String otherComment) {
        this.otherComment = otherComment;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
