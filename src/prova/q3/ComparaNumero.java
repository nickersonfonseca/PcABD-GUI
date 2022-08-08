/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.q3;

/**
 *
 * @author ferreira
 */
public class ComparaNumero {
    
    public static void main(String[] args) {
        
        ComparaNumero comp = new ComparaNumero();
        
        comp.comparar(100, 10);
        
    }
    
    public void comparar(int n1, int n2){
        
        if (n1 == n2){
            System.out.println("SÃO IGUAIS...");
        } else {
            System.out.println("SÃO DIFERENTES...");
            if (n1 > n2){
                System.out.println("Maior: " + n1);
                System.out.println("Menor: " + n2);
                
            } else {
                System.out.println("Maior: " + n2);
                System.out.println("Menor: " + n1);
            }
            
        }
        
        
    }
    
}
