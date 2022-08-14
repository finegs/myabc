package net.myabc.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.myabc.spring.batch.entity.Customer;


public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}
