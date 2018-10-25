package br.com.fiap.spring.model;

public enum Combustivel {
	
	ETANOL("Álcool"), GASOLINA("Gasolina"), GNV("Gás Natural"), DIESEL("Diesel"), ELETRICO("Elétrico"), FLEX("Flex");
	
	private final String label;
	
	private Combustivel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
