package ru.kravpeter.logistics.service;

public interface SecurityService {
    String findLoggedInEmail();
    void autoLogin(String email, String password);
}
