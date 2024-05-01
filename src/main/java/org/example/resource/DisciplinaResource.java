package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.example.interfaces.IResource;
import org.example.model.Disciplina;
import org.example.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Slf4j // nos ajuda a escrever log no projeto
@RestController // inicida que é uma camada para api
@RequestMapping("api/v1/disciplina")
@Tag(name = "disciplina", description = "documentação do resource disciplina")
public class DisciplinaResource implements IResource<Disciplina, Integer> {

        @Autowired // injeção de dependência
        private DisciplinaService disciplinaService;

        /**
         * Mètodo para criar T
         *
         * @param entity
         * @return
         */
        @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Cria uma disciplina", description = "Método responsável para criar uma disciplina no sistema", tags = {
                        "disciplina" })
        @ApiResponses({
                        @ApiResponse(responseCode = "201", content = {
                                        @Content(schema = @Schema(implementation = Disciplina.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "407", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "415", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "501", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "502", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "503", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "504", content = { @Content(schema = @Schema()) }) })
        @Override
        public Disciplina create(@RequestBody Disciplina entity) {
                log.info("Cadastro da disciplina iniciado");
                log.debug("Informações da disciplina: {}", entity);
                return disciplinaService.create(entity);
        }

        /**
         * Método para consultar T baseado no identificador N informado
         *
         * @param id
         * @return
         */
        @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma disciplina baseada em um identificador", description = "Método responsável para recuperar uma disciplina no sistema baseado no identificador", tags = {
                        "disciplina" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Disciplina.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "407", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "415", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "501", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "502", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "503", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "504", content = { @Content(schema = @Schema()) }) })
        @Override
        public Disciplina get(Integer id) {

                return disciplinaService.get(id);
        }

        /**
         * Retorna uma lista de T
         *
         * @return
         */
        @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma lista de disciplinas", description = "Método responsável para recuperar uma lista de disciplinas", tags = {
                        "disciplina" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Disciplina.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "407", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "415", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "416", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "501", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "502", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "503", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "504", content = { @Content(schema = @Schema()) }) })
        @Override
        public List<Disciplina> get() {
                return disciplinaService.get();
        }

        /**
         * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o
         * objeto;
         *
         * @param id
         * @param entity
         * @return
         */
        @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Atualiza todos os dados de uma disciplina", description = "Método responsável para atualizar todos os dados de uma disciplina.", tags = {
                        "disciplina" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Disciplina.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "407", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "409", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "415", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "501", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "502", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "503", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "504", content = { @Content(schema = @Schema()) }) })
        @Override
        public Disciplina update(Integer id, Disciplina entity) {
                return disciplinaService.update(id, entity);
        }

        /**
         * Deleta um registro com base no identificador N(id)
         *
         * @param id
         */
        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Delete uma disciplina com base no identificador.", description = "Método responsável para deletar uma disciplina com base no identificador.", tags = {
                        "disciplina" })
        @ApiResponses({
                        @ApiResponse(responseCode = "206", content = {
                                        @Content(schema = @Schema(implementation = Disciplina.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
                        @ApiResponse(responseCode = "202", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "405", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "407", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "415", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "501", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "502", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "503", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "504", content = { @Content(schema = @Schema()) }) })
        @Override
        public void delete(Integer id) {
                disciplinaService.delete(id);
        }
}