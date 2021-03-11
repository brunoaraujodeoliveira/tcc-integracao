package br.com.sgm.integracao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sgm.integracao.entity.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {


}
