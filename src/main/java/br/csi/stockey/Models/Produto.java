package br.csi.stockey.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull
    @Column(name = "nomeproduto")
    private String nomeproduto;

    @NotNull
    @Max(999)
    @Column(name = "valor")
    private double valor;

    @NotNull
    @Min(value = 0, message = "A quantidade deve ser maior ou igual a zero.")
    @Max(value = 1000, message = "A quantidade não pode ser maior que 1000.")
    @Column(name = "quantidade")
    private int quantidade;

    @NotNull
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
