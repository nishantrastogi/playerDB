package com.nishant.playerDB.service;

import com.nishant.playerDB.model.DelayPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * This class is just created to introduce another way of inducing sleep in an API. Not being used
 */
@Service
public class DelayService {

    Environment env;
    private Semaphore semaphore;

    @Autowired
    public DelayService(Environment env) {
        this.env = env;
        this.semaphore = new Semaphore(Integer.parseInt(env.getProperty("sleep-api.rate")));
    }

    public ResponseEntity delay(DelayPayload dp){
        if(semaphore.tryAcquire()){
            dp.run();
        }
        else{
            return ResponseEntity.status(429).body(null);
        }
        semaphore.release();
        return ResponseEntity.ok("{}");
    }

}
