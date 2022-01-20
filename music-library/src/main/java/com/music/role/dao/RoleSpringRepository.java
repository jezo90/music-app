package com.music.role.dao;

import com.music.role.dao.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleSpringRepository extends JpaRepository<RoleEntity, Long> {
}