package jim.pers.jerp;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/erpdb?characterEncoding=utf8&useSSL=true&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("1");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setMaximumPoolSize(20);
        ds.setMinimumIdle(10);
        ds.setIdleTimeout(8);
        //ds.setConnectionTimeout(8);
        return  ds;
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        DataSource dataSource = builder.url("jdbc:mysql://localhost:3306/erpdb?characterEncoding=utf8&useSSL=true&serverTimezone=UTC")
//                                       .username("root")
//                                       .password("1")
//                                       .driverClassName("com.mysql.cj.jdbc.Driver")
//                                       .build();
//        return dataSource;
    }
}

