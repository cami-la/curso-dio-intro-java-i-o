package br.com.dio.java.io.IOBytes.IOObject;

import java.io.*;

//Crie a classe Gato com os atributos nome, idade e cor:
//Instancie um objeto e serialize
//Desserialize este objeto e mostre no console
public class ExemploIOObjectComentado {
    public static void serealizarObjeto() {
        File f = new File("gato"); //representação do documento
        //objeto que será serealizado
        GatoComentado gatoComentado = new GatoComentado("Jon", "tigrado", 19, true);

        ObjectOutputStream oos = null; //inicializando o ObjectOutputStream

        try { //tente
            OutputStream os = new FileOutputStream(f.getAbsolutePath()); //criar arquivo
            oos = new ObjectOutputStream(os); //iniciar o fluxo da serealização
            oos.writeObject(gatoComentado); //metódo que escreve no objeto
        } catch (FileNotFoundException e) { //captura exigida pelo FileOutputStream
            //Caso apresente uma exception FileNotFoundException, imprima a frase abaixo no console:
            System.out.printf("Arquivo %s não encontrado! Verifique o diretório %s", f.getName(), e.getMessage());
            //e.printStackTrace();
        } catch (IOException e) { //captura exigida pelo método writeObject(object);
            //Caso apresente uma exception IOException, imprima a frase abaixo no console:
            System.out.printf("Não foi possível criar o arquivo \"%s\".", f.getName());
            e.printStackTrace();
        } finally { //esse bloco sempre será executando, independente se teve exception ou não.
            try { //tente
                oos.close(); //fechar o arquivo
            } catch (IOException e) { //captura exigida ppelo método close()
                System.out.printf("Erro ao fechar o arquivo \"%s\".",f.getName());
                //e.printStackTrace();
            }
        }
    }

    public static void desserializarObjeto(String arquivo) {
        File f = new File(arquivo); //representação do documento

        ObjectInputStream ois = null; //inicializando o ObjectOutputStream
        try { //tente
            InputStream is = new FileInputStream(f.getName()); //abrir o arquivo
            ois = new ObjectInputStream(is); //iniciar o fluxo de leitura de objeto serealizado
            GatoComentado gatoComentado = (GatoComentado) ois.readObject(); //método que lê o objeto serealizado

            //imprima no console:
            System.out.printf("\nNome..................: %s\n", gatoComentado.getNome());
            System.out.printf("Idade............: %d\n", gatoComentado.getIdade());
            System.out.printf("Cor...............: %s\n", gatoComentado.getCor());
            System.out.printf("Castrado...............: %s\n", gatoComentado.isCastrado());
            System.out.printf("Ronrona...............: %s\n", gatoComentado.isRonrona());

        } catch (FileNotFoundException e) { //captura exigida pelo FileInputStream
            System.out.printf("Arquivo %s não encontrado! Verifique o diretório %s", f.getName(), e.getMessage());
            //e.printStackTrace();
        } catch (ClassNotFoundException e) { //captura exigida pelo método readObject()
            System.out.printf("Não foi possível ler o objeto do arquivo \"%s\".", f.getName());
            //e.printStackTrace();
        } catch (IOException e) { //captura exigida pelo ObjectInputStream
            System.out.printf("Não foi possível abrir o arquivo \"%s\".", f.getName());
            //e.printStackTrace();
        } finally { //esse bloco sempre será executando, independente se teve exception ou não.
            try { //tente
                ois.close(); //fechar o arquivo
            } catch (IOException e) { //captura exigida pelo método close()
                System.out.printf("Erro ao fechar o arquivo \"%s\".",f.getName());
                //e.printStackTrace();
            }
        }
    }

        public static void main (String[]args){
            serealizarObjeto();
            //desserializarObjeto("/home/cami/git/curso-dio-intro-java-io/gato");
        }
}
