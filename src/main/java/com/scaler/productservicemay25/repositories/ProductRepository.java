package com.scaler.productservicemay25.repositories;
import com.scaler.productservicemay25.model.Category;
import com.scaler.productservicemay25.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);

    List<Product> findByTitleContainsIgnoreCase(String title);

    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    Optional<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Id(Long categoryId);

    List<Product> findAllByCategory_Title(String categoryTitle);

    @Override
    void deleteById(Long productId);
    // @Query("select title from products where id=?")
   // Optional<Product> findOnlyProductTitleById(Long productId);

    Product save(Product product);

    //HQL
    @Query(value = "select * from products p where p.id = :id", nativeQuery = true)
     Optional<Product> findProductWithGivenId(@Param("id") Long productId);
}

