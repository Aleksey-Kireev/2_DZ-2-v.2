package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private final String productName;
    private final int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("< %s   :   %d руб.", getProductName(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}
