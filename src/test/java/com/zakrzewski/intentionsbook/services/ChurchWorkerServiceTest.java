package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.exceptions.ChurchWorkerException;
import com.zakrzewski.intentionsbook.mappers.ChurchWorkerMapper;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import com.zakrzewski.intentionsbook.validators.ChurchWorkerValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ChurchWorkerServiceTest {

    private ChurchWorkerService churchWorkerService;
    private ChurchWorkerRepository churchWorkerRepository;
    private ChurchWorkerMapper churchWorkerMapper;
    private ChurchWorkerValidator churchWorkerValidator;

    @BeforeEach
    public void setup(){
        churchWorkerMapper = Mockito.mock(ChurchWorkerMapper.class);
        churchWorkerRepository = Mockito.mock(ChurchWorkerRepository.class);
        churchWorkerValidator = new ChurchWorkerValidator();
        churchWorkerService = new ChurchWorkerService(churchWorkerRepository, churchWorkerMapper, churchWorkerValidator);
    }


    @Test
    public void saveChurchWorker_nullChurchWorker_throwsException(){
        Assertions.assertThrows(NullPointerException.class, () -> churchWorkerService.save((ChurchWorkerRequest) null));
    }

    @Test
    public void saveChurchWorker_allParamsOk_savedCorrectly(){
        ChurchWorker churchWorker = new ChurchWorker("a_nowak", "qwerty", "Adam Nowak", "Kapłan");

        churchWorkerService.save(churchWorker);
        Mockito.verify(churchWorkerRepository, Mockito.times(1)).save(churchWorker);
    }

    @Test
    public void saveChurchWorker_emptyLogin_throwsException(){
        ChurchWorkerRequest churchWorkerRequest = new ChurchWorkerRequest.ChurchWorkerRequestBuilder()
                .login("")
                .password("qwerty")
                .fullName("Adam Nowak")
                .churchRole("Kapłan")
                .build();
        Assertions.assertThrows(ChurchWorkerException.class, () -> churchWorkerService.save(churchWorkerRequest));
    }

    @Test
    public void saveChurchWorker_emptyPassword_throwsException(){
        ChurchWorkerRequest churchWorkerRequest = new ChurchWorkerRequest.ChurchWorkerRequestBuilder()
                .login("a_nowak")
                .password("")
                .fullName("Adam Nowak")
                .churchRole("Kapłan")
                .build();
        Assertions.assertThrows(ChurchWorkerException.class, () -> churchWorkerService.save(churchWorkerRequest));
    }

   @Test
   public void saveChurchWorker_emptyFullName_throwsException(){
       ChurchWorkerRequest churchWorkerRequest = new ChurchWorkerRequest.ChurchWorkerRequestBuilder()
               .login("a_nowak")
               .password("qwerty")
               .fullName("")
               .churchRole("Kapłan")
               .build();
       Assertions.assertThrows(ChurchWorkerException.class, () -> churchWorkerService.save(churchWorkerRequest));
   }

   @Test
    public void saveChurchWorker_emptyChurchRole_throws_Exception(){
       ChurchWorkerRequest churchWorkerRequest = new ChurchWorkerRequest.ChurchWorkerRequestBuilder()
               .login("a_nowak")
               .password("qwerty")
               .fullName("Adam Nowak")
               .churchRole("")
               .build();
       Assertions.assertThrows(ChurchWorkerException.class, () -> churchWorkerService.save(churchWorkerRequest));
   }


}
