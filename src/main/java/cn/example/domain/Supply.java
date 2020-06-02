package cn.example.domain;

import java.io.Serializable;

/**
 * 服务点的实体类
 */
public class Supply implements Serializable {
    private Integer id;
    private String supplyname;
    private Double supplylongitude;//经度
    private Double supplylatitude;//纬度
    private Double supplycapacity;//库容量

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", supplyname='" + supplyname + '\'' +
                ", supplylongitude=" + supplylongitude +
                ", supplylatitude=" + supplylatitude +
                ", supplycapacity=" + supplycapacity +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplyname() {
        return supplyname;
    }

    public void setSupplyname(String supplyname) {
        this.supplyname = supplyname;
    }

    public Double getSupplylongitude() {
        return supplylongitude;
    }

    public void setSupplylongitude(Double supplylongitude) {
        this.supplylongitude = supplylongitude;
    }

    public Double getSupplylatitude() {
        return supplylatitude;
    }

    public void setSupplylatitude(Double supplylatitude) {
        this.supplylatitude = supplylatitude;
    }

    public Double getSupplycapacity() {
        return supplycapacity;
    }

    public void setSupplycapacity(Double supplycapacity) {
        this.supplycapacity = supplycapacity;
    }
}
