<%@ page import="controller.MainClass" %>
<%@ page import="controller.ProductInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lasha
  Date: 5/19/2019
  Time: 3:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String productid = request.getParameter("productid");
    MainClass mc = (MainClass)request.getSession().getAttribute("MainClass");
    List<ProductInfo> pi = mc.getProducts();
    ProductInfo pr = pi.get(0);
    for(int i = 0; i<pi.size(); i++){
        if(pi.get(i).getProductid().equals(productid)){
            pr = pi.get(i);
        }
    }
%>
<html>
<head>
    <title><%=pr.getName()%></title>
</head>
<body>
    <h1><%=pr.getName()%></h1>
    <img src="store-images/<%=pr.getImagefile()%>" />
    <br><br>
    <form action="AddCart" method="post">
            <label><%=pr.getPrice()%></label>
            <input type="hidden" name="productid" value="<%=pr.getProductid()%>">
            <button type="submit">Add to Cart</button>
    </form>
</body>
</html>
