package org.noob.design.service;

import org.noob.design.mapper.UserMapper;
import org.noob.design.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findByUsername(String username) {

        return userMapper.findByUsername(username);
    }
}
