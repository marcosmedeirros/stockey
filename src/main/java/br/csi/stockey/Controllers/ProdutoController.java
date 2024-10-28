package br.csi.stockey.Controllers;

import br.csi.stockey.Models.Produto;
import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    //SWAGGER - DOCUMENTAÇÃO DA API
    @PostMapping()
    @Operation(summary = "Adiciona Produto",
            description = "Adiciona um Produto no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Produto salvo com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar Produto", content = @Content)
    })
    //ATE AQUI É DOCUMENTAÇÃO
    public void salvar(@RequestBody Produto produto){
        this.service.Salvar(produto);
    }


    @GetMapping("/uuid/{uuid}")
    @Operation(summary = "Buscar UM Produto por UUID",
            description = "Busca um Produto no banco de dados por UUID")
    public Produto produto (@PathVariable String uuid){
        return this.service.getUsuarioByUUID(uuid);
    }

    @PutMapping("/uuid")
    @Operation(summary = "Atualizar Produto por UUID",
            description = "Atualiza um Produto no banco de dados por UUID")
    public void atualizarUUID(@RequestBody Produto produto){
        this.service.AtualizarUUID(produto);
    }

    @DeleteMapping("/uuid/{uuid}")
    @Operation(summary = "Deletar Produto por UUID",
            description = "Deleta um Produto no banco de dados por UUID")
    public void deletar(@PathVariable String uuid) {
        this.service.deletarUUID(uuid);
    }


}

