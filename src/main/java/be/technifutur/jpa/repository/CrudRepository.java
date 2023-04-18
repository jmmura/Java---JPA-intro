package be.technifutur.jpa.repository;

import be.technifutur.jpa.entities.Product;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<TENTITY,TID> {

    //READ
    Optional<TENTITY> get(TID id);
    List<TENTITY> getAll();

    //CREATE
    void add(TENTITY toInsert);

    //UPDATE
    void update(TID id, TENTITY entity);

    //DELETE
    void delete (TID id);

}
