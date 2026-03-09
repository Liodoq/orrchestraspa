package com.gabriel.emplms.repository;
import com.gabriel.emplms.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface UserDataRepository extends JpaRepository<UserData,Integer>{
    Optional<UserData> findByUserEmail(String userEmail);
}
