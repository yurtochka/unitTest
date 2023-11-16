package seminars.first.hw;

import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public static void main(String[] args) {
        testShopInitialization();
        testGetMostExpensiveProduct();
        testSortProductsByPrice();
    }

    public static void testShopInitialization() {
        // Проверка инициализации магазина с товарами
        List<Product> products = new ArrayList<>();
        products.add(new Product("Товар 1", 100));
        products.add(new Product("Товар 2", 50));
        Shop shop = new Shop();
        shop.setProducts(products);
        Assertions.assertThat(shop.getProducts()).isEqualTo(products);
    }

    public static void testGetMostExpensiveProduct() {
        // Проверка метода getMostExpensiveProduct
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("Товар 1", 100);
        Product product2 = new Product("Товар 2", 50);
        products.add(product1);
        products.add(product2);
        Shop shop = new Shop();
        shop.setProducts(products);
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();

        // Теперь сравниваем объекты по их содержимому
        Assertions.assertThat(mostExpensiveProduct)
                .isEqualTo(new Product("Товар 1", 100));
    }
    public static void testSortProductsByPrice() {
        // Проверка метода sortProductsByPrice
        List<Product> products = new ArrayList<>();
        products.add(new Product("Товар 1", 100));
        products.add(new Product("Товар 2", 50));
        Shop shop = new Shop();
        shop.setProducts(products);

        List<Product> sortedProducts = shop.sortProductsByPrice();
        Assertions.assertThat(sortedProducts).containsExactly(
                new Product("Товар 2", 50),
                new Product("Товар 1", 100)
        );

        // Проверка для пустого списка продуктов
        List<Product> emptyProducts = new ArrayList<>();
        Shop emptyShop = new Shop();
        emptyShop.setProducts(emptyProducts);
        List<Product> emptySortedProducts = emptyShop.sortProductsByPrice();
        Assertions.assertThat(emptySortedProducts).isEmpty();
    }
}




