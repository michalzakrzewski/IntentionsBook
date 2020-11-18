package com.zakrzewski.intentionsbook.controllers;

import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import com.zakrzewski.intentionsbook.services.ChurchWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ChurchWorkerController {

    private ChurchWorkerService churchWorkerService;

    @Autowired
    public ChurchWorkerController(ChurchWorkerService churchWorkerService) {
        this.churchWorkerService = churchWorkerService;
    }

    @GetMapping(path = "/workers")
    public List<ChurchWorker> getAllChurchWorkers(){
        return churchWorkerService.getAllChurchWorkers();
    }

    @GetMapping(path = "/worker")
    public ResponseEntity<ChurchWorker> findChurchWorkerByLogin(@RequestParam String login){
        ChurchWorker churchWorker = churchWorkerService.findChurchWorkerByLogin(login);
        return new ResponseEntity<>(churchWorker, HttpStatus.OK);
    }
}
