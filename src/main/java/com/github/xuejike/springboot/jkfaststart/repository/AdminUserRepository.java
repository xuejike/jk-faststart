package com.github.xuejike.springboot.jkfaststart.repository;

import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long> {
    AdminUser findByUsername(String username);
}
