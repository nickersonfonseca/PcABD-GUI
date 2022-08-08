/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author ferreira
 */
public class Sorteador {
    
    ArrayList<String> listaAlunos = new ArrayList<>();
    
    public static void main(String[] args) {
        Sorteador s = new Sorteador();
        s.sortearGrupos(2);
    }
    
    public void sortearGrupos(int numIntegrantes){
        
        lerArquivoAlunos();
        HashSet<Integer> indices = new HashSet<>();
        
        String grupo = "";
        int cont=0;
        
        while (indices.size() != listaAlunos.size()){
            Random ran = new Random();
            int x = ran.nextInt(listaAlunos.size());
            if (indices.contains(x)){
                continue;
            } else {
                indices.add(x);
                grupo += listaAlunos.get(x) + ", ";
                cont++;
            } // if - else
            
            if (cont == numIntegrantes){
                System.out.println(grupo);
                grupo = "";
                cont=0;
            }//if
            
        } // while
        
        if (grupo.length()>0){
            System.out.println(grupo);
        }
        
    } // sortearGrupos(int numIntegrantes)
    
    private void lerArquivoAlunos(){
        
        try {
        
            File f = new File("alunos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader buff = new BufferedReader(fr);
            String linha= "";
            while ((linha = buff.readLine()) != null ){
                listaAlunos.add(linha);
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
    } // lerArquivoAluno
    
} // classe Sorteador
