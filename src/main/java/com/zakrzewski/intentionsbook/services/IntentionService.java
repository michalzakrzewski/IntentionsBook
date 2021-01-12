package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.dtos.IntentionDTO;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.mappers.IntentionMapper;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntentionService {

    private IntentionRepository intentionRepository;
    private IntentionMapper intentionMapper;

    @Autowired
    public IntentionService(IntentionRepository intentionRepository, IntentionMapper intentionMapper) {
        this.intentionRepository = intentionRepository;
        this.intentionMapper = intentionMapper;
    }

    public List<Intention> getAllIntentions(){
        return intentionRepository.findAll();
    }

    public List<IntentionDTO> getAllIntentionDTO(){
        List<Intention> intentions = intentionRepository.findAll();
        return intentions.stream().map(intention -> intentionMapper.mapToIntentionDTO(intention)).collect(Collectors.toList());
    }

    public void saveIntentionDTO(IntentionDTO intentionDTO){
        if (intentionDTO.getDateOfMass() == null || intentionDTO.getTimeOfMass() == null
                || intentionDTO.getDescriptionOfIntention().equals("") || intentionDTO.getPriestOfMass().equals("")
                || intentionDTO.getOtherComment().equals("") || intentionDTO.getPayment() == 0){
            throw new IllegalArgumentException("Parameters cannot be empty");
        }
        Intention intention = intentionMapper.mapToIntention(intentionDTO);
        intentionRepository.save(intention);
    }


}
