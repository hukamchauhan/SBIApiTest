package com.example.demo.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.AccountDetails;
import com.example.demo.model.PersonalDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long>{
	
	@Query("select a from PersonalDetails a left join AccountDetails b on a.personId=b.personalDetails where b.debitCardNumber=:debitCardNumber")
	PersonalDetails getAccountDetails(@Param("debitCardNumber") String debitCardNumber);

}
