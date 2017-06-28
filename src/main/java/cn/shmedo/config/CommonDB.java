package cn.shmedo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ldd on 17-6-27.
 */
@PropertySource(value = "classpath:commondb.properties", encoding = "utf-8")
@Configuration
public class CommonDB {
    @Value("${driver}")
    private String driver;
    @Value("${oracleUser}")
    private String user;
    @Value("${oraclePassword}")
    private String password;
    @Value("${url}")
    private String url;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
