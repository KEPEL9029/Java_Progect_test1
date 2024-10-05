package org.example;

import org.example.database.DataType;
import org.example.database.SqlData;

import java.util.ArrayList;
import java.util.List;

public class ADMIN {


    private Integer id;
    private String Name ;
    private String email;
    private Status Status;
    private Integer age;
    private List<Sellers> sellers = new ArrayList<>();


    public ADMIN(){}

    public ADMIN(String Name ,String email, Status Status, Integer age, Integer id){
        this.Name = Name;
        this.email = email;
        this.Status = Status;
        this.age = age;
        this.id = id;
    }



    public List<SqlData> addValueInTable(Sellers sellers){
        return List.of(new SqlData(1, sellers.getId(), DataType.INTEGER),
                new SqlData(2, sellers.getName(), DataType.STRING),
                new SqlData(3, sellers.getEmail(), DataType.STRING),
                new SqlData(4, sellers.getStatus().toString(), DataType.STRING),
                new SqlData(5, sellers.getAge(), DataType.INTEGER),
                new SqlData(6, sellers.getIdShop(), DataType.INTEGER),
                new SqlData(7, sellers.isActive(), DataType.BOOLEAN));
    }

    public List<SqlData> addValueInTable(ADMIN admin){
        return List.of(new SqlData(1,admin.getId(),DataType.INTEGER),
                new SqlData(2,admin.getName(),DataType.STRING),
                new SqlData(3, admin.getEmail(), DataType.STRING),
                new SqlData(4, admin.getStatus().toString(), DataType.STRING),
                new SqlData(5, admin.getAge(), DataType.INTEGER));
    }

    public List<SqlData> addValueInTable(Products products){
        return List.of(new SqlData(1,products.getIdProducts(), DataType.INTEGER),
                new SqlData(2,products.getName(),DataType.STRING),
                new SqlData(3,products.getQuantity(),DataType.INTEGER),
                new SqlData(4,products.getPrice(),DataType.INTEGER),
                new SqlData(5,products.getIdShop(),DataType.INTEGER));

    }

    public List<SqlData> addValueInTable(Shop shop){
        return List.of(new SqlData(1,shop.getIdShop(),DataType.INTEGER),
                new SqlData(2,shop.getStoreName(),DataType.STRING),
                new SqlData(3,shop.getLocation(),DataType.STRING),
                new SqlData(4,shop.isOpen(),DataType.BOOLEAN));
    }

    public void addSeller(Sellers seller) {
        if (seller != null) {
            sellers.add(seller);
            System.out.println("Продавец добавлен: " + seller.getName());
        } else {
            System.out.println("Не удалось добавить продавца. Объект продавца равен null.");
        }
    }

    public void removeSeller(Sellers seller){
        if (sellers.remove(seller)){
            System.out.println("Продавец удален: " + seller.getName());
        }else{
            System.out.println("Не удалось удалить продавца, продавец не найден");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
