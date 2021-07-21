package com.psl.user.service;

import com.psl.user.objects.User;
import com.psl.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.getById(id);
    }
}
