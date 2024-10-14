package com.example.demo3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo3.Model.Model;

public interface SchoolRepository extends JpaRepository<Model, Long> {
}