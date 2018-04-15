package ru.kravpeter.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravpeter.logistics.entity.Truck;
import ru.kravpeter.logistics.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    @Override
    List<User> findAll();

    @Override
    void delete(User entity);

    @Override
    User save(User user);


    User findUserByEmail(String email); //find by e-mail
}
