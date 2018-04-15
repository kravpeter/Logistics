package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravpeter.logistics.entity.User;
import ru.kravpeter.logistics.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        switch (user.getUserRole()){
            case 1: grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            case 2: grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
            case 3: grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_DRIVER"));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getUserPassword(), grantedAuthorities);
    }
}
