package com;

import java.sql.ResultSet;
import java.sql.SQLException;

public class History_orm {

    private int id;
    private String lat;
    private String lnt;

    private String search_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSearch_date() {
        return search_date;
    }

    public void setSearch_date(String search_date) {
        this.search_date = search_date;
    }


    public History_orm(ResultSet rs) throws SQLException {
        id = rs.getInt("id");
        lat = rs.getString("lat");
        lnt = rs.getString("lnt");
        search_date = rs.getString("search_date");
    }

    public static History_orm FromRow(ResultSet Set) throws SQLException {
        History_orm new_object = new History_orm(Set); // rs? set?
        return new_object;
    }
}




