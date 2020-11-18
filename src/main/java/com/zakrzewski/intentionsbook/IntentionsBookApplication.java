package com.zakrzewski.intentionsbook;

import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import com.zakrzewski.intentionsbook.services.ChurchWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IntentionsBookApplication {

    private final ChurchWorkerService churchWorkerService;
    private final IntentionRepository intentionService;

    @Autowired
    public IntentionsBookApplication(ChurchWorkerService churchWorkerService, IntentionRepository intentionService) {
        this.churchWorkerService = churchWorkerService;
        this.intentionService = intentionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(IntentionsBookApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createFinalIntention(){
       ChurchWorker proboszcz = new ChurchWorker("proboszcz", "qwerty", "Proboszcz Proboszcz", "proboszcz");
       ChurchWorker wikary = new ChurchWorker("wikary", "qwerty", "Wikary Wikary", "wikary");
       churchWorkerService.save(proboszcz);
       churchWorkerService.save(wikary);
       Intention intention1 = new Intention(LocalDate.of(2020, 11, 21), LocalTime.of(8, 0), "Za ++ zbiorowa", proboszcz.getFullName(), "brak", 50);
       Intention intention2 = new Intention(LocalDate.of(2020, 11, 21), LocalTime.of(8, 0), "Za gregoriańska", wikary.getFullName(), "brak", 200);
       intention1.setChurchWorker(proboszcz);
       intention2.setChurchWorker(wikary);
       intentionService.save(intention1);
       intentionService.save(intention2);

    }


}
