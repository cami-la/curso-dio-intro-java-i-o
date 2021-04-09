package br.com.dio.java.io.IOCharacter;

import java.io.*;

public class Exercicio1Comentado {
    public static void abrirTecladoExibirConsole() throws IOException { //throws declarado para não tratar agora.
        //abrindo teclado
        InputStream is = System.in; //abrindo um fluxo de dados para receber entrada através do teclado
        Reader isr = new InputStreamReader(is); //Ponte que transforma o fluxo do InputStream em character
        //lê o stream de character e armazena em um buffer para facilitar a leitura desses characteres
        BufferedReader br = new BufferedReader(isr);

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //decorator

        //exibindo no console
        OutputStream os = System.out; //abrindo um fluxo de dados para enviar dados para o console.
        OutputStreamWriter osr = new OutputStreamWriter(os); //ponte que transforma o fluxo OutputStream em character
        //grava o stream de character (texto) e armazena em um buffer para facilitar a escrita desses characteres
        BufferedWriter bw = new BufferedWriter(osr);

        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //padrão decorator

        System.out.println("Digite sua rotina ao acordar e para finalizar digite 'fim': ");

        //agora precisamos ler do teclado e enviar para o console
        String linha = br.readLine();//método readLine lê cada linha do texto e retorna uma String.

        do { //faça:
            bw.write(linha); //pegue a linha lida através do teclado e armazene em um buffer
            bw.newLine(); //depois insira uma linha
            linha = br.readLine(); //depois de realizado a cópia da linha a cima, preenchemos a linha novamente
        } while(!linha.equalsIgnoreCase("fim")); //enquanto não digitar a palavra "fim".

        br.close(); //fechamos o fluxo de entrada
        bw.close(); //fechamos o fluxo de saída
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoExibirConsole();
    }
}
