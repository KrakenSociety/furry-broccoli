/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scamazon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public interface Globals {
    public static int MAX = 4;
    ArrayList<ItemClass> ItemArray = new ArrayList<>();
    ArrayList<ItemClass> VariableCategoryArray = new ArrayList<>();
    ArrayList<ItemClass> searchedItems = new ArrayList<>();
//    ArrayList<ItemClass> shoppingList = new ArrayList<>();
//    ArrayList<Integer> quantity = new ArrayList<>();
    ShoppingCart cart = new ShoppingCart();
    
    /**
     *
     * @param Searchword
     * @param ItemArray
     * @param VariableCategoryArray
     * @return
     */
    public static ArrayList Search(String Searchword, ArrayList<ItemClass> ItemArray, ArrayList<ItemClass> VariableCategoryArray){
        int k = 0;
        //int j = 0;
        for(int i = 0; i < Globals.MAX; i++){
            if((ItemArray.get(i).getCategory()).equalsIgnoreCase(Searchword)){
                VariableCategoryArray.add(k,ItemArray.get(i));
                k++;
                //j=i;
            }
            else{
                int H = 0;
                char[] charArray = Searchword.toCharArray();
                int len = charArray.length;
                char[] charArray2 = ItemArray.get(i).getItemName().toCharArray();
                for(int t = 0; t < len; t++){
                    if(charArray[t] == charArray2[t]){
                        H++;
                    }
                }
                if(H >= 3){
                    VariableCategoryArray.add(k, ItemArray.get(i));
                    //j=i;
                }
            }
        }
    return VariableCategoryArray;
    }
    
    
    public static ItemClass Read (String FileName) throws FileNotFoundException{
        ItemClass temp = new ItemClass();
        try{            
            //File file = new File(FileName);
            Scanner read = new Scanner(new File(FileName));
                read.useDelimiter("\n");
                
                temp.setItemName(read.next());//string name
                String a = read.next(); //storing next line in file in "a"
                //System.out.println("name: " + temp.getItemName());
                double c = Double.parseDouble(a); //parsing the string to a double
                temp.setPrice(c);               //double price
                //System.out.println("price: " + temp.getPrice());
                temp.setSeller(read.next());    //string seller
                //System.out.println("seller: " + temp.getSeller());
                temp.setIsbn(read.next());      //string isbn
                //System.out.println("isbn: " + temp.getIsbn());
                temp.setDescription(read.next());//string description
                //System.out.println("desc: " + temp.getDescription());
                temp.setCategory(read.next());  // string category
                //System.out.println("cat: " + temp.getCategory());
                String z = read.next();
                //System.out.print(z);
                int b = (int) Double.parseDouble(z);
                temp.setRating(b);              //int rating
                //System.out.println("rating: " + temp.getRating());
                String y = read.next();
                int x = (int) Double.parseDouble(y);
                temp.setStock(x);               //int stock
                //System.out.println("stock: " + temp.getStock());
        
            
        }
        catch (IOException | NumberFormatException ex) {
            Logger lgr = Logger.getLogger(ItemClass.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        //ItemArray.add(0, temp);
        return temp;
    }
    
    
    public static void Retrieve (ArrayList<ItemClass> ItemArray) throws FileNotFoundException{
        int j = 1; //setting variable to append to txt file
        for (int i = 0; i < MAX; i++){
            String fileName = "/Users/Desktop/Scamazon_Kody/src/item" + j;
            String txt = fileName + ".txt";
            ItemArray.add(Read(txt));
            j++; //incrementing txt variable
        }
    }
    
    
}
    
   ///



