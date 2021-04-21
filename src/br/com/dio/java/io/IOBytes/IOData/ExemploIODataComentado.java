package br.com.dio.java.io.IOBytes.IOData;

import java.io.*;
import java.util.Scanner;

/*
Crie um arquivo “roupa.bin” e armazene:
1. Nome do produto, tamanho (P/M/G/U),quantidade e preço.
2. Leia este arquivo e imprima no console.
*/
public class ExemploIODataComentado {
    public static void incluirProduto() throws IOException, EOFException {
        File f = new File("/home/cami/Documents/roupas.bin"); //utilizada para apontar arquivos ou diretórios.
        PrintStream ps = new PrintStream(System.out, true); //Criando um fluxo de saída para o console

        /*OutputStream os = new FileOutputStream(f.getName()); //criando um fluxo de armazenamento em um arquivo
        DataOutputStream dos = new DataOutputStream(os); //iniciando um objeto DataOutputStream*/
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath())); //decorator

        Scanner scan = new Scanner(System.in); //abrindo teclado

        ps.print("Nome do produto: "); //Pedindo o nome do produto
        String nome = scan.next(); //armazenando o input na variável
        dos.writeUTF(nome); //escrevendo no documento

        ps.print("Quantidade: "); //Pedindo a quantidade do produto
        int quantidade = scan.nextInt();  //armazenando o input na variável
        dos.writeInt(quantidade); //escrevendo no documento

        ps.print("Tamanho: "); //Pedindo o tamanho do produto
        char tamanho = (char) System.in.read(); //armazenando o input na variável
        dos.writeChar(tamanho); //escrevendo no documento

        ps.print("Preço: "); //Pedindo o preço do produto
        double preco = scan.nextDouble(); //armazenando o input na variável
        dos.writeDouble(preco); //escrevendo no documento

        /*ps.print("Nome do produto: ");
        nome = dis.readUTF();
        dos.writeUTF(nome);

        ps.print("Quantidade: ");
        quantidade = dis.readInt();
        dos.writeInt(quantidade);

        ps.print("Tamanho: ");
        tamanho = dis.readChar();
        dos.writeChar(tamanho);

        ps.print("Preço: ");
        preco = dis.readDouble();
        dos.writeDouble(preco);*/

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                f.getName(), f.length(), f.getAbsolutePath()); //imprimindo frase formatada

        lerArquivoBin(f.getPath()); //lendo o arquivo e exibindo no console

        scan.close(); //fechando o fluxo de entrada pelo teclado
        dos.close(); //fechando o fluxo de escrita de dados primitivos no documento

        ps.close(); //fechando o fluxo de escrita no console
    }

    public static void lerArquivoBin(String arquivo) throws IOException {

        File f = new File(arquivo); //utilizada para apontar arquivos ou diretórios.
        PrintStream ps = new PrintStream(System.out); //Criando um fluxo de saída para o console

        /*InputStream is = new FileInputStream(f.getPath()); //abrindo um fluxo de leitura de um arquivo
        DataInputStream dis = new DataInputStream(is); //iniciando um objeto DataInputStream*/
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath())); //decorator

        //criando as variáveis
        String nome;
        int quantidade;
        char tamanho;
        double preco;

        //Um problema a ter em mente ao ler tipos de dados primitivos é que não há como distinguir um valor
        // int válido de -1 do marcador de fim de fluxo normal. Isso basicamente significa que você não pode ver
        // a partir do valor primitivo retornado se você atingiu o fim do fluxo.
        nome = dis.readUTF(); //lendo a primeira linha do arquivo que contém uma String
        quantidade = dis.readInt(); //lendo a segunda linha do arquivo que contém um número inteiro
        tamanho = dis.readChar(); //lendo a terceira linha do arquivo que contém um char
        preco = dis.readDouble(); //lendo a quarta linha do arquivo que contém um valor double
        System.out.printf("\nNome..................: %s\n", nome);
        System.out.printf("Quantidade............: %d\n", quantidade);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Preço.................: %f\n", preco);

        /*//É necessário repetir as intruções acima pois você precisa saber com antecedência quais tipos
        // de dados ler e em que sequência.
        nome = dis.readUTF();
        quantidade = dis.readInt();
        tamanho = dis.readChar();
        preco = dis.readDouble();
        System.out.printf("Nome..................: %s\n", nome);
        System.out.printf("Quantidade............: %d\n", quantidade);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Preço.................: %f\n", preco);*/

    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}
