package org.example;

import org.example.database.DataType;
import org.example.database.PostgresConnection;
import org.example.database.SqlData;
import org.example.database.SqlExecutor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new PostgresConnection().getConnection();

        ADMIN admin = new ADMIN();
        admin.setName("Слава");
        admin.setStatus(Status.ADMIN);

        SqlExecutor sqlExecutor = new SqlExecutor(connection);

        sqlExecutor.Delete("DELETE FROM sellers",null);
        sqlExecutor.Delete("DELETE FROM shops",null);
        sqlExecutor.Delete("DELETE FROM products",null);
        sqlExecutor.Delete("DELETE FROM admins",null);


        Sellers seller1 = new Sellers("Николай","mama@mama.com",Status.SELLER,20,1,true,10,2);
        var list =  admin.addValueInTable(seller1);
        sqlExecutor.insert("INSERT INTO sellers (id, name, email, status, age, id_shop, is_active)" + "VALUES (?, ?, ?, ?, ?, ?, ?);",list);

        ADMIN admin1 = new ADMIN("Николай","kol@kol.com",Status.ADMIN,30,1);
        list = admin.addValueInTable(admin1);
        sqlExecutor.insert("INSERT INTO admins (id, name, email, status, age)" + "VALUES (?, ?, ?, ?, ?);",list);

        Products products = new Products("Пылесос",10,1000,2,3);
        list = admin.addValueInTable(products);
        sqlExecutor.insert("INSERT INTO products (id, name, quantity, price, id_shop)" + "VALUES (?, ?, ?, ?, ?);",list);

        Shop shop = new Shop("Магазин технили","Город 2",true,2);
        list = admin.addValueInTable(shop);
        sqlExecutor.insert("INSERT INTO shops (id, store_name, location,is_open)" + "VALUES (?, ?, ?, ?);",list);

        sqlExecutor.Delete("DELETE FROM sellers WHERE id = ?",3);

        // Пример обновления данных с использованием безопасного метода changeData
        String updateSql = "UPDATE sellers SET name = ? WHERE id = ?";
        List<SqlData> updateParams = List.of(
                new SqlData(1, "Александр", DataType.STRING),
                new SqlData(2, 1, DataType.INTEGER)
        );
        sqlExecutor.changeData(updateSql, updateParams);



        admin.addSeller(seller1);
        admin.removeSeller(seller1);
        System.out.println();


        Sellers seller2 = new Sellers("Иван", "ivan@example.com", Status.SELLER, 30, 1, true, 0,1);

        Shop productStore = new Shop("Магазин продуктов", "Город 1", true,1);
        Shop productStore2 = new Shop("Магазин техники", "Город 2", true,2);

        // Продавец добавляет товар
        seller1.addProductToStore(productStore, "Кокосы", 100, 50,1,1);
        seller1.addProductToStore(productStore, "Кокосы", 234, 60,1,1);

        seller2.addProductToStore(productStore2, "Айфон", 15, 2000,2,2);
        seller2.addProductToStore(productStore2, "Айфон", 20, 2000,2,2);

        System.out.println();

        // Выводим товары в магазине
        productStore.displayProducts();
        System.out.println();
        productStore2.displayProducts();

        System.out.println();
        seller1.ChangePrice(productStore,"Кокосы",40);
        productStore.displayProducts();

    // sql join прочитать для select

    }
}