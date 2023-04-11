package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.JogoDigital;

/**
 *
 * @author Leonardo
 */
public class Main {

    /*
    * A classe main se inicia inicializando dois componentes que serão 
    * constantemente usados dentro do funcionamento do sistema. Nesse
    * caso esses componentes serão o Scanner em que iremos inserir os inputs
    * para definir qual função iremos realizar dentro do código. 
    * O outro componente será o ArrayList que armazenará os objetos criados a 
    * partir da classe JogoDigital e dessa lista iremos realizar as funções que utilizarão
    * dos objetos e seus atributos
    *
    */
    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList<JogoDigital> jogos;

    /*
    * Aqui abaixo iremos implementar o método main que irá fazer a inserção dos
    * respectivos objetos da classe JogoDigital dentro do ArrayList "jogos" instanciado
    * anteriormente. Cada jogo será inserido a partir de um construtor e cada construtor possuirá
    * O nome do respectivo jogo. Cada jogo tem seu nome único.
    * Ao final da inserção dos objetos dentro da lista o método termina iniciando o outro método chamado
    * menu(), o qual irá realizar as operações dos métodos estáticos abaixo. Posteriormente o método menu()
    * será detalhado
    */
    public static void main(String[] args) throws InterruptedException {

        jogos = new ArrayList<JogoDigital>();
        JogoDigital jogoDigital1 = new JogoDigital("Age of Mythology");
        JogoDigital jogoDigital2 = new JogoDigital("Counter Strike: Global Offensive");
        JogoDigital jogoDigital3 = new JogoDigital("Cuphead");
        JogoDigital jogoDigital4 = new JogoDigital("Dark Souls III");
        JogoDigital jogoDigital5 = new JogoDigital("Dead Cells");
        JogoDigital jogoDigital6 = new JogoDigital("Elden Ring");
        JogoDigital jogoDigital7 = new JogoDigital("Fallout 4");
        JogoDigital jogoDigital8 = new JogoDigital("Grand Theft Auto V");
        JogoDigital jogoDigital9 = new JogoDigital("Hollow Knight");
        JogoDigital jogoDigital10 = new JogoDigital("Hotline Miami");
        JogoDigital jogoDigital11 = new JogoDigital("Mortal Kombat X");
        JogoDigital jogoDigital12 = new JogoDigital("Pathologic 2");
        JogoDigital jogoDigital13 = new JogoDigital("Plants vs. Zombies");
        JogoDigital jogoDigital14 = new JogoDigital("PlayerUnknown's Battlegrounds");
        JogoDigital jogoDigital15 = new JogoDigital("Resident Evil 2 Remake");
        JogoDigital jogoDigital16 = new JogoDigital("Sekiro: Shadows Die Twice");
        JogoDigital jogoDigital17 = new JogoDigital("Subnautica");
        JogoDigital jogoDigital18 = new JogoDigital("Sunset Overdrive");
        JogoDigital jogoDigital19 = new JogoDigital("Terraria");
        JogoDigital jogoDigital20 = new JogoDigital("The Witcher 3: Wild Hunt");

        jogos.add(jogoDigital1);
        jogos.add(jogoDigital2);
        jogos.add(jogoDigital3);
        jogos.add(jogoDigital4);
        jogos.add(jogoDigital5);
        jogos.add(jogoDigital6);
        jogos.add(jogoDigital7);
        jogos.add(jogoDigital8);
        jogos.add(jogoDigital9);
        jogos.add(jogoDigital10);
        jogos.add(jogoDigital11);
        jogos.add(jogoDigital12);
        jogos.add(jogoDigital13);
        jogos.add(jogoDigital14);
        jogos.add(jogoDigital15);
        jogos.add(jogoDigital16);
        jogos.add(jogoDigital17);
        jogos.add(jogoDigital18);
        jogos.add(jogoDigital19);
        jogos.add(jogoDigital20);

        menu();
    }
    
    /*
    * O primeiro método estático operacional que encontramos também é o primeiro método
    * que será iniciado no momento em que o código é iniciado, independente do controle do usuário.
    * Este método tem como função usar de um loop for para percorrer todos os jogos presentes dentro
    * do ArrayList citado anteriormente e irá realizar métodos que estão presentes dentro da classe
    * JogoDigital. Esses métodos tem como função aplicar valores aleatórios, seguindo as regras
    * estabelecidas pelo desesnvolvedor, em cada um dos atributos dos objetos da classe JogoDigital,
    * excluindo apenas os atributos nome e id.
    */

    public static void gerarModelosAleatorios() {
        for (int i = 0; i < jogos.size(); i++) {
            jogos.get(i).setPrecoAleatorio();
            jogos.get(i).setPromocaoAleatoria();
            jogos.get(i).setUnidadesVendidasAleatoria();
            jogos.get(i).setAvaliacoesPositivasAleatoria();
        }
    }
    
    /*
    * Este método estático será chamado a partir do método menu() quando o usuário selecioná-lo.
    * Sua função é simples, ele irá percorrer todos os objetos do ArrayList mencionado anteriormente 
    * e irá realizar o método toString() que é responstável por imprimir os atributos de cada um dos jogos
    * percorridos, detalhando-os e deixando claro qual é qual.
    */

    public static void gerarLeituras() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.println(
                    jogos.get(i)
            );
        }
    }
    
    /*
    Este método funciona semelhante como o método anterior, porém ao invés de imprimir todos os atributos
    de cada um dos jogos como o método toString(), ele irá apenas imprimir o nome de cada um dos jogos do ArrayList
    utilizando o método getNome()
    */

    public static void gerarJogosNomes() throws InterruptedException {
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

    public static void encontrarMaiorDiferenca(ArrayList<JogoDigital> jogos) {
        int n = jogos.size(); //declara a variável que segue o tamanho da lista
        double maiorDiferenca = 0; // essa variável será usada para armazenar a maior diferença entre as porcentagens
        int indexJogoMaiorPorcentagem = 0; // declara como variável o jogo com maior porcentagem
        int indexJogoMenorPorcentagem = 0; // declara como variável o jogo com menor porcentagem
        /*
        * essa variável abaixo se inicia com valor máximo pois será utilizada na verificação de se a 
        * porcentagem é menor que a variável presente até então
        */
        double menorPorcentagem = Double.MAX_VALUE; 

        /*
        * O conjunto de loops irão percorrer sobre todos os possíveis trios de jogos presentes na lista.
        * O primeiro loop itera sobre o primeiro jogo, o seguinte itera o segundo e o último intera sobre o terceiro.
        */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    /*
                    * verificação se os jogos iterados são diferentes uns dos outros
                    */
                    if (i != j && i != k && j != k) {
                        /*
                        * são calculadas as porcentagens de cada um dos 3 jogos
                        */
                        double porcentagemI = 100 * ((double) jogos.get(i).getAvaliacoesPositivas() / jogos.get(i).getUnidadesVendidas());
                        double porcentagemJ = 100 * ((double) jogos.get(j).getAvaliacoesPositivas() / jogos.get(j).getUnidadesVendidas());
                        double porcentagemK = 100 * ((double) jogos.get(k).getAvaliacoesPositivas() / jogos.get(k).getUnidadesVendidas());
                        /*
                        * são calculadas as diferenças das porcentagens de cada um dos 3 jogos
                        */
                        double diferencaIJ = Math.abs(porcentagemI - porcentagemJ);
                        double diferencaIK = Math.abs(porcentagemI - porcentagemK);
                        double diferencaJK = Math.abs(porcentagemJ - porcentagemK);
                        /*
                        * A maior diferença entre as três diferenças é dada pela variável abaixo maiorDif
                        */
                        double maiorDif = Math.max(diferencaIJ, Math.max(diferencaIK, diferencaJK));
                        /*
                        * Se a maior diferença encontrada for maior que a maior diferença encontrada até então
                        * a variável maiorDiferenca será atualizada pelo valor da variável maiorDif. Em seguida, a variável
                        * indexJogoMaiorPorcentagem é atualizada com o índice do jogo que possuiu a maior diferença dentro do calculo
                        */
                        if (maiorDif > maiorDiferenca) {
                            maiorDiferenca = maiorDif;
                            indexJogoMaiorPorcentagem = porcentagemI > porcentagemJ ? i : j;
                            indexJogoMaiorPorcentagem = porcentagemK > porcentagemI && porcentagemK > porcentagemJ ? k : indexJogoMaiorPorcentagem;
                        }
                        /*
                        * Da mesma forma, uma variável menorDif é criada e seu valor é dado com base na menor porcentagem encontrada
                        * e se a menor porcentagem atual encontrada for menor que a porcentagem armazenada até então, na variável menorPorcentagem
                        * a variável menorPorcentagem é atualizada para o valor da menor porcentagem encotnrada (menorDif) e o valor de indexJogoMenorPorcentagem
                        * também é atualizada com o índice do jogo que possuiu essa menor porcentagem
                        */
                        double menorDif = Math.min(porcentagemI, Math.min(porcentagemJ, porcentagemK));
                        if (menorDif < menorPorcentagem) {
                            menorPorcentagem = menorDif;
                            indexJogoMenorPorcentagem = porcentagemI < porcentagemJ ? i : j;
                            indexJogoMenorPorcentagem = porcentagemK < porcentagemI && porcentagemK < porcentagemJ ? k : indexJogoMenorPorcentagem;
                        }
                    }
                }
            }
        }

        /*
        * Por fim são impressos os valores do jogo com maior porcentagem, de menor porcentagem e diferença 
        * do valor das porcentagens de avaliações positivas entre entre eles
        */
        System.out.println("Jogo com maior porcentagem de avaliações positivas: " + jogos.get(indexJogoMaiorPorcentagem).getNome());
        System.out.println("Jogo com menor porcentagem de avaliações positivas: " + jogos.get(indexJogoMenorPorcentagem).getNome());
        System.out.println("Maior diferença entre as porcentagens de avaliações positivas dos jogos: " + maiorDiferenca);
    }

    /*
    * Este método irá ordenar e imprimir os jogos com base no valor de preço dos mesmos de forma crescente. 
    * Ele irá percorrer a lista de jogos utilizando dois loops e irá comparar o valor do primeiro jogo com o preço do segundo. 
    * O primeiro loop irá interar o primeiro jogo e o segundo irá interar o segundo jogo, os loops são criados garantindo que não
    * serão comparados jogos repetidos. Se o valor do segundo jogo for maior do que o valor do primeiro, o valor do primeiro 
    * jogo será armazenado  em uma variável chamada temp. O valor do primeiro jogo passará a ser o valor do segundo, 
    * ocupando seu lugar na lista e o valor do segundo jogo iterado receberá o valor da variável que armazenou o valor do primeiro jogo
    * ocupando o lugar do segundo jogo e consequentemente, descendo de posição na lista. 
    */
    
    public static void ordenarLeituras(ArrayList<JogoDigital> jogos) throws InterruptedException {

        for (int i = 0; i < jogos.size(); i++) {
            for (int j = i + 1; j < jogos.size(); j++) {
                if (jogos.get(i).getPreco() > jogos.get(j).getPreco()) {
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
    * Este método estático tem como função imprimir os visuais que serão usados pelo usuário, representando o front-end
    * Logo em seu início esse método irá realizar o método gerarModelosAleatórios() que realizará a função detalhada anteriormente.
    * O método terá variáveis de char para a funcionalidade das opções requisitadas pelo usuário sob função de um switch case simples
    * e uma variável booleana de ligado que irá definir o funcionamento do sistema se está "ligado" ou "desligado" em função de um do while simples
    */

    public static void menu() throws InterruptedException {

        System.out.println("-----------------------------------------------------");
        System.out.println("----------------BEM-VINDO À NOSSA LOJA---------------");
        System.out.println("-----------------------------------------------------\n");
        gerarModelosAleatorios();

        char opcao;
        boolean ligado = true;
        do {
            System.out.println("\n##### SELECIONE QUAL FUNÇÃO DESEJA REALIZAR #####");
            System.out.println("\n[A] - IMPRIMIR A LISTA DE JOGOS");
            System.out.println("[B] - IMPRIMIR A LISTA COM OS VALORES DOS JOGOS");
            System.out.println("[C] - IMPRIMIR A LISTA DE JOGOS DE ORDENADA DE FORMA CRESCENTE");
            System.out.println("[D] - CALCULAR A MAIOR DIFERÊNÇA ENTRE PORCENTAGENS DE AVALIAÇÕES POSITIVAS");
            System.out.println("[E] - SAIR");
            opcao = entrada.nextLine().charAt(0);
            char opcaoUpperCase = Character.toUpperCase(opcao);

            switch (opcaoUpperCase) {
                case 'A':
                    gerarJogosNomes();
                    break;
                case 'B':
                    gerarLeituras();
                    break;
                case 'C':
                    ordenarLeituras(jogos);
                    break;
                case 'D':
                    encontrarMaiorDiferenca(jogos);
                    break;
                case 'E':
                    ligado = false;
                    break;
            }

        } while (ligado);
    }
}
