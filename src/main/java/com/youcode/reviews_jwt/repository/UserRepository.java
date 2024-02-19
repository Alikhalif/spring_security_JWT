package com.youcode.reviews_jwt.repository;

import com.youcode.reviews_jwt.entity.OurUsers;
import com.youcode.reviews_jwt.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<OurUsers, UUID> {
    Optional<OurUsers> findByRole(Role roles);
    Optional<OurUsers> findByUsername(String userName);


}
