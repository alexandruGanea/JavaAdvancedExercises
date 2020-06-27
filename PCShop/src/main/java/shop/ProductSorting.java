package shop;

import product.Product;

import java.util.Comparator;

public class ProductSorting implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }

    //sortare dupa pret - AlphabeticalPriceSorting si PriceSorting
}
