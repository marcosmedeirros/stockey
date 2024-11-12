package br.csi.stockey.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @UuidGenerator
    private UUID uuid;

    @NotNull
    @NotBlank
    @Column(name = "nomeusuario")
    private String nomeUsuario;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "emailusuario")
    private String emailUsuario;

    @NotNull
    @NotBlank
    @Column(name = "senhausuario")
    private String senhaUsuario;

    @Column(name = "permissao")
    private boolean permissao;


    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Produto> produtos;


    public Usuario(String nomeUsuario, String emailUsuario, String senhaUsuario, boolean permissao) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.permissao = permissao;
    }


}