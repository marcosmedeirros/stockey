package br.csi.stockey.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
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



    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;



    public Produto(String nomeproduto, double valor, int quantidade, Categoria categoria, Usuario usuario) {
        this.nomeproduto = nomeproduto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.usuario = usuario;
    }


}
