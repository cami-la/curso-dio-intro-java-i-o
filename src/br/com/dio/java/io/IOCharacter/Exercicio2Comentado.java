package br.com.dio.java.io.IOCharacter;

import java.io.*;

public class Exercicio2Comentado {
    public static void abrirTecladoEscreverDocumento() throws IOException {
       /*InputStream is = System.in; //abrindo um fluxo de dados para receber entrada através do teclado
       Reader isr = new InputStreamReader(is); //Ponte que transforma o fluxo do InputStream em character
       //lê o stream de character e armazena em um buffer para facilitar a leitura desses characteres
       BufferedReader br = new BufferedReader(isr);*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //decorator

       /*Writer w = new FileWriter("rotina.txt"); //criando o documento na pasta raiz. Também pode ser o caminho.
       //grava o stream de character (texto) e armazena em um buffer para facilitar a escrita desses characteres
       BufferedWriter bw = new BufferedWriter(w); */

        BufferedWriter bw = new BufferedWriter(new FileWriter("rotina.txt")); //decorator

        PrintWriter pw = new PrintWriter(System.out, true); //imprimindo no console (System.out)
        pw.println("Digite sua rotina ao acordar e para finalizar digite 'fim': ");

        String linha = br.readLine(); //método readLine() lê cada linha do texto e retorna uma String.
        do { //escreve a linha no arquivo 'rotina-copy.txt' (no momento, armazenado no buffer)
            bw.write(linha); //pegue a linha lida através do teclado e armazene em um buffer
            bw.newLine();  //pula uma linha no arquivo 'rotina.txt'
            bw.flush(); //descarrega linha no arquivo
            linha = br.readLine(); //pegue outra linha e refaça a escrita
        } while (!linha.equalsIgnoreCase("fim"));  //enquanto não digitar a palavra "fim".

        pw.println("Documento escrito com sucesso!"); //imprindo mensagem no console

        br.close(); //fechamos o fluxo de entrada através do teclado
        bw.close(); //fechamos o fluxo de saída para escrita no documento
        pw.close(); //fechamos o fluxo de saída para o console
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoEscreverDocumento();
    }
}
