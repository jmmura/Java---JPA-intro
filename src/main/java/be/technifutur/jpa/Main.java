package be.technifutur.jpa;
import be.technifutur.jpa.entities.Category;
import be.technifutur.jpa.entities.Product;
import be.technifutur.jpa.entities.Supplier;
import be.technifutur.jpa.repository.ProductRepository;
import be.technifutur.jpa.repository.SupplierRepository;
import be.technifutur.jpa.repository.impl.ProductRepositoryImpl;
import be.technifutur.jpa.repository.impl.SupplierRepositoryImpl;
import be.technifutur.jpa.utils.EMFSharer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.awt.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepositoryImpl();
        SupplierRepository supplierRepository = new SupplierRepositoryImpl();

//        List<Product> products = productRepository.getUnitPriceLessThan(1,10);
//        products.forEach(p-> System.out.printf(" %s: %f$\n",p.getName(),p.getUnit_price()));
//
//        Product product = products.get(0);
//        product.setUnit_price(11.F);
//
//        productRepository.update(product.getId(),product);
//
//        productRepository.delete(78L);
//        List<Product> productss = productRepository.getAll();
//        productss.forEach(p-> System.out.printf(" %s: %f$\n",p.getName(),p.getUnit_price()));


//        Product p = productRepository.get(1L)
//                    .orElseThrow();
//
//        System.out.printf("- [%d] %s: %f\n",p.getId(),p.getName(),p.getUnit_price());
//
//        p.setId(90);
//        p.setName(p.getName()+" - copy");
//        productRepository.add(p);

        List<Supplier> region = supplierRepository.getAll();
//        EMFSharer.getInstance().createEntityManager()
//                .createQuery("SELECT sup FROM Supplier sup WHERE sup.region = ?1", Supplier.class)
//                .setParameter(1,"Québec")
//                .getResultList()
//                .forEach(s->s.setCompanyName(s.getCompanyName()+" - VIP"));
//        query.setParameter(1,region);



        EMFSharer.getInstance().close();

    }
}