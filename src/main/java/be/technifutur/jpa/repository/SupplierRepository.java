package be.technifutur.jpa.repository;

import be.technifutur.jpa.entities.Supplier;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier,Long> {

    List<Supplier> getRegion(String region);

    void vip(List<Supplier> sups);

    void vipForInCity(String city);
}
