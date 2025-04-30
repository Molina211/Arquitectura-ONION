package com.corhuila.domain.infrastructure.persistence.impl;

import com.corhuila.domain.application.service.IUserService;
import com.corhuila.domain.model.User;
import com.corhuila.domain.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> User = userRepository.findById(id);
        return User.orElse(null);
    }

    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
