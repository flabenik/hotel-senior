package br.com.hotel.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotel.data.CheckinPessoaVO;
import br.com.hotel.data.PessoaVO;
import br.com.hotel.services.PessoaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pessoa/v1")
@Tag(name = "Hospede", description = "Endpoints para manter Hospede")
public class PessoaController {
	
	@Autowired
	private PessoaServices service;

	@GetMapping(value = "/buscaTodosHospedesEHospedagens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CheckinPessoaVO> buscaTodosHospedesEHospedagens(){		
		return service.buscaTodosHospedesEHospedagens();
	}
	
	@GetMapping(value = "/buscaTodosHospedes", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Todos os Hospedes", description = "Busca Todos os Hospedes",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
				content = {
					@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = PessoaVO.class))
					)
				}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				}
			)
	public List<PessoaVO> findAll(){		
		return service.buscaTodosHospedes();
	}
	
	@GetMapping(value = "buscaHospedePorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Hospede por ID", description = "Busca Hospede por ID",
			responses = {
			@ApiResponse(description = "Success", responseCode = "200",
				content = @Content(schema = @Schema(implementation = PessoaVO.class))
					),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			}
		)
	public PessoaVO buscaHospedePorId(
			@PathVariable(value="id") Long id ) throws Exception {		
		return service.buscaHospedePorId(id);
	}
	
	@GetMapping(value = "buscaHospedeEHospedagensPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Hospede com suas respectivas hospedagens por ID", description = "Busca Hospede com suas respectivas hospedagens por ID",
			responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = CheckinPessoaVO.class))
						),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			}
		)
	public CheckinPessoaVO buscaHospedeEHospedagensPorId(
			@PathVariable(value="id") Long id ) throws Exception {		
		return service.buscaHospedeEHospedagensPorId(id);
	}
	
	@GetMapping(value = "/buscaHospedePorNome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Hospede por Nome", description = "Busca Hospede por Nome",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PessoaVO.class))
						),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PessoaVO buscaHospedePorNome(@PathVariable(value = "nome") String nome) throws Exception {
		return service.buscaHospedePorNome(nome);
	}
	
	@GetMapping(value = "/buscaPorTelefone/{telefone}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Hospede por Telefone", description = "Busca Hospede por Telefone",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PessoaVO.class))
						),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PessoaVO buscaPorTelefone(@PathVariable(value = "telefone") String telefone) throws Exception {
		return service.buscaPorTelefone(telefone);
	}
	
	@GetMapping(value = "/buscaPorDocumento/{documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Hospede por documento", description = "Busca Hospede por documento",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PessoaVO.class))
						),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PessoaVO buscaPorDocumento(@PathVariable(value = "documento") String documento) throws Exception {
		return service.buscaPorDocumento(documento);
	}	
	
	@GetMapping(value = "/hospedagemFinalizada", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Todas as Hospedagens Finalizadas", description = "Busca Todas as Hospedagens Finalizadas",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
				content = {
					@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = List.class))
					)
				}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				}
			)
	public List<Map<String, Object>> buscaHospedesHospedagemFinalizada(){		
		return service.buscaHospedesHospedagemFinalizada();
	}
	
	@GetMapping(value = "/hospedagemAndamento", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Busca Todas as Hospedagens Em Andamento", description = "Busca Todas as Hospedagens Em Andamento",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
				content = {
					@Content(
						mediaType = "application/json",
						array = @ArraySchema(schema = @Schema(implementation = List.class))
					)
				}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				}
			)
	public List<Map<String, Object>> buscaHospedesHospedagemAndamento(){		
		return service.buscaHospedesHospedagemAndamento();
	}
	
	@PostMapping(value = "/cadastraHospede", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Cadastra Hospede", description = "Cadastra Hospede",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PessoaVO.class))
						),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PessoaVO cadastraHospede(
			@RequestBody PessoaVO pessoa ) throws Exception {		
		return service.cadastraHospede(pessoa);
	}
	
	@PutMapping(value = "/atualizaHospede", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza Cadastro Hospede", description = "Atualiza Cadastro Hospede",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PessoaVO.class))
						),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public PessoaVO atualizaHospede(
			@RequestBody PessoaVO pessoa ) throws Exception {		
		return service.atualizaHospede(pessoa);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta Cadastro Hospede", description = "Deleta Cadastro Hospede",
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = ResponseEntity.class))
						),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public ResponseEntity<?> delete(
			@PathVariable(value="id") Long id ) throws Exception {		
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/cadastraCheckin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Cadastra Check-In Hospede", description = "Cadastra Check-In Hospede",
	tags = {"checkin"},
	responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = ResponseEntity.class))
						),
				@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public CheckinPessoaVO cadastraCheckin(
			@RequestBody CheckinPessoaVO checkin ) throws Exception {		
		return service.cadastraCheckin(checkin);
	}
	
	
	
	                                               
}
