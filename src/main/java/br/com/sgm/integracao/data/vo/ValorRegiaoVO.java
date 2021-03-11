package br.com.sgm.integracao.data.vo;

import java.io.Serializable;
import java.util.Date;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sgm.integracao.entity.Serie;
import br.com.sgm.integracao.entity.ValorRegiao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ValorRegiaoVO implements Serializable  {

	private static final long serialVersionUID = -5485578130734535424L;

	private Long id;
	
	@JsonProperty("cod")
	private String codigo;

	private String sigla;
	
	private Double valor;
	
	private Date periodo;
	
	private Serie serie;

	public static ValorRegiaoVO create(ValorRegiao valorRegiao) {
		return new ModelMapper().map(valorRegiao, ValorRegiaoVO.class);
	}
}
