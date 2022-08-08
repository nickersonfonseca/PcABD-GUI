/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2019.q01;

/**
 *
 * @author ferreira
 */
public class TesteConta {
    public static void main(String[] args) {
        
        Conta c = new Conta();
        c.setSaldo(1000);
        c.atualizar(0.01);
        System.out.println("Saldo em C: " + c.getSaldo());
        c.depositar(100);
        System.out.println("Saldo em C: " + c.getSaldo());
        
        // ********************************************
        
        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo(1000);
        cc.atualizar(0.01);
        System.out.println("Saldo em CC: " + cc.getSaldo());
        cc.depositar(100);
        System.out.println("Saldo em CC: " + cc.getSaldo());
        
        // ********************************************
        
        ContaPoupanca cp = new ContaPoupanca();
        cp.setSaldo(1000);
        cp.atualizar(0.01);
        System.out.println("Saldo em CP: " + cp.getSaldo());
        cp.depositar(100);
        System.out.println("Saldo em CP: " + cp.getSaldo());
        
    }
}
