package com.example.bb.repository;

import com.example.bb.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>className: com.example.bb.repository-UserRepository
 * <p>description:
 * <p>author: wn
 * <p>date: 2024/3/19
 **/
public interface UserRepository extends JpaRepository<User, String> {

}
