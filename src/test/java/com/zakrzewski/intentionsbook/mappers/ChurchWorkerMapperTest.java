package com.zakrzewski.intentionsbook.mappers;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChurchWorkerMapperTest {

    private ChurchWorkerMapper churchWorkerMapper;

    @BeforeEach
    public void setup(){
        churchWorkerMapper = new ChurchWorkerMapper();
    }


    @Test
    public void churchWorker_ToDTO_MappedCorrectly(){
        ChurchWorker churchWorker = new ChurchWorker("j_kowalski", "qwerty", "Jan Kowalski", "Kapłan");

        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login("j_kowalski")
                .password("qwerty")
                .fullName("Jan Kowalski")
                .churchRole("Kapłan")
                .build();

        ChurchWorkerDTO expectedDTO = churchWorkerMapper.mapToChurchWorkerDTO(churchWorker);
        Assertions.assertEquals(expectedDTO, churchWorkerDTO);
    }

    @Test
    public void churchWorkerDTO_toChurchWorker_MappedCorrectly(){
        ChurchWorker churchWorker = new ChurchWorker("j_kowalski", "qwerty", "Jan Kowalski", "Kapłan");

        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login("j_kowalski")
                .password("qwerty")
                .fullName("Jan Kowalski")
                .churchRole("Kapłan")
                .build();

        ChurchWorker expectedChurchWorker = churchWorkerMapper.mapToChurchWorker(churchWorkerDTO);
        Assertions.assertEquals(expectedChurchWorker, churchWorker);
    }
}
