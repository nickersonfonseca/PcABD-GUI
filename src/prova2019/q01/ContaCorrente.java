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
public class ContaCorrente extends Conta {
    
    @Override
    public void atualizar(double tx){
        super.setSaldo( super.getSaldo() +  (super.getSaldo() * 2 * tx));
    }
    
    @Override
    public void depositar(double valor){
        super.setSaldo( super.getSaldo() + valor - 0.1);
    }
    
}
