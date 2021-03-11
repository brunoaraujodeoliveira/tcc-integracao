package br.com.sgm.integracao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.modelmapper.ModelMapper;

import br.com.sgm.integracao.data.vo.ValorRegiaoVO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "valor_regiao")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ValorRegiao implements Serializable {

	private static final long serialVersionUID = -1166307037049632796L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "codigo", nullable = false, length = 50)
	private String codigo;
	
	@Column(name = "sigla", nullable = false, length = 100)
	private String sigla;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Temporal(TemporalType.DATE)	
	@Column(name = "periodo", nullable = false)
	private Date periodo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_serie")
	private Serie serie;
	
	public static ValorRegiao create(ValorRegiaoVO valorRegiaoVO) {
		return new ModelMapper().map(valorRegiaoVO, ValorRegiao.class);
	}
}
