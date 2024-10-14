package com.example.demo3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo3.Model.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    @Query("SELECT m FROM Model m WHERE m.name LIKE %:filter%")
    List<Model> findByNameContains(@Param("filter") String filter);
}