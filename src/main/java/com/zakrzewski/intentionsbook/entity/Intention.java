package com.zakrzewski.intentionsbook.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "intention")
public class Intention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_mass")
    private LocalDate dateOfMass;

    @Column(name = "time_of_mass")
    private LocalTime timeOfMass;

    @Column(name = "description_of_intention")
    private String descriptionOfIntention;

    @Column(name = "which_priest")
    private String priestOfMass;

    @Column(name = "others_attention")
    private String otherComment;

    @Column(name = "payment")
    private int payment;

    @OneToOne
    @JoinColumn(name = "church_worker_id")
    private ChurchWorker churchWorker;

    public Intention() {
    }

    public Intention(LocalDate dateOfMass, LocalTime timeOfMass, String descriptionOfIntention, String priestOfMass, String otherComment, int payment) {
        this.dateOfMass = dateOfMass;
        this.timeOfMass = timeOfMass;
        this.descriptionOfIntention = descriptionOfIntention;
        this.priestOfMass = priestOfMass;
        this.otherComment = otherComment;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ChurchWorker getChurchWorker() {
        return churchWorker;
    }

    public void setChurchWorker(ChurchWorker churchWorker) {
        this.churchWorker = churchWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intention intention = (Intention) o;
        return payment == intention.payment &&
                Objects.equals(id, intention.id) &&
                Objects.equals(dateOfMass, intention.dateOfMass) &&
                Objects.equals(timeOfMass, intention.timeOfMass) &&
                Objects.equals(descriptionOfIntention, intention.descriptionOfIntention) &&
                Objects.equals(priestOfMass, intention.priestOfMass) &&
                Objects.equals(otherComment, intention.otherComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfMass, timeOfMass, descriptionOfIntention, priestOfMass, otherComment, payment);
    }

    @Override
    public String toString() {
        return "Intention{" +
                "id=" + id +
                ", dateOfMass=" + dateOfMass +
                ", timeOfMass=" + timeOfMass +
                ", descriptionOfIntention='" + descriptionOfIntention + '\'' +
                ", priestOfMass='" + priestOfMass + '\'' +
                ", otherComment='" + otherComment + '\'' +
                ", payment=" + payment +
                '}';
    }
}
