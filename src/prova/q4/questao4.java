/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.q4;

/**
 *
 * @author ferreira
 */
public class questao4 {
    
    
    public static void main(String[] args) {
        
        questao4 q = new questao4();
        
        q.substituir(100, 10);
        
    }
    
    public void substituir(int numA, int numB){
        
        int aux = 0;
        
        aux = numB;
        
        numB = numA;
        
        numA = aux;
        
        System.out.println("numA: " + numA + " numB: " + numB);
        
        
    }
    
}
