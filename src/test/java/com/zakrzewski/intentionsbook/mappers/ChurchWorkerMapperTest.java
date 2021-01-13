package com.zakrzewski.intentionsbook.mappers;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ChurchWorkerMapperTest {

    private ChurchWorkerMapper churchWorkerMapper;

    @BeforeEach
    public void setup(){
        churchWorkerMapper = new ChurchWorkerMapper();
    }

    /*@Test
    public void churchWorkerDTO_toChurchWorker_MappedCorrectly(){
        ChurchWorker churchWorker = new ChurchWorker("j_kowalski", "qwerty", "Jan Kowalski", "Kapłan");

        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login("j_kowalski")
                .password("qwerty")
                .fullName("Jan Kowalski")
                .churchRole("Kapłan")
                .build();

        ChurchWorker expectedChurchWorker = churchWorkerMapper.mapToChurchWorker(churchWorkerDTO);
        Assertions.assertThat(expectedChurchWorker).isEqualTo(churchWorker);
    }*/
}
