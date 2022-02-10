package com.music.role.port.inbound;

import com.music.role.dto.RoleResponseDto;

public interface RoleComponent {
    RoleResponseDto findById(Long id);
}
