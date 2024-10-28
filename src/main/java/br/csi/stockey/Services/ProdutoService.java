package br.csi.stockey.Services;

import br.csi.stockey.Models.Produto;
import br.csi.stockey.Models.ProdutoRepository;
import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Models.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void Salvar(Produto produto){
        this.repository.save(produto);
    }

    public List<Produto> Listar(){
        return this.repository.findAll();
    }

    public Produto getProduto(Long idproduto){
        return this.repository.findById(idproduto).get();
    }

    public void Atualizar(Produto produto){
        Produto p = this.repository.findById(produto.getIdproduto()).get();
        p.setNomeproduto(produto.getNomeproduto());
        p.setValor(produto.getValor());
        p.setQuantidade(produto.getQuantidade());
        this.repository.save(p);
    }

    public void AtualizarUUID(Produto produto){
        Produto p = this.repository.findProdutoByUuid(produto.getUuid());
        p.setNomeproduto(produto.getNomeproduto());
        p.setValor(produto.getValor());
        p.setQuantidade(produto.getQuantidade());
        this.repository.save(p);
    }

    public Produto getUsuarioByUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findProdutoByUuid(uuidformatado);
    }

    @Transactional
    public void deletarUUID(String uuid) {
        this.repository.deleteProdutoByUuid(UUID.fromString(uuid));
    }

}
