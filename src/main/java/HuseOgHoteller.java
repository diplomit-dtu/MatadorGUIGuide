import gui_fields.GUI_Street;
import gui_main.GUI;

public class HuseOgHoteller {

    public static void main(String[] args) {

        GUI gui = new GUI();

        // Sætter 2 huse på Rødovrevej
        ((GUI_Street) gui.getFields()[1]).setHouses(2);

        // Sætter hotel på Hvidovrevej
        ((GUI_Street) gui.getFields()[3]).setHotel(true);

        // Sætter 3 huse på Roskildevej og fjerner dem igen
        ((GUI_Street) gui.getFields()[6]).setHouses(3);
        ((GUI_Street) gui.getFields()[6]).setHouses(0);

        // Sætter 3 huse på Valby Langgade, men ændrer det til et hotel
        ((GUI_Street) gui.getFields()[8]).setHouses(3);
        ((GUI_Street) gui.getFields()[8]).setHotel(true);

        // Sætter hotel på Allégade, men fjerner det igen
        ((GUI_Street) gui.getFields()[9]).setHotel(true);
        ((GUI_Street) gui.getFields()[9]).setHotel(false);
    }

}
