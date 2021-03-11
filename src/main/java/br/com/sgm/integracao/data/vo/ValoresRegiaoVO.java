package br.com.sgm.integracao.data.vo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ValoresRegiaoVO implements Serializable {

	private static final long serialVersionUID = -5748309498487639095L;
	
	@JsonProperty("valoresRegiao")
	private List<ValorRegiaoVO> valorVO;
	
	public ValoresRegiaoVO(ValorRegiaoVO[] arrayValorRegiaoVO) {
		this.valorVO = Stream.of(arrayValorRegiaoVO).collect(Collectors.toList());
	}
	
}
