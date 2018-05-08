package com.jvirriel.testrestful.backend;

import com.jvirriel.testrestful.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersJpaRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {
}
