package br.csi.stockey.Models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public Produto findProdutoByUuid(UUID uuid);
    public void deleteProdutoByUuid(UUID uuid);
}
