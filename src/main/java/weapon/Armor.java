package weapon;

public class Armor {
    private String name;
    private int defense;
    private String charactor;
    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
            return name;
        }

    public int getDefense() {
            return defense;
        }
 }

