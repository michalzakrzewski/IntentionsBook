package com.zakrzewski.intentionsbook;

import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.repositories.ChurchWorkerRepository;
import com.zakrzewski.intentionsbook.repositories.IntentionRepository;
import com.zakrzewski.intentionsbook.services.ChurchWorkerService;
import com.zakrzewski.intentionsbook.services.IntentionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IntentionsBookApplicationTests {

    private IntentionService intentionService;
    private IntentionRepository intentionRepository;

    private ChurchWorkerService churchWorkerService;
    private ChurchWorkerRepository churchWorkerRepository;

    @BeforeEach
    public void setup(){
        intentionRepository = Mockito.mock(IntentionRepository.class);
        churchWorkerRepository = Mockito.mock(ChurchWorkerRepository.class);
        intentionService = new IntentionService(intentionRepository);
        churchWorkerService = new ChurchWorkerService(churchWorkerRepository);
    }

    @Test
    public void save_saveClientInDatabaseCorrectly(){
        ChurchWorker churchWorkerToSave = new ChurchWorker("login", "password", "Priest priest", "Priest");
        churchWorkerService.save(churchWorkerToSave);
    }

    @Test
    public void findChurchWorkerByFullName_checkIfFindCorrectly(){
        ChurchWorker churchWorkerToSave = new ChurchWorker("login", "password", "Priest priest", "Priest");
        Mockito.when(churchWorkerService.findChurchWorkerByFullName(churchWorkerToSave.getFullName())).thenReturn(churchWorkerToSave);

        ChurchWorker expectedChurchWorker = new ChurchWorker("login", "password", "Priest priest", "Priest");
        ChurchWorker churchWorkerByFullName = churchWorkerService.findChurchWorkerByFullName(expectedChurchWorker.getFullName());
        assertEquals(churchWorkerToSave.getFullName(), churchWorkerByFullName.getFullName());

    }

    @Test
    void contextLoads() {
    }



}
