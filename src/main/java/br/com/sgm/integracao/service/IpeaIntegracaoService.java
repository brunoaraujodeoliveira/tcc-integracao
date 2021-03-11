package br.com.sgm.integracao.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sgm.integracao.data.vo.SerieVO;
import br.com.sgm.integracao.data.vo.SeriesVO;
import br.com.sgm.integracao.data.vo.ValorRegiaoVO;
import br.com.sgm.integracao.data.vo.ValoresRegiaoVO;

@Service
public class IpeaIntegracaoService {
	
	@Value("${integracao.ipea.url.series}")
	private String urlSeries;
	
	@Value("${integracao.ipea.url.valores-por-regiao}")
	private String urlValoresPorRegiao;	
	
	private final RestTemplate restTemplate;
	 
    public IpeaIntegracaoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public SeriesVO recuperarSeries() {
    	SerieVO[] arraySerieVO = this.restTemplate.getForObject(urlSeries, SerieVO[].class);
    	return new SeriesVO(arraySerieVO);
    }

	public ValoresRegiaoVO recuperarValoresPorRegiao(Long serieId, Long ibge) {
		Map<String, Long> params = new HashMap<>();
	    params.put("serie_id", serieId);
	    params.put("regioes", ibge);
	    
	    ValorRegiaoVO[] arrayValorRegiaoVO = this.restTemplate.getForObject(urlValoresPorRegiao, ValorRegiaoVO[].class, params);
	    
	    return new ValoresRegiaoVO(arrayValorRegiaoVO);
	}
}
