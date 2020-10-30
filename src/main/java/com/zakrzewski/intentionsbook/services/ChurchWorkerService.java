package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchWorkerService {

    private final ChurchWorkerRepository churchWorkerRepository;

    @Autowired
    public ChurchWorkerService(ChurchWorkerRepository churchWorkerRepository) {
        this.churchWorkerRepository = churchWorkerRepository;
    }

    public List<ChurchWorker> getAllChurchWorkers(){
        return churchWorkerRepository.findAll();
    }

    public void save(ChurchWorker churchWorker){
        churchWorkerRepository.save(churchWorker);
    }

    public ChurchWorker findChurchWorkerByFullName(String fullName){
        return churchWorkerRepository.findChurchWorkerByFullName(fullName);
    }


}
