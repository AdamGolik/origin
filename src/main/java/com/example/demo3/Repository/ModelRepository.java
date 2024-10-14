package com.example.demo3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo3.Model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    @Query("SELECT m FROM Model m WHERE m.grade LIKE %:search% " +
            "OR m.name LIKE %:search% " +
            "OR m.lastname LIKE %:search%")
    List<Model> findByAnyFieldContains(@Param("search") String search);
}