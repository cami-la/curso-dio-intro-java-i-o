package br.com.dio.java.io.IOCharacter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Abra o teclado para escrever 3 filmes/séries que você recomendaria e armazene em “recomendacoes.txt”.
public class Exercicio2IOCaracterComentado {
    public static void abrirTecladoEscreverDocumento() throws IOException {
        Scanner scanner = new Scanner(System.in); //abertura do teclado

        PrintWriter pw = new PrintWriter(System.out); //impressão no console
        pw.write("Digite 3 recomendações de filmes e séries: "); //mensagem que será exibida no console
        pw.println(); //criando uma nova linha
        pw.flush(); //descarregue a conteúdo do método write no console
        String linha = scanner.nextLine(); //captura da linha do teclado

        /*Writer w = new FileWriter("recomendacoes.txt"); //criando o documento recomendacoes.txt
        BufferedWriter bw = new BufferedWriter(w);*/
        //criando um buffer interno para armazenar os characters em vez de gravar diretamente no disco.
        //assim que buffer preenchido ou o gravador fechado, todos os characters do buffer são gravados no disco.
        BufferedWriter bw = new BufferedWriter(new FileWriter("recomendacoes.txt")); //padrão decorator

        do { //faça
            bw.write(linha); //escreva no buffer interno a linha capturada pelo scanner
            bw.newLine(); //pule para próxima linha no buffer
            linha = scanner.nextLine(); //pegue a proxima linha do teclado
        } while(!linha.isEmpty()); //repita as operações do laço do-while. Quando a linha estiver vazia, pare.
        bw.flush(); //terminado o laço, descarrege as informações capturadas no teclado no arquivo recomendacoes.txt

        pw.write("Arquivo criado com sucesso!"); //após terminar o laço acima, mostre esta frase no console

        //fechando os fluxos
        scanner.close(); //fechamos o fluxo de entrada através do teclado
        bw.close(); //fechamos o fluxo de saída para escrita no documento
        pw.close(); //fechamos o fluxo de saída para o console
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoEscreverDocumento();
    }
}
