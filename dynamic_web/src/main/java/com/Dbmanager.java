package com;

import java.sql.*;
import java.sql.Connection;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Dbmanager {

    String url = "jdbc:mariadb://52.79.222.202:3306/testdb1";
    String dbUserId = "testuser1";
    String dbPassword = "zerobase";

    public void Insert(WifiService[] services) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            Statement statement = connection.createStatement();

            for (int i = 0; i < services.length; i++) {
                WifiService service = services[i];
                String sql = " insert into wifi_info (mgr_No, wrdoFc, main_Nm, adres_1, adres_2, instl_Floor, instl_Ty, instl_Mby, svc_se, cmcwr, cnstc_year, inout_door, remars3, LAT, LNT, work_dttm)" +
                        " values " +
                        "(" +
                        "'" + service.getX_SWIFI_MGR_NO() + "'" + "," +
                        "'" + service.getX_SWIFI_WRDOFC() + "'" + "," +
                        "'" + service.getX_SWIFI_MAIN_NM() + "'" + "," +
                        '"' + service.getX_SWIFI_ADRES1() + '"' + "," +
                        '"' + service.getX_SWIFI_ADRES2() + '"' + "," +
                        "'" + service.getX_SWIFI_INSTL_FLOOR() + "'" + "," +
                        "'" + service.getX_SWIFI_INSTL_TY() + "'" + "," +
                        "'" + service.getX_SWIFI_INSTL_MBY() + "'" + "," +
                        "'" + service.getX_SWIFI_SVC_SE() + "'" + "," +
                        "'" + service.getX_SWIFI_CMCWR() + "'" + "," +
                        "'" + service.getX_SWIFI_CNSTC_YEAR() + "'" + "," +
                        "'" + service.getX_SWIFI_INOUT_DOOR() + "'" + "," +
                        "'" + service.getX_SWIFI_REMARS3() + "'" + "," +
                        "'" + String.valueOf(service.getLAT()) + "'" + "," +
                        "'" + String.valueOf(service.getLNT()) + "'" + "," +
                        "'" + service.getWORK_DTTM() + "'" + ")";

                System.out.println(sql);


                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    String mgrNo = rs.getString("mgr_No");
                    String wrdofc = rs.getString("wrdoFc");
                    String mainNm = rs.getString("main_Nm");
                    String adres1 = rs.getString("adres_1");
                    String adres2 = rs.getString("adres_2");
                    String instlFloor = rs.getString("instl_Floor");
                    String instlTy = rs.getString("instl_Ty");
                    String instlMby = rs.getString("instl_Mby");
                    String svcSe = rs.getString("svc_se");
                    String cmcwr = rs.getString("cmcwr");
                    String cnstcYear = rs.getString("cnstc_year");
                    String inoutDoor = rs.getString("inout_door");
                    String remars3 = rs.getString("remars3");
                    float lat = rs.getFloat("LAT");
                    float lnt = rs.getFloat("LNT");
                    String workDttm = rs.getString("work_dttm");


                    System.out.println(mgrNo + ", " + wrdofc + ", " + mainNm + ", " + adres1 + ", " + adres2 + ", " + instlFloor + ", "
                            + instlTy + ", " + instlMby + ", " + svcSe + ", " + cmcwr + ", " + cnstcYear + ", " + inoutDoor + ", " +
                            remars3 + ", " + lat + ", " + lnt + ", " + workDttm);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<Wifi_info_orm> GetNearby(float lat, float lnt) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Wifi_info_orm> ormList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            Statement statement = connection.createStatement();

            String sql = String.format(
                    "SELECT *,\n" +
                            "       (6371 * acos(cos(radians(%f)) * cos(radians(LNT)) * cos(radians(LAT)\n" +
                            "        - radians(%f)) + sin(radians(%f)) * sin(radians(LNT))))\n" +
                            "           AS distance\n" +
                            "FROM wifi_info\n" +
                            "\n" +
                            "ORDER BY distance\n" +
                            "LIMIT 20;\n", lat, lnt, lat);
            ResultSet rs = statement.executeQuery(sql);

            System.out.println(sql);

            while (rs.next()) {
                Wifi_info_orm new_orm = Wifi_info_orm.FromRow(rs);
                ormList.add(new_orm);
            }

            String sql2 = String.format(
                    "insert into history (lat, lnt, search_date)\n" +
                            "values (" +
                            "'" + String.valueOf(lat) + "'" + "," +
                            "'" + String.valueOf(lnt) + "'" + "," +
                            "'" + Instant.now().toString() + "'" + ")"
            );
            ResultSet rs2 = statement.executeQuery(sql2);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } return ormList;
    }

    public List<History_orm> GetHistory() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<History_orm> ormList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            Statement statement = connection.createStatement();

            String sql = "SELECT *\n" +
                    "FROM history\n" +
                    "ORDER BY id desc\n";
            ResultSet rs = statement.executeQuery(sql);

            System.out.println(sql);

            while (rs.next()) {
                History_orm new_orm = History_orm.FromRow(rs);
                ormList.add(new_orm);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } return ormList;
    }



    public void Delete(int id) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            Statement statement = connection.createStatement();

            String sql = String.format("delete\n" +
                    "from history\n" +
                    "where id = %d", id);
            ResultSet rs = statement.executeQuery(sql);

            System.out.println(sql);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}




