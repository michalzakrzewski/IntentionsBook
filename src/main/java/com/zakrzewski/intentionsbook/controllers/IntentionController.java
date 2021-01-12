package com.zakrzewski.intentionsbook.controllers;

import com.zakrzewski.intentionsbook.dtos.IntentionDTO;
import com.zakrzewski.intentionsbook.entity.Intention;
import com.zakrzewski.intentionsbook.services.IntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class IntentionController {

    private IntentionService intentionService;

    @Autowired
    public IntentionController(IntentionService intentionService) {
        this.intentionService = intentionService;
    }


    @GetMapping(path = "/intentions")
    public ResponseEntity<List<IntentionDTO>> getAllIntentionDTO(){
        return new ResponseEntity<>(intentionService.getAllIntentionDTO(), HttpStatus.OK);
    }

    @PostMapping(path = "/intention")
    public ResponseEntity<String> saveIntention(@RequestBody IntentionDTO intentionDTO){
        intentionService.saveIntentionDTO(intentionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Intention saved correctly"));
    }


}
