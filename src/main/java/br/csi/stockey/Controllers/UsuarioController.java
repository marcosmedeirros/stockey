package br.csi.stockey.Controllers;

import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping()
    @Operation(summary = "Adiciona Usuario",
            description = "Adiciona um Usuario no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Usuario salvo com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar Usuario", content = @Content)
    })
    //ATE AQUI É DOCUMENTAÇÃO
    public void salvar(@RequestBody Usuario usuario){
        this.service.Salvar(usuario);
    }


    @GetMapping("/uuid/{uuid}")
    @Operation(summary = "Buscar UM Usuario por UUID",
            description = "Busca um Usuario no banco de dados por UUID")
    public Usuario usuario (@PathVariable String uuid){
        return this.service.getUsuarioByUUID(uuid);
    }

    @PutMapping("/uuid")
    @Operation(summary = "Atualizar Usuario por UUID",
            description = "Atualiza um Usuario no banco de dados por UUID")
    public void atualizarUUID(@RequestBody Usuario usuario){
        this.service.AtualizarUUID(usuario);
    }

    @DeleteMapping("/uuid/{uuid}")
    @Operation(summary = "Deletar Usuario por UUID",
            description = "Deleta um Usuario no banco de dados por UUID")
    public void deletar(@PathVariable String uuid) {
        this.service.deletarUUID(uuid);
    }


}

