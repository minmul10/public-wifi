package com;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Wifi_info_orm {
    private float distance;
    private String mgr_no;
    private String wrdofc;
    private String mainNm;
    private String adres1;
    private String adres2;
    private String instlFloor;
    private String instlTy;
    private String instlMby;
    private String svcSe;
    private String cmcwr;
    private String cnstcYear;
    private String inoutDoor;
    private String remars3;
    private String lat;
    private String lnt;
    private String workDttm;

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getMgr_no() {
        return mgr_no;
    }

    public void setMgr_no(String mgr_no) {
        this.mgr_no = mgr_no;
    }

    public String getWrdofc() {
        return wrdofc;
    }

    public void setWrdofc(String wrdofc) {
        this.wrdofc = wrdofc;
    }

    public String getMainNm() {
        return mainNm;
    }

    public void setMainNm(String mainNm) {
        this.mainNm = mainNm;
    }

    public String getAdres1() {
        return adres1;
    }

    public void setAdres1(String adres1) {
        this.adres1 = adres1;
    }

    public String getAdres2() {
        return adres2;
    }

    public void setAdres2(String adres2) {
        this.adres2 = adres2;
    }

    public String getInstlFloor() {
        return instlFloor;
    }

    public void setInstlFloor(String instlFloor) {
        this.instlFloor = instlFloor;
    }

    public String getInstlTy() {
        return instlTy;
    }

    public void setInstlTy(String instlTy) {
        this.instlTy = instlTy;
    }

    public String getInstlMby() {
        return instlMby;
    }

    public void setInstlMby(String instlMby) {
        this.instlMby = instlMby;
    }

    public String getSvcSe() {
        return svcSe;
    }

    public void setSvcSe(String svcSe) {
        this.svcSe = svcSe;
    }

    public String getCmcwr() {
        return cmcwr;
    }

    public void setCmcwr(String cmcwr) {
        this.cmcwr = cmcwr;
    }

    public String getCnstcYear() {
        return cnstcYear;
    }

    public void setCnstcYear(String cnstcYear) {
        this.cnstcYear = cnstcYear;
    }

    public String getInoutDoor() {
        return inoutDoor;
    }

    public void setInoutDoor(String inoutDoor) {
        this.inoutDoor = inoutDoor;
    }

    public String getRemars3() {
        return remars3;
    }

    public void setRemars3(String remars3) {
        this.remars3 = remars3;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLnt() {
        return lnt;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt;
    }

    public String getWorkDttm() {
        return workDttm;
    }

    public void setWorkDttm(String workDttm) {
        this.workDttm = workDttm;
    }

    public Wifi_info_orm(ResultSet rs) throws SQLException {
        mgr_no = rs.getString("mgr_No");
        wrdofc = rs.getString("wrdoFc");
        mainNm = rs.getString("main_Nm");
        adres1 = rs.getString("adres_1");
        adres2 = rs.getString("adres_2");
        instlFloor = rs.getString("instl_Floor");
        instlTy = rs.getString("instl_Ty");
        instlMby = rs.getString("instl_Mby");
        svcSe = rs.getString("svc_se");
        cmcwr = rs.getString("cmcwr");
        cnstcYear = rs.getString("cnstc_year");
        inoutDoor = rs.getString("inout_door");
        remars3 = rs.getString("remars3");
        lat = rs.getString("LAT");
        lnt = rs.getString("LNT");
        workDttm = rs.getString("work_dttm");
        distance = rs.getFloat("distance"); // km
    }

    public static Wifi_info_orm FromRow(ResultSet Set) throws SQLException {
        Wifi_info_orm new_object = new Wifi_info_orm(Set); // rs? set?
        return new_object;
    }
}

