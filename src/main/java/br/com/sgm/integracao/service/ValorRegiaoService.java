package br.com.sgm.integracao.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgm.integracao.data.vo.ValorRegiaoVO;
import br.com.sgm.integracao.entity.ValorRegiao;
import br.com.sgm.integracao.repository.ValorRegiaoRepository;

@Service
public class ValorRegiaoService {
	
	private final ValorRegiaoRepository repository;
		
	@Autowired
	public ValorRegiaoService(ValorRegiaoRepository repository) {
		this.repository = repository;
	}
	
	public List<ValorRegiaoVO> findByMunicipio(String municipio) {
		List<ValorRegiao> valorRegiaoList = repository.findByMunicipio(municipio);
		
		return valorRegiaoList.stream()
				.map(it -> ValorRegiaoVO.create(it))
				.collect(Collectors.toList());
	}
	
}
