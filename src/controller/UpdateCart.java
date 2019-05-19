package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] quantities = request.getParameterValues("quantity[]");
        String[] productids = request.getParameterValues("productid[]");
        MainClass mc = (MainClass)request.getSession().getAttribute("MainClass");
        for(int i = 0; i<quantities.length; i++){
            mc.UpdateCart(productids[i], Integer.parseInt(quantities[i]));
        }
        mc.UpdateTotal();
        response.sendRedirect("cart.jsp");
    }
}
