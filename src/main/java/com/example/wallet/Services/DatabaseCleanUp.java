package com.example.wallet.Services;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseCleanUp {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public void databaseTotalCleanUp(){
//        List<String> tableName = jdbcTemplate.queryForList("Select table name from pg_table where schema name = 'public' ", String.class);
//        for (String table : tableName){
//            jdbcTemplate.execute("Truncate table" + table + "cascade");
//        }
//        System.out.println("Database record cleared");
//    }

}
