package br.com.sgm.integracao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgm.integracao.service.SincronismoService;

@RestController
@RequestMapping("/sincronismo")
public class SincronismoController {

	private final SincronismoService service;
	
	public SincronismoController(SincronismoService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<?> sincronizarDados() {
		try {
			service.sincronizarDadosIpea();
			return ResponseEntity.ok("Dados sincronizados com sucesso!");			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
