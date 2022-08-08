<%@ page import="com.Dbmanager" %>
<%@ page import="com.History_orm" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: minmu
  Date: 2022-08-05
  Time: 오후 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1><%= "위치 히스토리 목록" %>
</h1>
<br/>
<a href="http://localhost:8080">홈</a> &#166;
<a href="http://localhost:8080/sub2.jsp">위치 히스토리 목록</a> &#166;
<a href="http://localhost:8080/sub1.jsp">Open API 와이파이 정보 가져오기</a>
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
        <th class="tg-15nz">ID</th>
        <th class="tg-15nz">X좌표</th>
        <th class="tg-15nz">Y좌표</th>
        <th class="tg-15nz">조회일자</th>
        <th class="tg-15nz">비고</th>
        <td>

        </td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <%
            try
            {
                Dbmanager manager = new Dbmanager();
                List<History_orm> orm_list = manager.GetHistory();
                for(History_orm target: orm_list) {
                    out.write("<tr>");
                    out.write("<td>" + target.getId() + "</td>");
                    out.write("<td>" + target.getLat() + "</td>");
                    out.write("<td>" + target.getLnt() + "</td>");
                    out.write("<td>" + target.getSearch_date() + "</td>");
                    out.write("<td><button type='submit'>삭제</button></td>");
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

</body>
</html>

