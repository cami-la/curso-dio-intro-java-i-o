package br.com.dio.java.io.IOBytes.IOData;

import java.io.*;
import java.util.Scanner;

/*
Crie um arquivo “peca-de-roupa.bin” e armazene:
1. Nome do produto, tamanho (P/M/G/U),quantidade e preço.
2. Leia este arquivo e imprima no console.
*/
public class ExemploIOData {
    public static void incluirProduto() throws IOException {

        File f = new File("/home/cami/Documents/peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        /*OutputStream os = new FileOutputStream(f.getPath());
        DataOutputStream dos = new DataOutputStream(os);*/
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        Scanner scan = new Scanner(System.in);

        ps.print("Nome da peça: ");
        String nome = scan.nextLine();
        dos.writeUTF(nome);

        ps.print("Tamanho da peça (P/M/G/U): ");
        char tamanho = (char) System.in.read();
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Preço unitário: ");
        double preco = scan.nextDouble();
        dos.writeDouble(preco);

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                f.getName(), f.length(), f.getAbsolutePath());

        lerProduto(f.getPath());

        dos.close();
        scan.close();
        ps.close();

    }

    public static void lerProduto(String caminhoArquivo) throws IOException {

        File f = new File(caminhoArquivo);

        /*InputStream is = new FileInputStream(f.getPath());
        DataInputStream dis = new DataInputStream(is);*/
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        double preco = dis.readDouble();

        System.out.printf("\nNome..................: %s\n", nome);
        System.out.printf("Quantidade............: %d\n", quantidade);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Preço.................: %f\n", preco);
        System.out.print("Total valor das peças: " + (quantidade * preco));

        dis.close();

    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}
