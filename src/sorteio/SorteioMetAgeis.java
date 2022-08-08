/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorteio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author 2131795
 */
public class SorteioMetAgeis {
    
    
    
    
    public static void main(String[] args) {
        
        String[] listaGrupos = new String[]{"GRUPO 01","GRUPO 02","GRUPO 03","GRUPO 04",
        "GRUPO 05","GRUPO 06","GRUPO 07"};
    
        String[] listaMet = new String[]{"SCRUM","XP","FDD","RAD",
        "CRYSTAL","ASD","KANBAN"};
        
        HashSet<String> conjunto = new HashSet<>();
        
        Random rand = new Random();
        
        while (conjunto.size() < listaGrupos.length){
            int i = rand.nextInt(6);
            
            int i2 = rand.nextInt(6);
            System.out.println(i + "" + i2);
            String desc = listaGrupos[i] + listaMet[i2];
            
            if (!conjunto.contains(desc)){
                conjunto.add(desc);
            }
            
        }
        
    }
    
}
