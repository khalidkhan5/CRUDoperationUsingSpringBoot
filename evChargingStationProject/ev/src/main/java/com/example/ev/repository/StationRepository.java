package com.example.ev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ev.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station,Integer> {
}
