package org.example;
// считате прибыль
public class Sellers extends ADMIN{
    private Integer idShop;
    private Integer id;
    private  boolean isActive;
    private Integer quantityOfGoodsSold;


    public void addProductToStore(Shop store, String productName, Integer quantity, Integer price,Integer idProduct,Integer idShop){
        if(store != null){
            store.addProduct(productName,quantity,price,idProduct,idShop);
        }else{
            System.out.println("Магазин не найден");
        }
    }

    public void ChangePrice(Shop store, String productName, Integer newPrice) {
        if (store != null) {
            // Поиск продукта в магазине
            for (Products product : store.getProducts()) {
                if (product.getName().equals(productName)) {
                    // Изменение цены
                    product.setPrice(newPrice);
                    System.out.println("Цена изменена успешно на: " + newPrice);
                    return;
                }
            }
            System.out.println("Продукт с именем " + productName + " не найден в магазине.");
        } else {
            System.out.println("Данного магазина не существует!!!");
        }
    }



    public Sellers(){}

    public Sellers(String Name ,String email, Status Status, Integer age, Integer idShop, boolean isActive, Integer quantityOfGoodsSold, Integer id){
        super(Name,email,Status,age,id);
        this.idShop = idShop;
        this.isActive = isActive;
        this.quantityOfGoodsSold = quantityOfGoodsSold;
        this.id = id;
    }

    public Integer getQuantityOfGoodsSold() {
        return quantityOfGoodsSold;
    }

    public void setQuantityOfGoodsSold(Integer quantityOfGoodsSold) {
        this.quantityOfGoodsSold = quantityOfGoodsSold;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
