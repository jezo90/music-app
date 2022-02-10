package com.music.role;

import com.music.exception.EntityNotFoundException;
import com.music.role.dto.RoleResponseDto;
import com.music.role.port.outbound.RoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RoleService {
    private final RoleRepository roleRepository;

    public RoleResponseDto findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no artist with such Id "));
    }
}
