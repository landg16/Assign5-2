package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productid = request.getParameter("productid");
        MainClass mc = (MainClass)request.getSession().getAttribute("MainClass");
        mc.AddToCart(productid);
        mc.UpdateTotal();
        response.sendRedirect("cart.jsp");
    }

}
