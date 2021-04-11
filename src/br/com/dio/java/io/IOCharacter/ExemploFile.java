package br.com.dio.java.io.IOCharacter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExemploFile {
    public static void main(String[] args) {
        File f = new File("dica-para-ler-e-escrever-arquivo-java-IO.txt");
        System.out.println("Nome do arquivo: " + f.getName());
        System.out.println("Caminho: " + f.getPath());
        System.out.println("Caminho Absoluto: " + f.getAbsolutePath());
        System.out.println("Diretório pai: " + f.getParent());
        System.out.println(f.exists() ? "existe" : "não existe");
        System.out.println(f.canWrite() ? "pode ser gravado" : "não pode ser gravado");
        System.out.println(f.canRead() ? "pode ser lido" : "não pode ser lido");
        System.out.println(f.isDirectory() ? "é diretório" : "não é diretório");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date(f.lastModified());
        System.out.println("Ultima modificação do arquivo: " + df.format(data));
        System.out.println("Tamanho do arquivo: " + f.length() + " bytes.");
    }
}
