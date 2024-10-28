package br.csi.stockey.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "relatorios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Relatorio{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrelatorio;

    @UuidGenerator
    private UUID uuid;

    @Column(name = "nomerelatorio")
    private String nomerelatorio;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;

    @Column(name = "qtdalterada")
    private double qtdalterada;

    @Column(name = "qtdatualizada")
    private double qtdatualizada;

    @Column(name = "data")
    private String data;

    public Relatorio(String nomerelatorio, String tipo, Produto produto, double qtdalterada, double qtdatualizada, String data) {
        this.nomerelatorio = nomerelatorio;
        this.tipo = tipo;
        this.produto = produto;
        this.qtdalterada = qtdalterada;
        this.qtdatualizada = qtdatualizada;
        this.data = data;
    }


}
