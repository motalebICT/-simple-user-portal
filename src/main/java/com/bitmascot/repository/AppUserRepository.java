package com.bitmascot.repository;

import com.bitmascot.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by motaleb14029 on 12/8/2019.
 */
@Transactional
public interface AppUserRepository extends CrudRepository<AppUser,Long> {

   // @Query(value = "select * from app_user p where p.email=?1", nativeQuery = true)
    AppUser findAppUserByEmail(String email);

    /* Check that Email Is Exist Or Not */
    boolean existsByEmail(String email);

    /* Fetch AppUser by Role */
    Iterable<AppUser> findAppUserByRole(String role);


}
