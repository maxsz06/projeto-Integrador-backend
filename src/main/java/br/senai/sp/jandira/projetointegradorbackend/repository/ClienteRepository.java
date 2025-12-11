package br.senai.sp.jandira.projetointegradorbackend.repository;



import br.senai.sp.jandira.projetointegradorbackend.model.DadosDoCliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClienteRepository {

    private Path arquivos= Paths.get("C:\\Users\\25203648\\Desktop\\Teste\\dados.csv");
    public DadosDoCliente dadosDoCliente;

    public void gravarDados() {
        try {
            Files.writeString(arquivos, dadosDoCliente.SepararDados(), StandardOpenOption.APPEND);
            System.out.println("Arquivo gravado com um sucesso!");
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }
}

