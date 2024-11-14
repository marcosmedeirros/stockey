package br.csi.stockey.Models.Produto;


import br.csi.stockey.Models.Categoria.Categoria;
import br.csi.stockey.Models.Usuario.Usuario;

public interface ProdutoDTO {

    long getIdproduto();
    String getNomeproduto();
    double getValor();
    int getQuantidade();
    Categoria getCategoria();
    Usuario getUsuario();


}
