/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scamazon;

/**
 *
 * @author L
 */
public class User {
    
    private String username;
    private String password;
    private String customerID;
    private double balance;
    //private String contactInfo // depends on how we implement chat-base system
    private String email;
    public ShoppingCart cart;
    
    public String getUsername(){
        return username;
    }
    
    protected String getPass(){ //protected ensure password security
        return password;
    }
    
    protected String getID(){
        return customerID;
    }
    
    public double getBalance(){
        return balance;
    }
    
    //protected ensure protection from undesired alteration of user info
    protected void setUsername(String newUsername){
        username = newUsername;
    }
    
    protected void setPassword(String newPass){
        password = newPass;
    }
    
    protected void setID(String id){
        customerID = id;
    }
    
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    
    //simple functions to perform add/sub from user balance
    //returns the end balance after calculation
    public double addToBalance(double value){
        return balance += value;
    }
    
    public double subFromBalance(double value){
        return balance -= value;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
}
