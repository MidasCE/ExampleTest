package com.example.midas.domain.executor;

import rx.Scheduler;

/**
 * Created by Midas on 11/3/2559.
 */
public interface PostThread {
    Scheduler getScheduler();
}
