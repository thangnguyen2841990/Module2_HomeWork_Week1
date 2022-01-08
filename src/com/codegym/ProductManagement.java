package com.codegym;

import java.util.Comparator;
import java.util.List;

public class ProductManagement implements Comparable<ProductManagement> {
    private int id;
    private String name;
    private int price;
    private String description;

    public ProductManagement() {

    }

    public ProductManagement(int id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Hàm hiển thị thông tin sản phẩm
    public String display() {
        return this.id + ", " + this.name.toString() + ", giá: " + this.price + ", " + this.description;
    }

    // Hàm sắp xếp tên sản phẩm từ A-Z
//    public static Comparator<ProductManagement> sortName = new Comparator<ProductManagement>() {
//        public int compare(ProductManagement product1, ProductManagement product2) {
//            String productName1 = product1.getName();
//            String productName2 = product2.getName();
//            return productName1.compareTo(productName2);
//        }
//    };
    public int compareTo(ProductManagement product) {
        return this.getName().compareTo(product.getName());
    }
}
