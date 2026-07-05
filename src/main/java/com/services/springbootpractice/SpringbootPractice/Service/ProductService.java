package com.services.springbootpractice.SpringbootPractice.Service;

import com.services.springbootpractice.SpringbootPractice.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.services.springbootpractice.SpringbootPractice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }



    public List<Product> addProducts(List<Product> products) {
        return repository.saveAll(products);
    }
    public Product updateProduct(int id, Product product) {
        Product existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    public Product patchProduct(int id, Product product) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }

        if (product.getPrice() != 0) {
            existingProduct.setPrice(product.getPrice());
        }

        if (product.getQuantity() != 0) {
            existingProduct.setQuantity(product.getQuantity());
        }

        return repository.save(existingProduct);
    }
}