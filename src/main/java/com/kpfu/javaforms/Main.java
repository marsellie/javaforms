package com.kpfu.javaforms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@SpringBootApplication
public class Main {

    protected final DataSource dataSource;

    public Main(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void showTables() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });
        while (tables.next()) {
            String tableName=tables.getString("TABLE_NAME");
            System.out.println(tableName);
            ResultSet columns = metaData.getColumns(null,  null,  tableName, "%");
            while (columns.next()) {
                String columnName=columns.getString("COLUMN_NAME");
                System.out.println("\t" + columnName);
            }
        }
    }

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Main.class, args);
        var source = ctx.getBean(DataSource.class);
    }
}