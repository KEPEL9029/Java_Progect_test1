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
        List<SqlData> data = new ArrayList<>();

        Sellers seller1 = new Sellers("Николай","mama@mama.com",Status.SELLER,20,1,true,10,1);
        var list =  admin.addValueInTable(seller1);

        sqlExecutor.insert("INSERT INTO sellers (id, name, email, status, age, id_shop, is_active)" + "VALUES (?, ?, ?, ?, ?, ?, ?);",list);


        admin.addSeller(seller1);
        admin.removeSeller(seller1);
        System.out.println();


        Sellers seller2 = new Sellers("Иван", "ivan@example.com", Status.SELLER, 30, 1, true, 0,1);

        Shop productStore = new Shop("Магазин продуктов", "Город 1", true);
        Shop productStore2 = new Shop("Магазин техники", "Город 2", true);

        // Продавец добавляет товар
        seller1.addProductToStore(productStore, "Кокосы", 100, 50);
        seller1.addProductToStore(productStore, "Кокосы", 234, 60);

        seller2.addProductToStore(productStore2, "Айфон", 15, 2000);
        seller2.addProductToStore(productStore2, "Айфон", 20, 2000);

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