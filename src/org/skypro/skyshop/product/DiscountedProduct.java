package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice*(1-discount/100);
    }
}
