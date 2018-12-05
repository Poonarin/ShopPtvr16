/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entity.Product;
import entity.Buyer;
import entity.Purchase;


import java.util.List;

public interface Saveble {
    
    public void saveProducts(List<Product> products);
    public void saveBuyers(List<Buyer> buyers);
    public void saveHistories(List<Purchase> purchases);
    
    
    
    public List<Product> loadProducts();
    public List<Buyer> loadBuyers();
    public List<Purchase> loadPurchase();
    
}
