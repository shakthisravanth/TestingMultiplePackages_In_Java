package P3.repo;

import java.util.ArrayList;
import java.util.List;

import P3.model.Product;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        Product p = getById(id);
        if (p != null) {
            products.remove(p);
            return true;
        }
        return false;
    }
}