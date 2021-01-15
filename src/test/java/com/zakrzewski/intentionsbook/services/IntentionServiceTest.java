package com.zakrzewski.intentionsbook.services;


import com.zakrzewski.intentionsbook.dtos.IntentionRequest;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.mappers.IntentionMapper;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import com.zakrzewski.intentionsbook.validators.IntentionValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;


public class IntentionServiceTest {

    private IntentionService intentionService;
    private IntentionMapper intentionMapper;
    private IntentionRepository intentionRepository;
    private IntentionValidator intentionValidator;

    @BeforeEach
    public void setup(){
        intentionMapper = Mockito.mock(IntentionMapper.class);
        intentionRepository = Mockito.mock(IntentionRepository.class);
        intentionValidator = new IntentionValidator();
        intentionService = new IntentionService(intentionRepository, intentionMapper, intentionValidator);
    }

    @Test
    public void saveIntention_allParametersOk_savedCorrectly(){
        ChurchWorker churchWorker = new ChurchWorker("t_test", "qwerty", "Test Test", "Kapłan");
        Intention intention = new Intention(LocalDate.of(2021, Month.APRIL, 22), LocalTime.of(8, 0), "Za ++ test", "brak", 100, churchWorker);
        intentionService.save(intention);
        Mockito.verify(intentionRepository, Mockito.times(1)).save(intention);
    }

    @Test
    public void saveIntention_emptyDateOfMass_throwsException(){
        IntentionRequest intentionRequest = new IntentionRequest.IntentionRequestBuilder()
                .dateOfMass(null)
                .timeOfMass(LocalTime.of(8, 0))
                .descriptionOfIntention("Za ++ testowych")
                .otherComment("brak")
                .payment(100)
                .churchWorkerId(1L)
                .build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> intentionService.save(intentionRequest));
    }

    @Test
    public void saveIntention_emptyTimeOfMass_throwsException(){
        IntentionRequest intentionRequest = new IntentionRequest.IntentionRequestBuilder()
                .dateOfMass(LocalDate.of(2020, Month.APRIL, 22))
                .timeOfMass(null)
                .descriptionOfIntention("Za ++ testowych")
                .otherComment("brak")
                .payment(100)
                .churchWorkerId(1L)
                .build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> intentionService.save(intentionRequest));
    }

    @Test
    public void saveIntention_emptyDescriptionOfMass_throwsException(){
        IntentionRequest intentionRequest = new IntentionRequest.IntentionRequestBuilder()
                .dateOfMass(LocalDate.of(2020, Month.APRIL, 22))
                .timeOfMass(LocalTime.of(8, 0))
                .descriptionOfIntention("")
                .otherComment("brak")
                .payment(100)
                .churchWorkerId(1L)
                .build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> intentionService.save(intentionRequest));
    }

    @Test
    public void saveIntention_lessThanZeroPayment_throwsException(){
        IntentionRequest intentionRequest = new IntentionRequest.IntentionRequestBuilder()
                .dateOfMass(LocalDate.of(2020, Month.APRIL, 22))
                .timeOfMass(LocalTime.of(8, 0))
                .descriptionOfIntention("Za ++ testowych")
                .otherComment("brak")
                .payment(-100)
                .churchWorkerId(1L)
                .build();
        Assertions.assertThrows(NumberFormatException.class, () -> intentionService.save(intentionRequest));
    }

    @Test
    public void saveIntention_equalsZeroPayment_throwsException(){
        IntentionRequest intentionRequest = new IntentionRequest.IntentionRequestBuilder()
                .dateOfMass(LocalDate.of(2020, Month.APRIL, 22))
                .timeOfMass(LocalTime.of(8, 0))
                .descriptionOfIntention("Za ++ testowych")
                .otherComment("brak")
                .payment(0)
                .churchWorkerId(1L)
                .build();
        Assertions.assertThrows(NumberFormatException.class, () -> intentionService.save(intentionRequest));
    }

    @Test
    public void saveIntention_emptyChurchWorker_throwsException(){
        IntentionRequest intentionRequest = new IntentionRequest.IntentionRequestBuilder()
                .dateOfMass(LocalDate.of(2020, Month.APRIL, 22))
                .timeOfMass(LocalTime.of(8, 0))
                .descriptionOfIntention("Za ++ testowych")
                .otherComment("brak")
                .payment(100)
                .churchWorkerId(null)
                .build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> intentionService.save(intentionRequest));
    }
}