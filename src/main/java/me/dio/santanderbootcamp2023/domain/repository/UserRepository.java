package me.dio.santanderbootcamp2023.domain.repository;

import me.dio.santanderbootcamp2023.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByAccountNumber(String accountNumber);
}
