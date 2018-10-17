package br.com.fiap.spring.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name="pedido",allocationSize=1)
public class Venda {
	
	@Id
	@GeneratedValue(generator="pedido",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String cliente;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data;
	
	private boolean pago;
	
	private String descricao;
	
	private double valor;
	
	public Venda() {
		super();
	}

	public Venda(String cliente, Calendar data, boolean pago, String descricao, double valor) {
		super();
		this.cliente = cliente;
		this.data = data;
		this.pago = pago;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
