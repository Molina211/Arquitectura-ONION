package com.corhuila.domain.application.service;

import java.util.List;

import com.corhuila.domain.model.User;

public interface IUserService {

    public List<User> findAll();

    public User findById(Long id);

    public User save(User user);

    public void delete(Long id);

}
