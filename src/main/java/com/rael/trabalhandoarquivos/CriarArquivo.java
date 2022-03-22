
package com.rael.trabalhandoarquivos;

import java.io.File;
import java.io.IOException;

public class CriarArquivo {
    public static void main(String[] args) {
        
        
        File arquivo = new File ("texto.txt");
    
        
        //verificar se existe
        if (! arquivo.exists()){
            System.out.println("até aqui não foi criado ");
        }
        
        
        //criar arquivo
        try{
            if( arquivo.createNewFile() ){
                System.out.println("O arquivo foi criado");
            }else{
                System.out.println("O arquivo não foi criado, talvez ele já exista");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //criar pasta 
        File diretorio = new File("pasta");
        
        if (diretorio.mkdir()){
            System.out.println("diretório criado com sucesso");
        }else{
                System.out.println("não foi possível criar o diretorio");
        }

        File sub = new File("pasta2"+File.separator+"subpasta");
        sub.mkdirs();
        
        
        //criar arquivo dentro de pasta
        File dir = new File( "dir");
  
        if( dir.mkdir() ){
            System.out.println("Diretório criado");
        }else{
            System.out.println("Diretório não criado");
        }
        try{
            File file = new File(dir, "file.txt");
            if( file.createNewFile() ){
                System.out.println("Arquivo criado");
            }else{
                System.out.println("Arquivo não criado");
            }       
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        
        //listar
        if( dir.isDirectory() ){
            String[] arqs = dir.list();
            for(String nome : arqs){
                System.out.println(nome);
            }
        }
        
        //apagar arquivo
        if( arquivo.delete() ){
            System.out.println("O arquivo foi deletado");
        }else{
            System.out.println("O arquivo não foi deletado");
        }
        
        //renomear
        
        File novoNome = new File("pasta_renomeada");
        diretorio.renameTo( novoNome );
        
        //caminho absoluto
        System.out.println( arquivo.getAbsoluteFile() );
        
    } 
}
    
