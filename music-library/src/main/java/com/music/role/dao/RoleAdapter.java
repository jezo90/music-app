package com.music.role.dao;

import com.music.role.dto.RoleResponseDto;
import com.music.role.port.outbound.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
class RoleAdapter implements RoleRepository {

    private final RoleSpringRepository roleSpringRepository;

    @Override
    public Optional<RoleResponseDto> findById(Long id) {

        return roleSpringRepository.findById(id).map(RoleMapper::map);

    }
}
