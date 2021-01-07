package com.zakrzewski.intentionsbook.controllers;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerDTO;
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

    @PostMapping(path = "/save")
    public ResponseEntity<String> saveChurchWorker(@RequestBody ChurchWorkerDTO churchWorkerDTO){
        churchWorkerService.save(churchWorkerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Church Worker: '%s' created.", churchWorkerDTO.getFullName()));
    }

    @GetMapping(path = "/workersDTO")
    public ResponseEntity<List<ChurchWorkerDTO>> getAllDTOChurchWorkers(){
        return new ResponseEntity<>(churchWorkerService.getAllChurchWorkerDTO(), HttpStatus.OK);
    }

    @GetMapping(path = "/workers")
    public ResponseEntity<List<ChurchWorker>> getAll(){
        return new ResponseEntity<>(churchWorkerService.getAllChurchWorkers(), HttpStatus.OK);
    }

    @GetMapping(path = "/worker")
    public ResponseEntity<ChurchWorkerDTO> findChurchWorkerByLogin(@RequestParam String login){
        ChurchWorkerDTO churchWorkerDTO = churchWorkerService.findChurchWorkerByLogin(login);
        return new ResponseEntity<>(churchWorkerDTO, HttpStatus.OK);
    }
}
