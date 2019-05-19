package controller;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class MainClass {
    private DBConnect dbcon;
    private List<ProductInfo> cart;
    private List<ProductInfo> products;
    private double total;

    public MainClass(){
        dbcon = new DBConnect();
        cart = new ArrayList<>();
        products = new ArrayList<>();
    }

    public ResultSet index(){
        Connection con = dbcon.ConnectBase();
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while(rs.next()) {
                String id = rs.getString("productid");
                String name = rs.getString("name");
                String imagefile = rs.getString("imagefile");
                double price = rs.getDouble("price");
                ProductInfo pi = new ProductInfo(id, name, imagefile, price);
                products.add(pi);
            }
            rs.beforeFirst();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void AddToCart(String productID) {
        for(int i = 0; i<products.size(); i++){
            if(products.get(i).getProductid().equals(productID)){
                int quantity = 1;
                int cartPos = -1;
                for(int j = 0; j<cart.size(); j++){
                    if(cart.get(j).getProductid().equals(productID)){
                        quantity = cart.get(j).getQuantity()+1;
                        cartPos = j;
                        break;
                    }
                }
                ProductInfo tmp = products.get(i);
                tmp.setQuantity(quantity);
                if(cartPos > -1) cart.set(cartPos, tmp);
                else cart.add(tmp);
                break;
            }
        }
    }

    public void UpdateCart(String productid, int quantity){
        for(int i = 0; i<cart.size(); i++){
            ProductInfo tmp = cart.get(i);
            if(tmp.getProductid().equals(productid)){
                if(quantity == 0){
                    cart.remove(i);
                    break;
                }
                tmp.setQuantity(quantity);
                cart.set(i, tmp);
                break;
            }
        }
    }

    public void UpdateTotal(){
        total = 0;
        for(int i = 0; i<cart.size(); i++){
            total += (cart.get(i).getPrice() * cart.get(i).getQuantity());
        }
        total = round(total, 2);
    }

    public double getTotal() {
        return total;
    }

    public List<ProductInfo> getCart() {
        return cart;
    }

    public List<ProductInfo> getProducts() {
        return products;
    }
}
