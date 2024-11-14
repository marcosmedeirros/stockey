package br.csi.stockey.Services;

import br.csi.stockey.Models.Categoria.Categoria;
import br.csi.stockey.Models.Categoria.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public void Salvar(Categoria categoria){
        this.repository.save(categoria);
    }

    public List<Categoria> Listar(){
        return this.repository.findAll();
    }

    public Categoria getCategoria(Long  idcategoria){
        return this.repository.findById(idcategoria).get();
    }

    public void Atualizar(Categoria categoria){
        Categoria c = this.repository.findById(categoria.getIdcategoria()).get();
        c.setNomeCategoria(categoria.getNomeCategoria());
        this.repository.save(c);
    }

    public void AtualizarUUID(Categoria categoria){
        Categoria c = this.repository.findCategoriaByUuid(categoria.getUuid());
        c.setNomeCategoria(categoria.getNomeCategoria());
        this.repository.save(c);
    }

    public Categoria getUsuarioByUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findCategoriaByUuid(uuidformatado);
    }

    @Transactional
    public void deletarUUID(String uuid) {
        this.repository.deleteCategoriaByUuid(UUID.fromString(uuid));
    }

}
