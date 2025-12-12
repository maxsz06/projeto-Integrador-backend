package br.senai.sp.jandira.projetointegradorbackend.repository;



import br.senai.sp.jandira.projetointegradorbackend.model.Cliente;
import br.senai.sp.jandira.projetointegradorbackend.ui.RegistrarEntrada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class ClienteRepository {

    RegistrarEntrada registrarEntrada = new RegistrarEntrada();


    public void gravarCliente(Cliente cliente) {

        LocalDateTime horaAtual = LocalDateTime.now();
        DateTimeFormatter formator = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String horaEntrada = horaAtual.format(formator);

       Path arquivo= Paths.get("/Users/25203648/Arquivos/projetointegrador.csv");
       try{


           Files.writeString(arquivo, cliente.nome+ ";" + cliente.placa + ";" + cliente.carro, horaAtual StandardOpenOption.APPEND);
       }catch (IOException e){

           System.out.println("Erro ao criar o arquivo");
           System.out.println(e.getMessage());

       }

    }


    public void receberDados (TextField nomeUser, TextField placaCliente, TextField veiculoCliente) {

        RegistrarEntrada registrarEntrada =  new RegistrarEntrada();
        Cliente cliente = new Cliente();

        cliente.nome = nomeUser.getText();
        cliente.placa = placaCliente.getText();
        cliente.carro = veiculoCliente.getText();


        gravarCliente(cliente);
    }



}

