package com.edson.tutorialspringmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edson.tutorialspringmvc.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
