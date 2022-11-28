package com.projeto.funcionario.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Data
public class Funcionario {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_generator")
    private Long id;
    @Column(length = 150, nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @Column(columnDefinition = "Decimal(8,2)", nullable = false)
    private double salario;
    @Column(length = 25, nullable = false)
    private String celular;
    @Column(length = 50, nullable = false)
    private String email;

    
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "projeto_funcionario",
        joinColumns = { @JoinColumn(name = "id_funcionario") },
        inverseJoinColumns =  { @JoinColumn(name = "id_projeto") })
    private Set <Projeto> projetos = new HashSet<>();
}

