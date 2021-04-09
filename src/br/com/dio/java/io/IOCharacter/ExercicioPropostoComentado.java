package br.com.dio.java.io.IOCharacter;

import java.io.*;

public class ExercicioPropostoComentado {
    public static void copiarArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arquivo)); //decorator: abrindo o arquivo que será copiado

        //organizando nome do novo arquivo para fazer uma copia.
        File file = new File(arquivo); //criando uma referência desse arquivo
        String nomeArquivo = file.getName().substring(0, file.getName().indexOf(".")); //pegando tudo antes do ".txt"
        String arquivoCopy = nomeArquivo.concat("-copy.txt"); //criando o nome do novo arquivo

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCopy)); //decorator, criando documumento

        PrintWriter pw = new PrintWriter(System.out); //imprimindo no console (System.out)
        pw.printf("Documento '%s' copiado com sucesso! \n", file.getName()); //impressão formatada
        pw.println("Digite em pouca palavras sua rotina antes de dormir, para finalizar, digite fim: ");
        pw.flush(); //descarregando no console

        String linha = br.readLine(); //método readLine() lê cada linha do texto e retorna uma String.
        do { //faça
            bw.write(linha); //escreve a linha no arquivo 'rotina-copy.txt' (no momento, armazenado no buffer)
            bw.newLine(); //pula uma linha no arquivo 'rotina-copy.txt'
            linha = br.readLine(); //pegue outra linha e refaça a escrita
        } while (!(linha == null || linha.isEmpty()));
        //repita o processo desde que a linha não esteja apontando para null ou não esteja vazia.
        bw.flush(); //terminada o laço do-while, descarregue tudo que estava no buffer dentro arquivo.

        adicionarInformacoesArquivoJaExistente(arquivoCopy); //chamando o método
        pw.printf("Documento '%s' criado com sucesso! ", arquivoCopy); //mensagem formatada no console

        bw.close(); //fechando o fluxo de escrita no arquivo "rotina-copy.txt"
        br.close(); //fechando o fluxo de entrada do arquivo "rotina.txt"
        pw.close(); //fechando o fluxo de saída para o console
    }

    public static void adicionarInformacoesArquivoJaExistente(String arquivoCopy) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //decorator, abrindo teclado
        String linha = br.readLine(); //método readLine() lê cada linha do texto e retorna uma String.

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCopy, true)); //decorator, criando docum.
//        utilizando o true para dizer que queremos adicionar texto no nosso documento, e não substituir o que existe.

        do {
            bw.write(linha); //escreve a linha no arquivo 'rotina-copy.txt' (no momento, armazenado no buffer)
            bw.newLine(); //pula uma linha no arquivo 'rotina-copy.txt'
            linha = br.readLine(); //pegue outra linha e refaça a escrita
        } while (!linha.equalsIgnoreCase("fim")); //enquanto não digitar a palavra "fim".
        bw.flush(); //terminada o laço do-while, descarregue tudo que estava no buffer dentro arquivo.

        br.close(); //fechando o fluxo de entrada do arquivo "rotina.txt"
        bw.close(); //fechando o fluxo de escrita no arquivo "rotina-copy.txt"
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo("rotina.txt");
    }

}
