package com.nishant.playerDB.controller;

import com.nishant.playerDB.model.DelayPayload;
import com.nishant.playerDB.service.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sleep")
public class DelayController {

    private DelayService delayService;

    @Autowired
    public DelayController(DelayService delayService, Environment env) {
        this.delayService = delayService;
    }

    @RequestMapping(value = "/{seconds}", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity createDelay(@PathVariable Integer seconds){
        return delayService.delay(new DelayPayload(seconds));
    }

}
