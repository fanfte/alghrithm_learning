package com.fanfte.spring.jdbc;

import java.util.List;

/**
 * Created by tianen on 2019/3/25
 *
 * @author fanfte
 * @date 2019/3/25
 **/
public interface UserService {

    void save(User user);

    List<User> getUsers();
}
