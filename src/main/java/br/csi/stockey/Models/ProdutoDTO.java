package br.csi.stockey.Models;



public interface ProdutoDTO {

    long getIdproduto();
    String getNomeproduto();
    double getValor();
    int getQuantidade();
    Categoria getCategoria();
    Usuario getUsuario();


}
