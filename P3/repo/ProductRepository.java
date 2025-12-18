package P3.repo;

import java.util.List;

import P3.model.Product;

public interface ProductRepository {
    void add(Product product);

    List<Product> getAll();

    Product getById(int id);

    boolean deleteById(int id);
}
