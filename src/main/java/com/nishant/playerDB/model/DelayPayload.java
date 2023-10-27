package com.nishant.playerDB.model;

import lombok.Getter;

public class DelayPayload implements Runnable{
    @Getter
    private Integer duration;

    public DelayPayload(Integer duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
