package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.example.interfaces.IResource;
import org.example.model.Turma;
import org.example.service.TurmaService;
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
@RequestMapping("api/v1/turma")
public class TurmaResource implements IResource<Turma, Integer> {

        @Autowired
        private TurmaService turmaService;

        @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Cria uma turma", description = "Método responsável para criar uma turma no sistema", tags = {
                        "turma" })
        @ApiResponses({
                        @ApiResponse(responseCode = "201", content = {
                                        @Content(schema = @Schema(implementation = Turma.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Turma create(@RequestBody Turma entity) {
                log.info("Cadastro da turma iniciado");
                log.debug("Informações da turma: {}", entity);
                return turmaService.create(entity);
        }

        @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma turma baseado em um identificador", description = "Método responsável para recuperar uma turma no sistema baseado no identificador", tags = {
                        "turma" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Turma.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Turma get(@PathVariable Integer id) {
                return turmaService.get(id);
        }

        @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma lista de turmas", description = "Método responsável para recuperar uma lista de turmas", tags = {
                        "turma" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Turma.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public List<Turma> get() {
                return turmaService.get();
        }

        @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Atualiza todos os dados de uma turma", description = "Método responsável para atualizar todos os dados de uma turma.", tags = {
                        "turma" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Turma.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Turma update(@PathVariable Integer id, @RequestBody Turma entity) {
                return turmaService.update(id, entity);
        }

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Delete uma turma com base no identificador.", description = "Método responsável para deletar uma turma com base no identificador.", tags = {
                        "turma" })
        @ApiResponses({
                        @ApiResponse(responseCode = "206", content = {
                                        @Content(schema = @Schema(implementation = Turma.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
                turmaService.delete(id);
        }
}
