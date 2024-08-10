import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        /* Especifica as variáveis vazias */
        String nomeCliente = null;
        String nrAgencia = null;
        Integer nrConta = null;
        BigDecimal vlSaldo = null;
        Integer nrTecla = null;

        // Cria a mensagem inicial de saudação
        System.out.println("Prezado cliente, bem-vindo ao banco Java Básico DIO!");
        System.out.println("Por favor, me informe seu nome completo");
        nomeCliente = scanner.nextLine();
        
        System.out.println("\nQue ótimo " + nomeCliente + "! É um prazer recebe-lo aqui!");
        System.out.println("Para continuar o seu atendimento, por favor, informe o número da agência");
        System.out.println("Lembrando que o formato deve ser (ex: 123456-0), caso não possua digito, informe 0");
        
        /* Cria um loop para validar se o numero da agência foi digitado conforme esperado */
        while(true)
        {
            nrAgencia = scanner.nextLine();
            if (nrAgencia.contains("-")) 
            {
                break;  // Sai do loop se os dados estiverem corretos
            } 
            else 
            {
                System.out.println("Formato da agência inválido. Por favor, informe novamente o número da agência, se nao existir digito coloco 0 (ex: 123456-0).");
            }
        }
        
        System.out.println("\nCerto, obrigado pela informacao, agora digite o numero da conta");
        nrConta = scanner.nextInt();    
        
        System.out.println("\nOtimo, agora informe qual o saldo da conta");
        vlSaldo = scanner.nextBigDecimal();

        /* Adiciona um sleep de 2 segundos */
        System.out.println("\nAguarde um momento enquanto eu valido seus dados!");
        Thread.sleep(2000); 

        /* Cria um loop para alterar os dados, caso o cliente pressione a tecla 2 */
        while (true) 
        {
            System.out.println("Muito obrigado por ter aguardado " + nomeCliente + ", você informou os seguintes dados:");
            Thread.sleep(2000); 
            System.out.println("Agência: " + nrAgencia+", Conta: " + nrConta+", Saldo: R$ " + vlSaldo.setScale(2, RoundingMode.HALF_UP));
            System.out.println("Os dados estão corretos? Se sim, pressione 1, caso contrário 2");

            nrTecla = scanner.nextInt();

            if (nrTecla.equals(1)) 
            {
                System.out.println("Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+nrAgencia+", conta "+nrConta+" e seu saldo "+vlSaldo.setScale(2, RoundingMode.HALF_UP)+" já está disponível para saque");
                break; // Sai do loop se os dados estiverem corretos
            } 
            else 
            {
                System.out.println("Certo, por favor, qual dado deseja corrigir?");
                System.out.println("1. Nome");
                System.out.println("2. Agência");
                System.out.println("3. Conta");
                System.out.println("4. Saldo");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Faz a limpeza do buffer do scanner

                switch (escolha)
                {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        nomeCliente = scanner.nextLine();
                        break;
                    case 2:
                        System.out.print("Informe o novo número da agência: ");
                        nrAgencia = scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("Informe o novo número da conta: ");
                        nrConta = scanner.nextInt();
                        break;
                    case 4:
                        System.out.print("Informe o novo saldo: ");
                        vlSaldo = scanner.nextBigDecimal();
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                }
            }
        }
        scanner.close();
    }
}
