package cn.shmedo.db.common;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created by ldd on 17-6-27.
 */
public class TBaseProjInfo {
    private int id;
    private String name;
    private String connectString;
    private byte isValid;
    private String note;
    private Integer regionID;

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

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public byte getIsValid() {
        return isValid;
    }

    public void setIsValid(byte isValid) {
        this.isValid = isValid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TBaseProjInfo that = (TBaseProjInfo) o;

        if (id != that.id) return false;
        if (isValid != that.isValid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (connectString != null ? !connectString.equals(that.connectString) : that.connectString != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        return regionID != null ? regionID.equals(that.regionID) : that.regionID == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (connectString != null ? connectString.hashCode() : 0);
        result = 31 * result + (int) isValid;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (regionID != null ? regionID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TBaseProjInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", connectString='" + connectString + '\'' +
                ", isValid=" + isValid +
                ", note='" + note + '\'' +
                ", regionID=" + regionID +
                '}';
    }

    public static RowMapper<TBaseProjInfo> TBaseProjInfoMapper = (rs, num) -> {
        TBaseProjInfo pi=new TBaseProjInfo();
        pi.setId(rs.getInt("ID"));
        pi.setName(rs.getString("NAME"));
        pi.setConnectString(rs.getString("CONNECTSTRING"));
        return pi;
    };
}
