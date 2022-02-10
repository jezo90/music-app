package com.music.role.port.outbound;

import com.music.role.dto.RoleResponseDto;

import java.util.Optional;

public interface RoleRepository {
    Optional<RoleResponseDto> findById(Long id);
}
