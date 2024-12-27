package org.noob.design.service;

import org.noob.design.pojo.User;

public interface UserService {
     User login(User user) ;
     void register(User user);
     User findByUsername(String username);
}
