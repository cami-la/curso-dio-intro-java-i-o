package br.com.dio.java.io.IOCharacter;

import java.io.*;

//Abra o teclado para escrever 3 filmes que você recomendaria e exiba esses filmes no console.
public class Exercicio1IOCaracterComentado {
    public static void abrirTecladoExibirConsole() throws IOException { //throws declarado para não tratar agora.
        System.out.println("Digite 3 sugestões de filmes: ");

        //abrindo teclado
        InputStream is = System.in; //abrindo um fluxo de dados para receber entrada através do teclado
        Reader isr = new InputStreamReader(is); //Ponte que transforma o fluxo do InputStream em character
        //lê o stream de character e armazena em um buffer para facilitar a leitura desses characteres
        BufferedReader br = new BufferedReader(isr);

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //decorator

        //preparando a escrita no console
        OutputStream os = System.out; //abrindo um fluxo de dados para enviar dados para o console.
        OutputStreamWriter osr = new OutputStreamWriter(os); //ponte que transforma o fluxo OutputStream em character
        //grava o stream de character (texto) e armazena em um buffer para facilitar a escrita desses characteres
        BufferedWriter bw = new BufferedWriter(osr);

        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //padrão decorator

        //agora precisamos ler do teclado e enviar para o console
        String line = br.readLine();//método readLine lê cada linha do texto e retorna uma String.
        do { //faça:
            bw.write(line); //pegue a linha lida através do teclado e armazene em um buffer
            bw.newLine(); //depois insira uma linha
            line = br.readLine(); //depois de realizado a cópia da linha a cima, preenchemos a linha novamente
        } while(!line.isEmpty()); //quando a linha estiver vazia, pare.

        br.close(); //fechamos o fluxo de entrada
        bw.close(); //fechamos o fluxo de saída
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoExibirConsole();
    }
}
