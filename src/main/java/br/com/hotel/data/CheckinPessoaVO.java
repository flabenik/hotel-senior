package br.com.hotel.data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "nome", "documento", "telefone"})
public class CheckinPessoaVO extends RepresentationModel<CheckinPessoaVO> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	private String nome;
	private String documento;
	private String telefone;
	private double valorEstadiaTotal;
	private List<HospedagemVO> hospedagens;
	
	public CheckinPessoaVO() {}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = (telefone);
	}
	
	public double getValorEstadiaTotal() {
		return valorEstadiaTotal;
	}

	public void setValorEstadiaTotal(double valorEstadiaTotal) {
		this.valorEstadiaTotal = valorEstadiaTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(documento, key, nome, telefone);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckinPessoaVO other = (CheckinPessoaVO) obj;
		return Objects.equals(documento, other.documento) && Objects.equals(key, other.key)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}

	public List<HospedagemVO> getHospedagens() {
		return hospedagens;
	}

	public void setHospedagens(List<HospedagemVO> hospedagens) {
		this.hospedagens = hospedagens;
	}

}
