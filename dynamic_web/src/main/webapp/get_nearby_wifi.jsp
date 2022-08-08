<%@ page import="com.Dbmanager" %>
<%@ page import="com.Wifi_info_orm" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.Math" %>
<%--
  Created by IntelliJ IDEA.
  User: minmu
  Date: 2022-08-07
  Time: 오후 6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1><%= "와이파이 정보 구하기" %>
</h1>
<br/>
<a href="http://localhost:8080">홈</a> &#166;
<a href="http://localhost:8080/sub2.jsp">위치 히스토리 목록</a> &#166;
<a href="http://localhost:8080/sub1.jsp">Open API 와이파이 정보 가져오기</a>
<p>

</p>
<style>
    table {
        width: 80%;
    }
    th, td {
        border:solid 1px #0000;
    }
</style>

<form action="get_nearby_wifi.jsp", method="POST">
    LAT : <input id='getLAT()' type='text', name="lat_value"/>,
    LNT : <input id='getLNT()' type='txt', name="lnt_value"/>
    <input type='submit' value='내 위치 가져오기'>
    <input type='submit' value='근처 WIFI 가져오기', >

</form>
<p>

</p>

<style>
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
        overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
        font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
    .tg .tg-baqh{text-align:center;vertical-align:top}
    .tg .tg-15nz{background-color:#009901;color:#ffffff;text-align:left;vertical-align:top}
</style>
<table class="tg">
    <thead>
    <tr>
        <th class="tg-15nz">거리</th>
        <th class="tg-15nz">관리번호</th>
        <th class="tg-15nz">자치구</th>
        <th class="tg-15nz">와이파이명</th>
        <th class="tg-15nz">도로명주소</th>
        <th class="tg-15nz">상세주소</th>
        <th class="tg-15nz">설치위치(층)</th>
        <th class="tg-15nz">설치유형</th>
        <th class="tg-15nz">설치기관</th>
        <th class="tg-15nz">서비스구분</th>
        <th class="tg-15nz">망종류</th>
        <th class="tg-15nz">설치년도</th>
        <th class="tg-15nz">실내외구분</th>
        <th class="tg-15nz">WIFI접속환경</th>
        <th class="tg-15nz">X좌표</th>
        <th class="tg-15nz">Y좌표</th>
        <th class="tg-15nz">작업일자</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <%
            try
            {
                float lat_value = Float.parseFloat(request.getParameter("lat_value"));
                float lnt_value = Float.parseFloat(request.getParameter("lnt_value"));
                Dbmanager manager = new Dbmanager();
                List<Wifi_info_orm> orm_list = manager.GetNearby(lat_value, lnt_value);
                for(Wifi_info_orm target: orm_list) {
                    out.write("<tr>");
                    out.write("<td>" + target.getDistance() + "</td>");
                    out.write("<td>" + target.getMgr_no() + "</td>");
                    out.write("<td>" + target.getWrdofc() + "</td>");
                    out.write("<td>" + target.getMainNm() + "</td>");
                    out.write("<td>" + target.getAdres1() + "</td>");
                    out.write("<td>" + target.getAdres2() + "</td>");
                    out.write("<td>" + target.getInstlFloor() + "</td>");
                    out.write("<td>" + target.getInstlTy() + "</td>");
                    out.write("<td>" + target.getInstlMby() + "</td>");
                    out.write("<td>" + target.getSvcSe() + "</td>");
                    out.write("<td>" + target.getCmcwr() + "</td>");
                    out.write("<td>" + target.getCnstcYear() + "</td>");
                    out.write("<td>" + target.getInoutDoor() + "</td>");
                    out.write("<td>" + target.getRemars3() + "</td>");
                    out.write("<td>" + target.getLat() + "</td>");
                    out.write("<td>" + target.getLnt() + "</td>");
                    out.write("<td>" + target.getWorkDttm() + "</td>");
                    out.write("<tr>");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        %>
    </tr>
    </tbody>
</table>
<tr>

</tr>
</table>

</body>
</html>
