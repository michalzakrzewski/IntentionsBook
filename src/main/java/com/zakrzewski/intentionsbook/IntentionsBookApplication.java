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

        Intention intention = new Intention(LocalDate.of(2020, 11, 18), LocalTime.of(8,0), "Za ++ wypominkach", "brak", 50, proboszcz);
        Intention intention2 = new Intention(LocalDate.of(2020, 11, 18), LocalTime.of(18,0), "Za parafian", "brak", 100, wikary);
        intentionService.save(intention);
        intentionService.save(intention2);
    }


}
