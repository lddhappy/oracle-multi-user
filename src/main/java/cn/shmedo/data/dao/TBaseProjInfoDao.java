package cn.shmedo.data.dao;

import cn.shmedo.db.common.TBaseProjInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ldd on 17-6-27.
 */
@Component
public class TBaseProjInfoDao {
    @Autowired
    @Qualifier("commonDb")
    private JdbcTemplate jdbcTemplate;

    public List<TBaseProjInfo> getAllProj() {
        List<TBaseProjInfo> pis = jdbcTemplate.query(" select * from 	T_BASE_PROJINFO ", TBaseProjInfo.TBaseProjInfoMapper);
        return pis;
    }
}
