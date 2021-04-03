package br.com.dio.java.io.IOException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExemploThrowsParaUtilizarNoCurso {
    //throws: aviso para o compilador que sabemos da possibilidade de ocorrer um erro, mas não queremos tratar agora.
    public static void main(String[] args) throws IOException {
        FileReader fr = null; //abre um stream de caracter
        File f = new File("dica-para-ler-e-escrever-arquivo-java-IO.txt"); //arquivo existe
        File f1 = new File("test.txt"); //arquivo não existe

        fr = new FileReader(f.getName()); //recebe o stream. Sendo positivo, o try segue sendo executado.
        System.out.println("Stream recebido com sucesso! " + f.getName());
        //rotina aqui no meio...
        fr.close(); //fechamos a stream.

        fr = new FileReader(f1.getName()); //esse arquivo não existe, logo o try é interrompido e vai para o catch.
        System.out.println("Stream recebido com sucesso! " + f.getName());
        //rotina aqui no meio...
        fr.close(); //fechamos a stream

        System.out.println("Apresentando qualquer erro antes dessa linha, a mesma nunca será lida.");
    }
}
