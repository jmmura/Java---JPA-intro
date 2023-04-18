package be.technifutur.jpa.repository;

import be.technifutur.jpa.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> getUnitPriceLessThan(double min, double max);


}
