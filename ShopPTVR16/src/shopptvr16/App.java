/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopptvr16;

import classes.AddBuyer;
import classes.AddProduct;
import classes.AddPurchase;
import classes.CityShower;

import entity.Product;
import entity.Buyer;

import entity.Purchase;
import interfaces.Insertable;
import interfaces.Saveble;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class App {
    
    public List<Product> products = new ArrayList<>();
    public List<Buyer> buyers = new ArrayList<>();
    public List<Purchase> purchases = new ArrayList<>();
    
    
    public Insertable inserter = new ConsoleInsert();
    public CityShower cityShower= new CityShower();
   // public SaverToFile saverToFile;
    public Saveble saver;
    public App(){
//this.saver = new SaverToFile();
        this.saver = new SaverToDB();
        this.products=saver.loadProducts();
        this.buyers = saver.loadBuyers();
        this.purchases = saver.loadPurchase();
    }
    
    
    
    
    public void run(){

    Scanner scanner = new Scanner(System.in);
    System.out.println("<<<<<<<<<<<<<<<<Welcome>>>>>>>>>>>>>>>>");
    String repeat = "r";
        do {
            System.out.println("Выберите нужное действие:");
            System.out.println("0 - для выхода из программы");
            System.out.println("1 - добавить товар");
            System.out.println("2 - идентифицировать покупателя");

            System.out.println("3 - Покупка");
            System.out.println("4 - Товары покупетелей");
            System.out.println("5 - Статистика городов");
            
         
            
            String action = scanner.next();
            
            switch (action) {
                case "0":
                    repeat = "n";
                    break;
                    
                case "1":
                    AddProduct addProduct = new AddProduct();
                    this.products.add(addProduct.add());
                    saver.saveProducts(products);
                    System.out.println(products);
                    System.out.println("--- Товар добавлен ----");
                    break;
                case "2":
                    AddBuyer addBuyer = new AddBuyer();
                    this.buyers.add(addBuyer.add());
                    saver.saveBuyers(buyers);
                    System.out.println(buyers);
                    System.out.println("--- Покупатель идентифицирован ----");
                    break;
//                case "3":
//                    Seller seller = new Seller(3);
//                    System.out.println("Баланс:"+seller.getCash());
//                    break;
                case "3":
                    AddPurchase addPurchase = new AddPurchase();
                    System.out.println("");
                    Purchase purchase = addPurchase.add(products,buyers,purchases);
                    
                    if(purchase.getBuyer()!=null){
                       this.purchases.add(purchase);
                       saver.saveHistories(purchases);
                       System.out.println("---Покупатель выбрал товар---");
                    }
                    
                    
                    break;
                case "4":
                    inserter.showHistoryPurchases(purchases);
                    break;
                case "5":
                    System.out.println("");
                    cityShower.show(buyers);
                    break;
                
                default:
                    System.out.println("Выберите действие из списка!");
                    System.out.println("----------------------------");
                    repeat="r";
            }   
           
            
            
        } while ("r".equals(repeat));

}
    
}

