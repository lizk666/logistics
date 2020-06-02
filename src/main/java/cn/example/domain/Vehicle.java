package cn.example.domain;

import java.io.Serializable;

/**
 * 车辆的实体类
 */
public class Vehicle implements Serializable {
    private Integer id;
    private String carname;
    private Double carcapacity;
    private String carnumber;
    private Double carload;
    private Double carlength;
    private String drivername;
    private Integer driverphone;
    private Integer serviceid;
    private String isfree;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", carname='" + carname + '\'' +
                ", carcapacity=" + carcapacity +
                ", carnumber='" + carnumber + '\'' +
                ", carload=" + carload +
                ", carlength=" + carlength +
                ", drivername='" + drivername + '\'' +
                ", driverphone=" + driverphone +
                ", serviceid=" + serviceid +
                ", isfree='" + isfree + '\'' +
                '}';
    }

    public String getIsfree() {
        return isfree;
    }

    public void setIsfree(String isfree) {
        this.isfree = isfree;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public Double getCarcapacity() {
        return carcapacity;
    }

    public void setCarcapacity(Double carcapacity) {
        this.carcapacity = carcapacity;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public Double getCarload() {
        return carload;
    }

    public void setCarload(Double carload) {
        this.carload = carload;
    }

    public Double getCarlength() {
        return carlength;
    }

    public void setCarlength(Double carlength) {
        this.carlength = carlength;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public Integer getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(Integer driverphone) {
        this.driverphone = driverphone;
    }
}
