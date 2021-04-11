package br.com.dio.java.io.IOCharacter;

import java.io.*;

//Abra o teclado para escrever 3 filmes/séries que você recomendaria e exiba esses filmes/séries no console.
public class Exercicio1IOCaracter {
    public static void lerTecladoImprimirConsole() throws IOException {

        /*InputStream is = System.in;
        Reader isr = new InputStreamReader(is);
        BufferedReader bw = new BufferedReader(isr);*/

        System.out.println("Digite 3 sugestões de filmes ou séries: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        /*OutputStream os = System.out;
        Writer osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);*/

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while(!line.equalsIgnoreCase("fim"));
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        lerTecladoImprimirConsole();
    }
}
