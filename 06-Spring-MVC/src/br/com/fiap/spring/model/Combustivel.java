package br.com.fiap.spring.model;

public enum Combustivel {
	
	ETANOL("�lcool"), GASOLINA("Gasolina"), GNV("G�s Natural"), DIESEL("Diesel"), ELETRICO("El�trico"), FLEX("Flex");
	
	private final String label;
	
	private Combustivel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
