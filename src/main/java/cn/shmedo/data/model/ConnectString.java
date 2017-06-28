package cn.shmedo.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Created by ldd on 17-6-27.
 */
public class ConnectString {
    @JsonProperty("DATAALIAS")
    private String DATAALIAS;
    @JsonProperty("IP")
    private String IP;
    @JsonProperty("PORT")
    private int PORT;
    @JsonProperty("SID")
    private String SID;
    @JsonProperty("USER")
    private String USER;
    @JsonProperty("PASSWORD")
    private String PASSWORD;
    @JsonProperty("SERVICENAME")
    private String SERVICENAME;

    public String getDATAALIAS() {
        return DATAALIAS;
    }

    public void setDATAALIAS(String DATAALIAS) {
        this.DATAALIAS = DATAALIAS;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getSERVICENAME() {
        return SERVICENAME;
    }

    public void setSERVICENAME(String SERVICENAME) {
        this.SERVICENAME = SERVICENAME;
    }

    public static ConnectString valueOf(String conn) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
            return objectMapper.readValue(conn, ConnectString.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
