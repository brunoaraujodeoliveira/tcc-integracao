package br.com.sgm.integracao.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgm.integracao.data.vo.ValorRegiaoVO;
import br.com.sgm.integracao.service.ValorRegiaoService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	private final ValorRegiaoService regiaoService;
	
	public DashboardController(ValorRegiaoService regiaoService) {
		this.regiaoService = regiaoService;
	}
	
	@PostMapping(value = "/dados", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> findByMunicipio(@RequestParam String municipio) {
		List<ValorRegiaoVO> valorRegioaoList = regiaoService.findByMunicipio(municipio);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION).body(valorRegioaoList);
	}
	
	@GetMapping(value = "/teste")
	public String teste() {
		return "Olá";
	}
}
