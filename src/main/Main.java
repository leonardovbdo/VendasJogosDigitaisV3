package main;

import model.JogoDigital;
import model.Nomes;
import threads.AtualizarPrecoJogo;
import threads.MonitorarJogo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Leonardo
 */
public class Main {

    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList<JogoDigital> jogos = new ArrayList<>();
    public static ArrayList<AtualizarPrecoJogo> threads = new ArrayList<>();
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static MonitorarJogo monitorarJogo = new MonitorarJogo(jogos);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            JogoDigital jogo = new JogoDigital(Nomes.getNomeById(i));
            jogos.add(jogo);
            AtualizarPrecoJogo atualizarPrecoJogo = new AtualizarPrecoJogo(jogo);
            threads.add(atualizarPrecoJogo);
            atualizarPrecoJogo.start();
        }
        monitorarJogo.start();

        System.out.println("-----------------------------------------------------");
        System.out.println("----------------BEM-VINDO-À-NOSSA-LOJA---------------");
        System.out.println("-----------------------------------------------------\n");

        menu();
    }

    /*
     * Este método estático será chamado a partir do método menu() quando o usuário selecioná-lo.
     * Sua função é simples, ele irá percorrer todos os objetos do ArrayList mencionado anteriormente
     * e irá realizar o método toString() que é responstável por imprimir os atributos de cada um dos jogos
     * percorridos, detalhando-os e deixando claro qual é qual.
     * A complexidade do método é linear, O(n) onde 'n' é o número de jogos na lista. Isso ocorre porque
     * o tempo de execução do método aumenta proporcionalmente ao tamanho da lista. Quanto maior a lista,
     * mais tempo será necessário para percorrê-la e imprimir cada elemento.
     */
    public static void listarLeituras() {
        for (JogoDigital jogo : jogos) {
            System.out.println(jogo);
        }
    }

    /*
     * Este método funciona semelhante como o método anterior, porém ao invés de imprimir todos os atributos
     * de cada um dos jogos como o método toString(), ele irá apenas imprimir o nome de cada um dos jogos do ArrayList
     * utilizando o método getNome().
     * A complexidad deste método também é linear O(n), onde 'n' é o número de jogos na lista, pois o número
     * de iterações será igual ao número de elementos na lista. O tempo de execução aumenta proporcionalmente
     * ao tamanho da lista.
     */
    public static void gerarJogosNomes() {
        System.out.println("\n##### SEGUE ABAIXO A LISTA COM O NOME DOS JOGOS EM NOSSA LOJA #####\n");
        for (JogoDigital jogo : jogos) {
            System.out.println(jogo.getNome());
        }
    }

    /*
     * Este método tem como objetivo realizar o algoritmo de maior complexidade presente dentro deste sistema.
     * A sua função é percorrer o ArrayList de JogoDigital calculando a porcentagem de avaliações positivas de
     * cada um dos jogos com base nos atributos AvaliacoesPositivas e UnidadesVendidas e comparando-as definindo
     * qual jogo tem maior porcentagem de avaliações positivas, qual tem menor porcentagem e qual a diferença entre
     * essas porcentagens. Primeiramente o método iniciar três loops aninhados que percorrem cada combinação de três
     * jogos diferentes. O loop mais interno calcula as porcentagens de cada um dos três jogos com base nas variáveis
     * de cada um dos loops (i, j e k), em seguida a diferença entre essas porcentagens é calculada como
     * diferencaIJ(porcentagemI - porcentagemJ), diferencaIK(porcentagemI - porcentagemK) e diferencaJK(porcentagemJ - porcentagemK)
     * esse cálculo será feito utilizando o método abs() da biblioteca Math para gerar um valor absoluto (independente de sinal
     * positivo ou negativo). Em seguida, o algoritmo irá verificar se a maior diferença calulcada é maior do que a maior diferença
     * calculada até o momento e atualiza essas variáveis caso essa verificação retorne como verdadeira. Da mesma forma, ele
     * irá verificar se a menor porcentagem atual é menor do que a menor porcentagem encontrada até o momento e atualiza
     * as variáveis novamente, caso a verificação retorne como verdadeira. A complexidade do algoritmo presente neste método
     * estático é de O(n^3), já que a presença dos três loops aninhados para realizar essas buscas e comparações implica neste fato,
     * afinal cada loop utiliza a quantidade de jogos presente na lista, sendo esse o valor de n.
     */
    public static void encontrarMaiorDiferencaAvaliacao(ArrayList<JogoDigital> jogos) {
        int n = jogos.size();
        double maiorDiferenca = 0;
        int indexJogoMaiorPorcentagem = 0;
        int indexJogoMenorPorcentagem = 0;
        double menorDiferenca = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (i != j && i != k && j != k) {

                        double porcentagemI = 100 * ((double) jogos.get(i).getAvaliacoesPositivas() / jogos.get(i).getUnidadesVendidas());
                        double porcentagemJ = 100 * ((double) jogos.get(j).getAvaliacoesPositivas() / jogos.get(j).getUnidadesVendidas());
                        double porcentagemK = 100 * ((double) jogos.get(k).getAvaliacoesPositivas() / jogos.get(k).getUnidadesVendidas());

                        double diferencaIJ = Math.abs(porcentagemI - porcentagemJ);
                        double diferencaIK = Math.abs(porcentagemI - porcentagemK);
                        double diferencaJK = Math.abs(porcentagemJ - porcentagemK);

                        double maiorDif = Math.max(diferencaIJ, Math.max(diferencaIK, diferencaJK));

                        if (maiorDif > maiorDiferenca) {
                            maiorDiferenca = maiorDif;
                            indexJogoMaiorPorcentagem = porcentagemI > porcentagemJ ? i : j;
                            indexJogoMaiorPorcentagem = porcentagemK > porcentagemI && porcentagemK > porcentagemJ ? k : indexJogoMaiorPorcentagem;
                        }

                        double menorDif = Math.min(porcentagemI, Math.min(porcentagemJ, porcentagemK));
                        if (menorDif < menorDiferenca) {
                            menorDiferenca = menorDif;
                            indexJogoMenorPorcentagem = porcentagemI < porcentagemJ ? i : j;
                            indexJogoMenorPorcentagem = porcentagemK < porcentagemI && porcentagemK < porcentagemJ ? k : indexJogoMenorPorcentagem;
                        }
                    }
                }
            }
        }

        System.out.println("Jogo com maior porcentagem de avaliações positivas: " + jogos.get(indexJogoMaiorPorcentagem).getNome());
        System.out.println("Jogo com menor porcentagem de avaliações positivas: " + jogos.get(indexJogoMenorPorcentagem).getNome());
        System.out.println("Maior diferença entre as porcentagens de avaliações positivas dos jogos: " + df.format(maiorDiferenca));
    }

    /*
     * Este método irá ordenar e imprimir os jogos com base no valor de preço dos mesmos de forma crescente.
     * Ele irá percorrer a lista de jogos utilizando dois loops e irá comparar o valor do primeiro jogo com o preço do segundo.
     * O primeiro loop irá interar o primeiro jogo e o segundo irá interar o segundo jogo, os loops são criados garantindo que não
     * serão comparados jogos repetidos. Se o valor do segundo jogo for maior do que o valor do primeiro, o valor do primeiro
     * jogo será armazenado  em uma variável chamada temp. O valor do primeiro jogo passará a ser o valor do segundo,
     * ocupando seu lugar na lista e o valor do segundo jogo iterado receberá o valor da variável que armazenou o valor do primeiro jogo
     * ocupando o lugar do segundo jogo e consequentemente, descendo de posição na lista.
     * Este algoritmo segue a lógia do algoritmo de bubble sort. No melhor caso o algoritmo executa 'n' operações
     * relevante onde 'n' representa o número de elementos na lista e no pior caso são feitas n^2 operações.
     * Por essa razão a complexidade deste algoritmo é quadrática e em notação big O é (n^2).
     */
    public static void ordenarLeituras(ArrayList<JogoDigital> jogos) {

        for (int i = 0; i < jogos.size(); i++) {
            for (int j = i + 1; j < jogos.size(); j++) {
                if (jogos.get(i).getPrecoAtual() > jogos.get(j).getPrecoAtual()) {
                    JogoDigital temp = jogos.get(i);
                    jogos.set(i, jogos.get(j));
                    jogos.set(j, temp);
                }
            }
            jogos.get(i).setId(i + 1);
        }

        for (JogoDigital jogo : jogos) {
            System.out.println(jogo);
        }
    }

    /*
    * Este método percorre a lista de jogos e verifica, para cada jogo, se houve uma diminuição
    * significativa de preço, executando o método da classe JogoDigital e também verificando
    * se o preço anterior do jogo é diferente de zero. Se essas condições forem atendidas, a mensagem
    * com as informações do respectivo jogo são expostas na tela. Se nenhum jogo apresentar uma dimiuição
    * significativa de preço, outra mensagem indicando que não houve redução significativa nos preços
    * é impressa.
    * A complexidade do método é linear O(n), onde 'n' é o número de jogos na lista. Isso ocorre pois
    * o método percorre todos os jogos da lista de uma vez, realizando uma verificação simples para cada
    * jogo.
    *  */
    public static void iniciarMonitorarThread() throws InterruptedException{
        char saida;
        monitorarJogo.monitorar();
        System.out.println("\nDigite S para parar de monitorar");
        saida = entrada.nextLine().charAt(0);
        char saidaUpperCase = Character.toUpperCase(saida);
        boolean monitorando = true;

        do {
            if (saidaUpperCase == 'S') {
                monitorando = false;
            } else {
                saidaUpperCase = Character.toUpperCase(entrada.nextLine().charAt(0));
            }
        } while (monitorando);
        monitorarJogo.pararMonitorar();
        menu();
    }

    /*
    * Método menu que é reponsável por exibir um menu de opções para o usuário realizar diferentes
    * ações com base na escolha. A complexidade deste método vai depender da complexidade das ações
    * realizadas em cada caso no bloco switch.
    * */
    public static void menu() throws InterruptedException {

        char opcao;
        boolean ligado = true;
        do {
            System.out.println("\n##### SELECIONE QUAL FUNÇÃO DESEJA REALIZAR #####");
            System.out.println("\n[A] - IMPRIMIR A LISTA DE JOGOS");
            System.out.println("[B] - IMPRIMIR A LISTA COM OS VALORES DOS JOGOS");
            System.out.println("[C] - IMPRIMIR A LISTA DE JOGOS DE ORDENADA DE FORMA CRESCENTE");
            System.out.println("[D] - CALCULAR A MAIOR DIFERÊNÇA ENTRE PORCENTAGENS DE AVALIAÇÕES POSITIVAS");
            System.out.println("[P] - EXIBIR MONITORAMENTO PELO PROGRAMA PRINCIPAL");
            System.out.println("[S] - SAIR");
            System.out.print("Sua escolha: ");
            opcao = entrada.nextLine().charAt(0);
            char opcaoUpperCase = Character.toUpperCase(opcao);

            switch (opcaoUpperCase) {
                case 'A':
                    gerarJogosNomes();
                    break;
                case 'B':
                    listarLeituras();
                    break;
                case 'C':
                    ordenarLeituras(jogos);
                    break;
                case 'D':
                    encontrarMaiorDiferencaAvaliacao(jogos);
                    break;
                case 'P':
                    iniciarMonitorarThread();
                    ligado = false;
                    break;
                case 'S':
                    System.out.println("\nAguarde, o sistema está sendo desligado...");
                    ligado = false;
                    entrada.close();
                    break;
            }

        } while (ligado);
        encerrarThreads();
    }

    /*
    * Método responsável para executar o método da classe da thread que irá desligar
    * a respectiva thread. Como esse método percorre por todos os threads da lista de
    * threads, ele executará o método em cada uma das threads presentes na lista. E mais
    * uma vez, a complexidade deste método é O(n), onde 'n' é o número de threads na lista.
    * */
    public static void encerrarThreads() {
        for (AtualizarPrecoJogo thread : threads) {
            thread.desligar();
        }
    }
}