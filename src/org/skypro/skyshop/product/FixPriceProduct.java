package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{

    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String productName) {
        super(productName);
    }


    @Override
    public int getPrice(){
        return FIX_PRICE;
    }
}
