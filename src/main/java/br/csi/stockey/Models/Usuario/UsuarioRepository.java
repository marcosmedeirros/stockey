package br.csi.stockey.Models.Usuario;

import br.csi.stockey.Models.Produto.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuariooByUuid(UUID uuid);
    public void deleteAlunoByUuid(UUID uuid);

    @Query(value = "SELECT * FROM produto WHERE idcategoria = :idcategoria", nativeQuery = true)
    List<ProdutoDTO> findAllByCategoriaIdcategoria(Long idcategoria);

    @Query(value = "SELECT * FROM produto WHERE idproduto IN (SELECT idproduto FROM produtoprojetos WHERE idprojeto = :id)", nativeQuery = true)
    List<ProdutoDTO> findProdutosByUsuario(@Param("id") Long id);

    public Usuario findByEmailUsuario (String emailUsuario);

}
