package com.fanfte.spring.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tianen on 2019/3/25
 *
 * @author fanfte
 * @date 2019/3/25
 **/
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(resultSet.getInt("id"), resultSet.getString("name")
                , resultSet.getInt("age"), resultSet.getString("sex"));
        return user;
    }
}
