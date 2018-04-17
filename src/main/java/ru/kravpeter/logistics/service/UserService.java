package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravpeter.logistics.entity.User;
import ru.kravpeter.logistics.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;


public interface UserService {
    User save(User user);

    User findUserByEmail(String email);
    /*@Autowired
    UserRepository userRepository;
    */
    /*
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User addUser(String email, String password, String userName, String userSurname, int userRole, String userPhoneNumber) {
        User user = new User();
        user.setEmail(email);
        user.setUserPassword(bCryptPasswordEncoder.encode(password));
        user.setUserName(userName);
        user.setUserSurname(userSurname);
        user.setUserRole(userRole);
        user.setUserPhoneNumber(userPhoneNumber);
        userRepository.saveAndFlush(user);
        return user;
    }
*//*
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findById(email).get();
    }*/
}
