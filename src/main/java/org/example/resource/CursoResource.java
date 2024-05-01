package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.example.interfaces.IResource;
import org.example.model.Curso;
import org.example.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/curso")
public class CursoResource implements IResource<Curso, Integer> {

        @Autowired
        private CursoService cursoService;

        @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Cria um curso", description = "Método responsável para criar um curso no sistema", tags = {
                        "curso" })
        @ApiResponses({
                        @ApiResponse(responseCode = "201", content = {
                                        @Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Curso create(@RequestBody Curso entity) {
                log.info("Cadastro do curso iniciado");
                log.debug("Informações do curso: {}", entity);
                return cursoService.create(entity);
        }

        @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera um curso baseado em um identificador", description = "Método responsável para recuperar um curso no sistema baseado no identificador", tags = {
                        "curso" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Curso get(@PathVariable Integer id) {
                return cursoService.get(id);
        }

        @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma lista de cursos", description = "Método responsável para recuperar uma lista de cursos", tags = {
                        "curso" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public List<Curso> get() {
                return cursoService.get();
        }

        @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Atualiza todos os dados de um curso", description = "Método responsável para atualizar todos os dados de um curso.", tags = {
                        "curso" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Curso update(@PathVariable Integer id, @RequestBody Curso entity) {
                return cursoService.update(id, entity);
        }

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Delete um curso com base no identificador.", description = "Método responsável para deletar um curso com base no identificador.", tags = {
                        "curso" })
        @ApiResponses({
                        @ApiResponse(responseCode = "206", content = {
                                        @Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public void delete(@PathVariable Integer id) {
                cursoService.delete(id);
        }
}
