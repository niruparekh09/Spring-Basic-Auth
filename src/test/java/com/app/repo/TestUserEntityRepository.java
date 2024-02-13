package com.app.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest //Auto scan only DAO component
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestUserEntityRepository {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Test
    void testUserByEmail(){
        System.out.println(userEntityRepository
                .findByEmail("NRV").orElseThrow(()-> new RuntimeException("Invalid Email")));
    }
}
