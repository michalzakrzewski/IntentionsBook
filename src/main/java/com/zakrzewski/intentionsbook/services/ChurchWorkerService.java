package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchWorkerService {

    private ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public ChurchWorkerService(ChurchWorkerRepository churchWorkerRepository) {
        this.churchWorkerRepository = churchWorkerRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public List<ChurchWorker> getAllChurchWorkers(){
        return churchWorkerRepository.findAll();
    }

    public void save(ChurchWorker churchWorker){
        passwordEncoder().encode(churchWorker.getPassword());
        churchWorkerRepository.save(churchWorker);
    }

    public ChurchWorker findChurchWorkerByLogin(String login){
        return churchWorkerRepository.findChurchWorkerByLogin(login);
    }


}
