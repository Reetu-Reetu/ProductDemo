package com.services.springbootpractice.SpringbootPractice.Controller;

import com.services.springbootpractice.SpringbootPractice.Entity.Product;
import com.services.springbootpractice.SpringbootPractice.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/productcatalog")
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

@PostMapping("/products")
public Product addProduct(@RequestBody Product product) {
    return service.saveProduct(product);
}
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.addProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        log.info("retrieving all products");
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/product/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
    log.info("Updating product with id " + id);
        return service.updateProduct(id, product);
    }

    @PatchMapping("/product/update/{id}")
    public Product patchProduct(@RequestBody Product product,
                                @PathVariable int id) {

        log.info("Updating product with id " + id);
        return service.patchProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
