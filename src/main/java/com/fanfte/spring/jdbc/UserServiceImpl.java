package com.fanfte.spring.jdbc;

import com.fanfte.java8.stream.Dish;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * Created by tianen on 2019/3/25
 *
 * @author fanfte
 * @date 2019/3/25
 **/
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(name, age, sex) values(?, ?, ?)"
                , new Object[] {user.getName(), user.getAge(), user.getSex() }
                , new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
    }

    @Override
    public List<User> getUsers() {
        List<User> query = jdbcTemplate.query("select * from user", new UserRowMapper());
        return query;
    }
}
