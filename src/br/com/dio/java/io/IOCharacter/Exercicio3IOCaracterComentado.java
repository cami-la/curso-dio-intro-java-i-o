package br.com.dio.java.io.IOCharacter;

import java.io.*;

//Faça uma cópia do arquivo “recomendacoes.txt” e agora adicione 3 recomendações de livros.
public class Exercicio3IOCaracterComentado {
    public static void copiarArquivo(String arquivo) throws IOException {
        File f = new File(arquivo); //criando uma referência para o arquivo que será copiado
        String nomeDoArquivoOriginal = f.getName(); //nome do arquivo original

        BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivoOriginal)); //abrir arquivo que será copiado

        //formatando o nome do arquivo de copia
        /*1. pegando tirando a estensão .txt do nome do arquivo original
          2. acrescentando -copy.txt ao nome do arquivo que será armazenado a copia*/
        String nomeDoArquivoCopy = nomeDoArquivoOriginal.substring(0, nomeDoArquivoOriginal.indexOf("."))
                .concat("-copy.txt");

        File fcopy = new File(nomeDoArquivoCopy);  //criando uma referência para o copia arquivo
        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName())); //criando o arquivo copia

        String linha = br.readLine(); //lendo as linhas do arquivo que será copiado
        do { //faça
            bw.write(linha); //pegue a linha lida no arquivo original "recomendacoes.txt" e armazene no buffer
            bw.newLine(); //depois insira uma linha
            linha = br.readLine(); //depois de realizado a cópia da linha acima, preenchemos a linha novamente
        } while(!(linha == null)); //enquanto a linha for diferente de null, continue copiando.
        bw.flush(); //terminado o laço, descarrege as informações capturadas no teclado no arquivo recomendacoes.txt

        PrintWriter pw = new PrintWriter(System.out); //impressão no console
        pw.printf("Arquivo '%s' criado com sucesso| \n diretório: '%s'\n", fcopy.getName(),
                fcopy.getAbsolutePath()); //mensagem formatada que será exibida no console
        pw.println("Agora, faça recomendações de 3 livros: ");
        pw.flush(); //descarregue a conteúdo do método write no console

        adicionarInformacoesArquivoJaExistente(nomeDoArquivoCopy); //executando o método

        pw.printf("Ok! Tudo certo. Tamanho do arquivo %d bytes.", fcopy.length()); //mensagem formatada no console
        pw.flush(); //descarregue a conteúdo do método write no console

        //fechando todos os fluxos
        br.close(); //fechamos o fluxo de entrada
        bw.close(); //fechamos o fluxo de saída para escrita no documento
        pw.close(); //fechamos o fluxo de saída para o console

    }

    public static void adicionarInformacoesArquivoJaExistente(String arquivoCopy) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //padrão decorator para ler (input) do teclado.

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCopy, true));
        //padrão decorator para escrever (output) no arquivo sem apagar o conteúdo que já existia.

        String line = br.readLine();
        do { //faça
            bw.write(line); //escreva no buffer interno a linha capturada pelo scanner
            bw.newLine(); //pule para próxima linha no buffer
            line = br.readLine(); //pegue a proxima linha do teclado
        } while(!line.equalsIgnoreCase("fim"));
        //repita as operações do laço do-while. Quando digitar a palavra 'fim', pare.
        bw.flush(); //terminado o laço, descarrege as informações capturadas pelo teclado no arquivo recomendacoes.txt
        //(neste caso não precisaria do método flush já que em seguida fechamos o fluxo: bw.close())

        //fechando todos os fluxos
        br.close(); //fechamos o fluxo de entrada
        bw.close(); //fechamos o fluxo de saída para escrita no documento
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo("recomendacoes.txt");
    }
}
