package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.example.interfaces.IResource;
import org.example.model.Avaliacao;
import org.example.service.AvaliacaoService;
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
@RequestMapping("api/v1/avaliacao")
public class AvaliacaoResource implements IResource<Avaliacao, Integer> {

        @Autowired
        private AvaliacaoService avaliacaoService;

        @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Cria uma avaliação", description = "Método responsável para criar uma avaliação no sistema", tags = {
                        "avaliação" })
        @ApiResponses({
                        @ApiResponse(responseCode = "201", content = {
                                        @Content(schema = @Schema(implementation = Avaliacao.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Avaliacao create(@RequestBody Avaliacao entity) {
                log.info("Cadastro da avaliação iniciado");
                log.debug("Informações da avaliação: {}", entity);
                return avaliacaoService.create(entity);
        }

        @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma avaliação baseado em um identificador", description = "Método responsável para recuperar uma avaliação no sistema baseado no identificador", tags = {
                        "avaliação" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Avaliacao.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Avaliacao get(@PathVariable Integer id) {
                return avaliacaoService.get(id);
        }

        @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Recupera uma lista de avaliações", description = "Método responsável para recuperar uma lista de avaliações", tags = {
                        "avaliacao" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Avaliacao.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public List<Avaliacao> get() {
                return avaliacaoService.get();
        }

        @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
                        MediaType.APPLICATION_JSON_VALUE })
        @Operation(summary = "Atualiza todos os dados de uma avaliação", description = "Método responsável para atualizar todos os dados de uma avaliação.", tags = {
                        "avaliacao" })
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = Avaliacao.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        public Avaliacao update(@PathVariable Integer id, @RequestBody Avaliacao entity) {
                return avaliacaoService.update(id, entity);
        }

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Delete uma avaliação com base no identificador.", description = "Método responsável para deletar uma avaliação com base no identificador.", tags = {
                        "avaliacao" })
        @ApiResponses({
                        @ApiResponse(responseCode = "206", content = {
                                        @Content(schema = @Schema(implementation = Avaliacao.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
                avaliacaoService.delete(id);
        }
}
