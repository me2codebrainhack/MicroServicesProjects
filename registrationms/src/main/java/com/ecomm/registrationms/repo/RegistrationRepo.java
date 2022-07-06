package com.ecomm.registrationms.repo;

import com.ecomm.registrationms.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<Registration,Integer> {
}
