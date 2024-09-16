package veiculo;

import io.InOut;
import java.text.NumberFormat;
import java.util.Locale;


public class Oficina {

    private static VetVeiculo vetVeiculo = new VetVeiculo(10);

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = exibirMenu();
            if (opcao != 5) {
                executarOpcao(opcao);
            }
        } while (opcao != 5);
        InOut.msgDeInformacao("Saindo", "Programa encerrado!");
    }

    public static int exibirMenu() {
        String menu = "1. Adicionar um novo veículo à oficina\n"
                    + "2. Pesquisar um veículo pela placa\n"
                    + "3. Remover um veículo da oficina pela placa\n"
                    + "4. Listar todos os veículos\n"
                    + "5. Sair";
        String input = InOut.leString(menu + "\nEscolha uma opção:");
        if (input == null) {
            return 5;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            InOut.msgDeErro("Erro", "Opção inválida. Tente novamente.");
            return 0;
        }
    }

    public static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarVeiculo();
                break;
            case 2:
                pesquisarVeiculo();
                break;
            case 3:
                removerVeiculo();
                break;
            case 4:
                listarVeiculos();
                break;
            case 5:
                break;
            default:
                InOut.msgDeErro("Erro", "Opção inválida. Tente novamente.");
        }
    }

    public static void adicionarVeiculo() {
        String placa = InOut.leString("Informe a placa do veículo:");
        if (placa == null) {
            InOut.msgDeInformacao("Cancelado", "Processo cancelado.");
            return;
        }
        String modelo = InOut.leString("Informe o modelo do veículo:");
        if (modelo == null) {
            InOut.msgDeInformacao("Cancelado", "Processo cancelado.");
            return;
        }
        String problema = InOut.leString("Informe o problema do veículo:");
        if (problema == null) {
            InOut.msgDeInformacao("Cancelado", "Processo cancelado.");
            return;
        }
        String valorStr = InOut.leString("Informe o valor do serviço:");
        if (valorStr == null) {
            InOut.msgDeInformacao("Cancelado", "Processo cancelado.");
            return;
        }
        double valorDoServico;
        try {
            valorDoServico = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            InOut.msgDeErro("Erro", "Valor do serviço inválido.");
            return;
        }

        Veiculo veiculo = new Veiculo(placa, modelo, problema, valorDoServico);
        int resultado = vetVeiculo.inserirVeiculo(veiculo);

        if (resultado == -2) {
            InOut.msgDeAviso("Aviso", "Veículo já existente.");
        } else if (resultado == -1) {
            InOut.msgDeAviso("Aviso", "Não há espaço para mais veículos.");
        } else {
            InOut.msgDeInformacao("Sucesso", "Veículo adicionado com sucesso!");
        }
    }

    private static void pesquisarVeiculo() {
        String placa = InOut.leString("Informe a placa do veículo para pesquisa:");
        if (placa == null) {
            InOut.msgDeInformacao("Cancelado", "Processo cancelado.");
            return;
        }
        int posicao = vetVeiculo.pesquisarPlaca(placa);

        if (posicao == -1) {
            InOut.msgDeAviso("Aviso", "Veículo não encontrado.");
        } else {
            Veiculo veiculo = vetVeiculo.getPos(posicao);
            
            NumberFormat format = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(2);
            
            String valorFormatado = format.format(veiculo.getValorDoServico());
            
            InOut.msgDeInformacao("Informação", "Veículo encontrado:\n" 
                + "Placa: " + veiculo.getPlaca() + "\n"
                + "Modelo: " + veiculo.getModelo() + "\n"
                + "Problema: " + veiculo.getProblema() + "\n"
                + "Valor do Serviço: R$ " + valorFormatado);
        }
    }

    public static void removerVeiculo() {
        String placa = InOut.leString("Informe a placa do veículo para remoção:");
        if (placa == null) {
            InOut.msgDeInformacao("Cancelado", "Processo cancelado.");
            return;
        }
        Veiculo veiculo = new Veiculo(placa, "", "", 0);
        boolean sucesso = vetVeiculo.removerVeiculo(veiculo);

        if (sucesso) {
            InOut.msgDeInformacao("Sucesso", "Veículo removido com sucesso!");
        } else {
            InOut.msgDeAviso("Aviso", "Veículo não encontrado.");
        }
    }

    public static void listarVeiculos() {
    	 int numeroVeiculos = vetVeiculo.getNumeroPosicoesPreenchidas();
    	    if (numeroVeiculos == 0) {
    	        InOut.msgDeInformacao("Lista de Veículos", "Não existem veículos para serem listados!");
    	    } else {
    	        StringBuilder sb = new StringBuilder();
    	        for (int i = 0; i < numeroVeiculos; i++) {
    	            Veiculo veiculo = vetVeiculo.getPos(i);
    	            sb.append("Item ").append(i + 1).append("\n")
    	              .append("Modelo: ").append(veiculo.getModelo()).append("\n")
    	              .append("Placa: ").append(veiculo.getPlaca()).append("\n\n");
    	        }
    	        InOut.msgDeInformacao("Lista de Veículos", sb.toString());
    	    }
    }
}
