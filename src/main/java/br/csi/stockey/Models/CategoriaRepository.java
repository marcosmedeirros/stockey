package br.csi.stockey.Models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.UUID;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long > {

    public Categoria findCategoriaByUuid(UUID uuid);
    public void deleteCategoriaByUuid(UUID uuid);
}