package org.skypro.skyshop.product;

import org.skypro.skyshop.product.SimpleProduct;
import java.util.Objects;

public abstract class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return String.format("< %s   :   %d руб.", getProductName(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
