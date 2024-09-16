package veiculo;

public class Veiculo {
	private String placa, modelo, problema;
	private double valorDoServico;
	
	public Veiculo() {
		this.placa = "";
		this.modelo = "";
		this.problema = "";
		this.valorDoServico = 0.0;
	}
	
	public Veiculo(String placa, String modelo, String problema, double valorDoServico) {
		this.placa = placa;
		this.modelo = modelo;
		this.problema = problema;
		this.valorDoServico = valorDoServico;
	}
	
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", problema=" + problema + ", valorDoServico="
				+ valorDoServico + "]";
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public double getValorDoServico() {
		return valorDoServico;
	}

	public void setValorDoServico(double valorDoServico) {
		this.valorDoServico = valorDoServico;
	}
}
