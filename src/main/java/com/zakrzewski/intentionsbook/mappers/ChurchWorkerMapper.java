package com.zakrzewski.intentionsbook.mappers;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.dtos.ChurchWorkerResponse;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import org.springframework.stereotype.Component;

@Component
public class ChurchWorkerMapper {

/*    public ChurchWorkerDTO mapToChurchWorkerDTO(ChurchWorker churchWorker){
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
    }*/

    //Show data from database
    public ChurchWorkerResponse mapToChurchWorkerResponse(ChurchWorker churchWorker){
        ChurchWorkerResponse churchWorkerResponse = new ChurchWorkerResponse.ChurchWorkerResponseBuilder()
                .fullName(churchWorker.getFullName())
                .churchRole(churchWorker.getChurchRole())
                .build();
        return  churchWorkerResponse;
    }

    //Send data from request to f.e. Database.
    public ChurchWorker mapToChurchWorkerFromRequest(ChurchWorkerRequest churchWorkerRequest){
        ChurchWorker churchWorker = new ChurchWorker();
        churchWorker.setLogin(churchWorkerRequest.getLogin());
        churchWorker.setPassword(churchWorkerRequest.getPassword());
        churchWorker.setFullName(churchWorkerRequest.getFullName());
        churchWorker.setChurchRole(churchWorkerRequest.getChurchRole());
        return churchWorker;
    }

}
