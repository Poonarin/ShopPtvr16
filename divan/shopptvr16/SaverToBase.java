/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopptvr16;

import entity.Buyer;
import entity.Product;
import entity.Purchase;
import entity.Seller;
import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public abstract class SaverToBase implements Saveble{
    private EntityManager em;
    private EntityTransaction tx;

    public SaverToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPTVR16PU");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }
    
    @Override
    public void saveBuyers(List<Buyer> buyers) {
        int n = buyers.size();
        this.tx.begin();
        for(int i=0;i<n;i++){
            if(buyers.get(i).getId() == null){
               em.persist(buyers.get(i)); 
            }else{
               em.merge(buyers.get(i));
            }
        }
        this.tx.commit();
    }

    @Override
    public void saveHistories(List<Purchase> purchases) {
        int n = purchases.size();
        this.tx.begin();
        for(int i=0;i<n;i++){
            if(purchases.get(i).getId() == null){
               em.persist(purchases.get(i)); 
            }else{
               em.merge(purchases.get(i));
            }
        }
        this.tx.commit();
    }
    

    @Override
    public void saveSellers(List<Seller> sellers) {
        int n = sellers.size();
        this.tx.begin();
        for(int i=0;i<n;i++){
            if(sellers.get(i).getId() == null){
               em.persist(sellers.get(i)); 
            }else{
               em.merge(sellers.get(i));
            }
            
        }
        this.tx.commit();
    }
    public interface Retentive{
        public void saveBuyers(Buyer buyers);
        public void saveHistories(Purchase purchases);
        public void saveSellers(Seller sellers);
        public List<Buyer> loadBuyer();
        public List<Buyer> loadHistories();
        public List<Buyer> loadSellers();
        
    }

    @Override
    public List<Buyer> loadBuyers()  {
        List<Buyer> listBuyer = em.createQuery("SELECT h FROM History h").getResultList();
        return listBuyer;
    }
    @Override
    public List<Purchase> loadPurchase() {
        List<Purchase> listPurchase = em.createQuery("SELECT r FROM Reader r").getResultList();
        return listPurchase;
    }

    @Override
    public List<Seller> loadSellers() {
        List<Seller> listSeller = em.createQuery("SELECT b FROM Book b").getResultList();
        return listSeller;
    }
    @Override
    public List<Product> loadProducts() {
        List<Product> listProduct = em.createQuery("SELECT b FROM Book b").getResultList();
        return listProduct;
    }   

}
