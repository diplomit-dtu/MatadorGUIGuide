import gui_codebehind.GUI_FieldFactory;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class BrugerdefineretBraet {

    public static void main(String[] args) {

        // Laver array
        GUI_Field[] fields = new GUI_Field[16];

        // Laver orange startfelt
        fields[0] = new GUI_Start("Start", "", "Her starter du", Color.ORANGE, Color.WHITE);

        // Fylder resten af feltenre ud med veje
        for( int i=1; i<16; i++){
            if( i%2 == 0 )
                fields[i] = new GUI_Street(
                        "Street " + i,
                        "Price: " + (i*50),
                        "This is a street",
                        "100",
                        Color.PINK,
                        Color.WHITE
                );
            else
                fields[i] = new GUI_Street(
                        "Street " + i,
                        "Price: " + (i*100),
                        "This is a street",
                        "50",
                        Color.BLUE,
                        Color.WHITE
                );
        }

        GUI gui = new GUI(fields);
    }

}
