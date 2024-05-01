package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.Avaliacao;
import org.example.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AvaliacaoService implements IService<Avaliacao, Integer> {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Avaliacao create(Avaliacao entity) {
        return avaliacaoRepository.save(entity);
    }

    @Override
    public Avaliacao get(Integer id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Avaliacao> get() {
        return avaliacaoRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Avaliacao update(Integer id, Avaliacao entity) {
        Optional<Avaliacao> optionalAvaliacao = avaliacaoRepository.findById(id);
        if (optionalAvaliacao.isPresent()) {
            Avaliacao existingAvaliacao = optionalAvaliacao.get();
            existingAvaliacao.setNota1(entity.getNota1());
            existingAvaliacao.setNota2(entity.getNota2());
            existingAvaliacao.setNotaProvaFinal(entity.getNotaProvaFinal());
            existingAvaliacao.setFrequencia(entity.getFrequencia());
            return avaliacaoRepository.save(existingAvaliacao);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        avaliacaoRepository.deleteById(id);
    }
}
