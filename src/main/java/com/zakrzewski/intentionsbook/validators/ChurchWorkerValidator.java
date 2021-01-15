package com.zakrzewski.intentionsbook.validators;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.exceptions.EmptyLoginException;
import org.springframework.stereotype.Component;

@Component
public class ChurchWorkerValidator {

    public void checkCreateChurchWorkerCorrectly(ChurchWorkerRequest churchWorkerRequest){
        if ("".equals(churchWorkerRequest.getLogin())){
            throw new EmptyLoginException();
        }
        if ("".equals(churchWorkerRequest.getPassword())){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if ("".equals(churchWorkerRequest.getFullName())){
            throw new IllegalArgumentException("FullName cannot be empty");
        }
        if ("".equals(churchWorkerRequest.getChurchRole())){
            throw new IllegalArgumentException("Church role cannot be empty");
        }
    }
}
