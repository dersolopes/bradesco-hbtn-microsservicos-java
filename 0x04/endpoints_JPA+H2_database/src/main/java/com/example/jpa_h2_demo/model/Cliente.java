package com.example.jpa_h2_demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cliente-telefones")
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cliente-enderecos")
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Telefone> getTelefones() { return telefones; }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones.clear();
        if (telefones != null) {
            telefones.forEach(this::addTelefone);
        }
    }

    public List<Endereco> getEnderecos() { return enderecos; }
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos.clear();
        if (enderecos != null) {
            enderecos.forEach(this::addEndereco);
        }
    }

    public void addTelefone(Telefone telefone) {
        if (telefone == null) return;
        telefones.add(telefone);
        telefone.setCliente(this);
    }

    public void removeTelefone(Telefone telefone) {
        if (telefone == null) return;
        telefones.remove(telefone);
        telefone.setCliente(null);
    }

    public void addEndereco(Endereco endereco) {
        if (endereco == null) return;
        enderecos.add(endereco);
        endereco.setCliente(this);
    }

    public void removeEndereco(Endereco endereco) {
        if (endereco == null) return;
        enderecos.remove(endereco);
        endereco.setCliente(null);
    }
}
