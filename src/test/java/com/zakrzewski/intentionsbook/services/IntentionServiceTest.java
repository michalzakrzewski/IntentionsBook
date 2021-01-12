package com.zakrzewski.intentionsbook.services;


import com.zakrzewski.intentionsbook.dtos.IntentionDTO;
import com.zakrzewski.intentionsbook.mappers.IntentionMapper;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IntentionServiceTest {

    private IntentionService intentionService;
    private IntentionMapper intentionMapper;
    private IntentionRepository intentionRepository;

    @BeforeEach
    public void setup(){
        intentionMapper = Mockito.mock(IntentionMapper.class);
        intentionRepository = Mockito.mock(IntentionRepository.class);
        intentionService = new IntentionService(intentionRepository, intentionMapper);
    }


    @Test
    public void saveIntentionDTO_emptyParameters_throwIllegalArgumentException(){
        IntentionDTO intentionDTO = new IntentionDTO(null, null, "", "", "",  0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> intentionService.saveIntentionDTO(intentionDTO));
    }

}