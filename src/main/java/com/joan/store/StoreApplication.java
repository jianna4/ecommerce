package com.joan.store;

import com.joan.store.users.entity.Role;
import com.joan.store.users.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Component
    public static class RoleInitializer implements CommandLineRunner {

        private final RoleRepository roleRepository;

        public RoleInitializer(RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
        }

        @Override
        public void run(String... args) {

            if (roleRepository.findByName("ROLE_USER").isEmpty()) {

                Role userRole = new Role();
                userRole.setName("ROLE_USER");

                roleRepository.save(userRole);
                System.out.println("Created ROLE_USER");
            }

            if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {

                Role adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");

                roleRepository.save(adminRole);
                System.out.println("Created ROLE_ADMIN");
            }
        }
    }
}