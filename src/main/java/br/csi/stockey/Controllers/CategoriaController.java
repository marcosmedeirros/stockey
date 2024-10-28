package br.csi.stockey.Controllers;

import br.csi.stockey.Models.Categoria;
import br.csi.stockey.Models.Usuario;
import br.csi.stockey.Services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

    @RestController
    @RequestMapping("/categoria")
    @Tag(name = "Categorias", description = "API para gerenciamento de categoria")
    public class CategoriaController{
        private CategoriaService service;
        public CategoriaController(CategoriaService service) {
            this.service = service;
        }

        @GetMapping("/listar")
        @Operation(summary = "Listar Categoria",
                description = "Lista todos os Categoria cadastrados no banco de dados")
        public List<Categoria> listar(){
            return this.service.Listar();
        }

        @GetMapping("/{id}")
        @Operation(summary = "Buscar o Categoria por id",
                description = "Busca um Categoria no banco de dados por id")
        public Categoria categoria(@PathVariable Long  idcategoria){
            return this.service.getCategoria(idcategoria);
        }


        @PostMapping("/print-json")
        @Operation(summary = "Print JSON",
                description = "Printa um JSON recebido")
        public void printJson(@RequestBody String json){
            System.out.println(json);
        }


        //SWAGGER - DOCUMENTAÇÃO DA API
        @PostMapping()
        @Operation(summary = "Adiciona Categoria",
                description = "Adiciona um Categoria no banco de dados")
        @ApiResponses(value ={
                @ApiResponse(responseCode = "201", description = "Categoria salvo com sucesso",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Usuario.class))),
                @ApiResponse(responseCode = "400", description = "Erro ao salvar Categoria", content = @Content)
        })
        //ATE AQUI É DOCUMENTAÇÃO
        public void salvar(@RequestBody Categoria categoria){
            this.service.Salvar(categoria);
        }


        @GetMapping("/uuid/{uuid}")
        @Operation(summary = "Buscar UM Categoria por UUID",
                description = "Busca um Categoria no banco de dados por UUID")
        public Categoria categoria (@PathVariable String uuid){
            return this.service.getUsuarioByUUID(uuid);
        }

        @PutMapping("/uuid")
        @Operation(summary = "Atualizar Categoria por UUID",
                description = "Atualiza um Categoria no banco de dados por UUID")
        public void atualizarUUID(@RequestBody Categoria categoria){
            this.service.AtualizarUUID(categoria);
        }

        @DeleteMapping("/uuid/{uuid}")
        @Operation(summary = "Deletar Categoria por UUID",
                description = "Deleta um Categoria no banco de dados por UUID")
        public void deletar(@PathVariable String uuid) {
            this.service.deletarUUID(uuid);
        }

    }



