package com.projetoapi.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.projetoapi.model.OrdemServico;

@Service
public interface IOrdemServicoRepository  extends JpaRepository<OrdemServico, Long>{

}
