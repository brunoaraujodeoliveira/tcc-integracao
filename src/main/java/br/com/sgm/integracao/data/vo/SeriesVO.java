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
public class SeriesVO implements Serializable {

	private static final long serialVersionUID = -9018426991012425577L;
	
	public SeriesVO(SerieVO[] arraySerieVO) {
		this.seriesVO = Stream.of(arraySerieVO).collect(Collectors.toList());
	}

	@JsonProperty("series")
	private List<SerieVO> seriesVO;
	
}
