package br.csi.stockey.Models;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuariooByUuid(UUID uuid);
    public void deleteAlunoByUuid(UUID uuid);


}
