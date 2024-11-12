package br.csi.stockey.Controllers;

import br.csi.stockey.Models.Produto;
import br.csi.stockey.Models.ProdutoDTO;
import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuarios", description = "API para gerenciamento de usuarios")
public class UsuarioController{
    private UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Usuario",
            description = "Lista todos os Usuario cadastrados no banco de dados")
    public List<Usuario> listar(){
        return this.service.Listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar o Usuario por id",
            description = "Busca um Usuario no banco de dados por id")
    public Usuario usuario(@PathVariable Long id){
        return this.service.getUsuario(id);
    }


    @PostMapping("/print-json")
    @Operation(summary = "Print JSON",
            description = "Printa um JSON recebido")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }


    //SWAGGER - DOCUMENTAÇÃO DA API
    @PostMapping("/add")
    @Operation(summary = "Adiciona Usuario",
            description = "Adiciona um Usuario no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Usuario salvo com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar Usuario", content = @Content)
    })
    //ATE AQUI É DOCUMENTAÇÃO
    public ResponseEntity salvar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder){
        this.service.Salvar(usuario);
        URI uri = uriBuilder.path("/usuario/{uuid}").buildAndExpand(usuario.getUuid()).toUri();
        String mensagem = "Usuario adicionado com sucesso!";
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        resposta.put("usuario", usuario);
        return ResponseEntity.created(uri).body(usuario);
    }


    @GetMapping("/uuid/{uuid}")
    @Operation(summary = "Buscar UM Usuario por UUID",
            description = "Busca um Usuario no banco de dados por UUID")
    public Usuario usuario (@PathVariable String uuid){
        return this.service.getUsuarioByUUID(uuid);
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualizar Usuario por UUID",
            description = "Atualiza um Usuario no banco de dados por UUID")
    public ResponseEntity atualizarUUID(@RequestBody @Valid Usuario usuario){
        this.service.AtualizarUUID(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/uuid/{uuid}")
    @Operation(summary = "Deletar Usuario por UUID",
            description = "Deleta um Usuario no banco de dados por UUID")
    public ResponseEntity deletar(@PathVariable String uuid) {
        this.service.deletarUUID(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atribuir-produto")
    @Transactional
    public ResponseEntity atribuirProduto(@PathVariable Long id, @RequestBody Produto produto){
        return ResponseEntity.ok(this.service.atribuirProduto(id, produto));
    }


    @GetMapping("/produto/{id}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosByProjeto(@PathVariable int id) {
        this.service.findProdutosByUsuario(id);
        return ResponseEntity.ok(this.service.findProdutosByUsuario(id));
    }



}

