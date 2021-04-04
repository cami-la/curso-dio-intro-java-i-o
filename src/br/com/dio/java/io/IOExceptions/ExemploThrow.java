package br.com.dio.java.io.IOExceptions;

import java.io.*;

public class ExemploThrow {
    public static void recebeStream(String nomeArquivo) throws NaoAbreStreamException { //trataremos no chamador
        FileReader fr = null; //FileReader pede um try-catch ou throws. Usamos try-catch
        try {
            fr = new FileReader(nomeArquivo); //tente abrir o stream
            System.out.println("Stream recebido com sucesso! " + nomeArquivo);
            //rotina aqui no meio...
            fr.close(); //fechamos o stream.
        } catch (FileNotFoundException e) { //caso o arquivo não seja encontrado
            throw new NaoAbreStreamException(nomeArquivo); //será exibida a exception que nós criamos
        } catch (IOException e) { //caso a stream seja aberta, porém impedida de ser fechada.
            System.out.println("O arquivo não pode ser fechado, motivo: " + e.getCause());
        }
    }

    public static void main(String[] args) { //chamador do método recebeStream. Note que o método utiliza throws
        File f = new File("dica-para-ler-e-escrever-arquivo-java-IO.txt"); //arquivo existe
        File f1 = new File("test.txt"); //arquivo não existe

        try { //trataremos a exception customizada que foi lançada no próprio método recebeStream
            recebeStream(f.getName()); //exige um try-catch ou throws. Faremos um try-catch
            recebeStream(f1.getName()); //exige um try-catch ou throws. Faremos um try-catch
        } catch (NaoAbreStreamException e) { //utilizando nossa exception customizada
            System.out.println(e); //exibe mensagem que passamos no toString da nossa exception NaoAbreStreamException
            //e.printStackTrace();
        } finally { //(opcional)
            System.out.println("A execução do finally independe se apresentou exception ou não!");
        }
        System.out.println("** Programa continua normalmente! **"); //apesar de ter apresentado uma exception.
        //caso tivesse outro try por aqui ou qualquer outra rotina, seria executado!
    }
}

class NaoAbreStreamException extends IOException { //exeption customizada
    private String nomeDoArquivo; //criamos um atributo para conter o nome do arquivo

    public NaoAbreStreamException(String nomeDoArquivo) { //criamos um contrutor para iniciar o atributo
        this.nomeDoArquivo = nomeDoArquivo;
    }

    private String diretorioArquivo() {//método para exibir o diretório do arquivo que estamos tentando abrir
        File file = new File(this.nomeDoArquivo); //criamos um objeto File para utilizamos o método getAbsolutePath()
        return file.getAbsolutePath();  //método que retorna o caminho completo do arquivo
    }

    @Override
    public String toString() { //sobrescrevemnos o toString
        return "Arquivo '" + this.nomeDoArquivo + "' não encontrado. Verique o diretório: " + this.diretorioArquivo();
    }
}
