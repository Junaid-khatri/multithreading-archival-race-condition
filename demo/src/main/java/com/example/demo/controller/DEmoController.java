package com.example.demo.controller;

import com.example.demo.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.DemoService;
import com.example.demo.service.DemoServiceArchival;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DEmoController {

    @Autowired
    DemoService demoService;

    @Autowired
    DemoServiceArchival archivalService;

    @Autowired
    DemoRepository demoRepository;

    @GetMapping("/database/operation")
    public String databaseOperation(){
        log.info("Entered into database operation controller");
        demoService.databaseOperation();
        return "database operation working asynchronously";
    }

    @GetMapping("/database/operation/archival")
    public String databaseArchivalOperation(){
        List<DemoEntity> all = demoRepository.findAll();
        for(DemoEntity demo: all){
            archivalService.transferDataToArchival(demo.getId());
        }
        return "data transfer for archival started";
    }
}
