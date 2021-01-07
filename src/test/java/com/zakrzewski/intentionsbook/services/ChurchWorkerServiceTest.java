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

    @Test
    public void save_saveClientInDatabaseCorrectly(){
        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login("j_kowalski")
                .password("test")
                .fullName("Jan Kowalski")
                .churchRole("kapłan")
                .build();
        churchWorkerService.save(churchWorkerDTO);

    }

    @Test
    public void findChurchWorkerByLogin_checkIfFindCorrectly(){
        /*ChurchWorker churchWorkerToSave = new ChurchWorker("j_kowalski", "qwerty", "Jan Kowalski", "Kapłan");


        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login("j_kowalski")
                .password("test")
                .fullName("Jan Kowalski")
                .churchRole("kapłan")
                .build();
        churchWorkerService.save(churchWorkerDTO);
        ChurchWorkerDTO churchWorkerByLogin = churchWorkerService.findChurchWorkerByLogin(churchWorkerDTO.getLogin());

        Assertions.assertEquals(churchWorkerByLogin.getLogin(), churchWorkerDTO.getLogin());*/
        //ChurchWorker churchWorkerToSave = new ChurchWorker("j_kowalski", "qwerty", "Jan Kowalski", "Kapłan");
        //ChurchWorkerDTO churchWorkerDTOToSave = churchWorkerMapper.mapToChurchWorkerDTO(churchWorkerToSave);
        //Mockito.when(churchWorkerService.findChurchWorkerByLogin(churchWorkerDTOToSave.getLogin())).thenReturn(churchWorkerDTOToSave);

        //ChurchWorkerDTO expectedChurchWorker = churchWorkerMapper.mapToChurchWorkerDTO(churchWorkerToSave);
        //ChurchWorkerDTO churchWorkerDTOByFullName = churchWorkerService.findChurchWorkerByLogin(expectedChurchWorker.getLogin());



    }
}
