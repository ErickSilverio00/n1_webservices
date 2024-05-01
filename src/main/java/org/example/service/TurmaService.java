package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Turma;
import org.example.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j // nos ajuda a escrever log no projeto
@Service // indica que é uma camada de serviço(negócio)
public class TurmaService implements IService<Turma, Integer> {

    @Autowired
    private TurmaRepository turmaRepository;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Turma create(Turma entity) {
        return turmaRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @Override
    public Turma get(Integer id) {
        return turmaRepository.findById(id).orElse(new Turma());
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @Override
    public List<Turma> get() {
        return turmaRepository.findAll();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o
     * objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Turma update(Integer id, Turma entity) {
        Optional<Turma> optionalTurma = turmaRepository.findById(id);
        if (optionalTurma.isPresent()) {
            Turma turmaEncontrada = optionalTurma.get();
            turmaEncontrada.setAno(entity.getAno());
            turmaEncontrada.setSemestre(entity.getSemestre());
            turmaEncontrada.setDiaSemana(entity.getDiaSemana());
            turmaEncontrada.setHorarios(entity.getHorarios());
            return turmaRepository.save(turmaEncontrada);
        } else {
            return null;
        }
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        turmaRepository.deleteById(id);
    }
}