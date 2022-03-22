
package com.rael.trabalhandoarquivos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GravandoDados {
    public static void main(String[] args) {
        
        File arquivo = new File("teste.txt");
        
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
        
        System.out.println("\n");
        
        //escrever
        try( FileWriter fw = new FileWriter(arquivo) ){
            fw.write('2');
            fw.write("25 \n");
            fw.flush();
        }catch(IOException ex){
          ex.printStackTrace();
        } 
        
        System.out.println("\n");
        
        //fluxo de caracter
        try( FileReader fr = new FileReader(arquivo) ){
            int  c =   fr.read();
            while( c != -1){
                System.out.print( (char) c );
                c =  fr.read();
            }
        }catch(IOException ex){
          ex.printStackTrace();
        }
        
        //array de char
        try(FileReader fr = new FileReader(arquivo)){
            char[]  c =  new char[4];
            fr.read(c);
            System.out.print( c );
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        System.out.println("\n");
        //fluxo baseados em bytes
        File arquivo1 = new File("teste.bin");
        try( OutputStream os = new FileOutputStream(arquivo) ){
            byte[] b = {50,51,52,53};
            String string = "Rodrigo Aramburu";
            os.write( 53 );
            os.write( b );
            os.write( string.getBytes() );
            os.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        try( InputStream is = new FileInputStream(arquivo) ){
            int content;
            while ( (content = is.read() ) != -1) {
              System.out.println( content +" - "+ ( (char) content) );
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        System.out.println("\n ");
        //buferizam
        
        try( FileOutputStream fo = new FileOutputStream( arquivo ) ){
            BufferedOutputStream bos = new BufferedOutputStream(fo);             
            bos.write( "teste".getBytes());
            bos.write("\n".getBytes() );//inserindo um caractere de nova linha
            bos.write( "teste2".getBytes());
            bos.flush();  

        }catch(IOException ex){
            ex.printStackTrace();
        }

        try( FileInputStream fi = new FileInputStream(arquivo)){
            BufferedInputStream bis = new BufferedInputStream(fi);

            int content;
            while( ( content = bis.read() ) != -1){
                System.out.println( content  + " - " + ( (char) content) );
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

        System.out.println("\n");
        
        //classes para stream baseados em caracterews
        File arquivo3 = new File("arquivo2.txt");
        try( FileWriter fw = new FileWriter( arquivo ) ){
            BufferedWriter bw = new BufferedWriter(fw);             
            bw.write( "teste" );
            bw.newLine();
            bw.write( "teste2");
            bw.flush();  
        }catch(IOException ex){
            ex.printStackTrace();
        }

        try( FileReader fr = new FileReader(arquivo)){
            BufferedReader br = new BufferedReader(fr);
            String content;
            while( ( content = br.readLine() ) != null){
              System.out.println( content );
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        System.out.println("\n");
        
        //subclasse de Writer
        
        File arquivo4 = new File("print.txt");
        try(PrintWriter pw = new PrintWriter(arquivo) ){
            pw.println(true);
            pw.println(10);
            pw.println(10.20);
            pw.println("teste");
            pw.printf("String: %s | Double: %.2f | Inteiro: %5d " , "teste", 10f , 200);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println("");
        //Scanner
        
        try( InputStream in = new FileInputStream(arquivo) ){
            Scanner scan = new Scanner(in);
            while( scan.hasNext() ){
                System.out.println( scan.nextLine() );
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

        
        
        
    }
}
