package com.music.role;

import com.music.role.dto.RoleResponseDto;
import com.music.role.port.inbound.RoleComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RoleFacade implements RoleComponent {
    private final RoleService roleService;

    public RoleResponseDto findById(Long id) {
        return roleService.findById(id);
    }
}
