package com.e.wtc.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.wtc.entity.ApiUser;

public interface UserRepo extends JpaRepository<ApiUser, Integer> {

    Optional<ApiUser> findByUserName(String userName);
}
