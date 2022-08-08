/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2019.q2;

/**
 *
 * @author ferreira
 */
public class TesteTributavel {
    public static void main(String[] args) {
        
        Tributavel[] t = new Tributavel[5];
        
        ContaCorrenteQ2 c = new ContaCorrenteQ2();
        c.setSaldo(1000);
        
        t[0] = c;
        t[1] = new SeguroDeVida();
        t[2] = new SeguroDeVida();
        t[3] = new ContaCorrenteQ2();
        t[4] = c;
        
        double total = 0;
        
        for (int i = 0; i < t.length; i++) {
            Tributavel obj = t[i];
            
            total = total + obj.calculaTributos();
        }
        
        System.out.println("Total de tributos: " + total);
        
    }
}
