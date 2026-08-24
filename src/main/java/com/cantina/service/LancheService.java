package com.cantina.service;

import com.cantina.dto.LancheRequestDTO;
import com.cantina.dto.LancheResponseDTO;
import com.cantina.dto.LancheResumoDTO;
import com.cantina.exception.NomeDuplicadoException;
import com.cantina.exception.ResourceNotFoundException;
import com.cantina.model.Lanche;
import com.cantina.repository.LancheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    private final LancheRepository lancheRepository;

    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {
        if (lancheRepository.existsByNome(dto.nome())) {
            throw new NomeDuplicadoException("Já existe um lanche cadastrado com o nome '" + dto.nome() + "'");
        }

        Lanche lanche = new Lanche();
        lanche.setNome(dto.nome());
        lanche.setDescricao(dto.descricao());
        lanche.setPreco(dto.preco());

        Lanche salvo = lancheRepository.save(lanche);
        return LancheResponseDTO.fromEntity(salvo);
    }

    public List<LancheResumoDTO> listarTodos() {
        return lancheRepository.findAll()
                .stream()
                .map(LancheResumoDTO::fromEntity)
                .toList();
    }

    public LancheResponseDTO buscarPorId(Long id) {
        Lanche lanche = buscarEntidadePorId(id);
        return LancheResponseDTO.fromEntity(lanche);
    }

    public LancheResponseDTO atualizar(Long id, LancheRequestDTO dto) {
        Lanche lanche = buscarEntidadePorId(id);

        lancheRepository.findByNome(dto.nome())
                .filter(outro -> !outro.getId().equals(id))
                .ifPresent(outro -> {
                    throw new NomeDuplicadoException("Já existe um lanche cadastrado com o nome '" + dto.nome() + "'");
                });

        lanche.setNome(dto.nome());
        lanche.setDescricao(dto.descricao());
        lanche.setPreco(dto.preco());

        Lanche atualizado = lancheRepository.save(lanche);
        return LancheResponseDTO.fromEntity(atualizado);
    }

    public void deletar(Long id) {
        Lanche lanche = buscarEntidadePorId(id);
        lancheRepository.delete(lanche);
    }

    private Lanche buscarEntidadePorId(Long id) {
        return lancheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lanche com ID " + id + " não encontrado"));
    }
}
