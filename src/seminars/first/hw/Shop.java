package seminars.first.hw;

import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        int n = products.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (products.get(i - 1).getCost() > products.get(i).getCost()) {
                    Product temp = products.get(i - 1);
                    products.set(i - 1, products.get(i));
                    products.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);

        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null;
        }

        Product mostExpensive = products.get(0);
        for (Product product : products) {
            if (product.getCost() > mostExpensive.getCost()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }
}