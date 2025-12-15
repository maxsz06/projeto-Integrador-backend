package br.senai.sp.jandira.projetointegradorbackend.repository;



import br.senai.sp.jandira.projetointegradorbackend.model.Cliente;
import br.senai.sp.jandira.projetointegradorbackend.ui.RegistrarEntrada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class ClienteRepository {

    RegistrarEntrada registrarEntrada = new RegistrarEntrada();


    public void gravarCliente(Cliente cliente) {

    LocalDateTime entrada = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String dataHora = entrada.format(formatter);


       Path arquivo= Paths.get("/Users/25203648/Arquivos/projetointegrador.csv");
       try{


           Files.writeString(arquivo, cliente.nome+ ";" + cliente.placa + ";" + cliente.carro + ";" + dataHora + "\n", StandardOpenOption.APPEND);
       }catch (IOException e){

           System.out.println("Erro ao criar o arquivo");
           System.out.println(e.getMessage());

       }

    }




    public boolean placaJaExiste(String placa) {


        System.out.println("Validando Placa");

        File arquivo = new File("clientes.csv");

        if (!arquivo.exists()) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {

                // pula cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    if (linha.toLowerCase().contains("placa")) {
                        continue;
                    }
                }

                String[] dados = linha.split(",");

                if (dados.length < 3) continue;

                String placaCSV = dados[2].trim().toUpperCase();

                if (placaCSV.equals(placa.trim().toUpperCase())) {
                    return true; // ACHOU placa duplicada
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler CSV");
        }

        return false;
    }

}

