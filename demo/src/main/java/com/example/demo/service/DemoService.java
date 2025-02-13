package com.example.demo.service;

import com.example.demo.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Async
    public void databaseOperation(){
        log.info("Thread - {}",Thread.currentThread());
        log.info("Entered into database operation service");
        long id = insertData();
        updateData(id);
        deleteData(id);

    }

    private long insertData() {
        log.info("Entered insert operation");
        DemoEntity build = DemoEntity.builder()
                .name("Demo")
                .age(12)
                .isStudent(true)
                .workPlace("NHAI")
                .build();
        return demoRepository.save(build).getId();
    }

    private void updateData(long id) {
        log.info("Entered update operation");
        DemoEntity demoEntity = demoRepository.findById(id).get();
        demoEntity.setUpdated(true);
        demoRepository.save(demoEntity);
    }

    private void deleteData(long id){
        log.info("Entered delete operation");
        DemoEntity demoEntity = demoRepository.findById(id).get();
        demoEntity.setDeleted(true);
        demoRepository.save(demoEntity);
    }
}
