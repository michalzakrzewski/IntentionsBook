package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.dtos.IntentionRequest;
import com.zakrzewski.intentionsbook.dtos.IntentionResponse;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.mappers.IntentionMapper;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import com.zakrzewski.intentionsbook.validators.IntentionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntentionService {

    private IntentionRepository intentionRepository;
    private IntentionMapper intentionMapper;
    private IntentionValidator intentionValidator;

    @Autowired
    public IntentionService(IntentionRepository intentionRepository, IntentionMapper intentionMapper, IntentionValidator intentionValidator) {
        this.intentionRepository = intentionRepository;
        this.intentionMapper = intentionMapper;
        this.intentionValidator = intentionValidator;
    }

    public void save(Intention intention){
        intentionRepository.save(intention);
    }

    public void save(IntentionRequest intentionRequest){
        intentionValidator.checkSaveIntentionCorrectly(intentionRequest);
        Intention intention = intentionMapper.mapToIntentionFromRequest(intentionRequest);
        intentionRepository.save(intention);
    }

    public List<IntentionResponse> getAllIntentions(){
        List<Intention> intentionList = intentionRepository.findAll();
        return intentionList.stream().map(intention -> intentionMapper.mapToIntentionResponse(intention)).collect(Collectors.toList());
    }
}
