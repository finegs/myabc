package net.myabc.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.myabc.spring.batch.entity.Person;

public interface ExtractorTargetRepository extends JpaRepository<Person, Long>{
    
}
