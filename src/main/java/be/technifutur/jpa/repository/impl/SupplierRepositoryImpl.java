package be.technifutur.jpa.repository.impl;
import be.technifutur.jpa.entities.Product;
import be.technifutur.jpa.entities.Supplier;
import be.technifutur.jpa.repository.SupplierRepository;
import be.technifutur.jpa.utils.EMFSharer;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;


public class SupplierRepositoryImpl implements SupplierRepository {

    private final EntityManager manager = EMFSharer.getInstance().createEntityManager();


    @Override
    public Optional<Supplier> get(Long id) {
        Supplier p = manager.find(Supplier.class, id);
        manager.clear();
        return Optional.ofNullable(p);
    }

    @Override
    public List<Supplier> getAll() {
        TypedQuery<Supplier> query = manager.createQuery("SELECT sup FROM Supplier sup", Supplier.class);
        List<Supplier> list = query.getResultList();
        manager.clear();
        return list;
    }

    @Override
    public void add(Supplier toInsert) {
        manager.getTransaction().begin();
        manager.persist(toInsert);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Long id, Supplier entity) {
        entity.setId(id);

        String qlQuery = """
                SELECT COUNT(s)
                FROM Supplier s
                WHERE s.id = ?1
                """;
        TypedQuery<Long> countQuery = manager.createQuery(qlQuery,Long.class);
        countQuery.setParameter(1,id);
        long count = countQuery.getSingleResult();

        if(count==1){
            manager.getTransaction().begin();
            manager.merge(entity);
            manager.getTransaction().commit();
        }else{
            throw new IllegalArgumentException("element does not exist");
        }
    }

    @Override
    public void delete(Long id) {
        manager.getTransaction().begin();

        Supplier supplier = manager.find(Supplier.class,id);
        if(supplier!= null){manager.remove(supplier);}

        manager.getTransaction().commit();
    }

    @Override
    public List<Supplier> getRegion(String region) {
        TypedQuery<Supplier> query = manager.createQuery("SELECT sup FROM Supplier sup WHERE sup.region = ?1", Supplier.class);
        query.setParameter(1,region);
        List<Supplier> list = query.getResultList();
        manager.clear();
        return list;
    }

    @Override
    public void vip(List<Supplier> sups) {
        sups.forEach(s-> s.setCompanyName(s.getCompanyName()+"- VIP"));
    }

    @Override
    public void vipForInCity(String city) {
        TypedQuery<Supplier> query = manager.createQuery("SELECT sup FROM Supplier sup WHERE sup.city = ?1", Supplier.class);
        query.setParameter(1,city);
        List<Supplier> list = query.getResultList();

        manager.getTransaction().begin();
        list.forEach(s-> s.setCompanyName(s.getCompanyName()+" - VIP"));
        manager.getTransaction().commit();

        //pas besoin de merge car list = resultat d'une requête SQL -> déjà attaché
    }
}
