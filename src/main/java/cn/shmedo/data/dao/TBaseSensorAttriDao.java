package cn.shmedo.data.dao;

import cn.shmedo.data.ProjDbInit;
import cn.shmedo.data.model.TBaseSensorAttri;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by ldd on 17-6-28.
 */
@Component
public class TBaseSensorAttriDao {
    public List<TBaseSensorAttri>getSensors(int projID)
    {
        JdbcTemplate template= ProjDbInit.getJdbcTemplate(projID);
        if(template==null)
            return Collections.emptyList();
        return template.query(" select * from T_BASE_SENSORATTRI ",TBaseSensorAttri.TBaseSensorAttriRowMapper);
    }
}
