import gui_fields.GUI_Ownable;
import gui_main.GUI;

public class Ejendomme {

    public static void main(String[] args) {

        GUI gui = new GUI();

        // Sætter Albert som ejeren på Øresund-redderiet
        ((GUI_Ownable) gui.getFields()[5]).setOwnerName("Albert");

        // Sætter lejen af Øresunds redderiet til 1000
        ((GUI_Ownable) gui.getFields()[5]).setRent("1000");

        // Ændrer prisen for Rødovrevej til 500,-
        ((GUI_Ownable) gui.getFields()[1]).setSubText("Pris: 500,-");

    }
}
