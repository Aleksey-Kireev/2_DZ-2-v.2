package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт.");
            return;
        }
        products[size++] = product;
    }

    public int getSummBasket() {
        int summ = 0;
        for (Product prod : products) {
            if (prod != null) {
                summ += prod.getPrice();
            }
        }
        return summ;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("- = В корзине пусто = -");
            return;
        }
        int summ = 0;
        for (Product prod : products) {
            if (prod != null) {
                System.out.println(prod);
                summ += prod.getPrice();
            }
        }
        System.out.println("Итого: " + summ + " руб.");
    }

    public boolean detCompairProdukt(String nameReq) {
        for (Product prod : products) {
            if (prod != null && prod.getProductName().equals(nameReq)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        size = 0;
    }
}


