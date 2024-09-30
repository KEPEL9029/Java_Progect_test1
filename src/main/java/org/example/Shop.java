package org.example;
import java.util.ArrayList;
import java.util.List;

public class Shop extends Stores{
    private boolean isOpen;
    private final List<Products> products;

    public Shop(String storeName, String location, boolean isOpen){
        super(storeName,location);
        this.isOpen = isOpen;
        this.products = new ArrayList<>();
    }


    // добавление продуктов
    public void addProduct(String name, Integer quantity, Integer price){
        // Проверьте, существует ли продукт
        for (Products product : products) {
            if (product.getName().equals(name)) {
                // Увеличьте количество существующего продукта
                product.setQuantity(product.getQuantity() + quantity);
                return;
            }
        }
        products.add(new Products(name, quantity, price));
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

}
