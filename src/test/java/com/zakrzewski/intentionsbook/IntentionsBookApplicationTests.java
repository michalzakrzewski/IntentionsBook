package com.zakrzewski.intentionsbook;

import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.mappers.ChurchWorkerMapper;
import com.zakrzewski.intentionsbook.mappers.IntentionMapper;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import com.zakrzewski.intentionsbook.services.ChurchWorkerService;
import com.zakrzewski.intentionsbook.services.IntentionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IntentionsBookApplicationTests {
 /*   private IntentionService intentionService;
    private IntentionRepository intentionRepository;

    private ChurchWorkerService churchWorkerService;
    private ChurchWorkerRepository churchWorkerRepository;

    private IntentionMapper intentionMapper;
    private ChurchWorkerMapper churchWorkerMapper;

    @BeforeEach
    public void setup(){
        intentionRepository = Mockito.mock(IntentionRepository.class);
        churchWorkerRepository = Mockito.mock(ChurchWorkerRepository.class);
        intentionService = new IntentionService(intentionRepository, intentionMapper);
        churchWorkerService = new ChurchWorkerService(churchWorkerRepository, churchWorkerMapper);
    }

    @Test
    public void save_saveClientInDatabaseCorrectly(){
        ChurchWorker churchWorkerToSave = new ChurchWorker("login", "password", "Priest priest", "Priest");
        churchWorkerService.save(churchWorkerToSave);
    }

    @Test
    public void findChurchWorkerByFullName_checkIfFindCorrectly(){
        ChurchWorker churchWorkerToSave = new ChurchWorker("login", "password", "Priest priest", "Priest");
        Mockito.when(churchWorkerService.findChurchWorkerByLogin(churchWorkerToSave.getLogin())).thenReturn(churchWorkerToSave);

        ChurchWorker expectedChurchWorker = new ChurchWorker("login", "password", "Priest priest", "Priest");
        ChurchWorker churchWorkerByFullName = churchWorkerService.findChurchWorkerByLogin(expectedChurchWorker.getLogin());
        assertEquals(churchWorkerToSave.getLogin(), churchWorkerByFullName.getLogin());

    }*/

    @Test
    void contextLoads() {
    }



}
