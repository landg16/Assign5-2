package controller;

public class ProductInfo {

    private String productid;
    private String name;
    private String imagefile;
    private double price;
    private int quantity;

    public ProductInfo(String productid, String name, String imagefile, double price) {
        this.productid = productid;
        this.name = name;
        this.imagefile = imagefile;
        this.price = price;
        this.quantity = 0;
    }

    public String getProductid() {
        return productid;
    }

    public String getName() {
        return name;
    }

    public String getImagefile() {
        return imagefile;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
