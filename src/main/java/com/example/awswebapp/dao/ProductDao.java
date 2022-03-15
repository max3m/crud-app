package com.example.awswebapp.dao;

import com.example.awswebapp.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {
    public static long PEOPLE_COUNT;
    private List<Product> products;

    {
        products = new ArrayList<>();
        products.add(new Product(++PEOPLE_COUNT, "Name1"));
        products.add(new Product(++PEOPLE_COUNT, "Name2"));
        products.add(new Product(++PEOPLE_COUNT, "Name3"));
        products.add(new Product(++PEOPLE_COUNT, "Name4"));
        products.add(new Product(++PEOPLE_COUNT, "Name5"));
    }

    public List<Product> index () {
        return products;
    }

    public Product show(long id) {
        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public Product setById(long id, Product product) {
        var productToChange = show(id);
        if (productToChange == null) {
            products.add(product);
            productToChange = product;
        }
        productToChange.setName(product.getName());
        return show(id);
    }
}
