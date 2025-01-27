package com.Kunal.ecom_proj.Controller;

import com.Kunal.ecom_proj.Model.Product;
import com.Kunal.ecom_proj.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("")
    public String greet() {
        return "Hello Namaste!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = service.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        try {
            Product product = service.getProduct(id);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            // Validate inputs
            if (product == null || imageFile.isEmpty()) {
                return new ResponseEntity<>("Product details or image file is missing.", HttpStatus.BAD_REQUEST);
            }

            Product savedProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
        Product product= service.getProduct(id);
        byte[] imageFile= product.getImageDate();
        return ResponseEntity.ok().body(imageFile);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,
                                                @RequestPart MultipartFile imageFile){
        Product product1=null;
        try {
            product1=service.updateProduct(id,product,imageFile);
        }
        catch (IOException e){
            return new ResponseEntity<>("Failed to update",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(product1 !=null){
            return  new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Failed to update",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product=service.getProduct(id);
        if(product!=null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Product Deleted",HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>("Product not found",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        System.out.println("Searching with" + keyword);
        List<Product> products=service.searchProduct(keyword);
        return  new ResponseEntity<>(products,HttpStatus.OK);
    }
}
