package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IResource;
import org.example.model.Professor;
import org.example.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Slf4j // nos ajuda a escrever log no projeto
@RestController // inicida que é uma camada para api
@RequestMapping("api/v1/professor")
public class ProfessorResource implements IResource<Professor, Integer> {

    @Autowired // injeção de dependência
    private ProfessorService professorService;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @Operation(summary = "Cria um professor", description = "Método responsável para criar um professor no sistema", tags = {
            "professor" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = Professor.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
    public Professor create(@RequestBody Professor entity) {
        log.info("Cadastro do professor iniciado");
        log.debug("Informações do professor: {}", entity);
        return professorService.create(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @Operation(summary = "Recupera um professor baseado em um identificador", description = "Método responsável para recuperar um professor no sistema baseado no identificador", tags = {
            "professor" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Professor.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
    public Professor get(Integer id) {
        return professorService.get(id);
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @Operation(summary = "Recupera uma lista de professores", description = "Método responsável para recuperar uma lista de professores", tags = {
            "professor" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Professor.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
    public List<Professor> get() {
        return professorService.get();
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
    @Operation(summary = "Atualiza todos os dados de um professor", description = "Método responsável para atualizar todos os dados de um professor.", tags = {
            "professor" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Professor.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
    public Professor update(Integer id, Professor entity) {
        return professorService.update(id, entity);
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete um professor com base no identificador.", description = "Método responsável para deletar um professor com base no identificador.", tags = {
            "professor" })
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = {
                    @Content(schema = @Schema(implementation = Professor.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
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
        professorService.delete(id);
    }
}