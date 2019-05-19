<%--
  Created by IntelliJ IDEA.
  User: lasha
  Date: 5/19/2019
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="controller.MainClass" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Store</title>
</head>
<body>
    <h1>Student Store</h1>
    <p>Items Available:</p>
    <ul>
        <%
            MainClass mc = (MainClass)request.getSession().getAttribute("MainClass");
            ResultSet rs = mc.index();
            try {
                while(rs.next()){
                    String id = rs.getString("productid");
                    String name = rs.getString("name");
        %>
            <li><a href="item_page.jsp?productid=<%=id%>"><%=name%></a></li>
        <%
                }
                rs.beforeFirst();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
    </ul>
</body>
</html>
