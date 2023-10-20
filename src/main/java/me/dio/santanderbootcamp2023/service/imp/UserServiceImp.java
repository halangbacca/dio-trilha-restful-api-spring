package me.dio.santanderbootcamp2023.service.imp;

import jakarta.persistence.EntityExistsException;
import me.dio.santanderbootcamp2023.domain.model.User;
import me.dio.santanderbootcamp2023.domain.repository.UserRepository;
import me.dio.santanderbootcamp2023.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new EntityExistsException("This Account Number already exists!");
        }
        return userRepository.save(userToCreate);
    }
}
