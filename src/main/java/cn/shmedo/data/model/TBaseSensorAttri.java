package cn.shmedo.data.model;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created by ldd on 17-6-28.
 */
public class TBaseSensorAttri {
    private int id;
    private String name;
    private String alias;
    private Integer groupID;
    private Integer sensorType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getSensorType() {
        return sensorType;
    }

    public void setSensorType(Integer sensorType) {
        this.sensorType = sensorType;
    }

    public static RowMapper<TBaseSensorAttri>TBaseSensorAttriRowMapper=(rs,num)->{
        TBaseSensorAttri attri=new TBaseSensorAttri();
        attri.setId(rs.getInt("ID"));
        attri.setName(rs.getString("NAME"));
        attri.setAlias(rs.getString("ALIAS"));
        attri.setSensorType(rs.getInt("SENSORTYPE"));
        return attri;
    };
}
