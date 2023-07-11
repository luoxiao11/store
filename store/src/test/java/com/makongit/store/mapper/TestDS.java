package com.makongit.store.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
public class TestDS {

    @Autowired
    DataSource dataSource;
    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource);
    }
    @Test
    public void testUUID() throws SQLException {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

}
