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
public class Conta {
    
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void sacar(double valor){
        saldo = saldo - valor;
    }
    
    public void depositar(double valor){
        saldo = saldo + valor;
    }
    
    public void atualizar(double tx){
        saldo = saldo + (saldo * tx);
    }
    
}
