package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // find...By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    // exist...By
    boolean existsByNumber(Long number);

    // count...By
    long countByName(String name);

    // delete...By, remove...By
    void deleteByNumber(Long number);
    long removeByName(String name);

    // ...First<number>..., ...Top<number>...
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    // findByNumber 메서드와 동일하게 동작
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    // Not
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    // (is)Null, (is)NotNull
    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    List<Product> findByUpdatedAtIsNotNull();

    // (is)True, (is)False
    // Product findByisActiveTrue();
    // Product findByisActiveIsTrue();
    // Product findByisActiveFalse();
    // Product findByisActiveIsFalse();

    // And, Or
    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    // (is)GreaterThan, (is)LessThan, (is)Between
    List<Product> findByPriceIsGreaterThan(Integer price);
    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findByPriceGreaterThanEqual(Integer price);
    List<Product> findByPriceIsLessThan(Integer price);
    List<Product> findByPriceLessThan(Integer price);
    List<Product> findByPriceLessThanEqual(Integer price);
    List<Product> findByPriceIsBetween(Integer lowPrice, Integer highPrice);
    List<Product> findByPriceBetween(Integer lowPrice, Integer highPrice);

    // (is)StartingWith(==StartsWith), (is)EndingWith(==EndsWith), (is)Containing(==Contains), (is)Like
    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);
    List<Product> findByNameContains(String name);
    List<Product> findByNameIsContaining(String name);
    List<Product> findByNameStartsWith(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameIsStartingWith(String name);
    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIsEndingWith(String name);

    // Asc, Desc
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);
    List<Product> findByNameOrderByPriceAscStockDesc(String name);
    List<Product> findByName(String name, Sort sort);

    // Paging
    Page<Product> findByName(String name, Pageable pageable);

    // Query & Param
    @Query("SELECT p FROM Product AS p WHERE p.name = ?1")
    List<Product> findByName(String name);
    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);
    @Query("SELECT p.name, p.price, p.stock FROM Product AS p WHERE p.name = :name")
    List<Product> findByNameParam2(@Param("name") String name);
}
