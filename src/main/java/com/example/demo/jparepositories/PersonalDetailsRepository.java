package com.example.demo.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PersonalDetails;


public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long>{

}
