package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.mappers.ChurchWorkerMapper;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class ChurchWorkerServiceTest {

    private ChurchWorkerService churchWorkerService;
    private ChurchWorkerRepository churchWorkerRepository;

    private ChurchWorkerMapper churchWorkerMapper;

    @BeforeEach
    public void setup(){
        churchWorkerMapper = Mockito.mock(ChurchWorkerMapper.class);
        churchWorkerRepository = Mockito.mock(ChurchWorkerRepository.class);
        churchWorkerService = new ChurchWorkerService(churchWorkerRepository, churchWorkerMapper);
    }

    /*@Test
    public void save_saveClientInDatabaseCorrectly(){
        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login("j_kowalski")
                .password("test")
                .fullName("Jan Kowalski")
                .churchRole("kapłan")
                .build();
        churchWorkerService.save(churchWorkerDTO);

    }*/

}
