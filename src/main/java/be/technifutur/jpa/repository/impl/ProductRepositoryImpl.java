package be.technifutur.jpa.repository.impl;

import be.technifutur.jpa.entities.Product;
import be.technifutur.jpa.repository.ProductRepository;
import be.technifutur.jpa.utils.EMFSharer;
import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager manager = EMFSharer.getInstance().createEntityManager();



    @Override
    public void add(Product toInsert) {
        manager.getTransaction().begin();

        manager.persist(toInsert);          //le Product es attaché à la DB

        manager.getTransaction().commit();
    }

    @Override
    public Optional<Product> get(Long id) {
        Product p = manager.find(Product.class, id);
        manager.clear();
        return Optional.ofNullable(p);  //retourn un Optional si non null et Optional.empty si null
    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = manager.createQuery("SELECT prod FROM Product prod", Product.class);
        List<Product> list = query.getResultList();
        manager.clear();
        return list;
    }


    @Override
    public void update(Long id, Product entity) {
        entity.setId(id);

        String qlQuery = """
                SELECT COUNT(p)
                FROM Product p
                WHERE p.id = ?1
                """;
        TypedQuery<Long> countQuery = manager.createQuery(qlQuery,Long.class);
        countQuery.setParameter(1,10);
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

        Product product = manager.find(Product.class,id);
        if(product!= null){manager.remove(product);}

        manager.getTransaction().commit();
    }

    @Override
    public List<Product> getUnitPriceLessThan(double min, double max) {
        String qlQuery = """
                SELECT p
                FROM Product p
                WHERE p.unit_price BETWEEN ?1 AND ?2
                """;
        TypedQuery<Product> query = manager.createQuery(qlQuery,Product.class);
        query.setParameter(1,min);
        query.setParameter(2,max);
        List<Product> products = query.getResultList();
        manager.clear();
        return query.getResultList();
    }
}
