package com.zakrzewski.intentionsbook.mappers;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import org.springframework.stereotype.Component;

@Component
public class ChurchWorkerMapper {

    public ChurchWorkerDTO mapToChurchWorkerDTO(ChurchWorker churchWorker){
        ChurchWorkerDTO churchWorkerDTO = new ChurchWorkerDTO.ChurchWorkerDTOBuilder()
                .login(churchWorker.getLogin())
                .password(churchWorker.getPassword())
                .fullName(churchWorker.getFullName())
                .churchRole(churchWorker.getChurchRole())
                .build();
        return churchWorkerDTO;
    }

    public ChurchWorker mapToChurchWorker(ChurchWorkerDTO churchWorkerDTO){
        ChurchWorker churchWorker = new ChurchWorker();
        churchWorker.setLogin(churchWorkerDTO.getLogin());
        churchWorker.setPassword(churchWorkerDTO.getPassword());
        churchWorker.setFullName(churchWorkerDTO.getFullName());
        churchWorker.setChurchRole(churchWorkerDTO.getChurchRole());
        return churchWorker;
    }


}
