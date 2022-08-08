package com;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;



public class wifi_info {
    public void crawling() throws IOException {
        // HTTP Request to OpenAPI
        String BASE_URL = "http://openapi.seoul.go.kr:8088/";
        String OPEN_API_KEY = "5a566175646d696e313235715a6b686d";

        OkHttpClient client = new OkHttpClient();

        for (int i = 1; i < 17796; i = i + 999) {
            try {
                int start = i;
                int end = i + 999;
                String url_param = String.format("/json/TbPublicWifiInfo/%d/%d", start, end); // wifi info의 갯수 넣기
                HttpUrl.Builder urlBuilder
                        = HttpUrl.parse(BASE_URL + OPEN_API_KEY + url_param).newBuilder();


                String url = urlBuilder.build().toString();

                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call = client.newCall(request);
                Response response = call.execute();

                System.out.println(response.code());

                String result = response.body().string();

                Gson gson = new Gson();

                TbPublicWifiInfo wifiInfo = gson.fromJson(result, TbPublicWifiInfo.class);
                Dbmanager manager = new Dbmanager();
                manager.Insert(wifiInfo.GetWifiInfo().GetWifiServices());
            } catch (Exception e)  {
                e.printStackTrace();
                break;
            }
        }
    }
}
/*


        //DB Connection
        String url = "jdbc:mariadb://52.79.222.202:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            Statement statement = connection.createStatement();

            String sql = "select member_type, user_id, name, password " +
                    " from member" +
                    " where member_type = 'email'";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String name = rs.getString("name");
                String password = rs.getString("password");

                System.out.println(memberType + "," + userId + ", " + name + ", " + password);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

*/
