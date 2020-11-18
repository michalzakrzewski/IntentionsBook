package com.zakrzewski.intentionsbook.controllers;

import com.zakrzewski.intentionsbook.services.IntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntentionController {

    private IntentionService intentionService;

    @Autowired
    public IntentionController(IntentionService intentionService) {
        this.intentionService = intentionService;
    }
}
