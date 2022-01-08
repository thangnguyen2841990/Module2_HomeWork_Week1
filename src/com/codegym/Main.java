package com.codegym;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement[] products = new ProductManagement[5];
        products[0] = new ProductManagement(1, "Vinamilk", 10000, "Sữa tươi từ bò 100%");
        products[1] = new ProductManagement(2, "WakeUp 247", 8000, "Cà phê");
        products[2] = new ProductManagement(3, "Bò húc", 12000, "Nước tăng lực");
        products[3] = new ProductManagement(4, "Lavie", 5000, "Nước khoáng thiên nhiên");
        products[4] = new ProductManagement(5, "Heniken", 20000, "Bia sản xuất 100% từ lúa mạch");
        // Hiển thị sản phẩm.
        System.out.println("Các sản phẩm gồm: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].display());
        }
        int choice;
        System.out.println("Menu: ");
        System.out.println("1. Thêm sản phẩm. ");
        System.out.println("2. Xóa sản phẩm. ");
        System.out.println("3. Tìm sản phẩm theo tên. ");
        System.out.println("4. Sắp xếp tên sản phẩm theo bảng chữ cái. ");
        System.out.println("5. Cập nhật giá sản phẩm.");
        do {
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 5) {
                System.out.println("Menu chỉ từ 1 => 5");
            }
        } while (choice > 5);
        switch (choice) {
            case 1: {
                // Gọi hàm thêm sản phẩm
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Nhập tên sản phẩm mới: ");
                String newName = scanner2.nextLine();
                System.out.println("Nhập giá sản phẩm mới");
                int newPrice = scanner.nextInt();
                System.out.println("Nhập mô tả sản phẩm mới: ");
                String newDiscription = scanner2.nextLine();
                ProductManagement[] newProducts = new ProductManagement[products.length + 1];
                ProductManagement newProduct = new ProductManagement(6, newName, newPrice, newDiscription);
                System.out.println("\nMảng sau khi thêm sản phẩm: ");
                newProducts = addProduct(products, 5, newProduct);
                for (int i = 0; i < newProducts.length; i++) {
                    System.out.println(newProducts[i].display());
                }
                break;
            }
            case 2: {
                // Gọi hàm xóa sản phẩm
                System.out.print("Nhập vị trí sản phẩm muốn xóa: ");
                int index2 = scanner.nextInt();
                ProductManagement[] newProducts1 = new ProductManagement[4];
                newProducts1 = deleteProduct(products, index2 - 1);
                System.out.println("\nMảng sau khi xóa sản phẩm: ");
                for (int i = 0; i < newProducts1.length; i++) {
                    System.out.println(newProducts1[i].display());
                }
                break;
            }
            case 3: {
                // Tìm kiếm sản phẩm theo tên
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Nhập tên sản phẩm muốn tìm");
                String name = scanner1.nextLine();
                int index = positionOfProduct(products, name);
                if (index == -1) {
                    System.out.println("Sản phẩm không có trong danh sách");
                } else {
                    System.out.println(products[index].display());
                }
                break;
            }
            case 4: {
                // Gọi hàm sắp xếp tên sản phẩm tử A-Z
                Arrays.sort(products);
                System.out.println("Mảng sau khi sắp xếp theo thứ tự A-Z: ");
                for (int i = 0; i < products.length; i++) {
                    System.out.println(products[i].display());
                }
                break;
            }
            case 5: {
                // Cập nhật giá sản phẩm
                System.out.println("Nhập vị trí sản phẩm muốn thay đổi giá");
                int index1 = scanner.nextInt();
                System.out.println("Nhập giá mới: ");
                int newPrice = scanner.nextInt();
                changePrice(products, index1 - 1, newPrice);
                for (int i = 0; i < products.length; i++) {
                    System.out.println(products[i].display());
                }
                break;
            }
        }

    }

    //Xây dựng hàm thêm 1 sản phẩm vào mảng
    public static ProductManagement[] addProduct(ProductManagement[] arr, int index, ProductManagement value) {
        ProductManagement[] newArr = new ProductManagement[arr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            } else if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = arr[i - 1];
            }
        }
        return newArr;
    }

    //Xây dựng hàm xóa sản phẩm.
    public static ProductManagement[] deleteProduct(ProductManagement[] arr, int index) {
        ProductManagement[] newArr = new ProductManagement[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[i + 1];
            }
        }
        return newArr;
    }

    // Xây dựng hàm tìm kiếm sản phẩm theo tên.
    public static int positionOfProduct(ProductManagement[] arr, String name) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    //Hàm cập nhất giá sản phẩm
    public static ProductManagement[] changePrice(ProductManagement[] arr, int index, int newPrice) {
        arr[index].setPrice(newPrice);

        return arr;
    }
//    // Xây dựng hàm sắp xếp tên sản phẩm từ A-Z
//    public static ProductManagement[] sortProduct(ProductManagement[] arr) {
//       Arrays.sort(arr);
//        return arr;
//    }
}





