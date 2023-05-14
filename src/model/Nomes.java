package model;

/**
 *
 * @author Leonardo
 */
public enum Nomes {

    /*
    * Classe enum responsável por amarzenar elementos que contém
    * ID e nome para algum possível objeto jogo da classe JogoDigital.
    *  */

    AGE_OF_MYTHOLOGY(0, "Age of Mythology"),
    COUNTER_STRIKE(1, "Counter Strike: Global Offensive"),
    CUPHEAD(2, "Cuphead"),
    DARK_SOULS_III(3, "Dark Souls III"),
    DEAD_CELLS(4, "Dead Cells"),
    ELDEN_RING(5, "Elden Ring"),
    FALLOUT_4(6, "Fallout 4"),
    GRAND_THEFT_AUTO_V(7, "Grand Theft Auto V"),
    HOLLOW_KNIGHT(8, "Hollow Knight"),
    HOTLINE_MIAMI(9, "Hotline Miami"),
    MORTAL_KOMBAT_X(10, "Mortal Kombat X"),
    PATHOLOGIC_2(11, "Pathologic 2"),
    PLANTS_VS_ZOMBIES(12, "Plants vs. Zombies"),
    PUBG(13, "PlayerUnknown's Battlegrounds"),
    RESIDENT_EVIT_2_REMAKE(14, "Resident Evil 2 Remake"),
    SEKIRO(15, "Sekiro: Shadows Die Twice"),
    SUBNAUTICA(16, "Subnautica"),
    SUNSET_OVERDRIVE(17, "Sunset Overdrive"),
    TERRARIA(18, "Terraria"),
    THE_WITCHER_3(19, "The Witcher 3: Wild Hunt");

    private final String name;
    private final int id;

    Nomes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    /*
    * Método que tem complexidade linear, pois percorre todos os elementos do Enum 'Nomes
    * em um loop que verifica se o ID dado corresponde ao ID de cada nome de jogo no Enum.
    * A complexidade aumenta proporcionalmente ao número de elementos no enum. O método retorna
    * a string do atributo name do elemento no enum se o ID fornecido bater ao respectivo elemento.
    */
    public static String getNomeById(int id) {
        for (Nomes jogo : Nomes.values()) {
            if (jogo.getId() == id) {
                return jogo.getName();
            }
        }
        return null;
    }

}