package br.csi.stockey.Controllers;

import br.csi.stockey.Models.Produto.Produto;
import br.csi.stockey.Services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
@Tag(name = "Produtos", description = "API para gerenciamento de Produtos")
public class ProdutoController{
    private ProdutoService service;
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Produto",
            description = "Lista todos os Produto cadastrados no banco de dados")
    public List<Produto> listar(){
        return this.service.Listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar o Produto por id",
            description = "Busca um Produto no banco de dados por id")
    public Produto produto(@PathVariable Long id){
        return this.service.getProduto(id);
    }


    @PostMapping("/print-json")
    @Operation(summary = "Print JSON",
            description = "Printa um JSON recebido")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }



    @PostMapping("/add")
    @Operation(summary = "Adiciona produto", description = "Adiciona um produto no banco de dados")
    public ResponseEntity salvar(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder){
        this.service.Salvar(produto);
        URI uri = uriBuilder.path("/produto/{uuid}").buildAndExpand(produto.getUuid()).toUri();
        String mensagem = "produto adicionado com sucesso!";
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        resposta.put("produto", produto);
        return ResponseEntity.created(uri).body(produto);
    }



    @GetMapping("/uuid/{uuid}")
    @Operation(summary = "Buscar UM Produto por UUID",
            description = "Busca um Produto no banco de dados por UUID")
    public Produto produto (@PathVariable String uuid){
        return this.service.getUsuarioByUUID(uuid);
    }

    @PutMapping("/atualizar/{uuid}")
    @Operation(summary = "Atualizar Produto por UUID",
            description = "Atualiza um Produto no banco de dados por UUID")
    public ResponseEntity<Produto> atualizarUUID(@PathVariable String uuid, @RequestBody Produto produto) {
        // Aqui você pode usar o uuid para identificar o produto que será atualizado
        this.service.AtualizarUUID(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/uuid/{uuid}")
    @Operation(summary = "Deletar Produto por UUID",
            description = "Deleta um Produto no banco de dados por UUID")
    public ResponseEntity deletar(@PathVariable String uuid) {
        this.service.deletarUUID(uuid);
        return ResponseEntity.noContent().build();
    }


}

