package br.csi.stockey.Controllers;

import br.csi.stockey.Models.Relatorio;
import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Services.RelatorioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
@Tag(name = "Relatorios", description = "API para gerenciamento de Relatorios")
public class RelatorioController{
    private RelatorioService service;
    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Relatorios",
            description = "Lista todos os Relatorios cadastrados no banco de dados")
    public List<Relatorio> listar(){
        return this.service.Listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar o Relatorio por id",
            description = "Busca um Relatorio no banco de dados por id")
    public Relatorio relatorio(@PathVariable Long id){
        return this.service.getRelatorio(id);
    }


    @PostMapping("/print-json")
    @Operation(summary = "Print JSON",
            description = "Printa um JSON recebido")
    public void printJson(@RequestBody String json){
        System.out.println(json);
    }


    //SWAGGER - DOCUMENTAÇÃO DA API
    @PostMapping()
    @Operation(summary = "Adiciona Relatorio",
            description = "Adiciona um Relatorio no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Relatorio salvo com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao salvar Relatorio", content = @Content)
    })
    //ATE AQUI É DOCUMENTAÇÃO
    public void salvar(@RequestBody Relatorio relatorio){
        this.service.Salvar(relatorio);
    }


    @GetMapping("/uuid/{uuid}")
    @Operation(summary = "Buscar UM Relatorio por UUID",
            description = "Busca um Relatorio no banco de dados por UUID")
    public Relatorio relatorio (@PathVariable String uuid){
        return this.service.getRelatorioByUUID(uuid);
    }

    @PutMapping("/uuid")
    @Operation(summary = "Atualizar Relatorio por UUID",
            description = "Atualiza um Relatorio no banco de dados por UUID")
    public void atualizarUUID(@RequestBody Relatorio relatorio){
        this.service.AtualizarUUID(relatorio);
    }

    @DeleteMapping("/uuid/{uuid}")
    @Operation(summary = "Deletar Relatorio por UUID",
            description = "Deleta um Relatorio no banco de dados por UUID")
    public void deletar(@PathVariable String uuid) {
        this.service.deletarUUID(uuid);
    }


}