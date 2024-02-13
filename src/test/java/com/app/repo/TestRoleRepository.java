package com.app.repo;

import com.app.entities.Role;
import com.app.entities.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest //Auto scan only DAO component
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestRoleRepository {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Rollback(value = false)
    void testAddRoleAdmin() {
        System.out.println(roleRepository.save(new Role(UserRole.ROLE_ADMIN)));
    }

    @Test
    @Rollback(value = false)
    void testAddRoleCustomer() {
        System.out.println(roleRepository.save(new Role(UserRole.ROLE_CUSTOMER)));
    }

    @Test
    @Rollback(value = false)
    void testAddRoleUser() {
        System.out.println(roleRepository.save(new Role(UserRole.ROLE_USER)));
    }
}
