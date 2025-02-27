package com.javatechie.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerService {

    @Scheduled(fixedRate = 2000) // Executes every 2 seconds
    @SchedulerLock(name = "uniqueTaskName", lockAtMostFor = "1m", lockAtLeastFor = "2s")
    public void executeTask() {
        System.out.println("Executing task at: " + new Date());
    }
}

/*
  Explanation:
  @Scheduled(fixedRate = 5000): Schedules the task to run every 5 seconds.
 * @SchedulerLock(name = "uniqueTaskName"):
 * Ensures only one instance executes this task at a time.
 * lockAtMostFor: Maximum duration the lock will be held (prevents stale locks).
 * lockAtLeastFor: Minimum duration the lock will be held.
 * **/