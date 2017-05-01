/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scamazon;

import java.util.ArrayList;
//import static scamazon.Globals.quantity;
//import static scamazon.Globals.shoppingList;
/**
 * @author Kody Martens
 */

public final class ShoppingCart {
    
    ArrayList<ItemClass> shoppingList = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    
    public ShoppingCart(ItemClass item){
        addItem(item);
    }
    

    //totalPrice is the total sum of the item cost in the shoppingList
    public double totalPrice = 0.0;
    
    //salesTax is the tax that we are going to charge them
    public double salesTax = 0.1;

    ShoppingCart() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    //calcTotalPrice is a function that sums up the total price of the items
    //in the shopping cart
    public double calcTotalPrice(){
        for(int i = 0; i < shoppingList.size(); ++i){
            totalPrice += shoppingList.get(i).getPrice() * quantity.get(i);
        }
        salesTax *= totalPrice; //calculate sales tax
        totalPrice += salesTax; //add sales tax to the totalPrice
        return totalPrice;
    }
    
    /**
     *
     * @param item
     */
    public void addItem(ItemClass item){
        //if you add a duplicate item to the shoppingcart
        //list, the quantity increments rather than the length
        //of the list
        if (shoppingList.isEmpty()){
            shoppingList.add(item);//adding to an empty list
            quantity.add(1);//creating a quantity of 1
        }
        for (int i = 0; i < shoppingList.size(); ++i){
            if (item.getItemName().equals(shoppingList.get(i).getItemName())){
                quantity.set(i, quantity.get(i)+1);
            }
            else{ //no duplicate value
                shoppingList.add(item);//appending unique item to the list
                quantity.add(1);//creating a quantity of 1
            }
        }

    }
    
    /**
     *
     * @param item
     */
    public void removeItem(ItemClass item){
        for(int i = 0; i < shoppingList.size(); ++i){
            if (item.getItemName().equals(shoppingList.get(i).getItemName())){
                if (quantity.get(i) > 1){
                    quantity.set(i, quantity.get(i)-1);
                }
                else{
                    shoppingList.remove(i);
                    quantity.remove(i);
                }
            }
        }
        shoppingList.trimToSize();
        quantity.trimToSize();
    }
    
    public void clearCart(){
        shoppingList.clear();
        quantity.clear();
    }
}
