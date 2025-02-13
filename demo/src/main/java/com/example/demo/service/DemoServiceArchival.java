package com.example.demo.service;

import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.DemoEntityArchival;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.DemoServiceArchivalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoServiceArchival {

    @Autowired
    private DemoServiceArchivalRepository archivalRepository;

    @Autowired
    private DemoRepository demoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Async("taskExecutor")
    public void transferDataToArchival(long id){
        log.info("Entering into transferDataToArchival");
        log.info("Thread - {}",Thread.currentThread());
        DemoEntity demoEntity = demoRepository.findById(id).get();
        insertToArchival(demoEntity);
        updateOriginalDemo(demoEntity);
    }

    private void insertToArchival(DemoEntity demoEntity) {
        log.info("inserting data to archival");
        DemoEntityArchival archival = modelMapper.map(demoEntity, DemoEntityArchival.class);
        archivalRepository.save(archival);
    }

    private void updateOriginalDemo(DemoEntity demoEntity) {
        log.info("Updating original demo");
        demoEntity.setArchived(true);
        demoRepository.save(demoEntity);
    }
}
