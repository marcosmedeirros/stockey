package br.csi.stockey.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @UuidGenerator
    private UUID uuid;

    @Column(name = "nomeusuario")
    private String nomeUsuario;

    @Column(name = "emailusuario")
    private String emailUsuario;


    @Column(name = "senhausuario")
    private String senhaUsuario;

    @Column(name = "permissao")
    private boolean permissao;


    public Usuario(String nomeUsuario, String emailUsuario, String senhaUsuario, boolean permissao) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.permissao = permissao;
    }


}