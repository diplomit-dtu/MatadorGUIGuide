import gui_codebehind.GUI_Center;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class FeltInformation {

    public static void main(String[] args) {

        GUI gui = new GUI();

        // Ændrer titlen på "Gammel Kongevej"
        gui.getFields()[14].setTitle("Nye Kongevej");

        // Fjerner undertitlen på start-feltet
        gui.getFields()[0].setSubText("");

        // :ndrer undertitlen på det første skattefelt
        gui.getFields()[4].setSubText("0 i skat");

        // Ændrer farverne på det første prøv-lykken felt
        gui.getFields()[2].setForeGroundColor(Color.ORANGE);
        gui.getFields()[2].setBackGroundColor(Color.WHITE);

        // Ændrer beskrivelsen på det første "Gå i fængsel"-felt
        gui.getFields()[10].setDescription("Dette er min beskrivelse");
    }
}
