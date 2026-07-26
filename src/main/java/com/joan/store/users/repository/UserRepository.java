package com.joan.store.users.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.joan.store.mainstore.entry.Product;
import com.joan.store.mainstore.entry.SubCategory;
import com.joan.store.users.entity.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
      Optional<User> findByEmail(String email);
      boolean existsByEmail(String email);

 
    
}
