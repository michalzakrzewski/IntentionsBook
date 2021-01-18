package com.zakrzewski.intentionsbook.validators;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.exceptions.ChurchWorkerException;
import org.springframework.stereotype.Component;

@Component
public class ChurchWorkerValidator {

    public void checkCreateChurchWorkerCorrectly(ChurchWorkerRequest churchWorkerRequest){
        if ("".equals(churchWorkerRequest.getLogin())){
            throw new ChurchWorkerException("Login cannot be empty");
        }
        if ("".equals(churchWorkerRequest.getPassword())){
            throw new ChurchWorkerException("Password cannot be empty");
        }
        if ("".equals(churchWorkerRequest.getFullName())){
            throw new ChurchWorkerException("FullName cannot be empty");
        }
        if ("".equals(churchWorkerRequest.getChurchRole())){
            throw new ChurchWorkerException("Church role cannot be empty");
        }
    }
}
