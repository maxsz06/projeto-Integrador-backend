package br.senai.sp.jandira.projetointegradorbackend.model;
import br.senai.sp.jandira.projetointegradorbackend.repository.ClienteRepository;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import br.senai.sp.jandira.projetointegradorbackend.ui.RegistrarEntrada;
import br.senai.sp.jandira.projetointegradorbackend.repository.ClienteRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DadosDoCliente {

    public static ObservableList <RegistrarEntrada> listaCarros = FXCollections.observableArrayList();

    public String nome;
    public String placa;
    public String carro;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");
        public String horario = LocalDateTime.now().format(formatter);

        public String SepararDados() {
            String contatoSeparado = nome + ";" + placa + ";" + carro +"\n";
            return contatoSeparado;
        }

    public DadosDoCliente(String nome, String placa, String carro) {
            this.nome = nome;
        this.placa = placa;
        this.carro = carro;

      ClienteRepository clienteRepository = new ClienteRepository();
      clienteRepository.gravarDados();
    }

    @Override
    public String toString (){
        return "Nome: " + nome +
                ", Placa: " + placa +
                ", Carro: " + carro +
                ", Horário: " + horario;


    }






}

