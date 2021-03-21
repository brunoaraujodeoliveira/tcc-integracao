package br.com.sgm.integracao.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgm.integracao.data.vo.SeriesVO;
import br.com.sgm.integracao.data.vo.ValoresRegiaoVO;
import br.com.sgm.integracao.entity.Serie;
import br.com.sgm.integracao.repository.SerieRepository;
import br.com.sgm.integracao.repository.ValorRegiaoRepository;

@Service
public class SincronismoService {
	
	private final SerieRepository serieRepository;
	
	private final ValorRegiaoRepository valorRegiaoRepository;
	
	private final IpeaIntegracaoService ipeaIntegracaoService;
	
	@Autowired
	public SincronismoService(SerieRepository serieRepository, 
			ValorRegiaoRepository valorRegiaoRepository,
			IpeaIntegracaoService ipeaIntegracaoService) {
		this.serieRepository = serieRepository;
		this.valorRegiaoRepository = valorRegiaoRepository;
		this.ipeaIntegracaoService = ipeaIntegracaoService;
	}
	
	public void sincronizarDadosIpea() {
		valorRegiaoRepository.deleteAll();
		serieRepository.deleteAll();
		
		List<Serie> series = sincronizarSeries();		
		sincronizarValoresPorRegiao(series);			
	}

	private void sincronizarValoresPorRegiao(List<Serie> series) {		
		var filterSeries = Arrays.asList(17L, 24L);
		var municipiosIbge = Arrays.asList(3304557L, 3550308L, 1302603L);
		
		for (Long ibge : municipiosIbge) {
			for (Serie item : series) {
				if (filterSeries.contains(item.getCodigo())) {
					ValoresRegiaoVO valoresPorRegiao = ipeaIntegracaoService.recuperarValoresPorRegiao(item.getCodigo(), ibge);
					
					valoresPorRegiao.getValorVO().forEach(vr -> {
						Long nextSequence = valorRegiaoRepository.findNextSequence();
						valorRegiaoRepository.save(nextSequence, vr.getCodigo(), vr.getSigla(), vr.getValor(),
								vr.getPeriodo(), item.getId());
					});		
				}			
			}			
		}
		
	}

	private List<Serie> sincronizarSeries() {
		SeriesVO seriesVO = ipeaIntegracaoService.recuperarSeries();
		List<Serie> serieList = new ArrayList<>();
		
		
		seriesVO.getSeriesVO().forEach(item -> {
			Serie serie = Serie.create(item);
			serieList.add(serie);				
		});
		
		serieRepository.saveAll(serieList);
		
		return serieList;
	}
	
}
