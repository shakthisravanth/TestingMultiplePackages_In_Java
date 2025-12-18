package P3.service;

import java.util.List;

import P3.model.Product;
import P3.repo.ProductRepository;

public class ProductService {

    private ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public void addProduct(int id, String name, double price) {
        Product p = new Product(id, name, price);
        repo.add(p);
    }

    public List<Product> getAllProducts() {
        return repo.getAll();
    }

    public Product getProductById(int id) {
        return repo.getById(id);
    }

    public boolean deleteProduct(int id) {
        return repo.deleteById(id);
    }
}
