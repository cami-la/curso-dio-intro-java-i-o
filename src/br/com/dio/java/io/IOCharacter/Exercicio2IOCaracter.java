package br.com.dio.java.io.IOCharacter;

import java.io.*;
import java.util.Scanner;

//Abra o teclado para escrever 3 filmes que você recomendaria e armazene em “recomendacoes.txt”.
public class Exercicio2IOCaracter {
    public static void lerTecladoImprimirDocumento() throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 filmes e para finalizar digite 'fim': ");
        pw.flush();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        File f = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do{
            bw.write(line);
            bw.newLine();
            line = scanner.nextLine();
        }while(!line.equalsIgnoreCase("fim"));
        bw.flush();

        pw.printf("Tudo certo! Arquivo '%s' foi criado com tamanho '%d' bytes.", f.getName(), f.length());
        pw.flush();

        pw.close();
        scanner.close();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        lerTecladoImprimirDocumento();
    }
}
