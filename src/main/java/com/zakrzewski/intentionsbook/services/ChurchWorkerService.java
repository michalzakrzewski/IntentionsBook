package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.dtos.ChurchWorkerResponse;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.mappers.ChurchWorkerMapper;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChurchWorkerService {

    private ChurchWorkerRepository churchWorkerRepository;
    private ChurchWorkerMapper churchWorkerMapper;

    @Autowired
    public ChurchWorkerService(ChurchWorkerRepository churchWorkerRepository, ChurchWorkerMapper churchWorkerMapper) {
        this.churchWorkerRepository = churchWorkerRepository;
        this.churchWorkerMapper = churchWorkerMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(ChurchWorkerRequest churchWorkerRequest){
        String encodePassword = passwordEncoder().encode(churchWorkerRequest.getPassword());
        churchWorkerRequest.setPassword(encodePassword);
        ChurchWorker churchWorker = churchWorkerMapper.mapToChurchWorkerFromRequest(churchWorkerRequest);
        churchWorkerRepository.save(churchWorker);
    }

    public List<ChurchWorkerResponse> getAllChurchWorkerResponse(){
        List<ChurchWorker> churchWorkerList = churchWorkerRepository.findAll();
        return churchWorkerList.stream().map(churchWorker -> churchWorkerMapper.mapToChurchWorkerResponse(churchWorker)).collect(Collectors.toList());
    }
}
