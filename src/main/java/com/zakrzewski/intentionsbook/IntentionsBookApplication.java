package com.zakrzewski.intentionsbook;

import com.zakrzewski.intentionsbook.configurations.WebSecurityConfig;
import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.mappers.ChurchWorkerMapper;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import com.zakrzewski.intentionsbook.services.ChurchWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class IntentionsBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntentionsBookApplication.class, args);
    }
}
