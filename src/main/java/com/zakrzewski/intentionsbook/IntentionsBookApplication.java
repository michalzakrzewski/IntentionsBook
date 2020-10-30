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
        ChurchWorker churchWorker = new ChurchWorker();
        Intention intention = new Intention();
        Intention intention2 = new Intention();
        List<Intention> intentionList = new ArrayList<>();
        churchWorker.setLogin("admin");
        churchWorker.setPassword("qwerty");
        churchWorker.setFullName("Admin Admin");
        churchWorker.setChurchRole("Role Admin");
        intention.setDateOfMass(LocalDate.of(2020, 10, 20));
        intention.setTimeOfMass(LocalTime.of(8,0));
        intention.setDescriptionOfIntention("Za + poleconych w wypominkach");
        intention.setPriestOfMass("Kaplan Kaplan");
        intention.setOtherComment("none");
        intention.setPayment(50);

        intention2.setDateOfMass(LocalDate.of(2020, 10, 21));
        intention2.setTimeOfMass(LocalTime.of(7,0));
        intention2.setDescriptionOfIntention("Za ++ Jadwigę i Tadeusza");
        intention2.setPriestOfMass("Kaplan2 Kaplan2");
        intention2.setOtherComment("none2");
        intention2.setPayment(200);

        intentionList.add(intention);
        intentionList.add(intention2);

        churchWorker.setIntentions(intentionList);

        intentionService.save(intention);
        intentionService.save(intention2);
        churchWorkerService.save(churchWorker);

    }


}
