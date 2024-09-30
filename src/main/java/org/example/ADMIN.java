package org.example;

import org.example.database.DataType;
import org.example.database.SqlData;

import java.util.ArrayList;
import java.util.List;

public class ADMIN {
    private Long id;
    private String Name ;
    private String email;
    private Status Status;
    private Integer age;
    private List<Sellers> sellers = new ArrayList<>();


    public ADMIN(){}

    public ADMIN(String Name ,String email, Status Status, Integer age){
        this.Name = Name;
        this.email = email;
        this.Status = Status;
        this.age = age;
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
