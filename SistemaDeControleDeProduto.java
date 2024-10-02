import java.util.Scanner;

public class SistemaDeControleDeProduto {

    private String codigo;
    private String nome;
    private String tamanhoOuPeso;
    private String cor;
    private double valor;
    private int quantidadeEstoque;

    public SistemaDeControleDeProduto(String codigo, String nome, String tamanhoOuPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoOuPeso = tamanhoOuPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirDetalhes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho/Peso: " + tamanhoOuPeso);
        System.out.println("Cor: " + cor);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    public void realizarVenda(int quantidadeVendida, String formaPagamento) {
        if (quantidadeVendida > quantidadeEstoque) {
            System.out.println("Estoque insuficiente para a venda.");
        } else {
            double valorFinal = valor * quantidadeVendida;

            if (formaPagamento.equalsIgnoreCase("Pix") ||
                    formaPagamento.equalsIgnoreCase("Espécie") ||
                    formaPagamento.equalsIgnoreCase("Transferência") ||
                    formaPagamento.equalsIgnoreCase("Débito")) {

                valorFinal *= 0.95; // Aplicar 5% de desconto
                System.out.println("Desconto de 5% aplicado.");
            } else if (formaPagamento.equalsIgnoreCase("Crédito")) {
                System.out.println("Parcelamento disponível em até 3x sem juros.");
            }

            System.out.println("Valor total da compra: R$ " + valorFinal);

            if (formaPagamento.equalsIgnoreCase("Espécie")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Valor pago em espécie: R$ ");
                double valorPago = scanner.nextDouble();

                if (valorPago >= valorFinal) {
                    double troco = valorPago - valorFinal;
                    System.out.println("Troco: R$ " + troco);
                } else {
                    System.out.println("Valor pago insuficiente.");
                }
            }

            quantidadeEstoque -= quantidadeVendida;
            System.out.println("Venda realizada com sucesso. Quantidade restante em estoque: " + quantidadeEstoque);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro do produto
        System.out.print("Informe o código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o tamanho ou peso do produto: ");
        String tamanhoOuPeso = scanner.nextLine();
        System.out.print("Informe a cor do produto: ");
        String cor = scanner.nextLine();
        System.out.print("Informe o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.print("Informe a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        SistemaDeControleDeProduto produto = new SistemaDeControleDeProduto(codigo, nome, tamanhoOuPeso, cor, valor, quantidadeEstoque);

        produto.exibirDetalhes();

        System.out.print("Informe a quantidade a ser vendida: ");
        int quantidadeVendida = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Informe a forma de pagamento (Pix, Espécie, Transferência, Débito, Crédito): ");
        String formaPagamento = scanner.nextLine();

        produto.realizarVenda(quantidadeVendida, formaPagamento);

        scanner.close();
    }
}
