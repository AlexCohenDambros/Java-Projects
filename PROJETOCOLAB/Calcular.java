package PROJETOCOLAB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Calcular {
    public static ArrayList<String> nomes;

    public static ArrayList<String> getNumeroemails(File file) throws IOException {
        BufferedReader br2 = new BufferedReader(new FileReader(file)); // abrimos o arquivo
        String linha;

        nomes = new ArrayList<>(); // criamos um arraylist com os nomes

        while ((linha = br2.readLine()) != null) { // temos o while que percorre todas as linhas do nosso arquivo, ai quando chegar no final
            String[] splitlinha = linha.split(" "); // separa com espaÃ§os
            String remetente = splitlinha[0]; // defini o remetente como o index 0
            String destinatario = splitlinha[1]; // e defini o destinatario como index 1

            if(!nomes.contains(remetente)){ // verifica se o nome do remetente achado contem na lista
                nomes.add(remetente); //se nao tiver ele adiciona
            }

            if(!nomes.contains(destinatario)){ // verifica se o nome do destinatario contem na lista
                nomes.add(destinatario); //se nao tiver ele adiciona
            }
        }
        br2.close(); // fechamos o arquivo
        return nomes; // retornamos os nomes
    }
}