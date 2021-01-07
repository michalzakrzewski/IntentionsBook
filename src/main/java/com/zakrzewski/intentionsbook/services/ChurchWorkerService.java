package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
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

    public void save(ChurchWorkerDTO churchWorkerDTO){
        String encodePassword = passwordEncoder().encode(churchWorkerDTO.getPassword());
        churchWorkerDTO.setPassword(encodePassword);
        ChurchWorker churchWorker = churchWorkerMapper.mapToChurchWorker(churchWorkerDTO);
        churchWorkerRepository.save(churchWorker);
    }

    public List<ChurchWorker> getAllChurchWorkers(){
        return churchWorkerRepository.findAll();
    }

    public List<ChurchWorkerDTO> getAllChurchWorkerDTO(){
        List<ChurchWorker> churchWorkers = churchWorkerRepository.findAll();
        return churchWorkers.stream().map(churchWorker -> churchWorkerMapper.mapToChurchWorkerDTO(churchWorker)).collect(Collectors.toList());
    }


    public ChurchWorkerDTO findChurchWorkerByLogin(String login){
        ChurchWorker churchWorkerByLogin = churchWorkerRepository.findChurchWorkerByLogin(login);
        ChurchWorkerDTO churchWorkerDTO = churchWorkerMapper.mapToChurchWorkerDTO(churchWorkerByLogin);
        return churchWorkerDTO;
    }


}
