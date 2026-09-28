package atividadejogodaforca;

import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        String palavra = "";

        while (palavra.length() != 5) {
            palavra = JOptionPane.showInputDialog("Jogador 1, digite uma palavra com 5 letras:");

            if (palavra == null) {
                System.exit(0);
            }

            palavra = palavra.toUpperCase();

            if (palavra.length() != 5) {
                JOptionPane.showMessageDialog(null, "A palavra precisa ter exatamente 5 letras.");
            }
        }

        char[] descoberta = {'_', '_', '_', '_', '_'};
        int erros = 0;
        int limiteErros = 6;
        boolean venceu = false;

        JOptionPane.showMessageDialog(null, "Agora é a vez do Jogador 2!");

        for (int rodada = 0; rodada < 20 && erros < limiteErros && !venceu; rodada++) {
            String tela = "";

            for (int i = 0; i < 5; i++) {
                tela = tela + descoberta[i] + " ";
            }

            String entrada = JOptionPane.showInputDialog(
                    "Palavra: " + tela +
                    "\nErros: " + erros + " de " + limiteErros +
                    "\nDigite uma letra:");

            if (entrada == null) {
                System.exit(0);
            }

            entrada = entrada.toUpperCase();

            if (entrada.length() != 1) {
                JOptionPane.showMessageDialog(null, "Digite somente uma letra.");
                rodada--;
            } else {
                char letra = entrada.charAt(0);
                boolean acertou = false;

                for (int i = 0; i < 5; i++) {
                    if (palavra.charAt(i) == letra) {
                        descoberta[i] = letra;
                        acertou = true;
                    }
                }

                if (!acertou) {
                    erros++;
                    JOptionPane.showMessageDialog(null, "Essa letra não está na palavra.");
                }

                venceu = true;

                for (int i = 0; i < 5; i++) {
                    if (descoberta[i] == '_') {
                        venceu = false;
                    }
                }
            }
        }

        if (venceu) {
            JOptionPane.showMessageDialog(null, "Jogador 2 venceu! A palavra era " + palavra + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Jogador 1 venceu! A palavra era " + palavra + ".");
        }
    }
}
