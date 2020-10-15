package com.example.demo.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AccountCurrentBalance;

public interface AccountCurrentBalanceRepository extends JpaRepository<AccountCurrentBalance, Long>{

}
