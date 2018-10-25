package br.com.fiap.spring.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="T_CARRO")
@SequenceGenerator(name="carro",sequenceName="SQ_T_CARRO",allocationSize=1)
public class Carro {

	@Id
	@GeneratedValue(generator="carro",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank
	private String modelo;
	
	private boolean completo;
	
	@ManyToOne
	private Marca marca;
	
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFabricacao;
	
	private Combustivel combustivel;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}



}
