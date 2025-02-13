package com.example.demo.repository;

import com.example.demo.entity.DemoEntityArchival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoServiceArchivalRepository extends JpaRepository<DemoEntityArchival, Long> {
}
