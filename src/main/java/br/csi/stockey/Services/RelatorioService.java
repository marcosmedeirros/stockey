package br.csi.stockey.Services;

import br.csi.stockey.Models.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RelatorioService {
    private RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

    public void Salvar(Relatorio relatorio){
        this.repository.save(relatorio);
    }

    public List<Relatorio> Listar(){
        return this.repository.findAll();
    }

    public Relatorio getRelatorio(Long idrelatorio){
        return this.repository.findById(idrelatorio).get();
    }

    public void Atualizar(Relatorio relatorio){
        Relatorio r = this.repository.findById(relatorio.getIdrelatorio()).get();
        r.setNomerelatorio(relatorio.getNomerelatorio());
        r.setTipo(relatorio.getTipo());
        r.setProduto(relatorio.getProduto());
        r.setQtdalterada(relatorio.getQtdalterada());
        r.setQtdatualizada(relatorio.getQtdatualizada());
        r.setData(relatorio.getData());
        this.repository.save(r);

    }

    public void AtualizarUUID(Relatorio relatorio){
        Relatorio r = this.repository.findRelatorioByUuid(relatorio.getUuid());
        r.setNomerelatorio(relatorio.getNomerelatorio());
        r.setTipo(relatorio.getTipo());
        r.setProduto(relatorio.getProduto());
        r.setQtdalterada(relatorio.getQtdalterada());
        r.setQtdatualizada(relatorio.getQtdatualizada());
        r.setData(relatorio.getData());
        this.repository.save(r);
    }

    public Relatorio getRelatorioByUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findRelatorioByUuid(uuidformatado);
    }

    @Transactional
    public void deletarUUID(String uuid) {
        this.repository.deleteRelatorioByUuid(UUID.fromString(uuid));
    }

}

