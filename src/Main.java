import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Jogador> jogadores = new ArrayList<>();
        Integer opcao = 0;

        do {
            opcao = escolherOpcao();

            if (opcao == 1) {
                cadastrarJogador(jogadores);
            } else if (opcao == 2) {
                jogadorMaiorGol(jogadores);
            } else if (opcao == 3) {
                jogadorMenorGol(jogadores);
            } else if (opcao == 4) {
                goleirosComGol(jogadores);
            } else if (opcao == 5) {
                jogadoresCamisa10(jogadores);
            }

        } while (opcao != 6);
    }

    private static Integer escolherOpcao() {

        String opcoes = "1 - Cadastrar Jogador\n" +
                "2 - Mostrar os dados do jogador que teve o maior número de gols\n" +
                "3 - Mostrar os dados do jogador com menor número de gols\n" +
                "4 - Mostrar os dados de todos os goleiros que fizeram algum gol no campeonato\n" +
                "5 - mostrar todos os jogadores que utilizaram a camisa número 10\n" +
                "6 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(opcoes));
    }

    private static void cadastrarJogador(ArrayList<Jogador> jogadores) {

        Jogador _jogador = new Jogador();

        _jogador.setNome(JOptionPane.showInputDialog("Insira o nome do jogador!"));
        _jogador.setNumeroCamisa(Integer.parseInt(JOptionPane.showInputDialog("Insira o número da camisa!")));
        _jogador.setPosicao(JOptionPane.showInputDialog("Insira a posição do jogador!"));
        _jogador.setTime(JOptionPane.showInputDialog("Insira o time do jogador!"));
        _jogador.setGols(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de gols do jogador!")));

        jogadores.add(_jogador);
    }

    private static void jogadorMaiorGol(ArrayList<Jogador> jogadores) {

        var jogador = jogadores.stream().max(Comparator.comparing(i -> i.getGols())).orElse(null);

        if (jogador == null) {

            exibirMensagem("Não há nenhum jogador cadastrado!");

        } else {

            String mensagem = "Nome: " + jogador.getNome()
                    + "\nNúmero da Camisa: " + jogador.getNumeroCamisa()
                    + "\nPosição: " + jogador.getPosicao()
                    + "\nTime: " + jogador.getTime()
                    + "\nQuantidade de gols: " + jogador.getGols();

            exibirMensagem(mensagem);
        }
    }

    private static void jogadorMenorGol(ArrayList<Jogador> jogadores) {

        var jogador = jogadores.stream().min(Comparator.comparing(i -> i.getGols())).orElse(null);

        if (jogador == null) {

            exibirMensagem("Não há nenhum jogador cadastrado!");

        } else {

            String mensagem = "Nome: " + jogador.getNome()
                    + "\nNúmero da Camisa: " + jogador.getNumeroCamisa()
                    + "\nPosição: " + jogador.getPosicao()
                    + "\nTime: " + jogador.getTime()
                    + "\nQuantidade de gols: " + jogador.getGols();

            exibirMensagem(mensagem);
        }
    }

    private static void goleirosComGol(ArrayList<Jogador> jogadores) {

        var goleirosComGol = jogadores.stream().filter(i -> i.getPosicao().equalsIgnoreCase("GOL") && i.getGols() != null && i.getGols() > 0).collect(Collectors.toList());

        if (goleirosComGol == null || goleirosComGol.isEmpty()) {

            exibirMensagem("Não há nenhum Goleiro com gols!");

        } else {

            String mensagem = "";

            for (var goleiro : goleirosComGol) {

                mensagem += "\nNome: " + goleiro.getNome()
                        + "\nNúmero da Camisa: " + goleiro.getNumeroCamisa()
                        + "\nPosição: " + goleiro.getPosicao()
                        + "\nTime: " + goleiro.getTime()
                        + "\nQuantidade de gols: " + goleiro.getGols();
            }

            exibirMensagem(mensagem);
        }
    }


    private static void jogadoresCamisa10(ArrayList<Jogador> jogadores) {

        var jogadoresCamisa10 = jogadores.stream().filter(i -> i.getNumeroCamisa() == 10).collect(Collectors.toList());

        if (jogadoresCamisa10 == null || jogadoresCamisa10.isEmpty()) {

            exibirMensagem("Não há nenhum jogador com a camisa 10!");

        } else {

            String mensagem = "";

            for (var jogador : jogadoresCamisa10) {

                mensagem += "\nNome: " + jogador.getNome()
                        + "\nNúmero da Camisa: " + jogador.getNumeroCamisa()
                        + "\nPosição: " + jogador.getPosicao()
                        + "\nTime: " + jogador.getTime()
                        + "\nQuantidade de gols: " + jogador.getGols();
            }

            exibirMensagem(mensagem);
        }
    }

    private static void exibirMensagem(String mensagem) {

        JOptionPane.showMessageDialog(null, mensagem);
    }

}