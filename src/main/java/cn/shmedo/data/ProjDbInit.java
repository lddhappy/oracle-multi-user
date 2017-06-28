package cn.shmedo.data;

import cn.shmedo.config.CommonDB;
import cn.shmedo.config.ContextHolder;
import cn.shmedo.data.model.ConnectString;
import cn.shmedo.db.common.TBaseProjInfo;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ldd on 17-6-27.
 */
public class ProjDbInit {
    private static ConcurrentHashMap<Integer,DataSource>projectDataSources=new ConcurrentHashMap<>();


    public static void init(List<TBaseProjInfo> pis) {
        if (pis == null || pis.size() == 0)
            return;
        pis.forEach(pi -> {
            initPI(pi);
        });
    }


    private static void initPI(TBaseProjInfo pi) {
        CommonDB commonDBConfig= ContextHolder.getContext().getBean(CommonDB.class);
        ConnectString connectString=ConnectString.valueOf(pi.getConnectString());
        String url="jdbc:oracle:thin:@//"+connectString.getIP()+":"+connectString.getPORT()+"/"+
                connectString.getSERVICENAME();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(commonDBConfig.getDriver());
        dataSource.setUrl(url);
        dataSource.setUsername(connectString.getUSER());
        dataSource.setPassword(connectString.getPASSWORD());
        projectDataSources.put(pi.getId(),dataSource);
    }

    public static JdbcTemplate getJdbcTemplate(Integer projID)
    {
        DataSource dataSource= projectDataSources.getOrDefault(projID,null);
        if(dataSource==null)
            throw  new RuntimeException("project has no datasource");
        return new JdbcTemplate(dataSource);
    }
}
