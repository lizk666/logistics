package cn.example.domain;

/**
 * 路线的实体类
 */
public class RouteInfo {
    private Double longitude;//经度
    private Double latitude;//纬度
    private Double require;
    private Double satisfy;

    @Override
    public String toString() {
        return "RouteInfo{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", require=" + require +
                ", satisfy=" + satisfy +
                '}';
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getRequire() {
        return require;
    }

    public void setRequire(Double require) {
        this.require = require;
    }

    public Double getSatisfy() {
        return satisfy;
    }

    public void setSatisfy(Double satisfy) {
        this.satisfy = satisfy;
    }
}
