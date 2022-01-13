package com.codegym;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product(1, "Sting đỏ", 8000, "Nước tăng lục vị dâu");
        products[1] = new Product(2, "Sting vàng", 8000, "Nước tăng lục vị cam");
        products[2] = new Product(3, "Rồng đỏ", 10000, "Nước tăng lục vị rồng đỏ");
        products[3] = new Product(4, "WakeUp 247", 13000, "Nước tăng lục vị cà phê");
        products[4] = new Product(5, "Number 1", 9000, "Nước tăng lục vị dứa");
        menu();

        int choice;
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 6) {
                System.out.println("Menu chỉ có từ 1 => 6");
            }
            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị danh sách sản phẩm----");
                    showAllProducts(products);
                    break;
                }
                case 2: {
                    System.out.println("----Thêm sản phẩm mới----");
                    System.out.println("Nhập vị trí bạn muốn thêm sản phẩm");
                    int index = scanner.nextInt();
                    if (index < 0 || index > products.length) {
                        System.out.println("Vị trí này không xác định");
                    } else {
                        Product newProduct = inputNewProduct();
                        products = addNewProduct(products, index, newProduct);
                    }
                    break;
                }
                case 3: {
                    System.out.println("----Xóa sản phẩm----");
                    System.out.println("Nhập vị trí bạn muốn xóa sản phẩm");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= products.length) {
                        System.out.println("Vị trí này không xác định");
                    } else {
                        products = deleteNewProduct(products, index);
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Cập nhật sản phẩm----");
                    System.out.println("Nhập vị trí bạn muốn cập nhật sản phẩm");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= products.length) {
                        System.out.println("Vị trí này không xác định");
                    } else {
                        Product newProduct = inputNewProduct();
                        products[index] = newProduct;
                    }
                    break;
                }
                case 5: {
                    System.out.println("----Tìm sản phẩm theo tên----");
                    System.out.println("Nhập tên sản phẩm muốn tìm: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    int index = findElement(products, name);
                    if (index == -1) {
                        System.out.println("Không tìm thấy sản phẩm");
                    } else {
                        System.out.println(products[index]);
                    }

                    break;
                }
                case 6: {
                    System.out.println("----Sắp xếp sản phẩm theo thứ tự bảng chữ cái----");
                    sortElement(products);
                    break;
                }
            }


        } while (choice != 0);


    }

    // Hiển thị menu
    public static void menu() {
        System.out.println("Menu: ");
        System.out.println("1. Hiển thị danh sách sản phẩm. ");
        System.out.println("2. Thêm sản phẩm mới. ");
        System.out.println("3. Xóa sản phẩm, ");
        System.out.println("4. Cập nhât sản phẩm ");
        System.out.println("5. Tìm sản phẩm theo tên. ");
        System.out.println("6. Sắp xếp sản phẩm theo tên(A-Z) ");
        System.out.println("0. Thoát");
    }

    //Hiển thị danh sách sản phẩm
    public static void showAllProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    // Hàm nhập thông tin sản phẩm mới
    public static Product inputNewProduct() {
        System.out.println("Nhập thông tin sản phẩm mới");
        System.out.println("ID: ");
        int newID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name: ");
        String newName = scanner.nextLine();
        System.out.println("Price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Discription: ");
        String newDiscription = scanner.nextLine();
        return new Product(newID, newName, newPrice, newDiscription);
    }

    //Hàm thêm sản phẩm
    public static Product[] addNewProduct(Product[] products, int index, Product value) {
        Product[] newProducts = new Product[products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else if (i == index) {
                newProducts[i] = value;
            } else {
                newProducts[i] = products[i - 1];
            }
        }
        return newProducts;
    }

    // Hàm xóa sản phẩm
    public static Product[] deleteNewProduct(Product[] products, int index) {
        Product[] newProducts = new Product[products.length - 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else {
                newProducts[i] = products[i + 1];
            }
        }
        return newProducts;
    }

    // Hàm tìm sản phẩm theo tên
    public static int findElement(Product[] products, String name) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }
    // Hàm sắp xếp sản phẩm theo tên

    public static void sortElement(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length; j++) {
                if (products[i].getName().compareTo(products[j].getName()) < 0) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }
}





