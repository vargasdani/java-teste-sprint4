package br.com.fiap.previsaoSafra.service;

import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    public Fazenda cadastrarFazenda(FazendaDTO fazendaDTO) {
        Fazenda fazenda = new Fazenda();
        fazenda.setDono(fazendaDTO.getDono());
        fazenda.setLatitude(fazendaDTO.getLatitude());
        fazenda.setLongitude(fazendaDTO.getLongitude());
        fazenda.setTamanho(fazendaDTO.getTamanho());
        return fazendaRepository.save(fazenda); 
    }

    public Fazenda atualizarFazenda(Long id, FazendaDTO novaFazenda) {
        Optional<Fazenda> fazendaExistente = fazendaRepository.findById(id);

        if (fazendaExistente.isPresent()) {
            Fazenda fazendaAtualizada = fazendaExistente.get();
            fazendaAtualizada.setDono(novaFazenda.getDono());
            fazendaAtualizada.setLatitude(novaFazenda.getLatitude());
            fazendaAtualizada.setLongitude(novaFazenda.getLongitude());
            fazendaAtualizada.setTamanho(novaFazenda.getTamanho());
            fazendaAtualizada.setListaColheita(novaFazenda.getListaColheita());
            fazendaAtualizada.setDadosClimaticos(novaFazenda.getDadosClimaticos());
            return fazendaRepository.save(fazendaAtualizada);
        } else {
            throw new RuntimeException("Fazenda não encontrada com o ID: " + id);
        }
    }

    public List<Fazenda> listarFazendas() {
        return fazendaRepository.findAll();
    }

    public List<Fazenda> listarFazendaPeloDono(String dono) {
        return fazendaRepository.findByDono(dono);
    }

    public void removerFazenda(Long id) {
        if (fazendaRepository.existsById(id)) {
            fazendaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Fazenda não encontrada com o ID: " + id);
        }
    }

    public Fazenda buscarFazendaPorId(Long id) {
        Optional<Fazenda> fazendaOptional = fazendaRepository.findById(id);
        return fazendaOptional.orElseThrow(() -> new RuntimeException("Fazenda não encontrada com o ID: " + id));
    }
}
