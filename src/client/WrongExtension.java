/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author tomek
 */
public class WrongExtension extends Exception {
    
    public WrongExtension(){}
    
    public WrongExtension(String message){
        super(message);
    }
 }