<%@ page import="controller.MainClass" %>
<%@ page import="java.util.Map" %>
<%@ page import="controller.ProductInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lasha
  Date: 5/19/2019
  Time: 3:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <form action="UpdateCart" method="post">
        <ul>
            <%
                MainClass mc = (MainClass)request.getSession().getAttribute("MainClass");
                List<ProductInfo> cart = mc.getCart();
                for(int i = 0; i<cart.size(); i++) {
                    ProductInfo pr = cart.get(i);
            %>
                <li>
                    <label>
                        <input type="hidden" name="productid[]" value="<%=pr.getProductid()%>"/>
                        <input type="text" name="quantity[]" value="<%=pr.getQuantity()%>"> <%=pr.getName()%>, <%=pr.getPrice()%>$
                    </label>
                </li>
            <%
                }
            %>
        </ul>
        <p>Total: <%=mc.getTotal()%>$ <button type="submit">Update Cart</button></p>
    </form>
    <p><a href="index.jsp" >Continue Shopping</a></p>
</body>
</html>
