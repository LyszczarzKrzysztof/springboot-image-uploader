package com.example.springbootimageuploader.repository;

import com.example.springbootimageuploader.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUserName(String username);

}
