import java.util.Scanner;

public class SituacaoAcademica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do aluno
        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();

        // Solicita as notas
        System.out.print("Informe a nota 1: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Informe a nota 2: ");
        double nota2 = scanner.nextDouble();

        // Calcula a média
        double media = (nota1 + nota2) / 2;

        // Determina a situação do aluno com base na média
        String situacao;
        if (media >= 70) {
            situacao = "Aprovado";
        } else if (media < 40) {
            situacao = "Reprovado";
        } else {
            situacao = "Final";
        }

        // Exibe o resultado
        System.out.println("O aluno " + nome + " está " + situacao + " com média " + media + ".");

        // Fechar o scanner
        scanner.close();
    }
}
