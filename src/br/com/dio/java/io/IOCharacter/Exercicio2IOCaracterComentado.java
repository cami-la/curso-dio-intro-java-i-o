package br.com.dio.java.io.IOCharacter;

import java.io.*;
import java.util.Scanner;

//Abra o teclado para escrever 3 filmes/séries que você recomendaria e armazene em “recomendacoes.txt”.
public class Exercicio2IOCaracterComentado {
    public static void abrirTecladoEscreverDocumento() throws IOException {
        PrintWriter pw = new PrintWriter(System.out); //impressão no console
        pw.write("Recomende 3 filmes e para finalizar digite 'fim': "); //mensagem que será exibida no console
        pw.println(); //criando uma nova linha
        pw.flush(); //descarregue a conteúdo do método write no console

        Scanner scanner = new Scanner(System.in); //abertura do teclado
        String line = scanner.nextLine(); //captura da linha do teclado

        File f = new File("recomendacoes.txt"); //classe utilizada para especificar arquivos ou diretórios.

        /*Writer w = new FileWriter(f.getName()); //criando o documento recomendacoes.txt
        BufferedWriter bw = new BufferedWriter(w);*/
        //criando um buffer interno para armazenar os characters em vez de gravar diretamente no disco.
        //assim que buffer preenchido ou o gravador fechado, todos os characters do buffer são gravados no disco.
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName())); //padrão decorator

        do { //faça
            bw.write(line); //escreva no buffer interno a linha capturada pelo scanner
            bw.newLine(); //pule para próxima linha no buffer
            line = scanner.nextLine(); //pegue a proxima linha do teclado
        } while(!line.equalsIgnoreCase("fim"));
        //repita as operações do laço do-while. Quando digitar a palavra 'fim', pare.
        bw.flush(); //terminado o laço, descarrege as informações capturadas pelo teclado no arquivo recomendacoes.txt

        pw.printf("Tudo certo! Arquivo '%s' foi criado com tamanho '%d' bytes.", f.getName(), f.length());
        //utilizando o método printf da classe PrintWrite para formatar a mensagem que será exibida no console.
        pw.flush(); //descarregue a conteúdo do método write no console
        //(neste caso não precisaria do método flush já que em seguida fechamos o fluxo: pw.close())

        //fechando os fluxos
        scanner.close(); //fechamos o fluxo de entrada através do teclado
        bw.close(); //fechamos o fluxo de saída para escrita no documento
        pw.close(); //fechamos o fluxo de saída para o console
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoEscreverDocumento();
    }
}
