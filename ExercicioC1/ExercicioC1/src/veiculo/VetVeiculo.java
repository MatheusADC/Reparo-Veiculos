package veiculo;

public class VetVeiculo {

		private Veiculo[] vetorVeiculos;
		private int numeroPosicoesPreenchidas;

	public VetVeiculo() {
		this.vetorVeiculos = new Veiculo[10];
		this.numeroPosicoesPreenchidas = 0;
	}
	
	public VetVeiculo(int tamanho) {
        this.vetorVeiculos = new Veiculo[tamanho];
        this.numeroPosicoesPreenchidas = 0;
    }
	
	public int getNumeroPosicoesPreenchidas() {
        return numeroPosicoesPreenchidas;
    }
	
	public Veiculo getPos(int posicao) {
        if (posicao >= 0 && posicao < numeroPosicoesPreenchidas) {
            return vetorVeiculos[posicao];
        }
        return null;
    }
	
	public int pesquisarPlaca(String placa) {
        for (int i = 0; i < numeroPosicoesPreenchidas; i++) {
            if (vetorVeiculos[i].getPlaca().equals(placa)) {
                return i;
            }
        }
        return -1;
    }
	
	public int inserirVeiculo(Veiculo veiculo) {
        if (pesquisarPlaca(veiculo.getPlaca()) != -1) {
            return -2;
        }
        if (numeroPosicoesPreenchidas >= vetorVeiculos.length) {
            return -1;
        }
        vetorVeiculos[numeroPosicoesPreenchidas] = veiculo;
        numeroPosicoesPreenchidas++;
        return 0;
    }
	
	public boolean removerVeiculo(Veiculo veiculo) {
        int posicao = pesquisarPlaca(veiculo.getPlaca());
        if (posicao == -1) {
            return false;
        }
        for (int i = posicao; i < numeroPosicoesPreenchidas - 1; i++) {
            vetorVeiculos[i] = vetorVeiculos[i + 1];
        }
        vetorVeiculos[numeroPosicoesPreenchidas - 1] = null;
        numeroPosicoesPreenchidas--;
        return true;
    }
}
