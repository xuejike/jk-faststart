package com.github.xuejike.springboot.jkfaststart.repository;

import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AdminPermissionRepository extends BaseRepository<AdminPermission,Long>
{
}
