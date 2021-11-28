import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("\n\n\n");
            System.out.print("Selecione a opção desejada abaixo: \n");
            for (int i = 1; i < 11; i++) {
                System.out.print(i + "- Exercicio " + i + "\n");
            }
            System.out.print("11- Sair \n");
            int op = scanner.nextInt();
            switch (op) {
                case 1 -> exercicio1();
                case 2 -> exercicio2();
                case 3 -> exercicio3();
                case 4 -> exercicio4();
                case 5 -> exercicio5();
                case 6 -> exercicio6();
                case 7 -> exercicio7();
                case 8 -> exercicio8();
                case 9 -> exercicio9();
                case 10 -> exercicio10();
                case 11 -> menu = false;
            }
        }
    }

    static void exercicio1() {
        Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int minuto = data.get(Calendar.MINUTE);

        if (hora >= 5 && hora <= 12 ) {
            System.out.println("Bom dia, no momento são " + hora + ":" + minuto);
        } else if (hora > 12 && hora < 19){
            System.out.println("Boa tarde, no momento são " + hora + ":" + minuto);
        } else {
            System.out.println("Boa noite, no momento são " + hora + ":" + minuto);
        }
    }

    static void exercicio2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Agora seu nome: ");
        String nome = scanner.nextLine();
        System.out.println(nome + " " + sobrenome);
        System.out.println("Seu nome tem " + nome.length() + " letras");
    }

    static void exercicio3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();
        System.out.print("Agora digite seu peso: ");
        double peso = scanner.nextDouble();
        double imc = peso / (altura * altura);
        DecimalFormat df = new DecimalFormat("0.00");
        df.format(imc);
        System.out.println("Seu IMC é: " + df.format(imc));
    }

    static void exercicio4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero inteiro: ");
        int numero = scanner.nextInt();
        if (numero % 2 == 0) {
            System.out.println("O número é par!");
        } else {
            System.out.println("O número é ímpar!");
        }
    }

    static void exercicio5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adivinhe qual número de 1 a 5 eu estou pensando: ");
        int numero = scanner.nextInt();
        int numeroGerado = new Random().nextInt(5) + 1;
        if (numero == numeroGerado) {
            System.out.println("Você acertou!");
        } else {
            System.out.println("Você errou, o número correto era " + numeroGerado);
        }
    }

    static void exercicio6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite dua data de nascimento (DD/MM/YYYY): ");
        String respostaData = scanner.nextLine();
        Calendar nascimento = Calendar.getInstance();
        SimpleDateFormat dtFor = new SimpleDateFormat("dd/MM/yyyy");
        try {
            nascimento.setTime(dtFor.parse(respostaData));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        int anoNasc = nascimento.get(Calendar.YEAR);
        int mesNasc = nascimento.get(Calendar.MONTH)+1;
        int diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);

        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH)+1;
        int diaAtual = hoje.get((Calendar.DAY_OF_MONTH));

        boolean jaFezAniversario = diaAtual >= diaNasc && mesAtual >= mesNasc;

        int idade;
        if (jaFezAniversario) {
            idade = anoAtual - anoNasc;
        } else {
            idade = anoAtual - anoNasc - 1;
        }

        if (idade >= 18) {
            System.out.println("Você é maior de idade");
        } else {
            System.out.println("Você é menor de idade");
        }
    }

    static void exercicio7() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Insira a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Insira a terceira nota: ");
        double nota3 = scanner.nextDouble();
        double mediaFinal = (nota1 + nota2 + nota3) / 3;

        System.out.printf("Sua média final é: %,.2f%n", mediaFinal);
    }

    static void exercicio8() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();
        System.out.print("Digite a operação desejada (somar, subtrair, dividir, multiplicar): ");
        String op = scanner.next();
        double resultado = switch (op) {
            case "somar" -> numero1 + numero2;
            case "subtrair" -> numero1 - numero2;
            case "dividir" -> numero1 / numero2;
            case "multiplicar" -> numero1 * numero2;
            default -> 0;
        };
        System.out.printf("Resultado: %,.2f", resultado);
    }

    static void exercicio9() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro de 0 a 10: ");
        int numero = scanner.nextInt();
        if (numero == 0) {
            System.out.println("0");
        } else {
            int resultado = numero;

            for (int i = numero-1; i != 0; i--) {
                resultado *= i;
            }
            System.out.println(resultado);
        }

    }

    static void exercicio10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor inicial: ");
        int numero = scanner.nextInt();
        System.out.print("Valor da raiz: ");
        int raiz = scanner.nextInt();
        System.out.println("Selecione a opção desejada abaixo: \n 1- P.A. \n 2- P.G.");
        int op = scanner.nextInt();
        switch (op) {
            case 1 -> {
                System.out.print(numero + "   ");
                for (int i = 0; i < 9; i++) {
                    numero += raiz;
                    System.out.print(numero + "   ");
                }
            }
            case 2 -> {
                System.out.print(numero + "   ");
                for (int i = 0; i < 9; i++) {
                    numero *= raiz;
                    System.out.print(numero + "   ");
                }
            }
        }
    }
}