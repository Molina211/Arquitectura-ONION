package com.corhuila.domain.infrastructure.persistence.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.corhuila.domain.infrastructure.persistence.entity.UserEntity;
import com.corhuila.domain.infrastructure.persistence.jpa.UserJpaRepository;
import com.corhuila.domain.infrastructure.persistence.mapper.UserMapper;
import com.corhuila.domain.model.User;
import com.corhuila.domain.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepo;

    @Override
    public List<User> findAll() {
        return jpaRepo.findAll().stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepo.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity users = UserMapper.toEntity(user);
        users = jpaRepo.save(users);
        return UserMapper.toDomain(users);
    }

    @Override
    public void delete(Long id) {
        jpaRepo.deleteById(id);
    }
}
