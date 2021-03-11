package br.com.sgm.integracao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.sgm.integracao.data.vo.SerieVO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "serie")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Serie implements Serializable {

	private static final long serialVersionUID = 6179025433321835385L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "codigo", nullable = false)
	private Long codigo;

	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	public static Serie create(SerieVO serieVO) {
		return new ModelMapper().map(serieVO, Serie.class);
	}
	
}
