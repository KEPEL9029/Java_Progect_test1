package org.example;

public class Products  {

    private Integer idProducts;
    private String name;
    private Integer quantity;
    private Integer price;
    private Integer idShop;


    public Products(){}

    public Products(String name, Integer quantity, Integer price, Integer idProducts,Integer idShop) {
        this.idProducts = idProducts;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.idShop = idShop;
    }

    public Integer getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Integer idProducts) {
        this.idProducts = idProducts;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }
}
