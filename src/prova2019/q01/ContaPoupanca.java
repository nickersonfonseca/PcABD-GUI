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
public class ContaPoupanca extends Conta {
    
    @Override
    public void atualizar(double tx){
        super.setSaldo( super.getSaldo() +  (super.getSaldo() * 3 * tx));
    }
}
