/*
 *
 */

package scamazon;

import java.util.ArrayList;


/**
 *
 * @author Kyle Beckley
 */
public class ItemClass {
    private String  ItemName;
    private double  Price;
    private String  Seller;
    private String  Isbn;
    private String  Description;
    private String  Category;
    private int     Rating;
    private int     Stock;          
    
    public ItemClass(){
        
    }
    
    public void print (){
        System.out.println(getItemName());
        System.out.println(getPrice());
        System.out.println(getSeller());
        System.out.println(getIsbn());
        System.out.println(getDescription());
        System.out.println(getCategory());
        System.out.println(getRating());
        System.out.println(getStock());   
    }
    
    public void setItemName(String newItemName){
        ItemName = newItemName;
    }
    
    public String getItemName(){
        return ItemName;
    }
    
    public double getPrice(){
        return Price;
    }
    
    public void setPrice(double newPrice){
        Price = newPrice;
    }
    
    public String getSeller(){
        return Seller;
    }
    
    public void setSeller(String newSeller){
        Seller = newSeller;
    }
    
    public String getIsbn(){
        return Isbn;
    }
    
    public void setIsbn(String newIsbn){
        Isbn = newIsbn;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public void setDescription(String newDescription){
        Description = newDescription;
    }
    
    public String getCategory(){
        return Category;
    }
    
    public void setCategory(String newCategory){
        Category = newCategory;
    }
    
    public int getRating(){
        return Rating;
    }
    
    public void setRating(int newRating){
        Rating = newRating;
    }
    
    public int getStock(){
        return Stock;
    }
    
    public void setStock(int newStock){
        Stock = newStock;
    }
    
    
    public String displayItem(){
        String entireItem =
        "Item Name: " + getItemName() + "\n" +
        "Price: $" + getPrice() + "\n" +
        "Seller: " + getSeller() + "\n" +
        "ISBN: " + getIsbn() + "\n" +
        "Disc: " + getDescription() + "\n" +
        "Category: " + getCategory() + "\n" +
        "Rating: " + getRating() + "\n" +
        "Remaining Stock: " + getStock();
        return entireItem;
    }
    
    
public void Search(String Searchword, ArrayList<ItemClass> ItemArray, ArrayList<ItemClass> VariableCategoryArray){
    int k = 0;
    ItemClass temp = new ItemClass();
    for(int i = 0; i < Globals.MAX; i++){
        if((ItemArray.get(i).getCategory()).equalsIgnoreCase("Electronics")){
            temp = ItemArray.get(i);
            VariableCategoryArray.set(k,temp);
            k++;
        }
        else{
            char[] charArray = Searchword.toCharArray();
            int len = charArray.length;
            char[] charArray2 = ItemArray.get(i).getItemName().toCharArray();
            int H = 0;
            for(int t = 0; t < len; t++){
                if(charArray[t] == charArray2[t]){
                    H++;
                }
            }
            if(H >= 3){
                VariableCategoryArray.set(k, ItemArray.get(i));
            }
        }
    }
}
    
}

   
