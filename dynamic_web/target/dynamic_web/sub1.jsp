<%@ page import="java.sql.DriverManager" %>
<%@ page import="okhttp3.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.wifi_info" %>

<%--
  Created by IntelliJ IDEA.
  User: minmu
  Date: 2022-08-05
  Time: 오후 7:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>

<div align="center">
    <h1>
            <%
    wifi_info info = new wifi_info();
    info.crawling();
    try
    {
        Class.forName("org.mariadb.jdbc.Driver").newInstance();
        java.sql.Connection con = DriverManager.getConnection("jdbc:mariadb://52.79.222.202:3306/testdb1","testuser1","zerobase");
        Statement st = con.createStatement();
        String strQuery = "SELECT COUNT(*) FROM wifi_info";
        ResultSet rs = st.executeQuery(strQuery);

        String Countrow = "";
        while(rs.next()){
            Countrow = rs.getString(1);
            out.println(Countrow + "개의 wifi 정보를 저장하였습니다.");
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
%>
        <br>
        <br>
        <a href="http://localhost:8080"> 홈으로 가기 </a>

</div>

</body>
</html>
