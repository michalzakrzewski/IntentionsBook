package com.zakrzewski.intentionsbook.controllers;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.dtos.ChurchWorkerResponse;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.services.ChurchWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ChurchWorkerController {

    private ChurchWorkerService churchWorkerService;

    @Autowired
    public ChurchWorkerController(ChurchWorkerService churchWorkerService) {
        this.churchWorkerService = churchWorkerService;
    }

    @PostMapping(path = "/workers")
    public ResponseEntity<String> saveChurchWorker(@RequestBody ChurchWorkerRequest churchWorkerRequest){
        churchWorkerService.save(churchWorkerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Church Worker: '%s' created.", churchWorkerRequest.getFullName()));
    }

    @GetMapping(path = "/workers")
    public ResponseEntity<List<ChurchWorkerResponse>> getAllChurchWorkers(){
        return new ResponseEntity<>(churchWorkerService.getAllChurchWorkerResponse(), HttpStatus.ACCEPTED);
    }
    /*
    @GetMapping(path = "/worker")
    public ResponseEntity<ChurchWorkerDTO> findChurchWorkerByLogin(@RequestParam String login){
        ChurchWorkerDTO churchWorkerDTO = churchWorkerService.findChurchWorkerByLogin(login);
        return new ResponseEntity<>(churchWorkerDTO, HttpStatus.OK);
    }*/
}
