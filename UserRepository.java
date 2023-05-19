package com.shop.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.item.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
