package cn.shmedo.db.common;

import cn.shmedo.config.CommonDB;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by ldd on 17-6-27.
 */
@Configuration
public class CommonDbConfig {
    @Autowired
    private CommonDB commonDB;

    @Bean(name = "commonDbDataSource")
    public DataSource commonDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(commonDB.getDriver());
        dataSource.setUrl(commonDB.getUrl());
        dataSource.setUsername(commonDB.getUser());
        dataSource.setPassword(commonDB.getPassword());
        return dataSource;
    }

    @Bean("commonDb")
    @Scope("prototype")
    public JdbcTemplate commonJdbcTemplate(@Autowired @Qualifier("commonDbDataSource") DataSource dataSource)
    {
        JdbcTemplate template=new JdbcTemplate(dataSource);
        return template;
    }
}
