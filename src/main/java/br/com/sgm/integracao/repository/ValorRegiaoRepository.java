package br.com.sgm.integracao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sgm.integracao.entity.ValorRegiao;

@Repository
public interface ValorRegiaoRepository extends JpaRepository<ValorRegiao, Long> {

	@Query(value = "SELECT distinct sigla, codigo FROM valor_regiao ORDER BY sigla ASC", nativeQuery = true)
	List<ValorRegiao> findMunicipios();
	
	@Query(value = "SELECT vr "
			+ "FROM "
			+ "ValorRegiao vr "
			+ "WHERE "
			+ "sigla = :municipio "
			+ "AND "
			+ "periodo BETWEEN '2009-01-01' AND '2016-12-31' "
			+ "ORDER BY periodo ASC ")
	List<ValorRegiao> findByMunicipio(@Param("municipio") String municipio);
	
	@Query(value = "INSERT INTO valor_regiao(id, codigo, sigla, valor, periodo, id_serie) "
			+ "VALUES (:id, :codigo, :sigla, :valor, :periodo, :serieId) RETURNING id"
		, nativeQuery = true
	)
	Long save(@Param("id") Long id, @Param("codigo") String codigo, @Param("sigla") String sigla, @Param("valor") Double valor,
			@Param("periodo") Date periodo, @Param("serieId") Long serieId);
	
	@Query(value = "select nextval('valor_regiao_id_seq')", nativeQuery = true)
	Long findNextSequence();
}
