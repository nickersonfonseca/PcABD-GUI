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
public class ContaCorrenteQ2 extends Tributavel {

    @Override
    public double calculaTributos() {
        return getSaldo() * 0.01;
    }
    
}
