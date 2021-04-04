package br.com.dio.java.io.IOExceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExemploThrows {
    public static void recebeStream(String nomeArquivo) throws IOException { //método não trata exceptions, ele lança.
        FileReader fr = new FileReader(nomeArquivo); //FileReader pede um try-catch ou throws. Usamos throws
        System.out.println("Stream recebido com sucesso! " + nomeArquivo);
        //rotina aqui no meio...
        fr.close(); //fechamos o stream.
    }

    public static void main(String[] args) { //chamador do método recebeStream. Note que o método utiliza throws
        File f = new File("dica-para-ler-e-escrever-arquivo-java-IO.txt"); //arquivo existe
        File f1 = new File("test.txt"); //arquivo não existe

        try { //trataremos as exceptions que não foram tratadas no próprio método recebeStream
            recebeStream(f1.getName()); //exige um try-catch ou throws. Faremos um try-catch
            recebeStream(f.getName()); //exige um try-catch ou throws. Faremos um try-catch
        } catch (IOException e) { //se acontece algum erro correspondente com IOException
            System.out.println("Arquivo não encontrado, motivo: " + e.getCause()); //mostra a causa
            System.out.println("Por gentileza, confira se o arquivo existe " + e.getMessage()); //mostra o nome
            //e.printStackTrace();
        } finally { //(opcional)
            System.out.println("A execução do finally independe se apresentou exception ou não!");
        }

        System.out.println("** Programa continua normalmente! **"); //apesar de ter apresentado uma exception.
        /*Neste caso o try foi interrompido porque na primeira execução do método recebeStream já apresenta
         uma exception. O arquivo que existe (dica-para-ler-e-escrever-arquivo-java-IO.txt) não foi lido pois está
         dentro do try que apresentou a exception, porém a rotina fora do try continua.*/
    }
}
