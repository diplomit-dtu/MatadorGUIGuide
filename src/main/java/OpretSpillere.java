import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class OpretSpillere {

    public static void main(String[] args) {
        GUI gui = new GUI();

        // Opretter simpel spiller
        GUI_Player player1 = new GUI_Player("Albert");
        gui.addPlayer(player1);

        // Opretter spiller med specifik balance
        GUI_Player player2 = new GUI_Player("Stephen", 5000);
        gui.addPlayer(player2);

        // Opretter spiller med speciel-bil (hvid ufo med røde prikker)
        GUI_Car player3Car = new GUI_Car(Color.WHITE, Color.RED, GUI_Car.Type.UFO, GUI_Car.Pattern.DOTTED);
        GUI_Player player3 = new GUI_Player("John", 3000, player3Car);
        gui.addPlayer(player3);

        // Sætter Alberts bil på start-feltet
        gui.getFields()[0].setCar(player1, true);

        // Sætter Stephens bil på felt 3, men rykker den til felt 4
        gui.getFields()[2].setCar(player2, true);
        gui.getFields()[3].setCar(player2, true);
        // Bemærk: så er Stephens bil der to gange

        // Sætter Johns bil på felt 10, men rykker den til felt 11
        gui.getFields()[9].setCar(player3, true);
        gui.getFields()[9].setCar(player3, false); // Fjerner bilen fra felt 9
        gui.getFields()[10].setCar(player3, true);
        // Bemærk: Johns bil er der kun én gang, fordi vi huskede at fjerne bilen
        // fra felt 9, inden vi sat den på felt 10

    }

}
