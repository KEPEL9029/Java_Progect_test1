package org.example;
import java.util.ArrayList;
import java.util.List;

public class Shop extends Stores{
    private boolean isOpen;
    private final List<Products> products;



    private Integer idShop;

    public Shop(String storeName, String location, boolean isOpen,Integer idShop){
        super(storeName,location);
        this.isOpen = isOpen;
        this.products = new ArrayList<>();
        this.idShop = idShop;
    }


    // добавление продуктов
    public void addProduct(String name, Integer quantity, Integer price,Integer idProduct, Integer idShop){
        // Проверьте, существует ли продукт
        for (Products product : products) {
            if (product.getName().equals(name)) {
                // Увеличьте количество существующего продукта
                product.setQuantity(product.getQuantity() + quantity);
                return;
            }
        }
        products.add(new Products(name, quantity, price,idProduct,idShop));
    }

    // Метод для получения информации о товаре
    public void displayProducts() {
        System.out.println("Магазин: " + getStoreName() + ", Локация: " + getLocation());
        for (Products products : products) {
            System.out.println("Товар: " + products.getName() + ", Количество: " + products.getQuantity() + ", Цена: " + products.getPrice());
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public List<Products> getProducts() {
        return products;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }
}
