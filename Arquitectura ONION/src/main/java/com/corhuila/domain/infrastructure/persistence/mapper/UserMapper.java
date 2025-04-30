package com.corhuila.domain.infrastructure.persistence.mapper;

import com.corhuila.domain.infrastructure.persistence.entity.UserEntity;
import com.corhuila.domain.model.User;

public class UserMapper {

    public static User toDomain(UserEntity entidad) {
        return new User(
                entidad.getId(),
                entidad.getFullname(),
                entidad.getEmail(),
                entidad.getPhone(),
                entidad.getPassword(),
                entidad.getUrl());
    }

    public static UserEntity toEntity(User doUser) {
        return new UserEntity(
                doUser.getId(),
                doUser.getFullname(),
                doUser.getEmail(),
                doUser.getPhone(),
                doUser.getPassword(),
                doUser.getUrl());
    }

}
