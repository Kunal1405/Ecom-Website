package com.Kunal.ecom_proj.Repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Kunal.ecom_proj.Model.Product;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Product,Integer> {
    @Query ("SELECT p  FROM Product p WHERE "+
            "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%')) ")
    List<Product> searchProduct(String keyword);
}
