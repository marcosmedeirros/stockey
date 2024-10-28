package br.csi.stockey.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduto;

    @UuidGenerator
    private UUID uuid;

    @Column(name = "nomeproduto")
    private String nomeproduto;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;



    public Produto(String nomeProduto, double valor, int quantidade, Categoria categoria, double notaMedia) {
        this.nomeproduto = nomeProduto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }


}
