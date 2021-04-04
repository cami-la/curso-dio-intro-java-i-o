package br.com.dio.java.io.IOExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExemploTryCatchFinally {
    public static void main(String[] args) {
        File f = new File("dica-para-ler-e-escrever-arquivo-java-IO.txt"); //arquivo existe
        File f1 = new File("test.txt"); //arquivo não existe
        FileReader fr = null; //abre uma stream de caracter
        try { //tente receber o stream f e f1
            fr = new FileReader(f.getName()); //recebe o stream. Sendo positivo, o try segue sendo executado.
            System.out.println("Stream recebido com sucesso! " + f.getName());
            //rotina aqui no meio...
            fr.close(); //fechamos a stream.

            fr = new FileReader(f1.getName()); //esse arquivo não existe, logo o try é interrompido e vai para o catch.
            System.out.println("Stream recebido com sucesso! " + f.getName());
            //rotina aqui no meio...
            fr.close(); //fechamos a stream
        } catch (FileNotFoundException e) { //se o arquivo não existe
            System.out.println("Arquivo não encontrado, motivo: " + e.getCause()); //mostra a causa
            System.out.println("Por gentileza, confira se o arquivo existe " + e.getMessage()); //mostra o nome
            //e.printStackTrace();
        } catch (IOException | NullPointerException e) { //caso o stream estivesse aberto, mas impedido de ser fechado
            System.out.println("Arquivo não pode ser fechado!" + e.getCause()); //mostra a causa
        } finally { //(opcional)
            System.out.println("A execução do finally independe se apresentou exception ou não!");
        }
        System.out.println("** Programa continua normalmente! **"); //apesar de ter apresentado uma exception.
        //caso tivesse outro try por aqui ou qualquer outra rotina, seria executado!
    }
}
