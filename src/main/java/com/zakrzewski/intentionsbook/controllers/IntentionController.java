package com.zakrzewski.intentionsbook.controllers;

import com.zakrzewski.intentionsbook.dtos.IntentionRequest;
import com.zakrzewski.intentionsbook.dtos.IntentionResponse;
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

    @PostMapping(path = "/intention")
    public ResponseEntity<String> saveIntention(@RequestBody IntentionRequest intentionRequest){
        intentionService.save(intentionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Intention saved correctly"));
    }

    @GetMapping(path = "/intentions")
    public ResponseEntity<List<IntentionResponse>> getAllIntentions(){
        return new ResponseEntity<>(intentionService.getAllIntentions(), HttpStatus.OK);
    }




}
