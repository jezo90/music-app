package com.music.role;

import com.music.role.port.outbound.RoleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RoleConfig {

    @Bean
    RoleFacade roleFacade(RoleRepository roleRepository) {
        RoleService roleService = new RoleService(roleRepository);
        return new RoleFacade(roleService);
    }

}
