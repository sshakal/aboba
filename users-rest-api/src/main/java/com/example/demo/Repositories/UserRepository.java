package com.example.demo.Repositories;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query(name = "User.FindUser")//jpql
    Iterable<User> findAllByNameLikeIgnoreCase(String name);


    @Query(value="select * from list.t_users where c_name like :name",nativeQuery = true)
    Iterable<User> findAllByLastNameLikeIgnoreCase(String name);

    @Query(value="select u from User u where u.name like :name")//jpql
    Iterable<User> findAllByAgeLikeIgnoreCase(String name);

    @Query(name = "User.FindUser")//jpql
    Iterable<User> findAllByEmailLikeIgnoreCase(String name);

}
