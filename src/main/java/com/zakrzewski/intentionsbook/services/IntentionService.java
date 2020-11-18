package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntentionService {

    private IntentionRepository intentionRepository;

    @Autowired
    public IntentionService(IntentionRepository intentionRepository) {
        this.intentionRepository = intentionRepository;
    }

    public List<Intention> getAllIntentions(){
        return intentionRepository.findAll();
    }

    public void save(Intention intention){
        intentionRepository.save(intention);
    }


}
