package com.psl.user.service;

import com.psl.user.objects.User;


public interface UserService {
    User saveUser(User User);
    User findUserById(Long id);
}
