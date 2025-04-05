package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Random;

public class App {

    private static final SimpleProduct[] PROD = new SimpleProduct[5];

    private static final Random RANDOM = new Random();
    private static final String[] allFixProd = {"Помидоры", "Огурцы", "Картофель", "Перец Красный", "Баклажан",
            "Капуста",
            "Кабачок"};

    private static void initProd() {
        for (int i = 0; i < PROD.length; i++) {
//            String fullProd = allProd[RANDOM.nextInt(0, allProd.length)];
            PROD[i] = new SimpleProduct(allFixProd[RANDOM.nextInt(0, allFixProd.length)], RANDOM.nextInt(50, 1200));
        }
    }

    public static void main(String[] args) {
        System.out.println("---- ==== org.skypro.skyshop.App.main ==== ----\n");

        ProductBasket[] bask = new ProductBasket[5];    // Создаем массив корзин
        for (int i = 1; i < 4; i++) {                   //  и заполняем его рандомно.
            initProd();
            bask[i] = new ProductBasket();
            for (int j = 0; j < 5; j++) {
                bask[i].addProduct(PROD[j]);
            }
        }

        int i = 0;                                      // Печатаем список и состав корзин
        for (ProductBasket prod : bask) {
            if (prod == null) {
                System.out.println("\nКорзина № " + (i+1) + " пуста.");
            } else {
                System.out.println();
                System.out.println("Корзина № " + (i+1));
                prod.printBasket();
            }
            i++;
        }

        ProductBasket basket = new ProductBasket();

//    Печать пустой корзины
        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();
        System.out.println();

        SimpleProduct banana = new SimpleProduct("Банан", 320);
        SimpleProduct apple = new SimpleProduct("Яблоко", 410);
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 54, 5);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 650, 12);
        FixPriceProduct sugar = new FixPriceProduct("Сахор");
        SimpleProduct milk = new SimpleProduct("Молоко", 132);
        SimpleProduct fish = new SimpleProduct("Рыба", 740);

//    Добавляем продукты в корзину
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(bread);

//      Печатаем не полную корзину с продуктами
        System.out.println("Содержимое не полной корзины:");
        basket.printBasket();
        basket.addProduct(meat);
        basket.addProduct(sugar);
//    --- Попытка добавить еще один продукт
        basket.addProduct(milk);
        System.out.println();

//      Печатаем всю корзину с продуктами
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println();
        System.out.println("Общая стоимость продуктов в корзине: " + basket.getSummBasket() + " руб.");

        System.out.println();
        System.out.println("Поиск Хлеба в корзине:");
        String nameReq = "Хлеб";
        String find = basket.detCompairProdukt(nameReq) ? "Продукт найден." : "Такого продукта нет.";
        System.out.println(find);
        System.out.println();
        System.out.println("Поиск Молока в корзине:");
        nameReq = "Молоко";
        find = basket.detCompairProdukt(nameReq) ? "Продукт найден." : "Такого продукта нет.";
        System.out.println(find);

        System.out.println();
        basket.clearBasket();       // Очистка корзины 3
        bask[2].clearBasket();
        bask[2].printBasket();
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        System.out.println("Сьоимость пустой корзины: " + basket.getSummBasket() + " руб.");
        System.out.println();
        System.out.println("Есть ли Хлеб в пустой корзине: " + basket.detCompairProdukt("Хлеб"));

        System.out.println();

    }


}
