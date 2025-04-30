package com.corhuila.domain.repository;

import java.util.List;
import java.util.Optional;

import com.corhuila.domain.model.User;

public interface UserRepository {

    public List<User> findAll();

    public Optional<User> findById(Long id);

    public User save(User user);

    public void delete(Long id);
}
