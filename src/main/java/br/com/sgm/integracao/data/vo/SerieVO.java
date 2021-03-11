package br.com.sgm.integracao.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sgm.integracao.entity.Serie;
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
public class SerieVO implements Serializable {

	private static final long serialVersionUID = -9018426991012425577L;

	@JsonProperty("id")
	private Long codigo;

	private String titulo;
	
	public static SerieVO create(Serie serie) {
		return new ModelMapper().map(serie, SerieVO.class);
	}
}
