package br.csi.stockey.Models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

    public Relatorio findRelatorioByUuid(UUID uuid);
    public void deleteRelatorioByUuid(UUID uuid);
}
