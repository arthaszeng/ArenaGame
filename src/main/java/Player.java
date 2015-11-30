
public class Player {
    private int attact;
    private int bloodflow;
    private String name;

    public Player(String name ,int att,int blo) {
        this.attact = att;
        this.bloodflow = blo;
        this.name = name;
    }


    public String attack(Player AttackedPlayer) {
        AttackedPlayer.bloodflow -= this.attact;
        String result = "";
        result += this.name + " attacked " + AttackedPlayer.name +" " + this.attact + " blood!";
        return result;
    }

    public boolean isAlive() {
        return this.bloodflow > 0 ? true : false;
    }
}
