package br.csi.stockey.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @NotNull
    @Size(max = 40)
    @Column(name = "nomecategoria")
    private String nomeCategoria;


    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}
