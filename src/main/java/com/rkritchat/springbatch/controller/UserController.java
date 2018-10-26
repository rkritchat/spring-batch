package com.rkritchat.springbatch.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class UserController {


    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @GetMapping
    public BatchStatus load() throws JobExecutionException {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters =  new JobParameters(maps);
        JobExecution execution = jobLauncher.run(job, parameters);

        return execution.getStatus();
    }
}
