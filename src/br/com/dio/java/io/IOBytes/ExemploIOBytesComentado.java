package br.com.dio.java.io.IOBytes;

import java.io.*;

//Faça uma cópia do arquivo “recomendacoes-copy.txt”.
public class ExemploIOBytesComentado {

    public static void copiarArquivo(String arquivo) throws IOException {
        File f = new File(arquivo); //classe utilizada para especificar arquivos ou diretórios
        String nomeArquivo = f.getName(); //método para recuperar o nome do arquivo ou diretório

        //abrindo arquivo que será copiado
       /* InputStream is = new FileInputStream(nomeArquivo); //Fluxo de entrada que lê de um arquivo
        BufferedInputStream bis = new BufferedInputStream(is); // Fluxo de entrada que armazena em um buffer*/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo)); //padrão decorator

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf(".txt"))
                .concat("-coy2.txt"); //preparando o nome do novo arquivo cópia.
        File fcopy = new File(nomeArquivoCopy); //classe utilizada para especificar arquivos ou diretórios

        /*OutputStream os = new FileOutputStream(fcopy.getName()); //Fluxo de saída que grava em um arquivo
        BufferedOutputStream bos = new BufferedOutputStream(os); //Fluxo de saída armazenada em um buffer*/
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fcopy)); //padrão decorator

        int line = 0;
        while ((line = bis.read()) != -1) {
            bos.write((char) line);
            bos.flush();
        }

        bis.close();
        bos.close();

        System.out.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ",
                fcopy.getName(), fcopy.getPath(), fcopy.length());
    }


    public static void main(String[] args) throws IOException {
        copiarArquivo("recomendacoes-copy.txt");
    }
}
