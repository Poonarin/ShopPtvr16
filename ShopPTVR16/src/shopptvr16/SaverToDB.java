/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopptvr16;

import entity.Buyer;
import entity.Product;
import entity.Purchase;

import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class SaverToDB implements Saveble{
    private EntityManager em;
    private EntityTransaction tx;
    
    public SaverToDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShopPTVR16PU");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
        
        
    }
    
    public void freeResources(){
        if(em != null) em.close();
    }
    
    @Override
    public void saveProducts(List<Product> products) {
        int n = products.size();
        tx.begin();
        for(int i=0;i<n;i++){
            if (products.get(i).getId() == null){
                em.persist(products.get(i));
            }
            em.persist(products.get(i));
        }
        tx.commit();
    }

    @Override
    public void saveBuyers(List<Buyer> buyers) {
        int n = buyers.size();
        tx.begin();
        for(int i=0;i<n;i++){
            if (buyers.get(i).getId() == null){
                em.persist(buyers.get(i));
            }
            em.persist(buyers.get(i));
        }
        tx.commit();
       
    }

    @Override
    public void saveHistories(List<Purchase> purchases) {
        int n = purchases.size();
        tx.begin();
        for(int i=0;i<n;i++){
            if (purchases.get(i).getId() == null){
                em.merge(purchases.get(i));
            }else{
                 em.persist(purchases.get(i));
            }
           
        }
        tx.commit();
        
    }

    

    @Override
    public List<Product> loadProducts() {
        
        List<Product> listProduct = new ArrayList<>();
        listProduct = em.createQuery("SELECT product FROM Product product").getResultList();
        return listProduct;
        
        
    }

    @Override
    public List<Buyer> loadBuyers() {
        
        List<Buyer> listBuyer = new ArrayList<>();
        listBuyer = em.createQuery("SELECT buyer FROM Buyer buyer").getResultList();
        return listBuyer;
        
    }

    @Override
    public List<Purchase> loadPurchase() {
        
        List<Purchase> listPurchase = new ArrayList<>();
        listPurchase = em.createQuery("SELECT purchase FROM Purchase purchase").getResultList();
        return listPurchase;
        
    }

   
    
}
