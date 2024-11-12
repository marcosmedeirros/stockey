package br.csi.stockey.Services;

import br.csi.stockey.Models.Produto;
import br.csi.stockey.Models.ProdutoDTO;
import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Models.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;



@Service
public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void Salvar(Usuario usuario){
        this.repository.save(usuario);
    }

    public List<Usuario> Listar(){
        return this.repository.findAll();
    }

    public Usuario getUsuario(Long idusuario){
        return this.repository.findById(idusuario).get();
    }

    public void Atualizar(Usuario usuario){
        Usuario u = this.repository.findById(usuario.getIdusuario()).get();
        u.setNomeUsuario(usuario.getNomeUsuario());
        u.setEmailUsuario(usuario.getEmailUsuario());
        u.setSenhaUsuario(usuario.getSenhaUsuario());
        u.setPermissao(usuario.isPermissao());
        this.repository.save(u);
    }

    public void AtualizarUUID(Usuario usuario){
        Usuario u = this.repository.findUsuariooByUuid(usuario.getUuid());
        u.setNomeUsuario(usuario.getNomeUsuario());
        u.setEmailUsuario(usuario.getEmailUsuario());
        u.setSenhaUsuario(usuario.getSenhaUsuario());
        u.setPermissao(usuario.isPermissao());
        this.repository.save(u);
    }

    public Usuario getUsuarioByUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findUsuariooByUuid(uuidformatado);
    }

    @Transactional
    public void deletarUUID(String uuid){
        this.repository.deleteAlunoByUuid(UUID.fromString(uuid));
    }


    public String atribuirProduto(Long idproduto, Produto produto){
        Usuario usuario = this.repository.getReferenceById(idproduto);
        usuario.setProdutos(Collections.singletonList(produto));
        return "Produto atribuido com sucesso";
    }


    public List<ProdutoDTO> findProdutosByUsuario(long idproduto) {
        this.repository.findProdutosByUsuario(idproduto);
        return this.repository.findProdutosByUsuario(idproduto);
    }
}
