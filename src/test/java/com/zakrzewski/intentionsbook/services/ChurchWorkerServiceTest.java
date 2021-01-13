package com.zakrzewski.intentionsbook.services;

import com.zakrzewski.intentionsbook.mappers.ChurchWorkerMapper;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import org.junit.jupiter.api.BeforeEach;
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


}
