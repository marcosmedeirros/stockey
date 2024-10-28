package br.csi.stockey.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategoria;

    @UuidGenerator
    private UUID uuid;

    @Column(name = "nomecategoria")
    private String nomeCategoria;

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}
