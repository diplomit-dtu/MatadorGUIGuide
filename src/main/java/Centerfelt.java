import gui_main.GUI;

public class Centerfelt {

    public static void main(String[] args) {
        GUI gui = new GUI();

        while(true){
            String choice = gui.getUserButtonPressed(
                    "Hvad skal der ske med centerfeltet?",
                    "Sæt teksten",
                         "Vis tekst",
                        "Sæt teksten og vis"
            );

            if( choice.equals("Sæt teksten") )
                gui.setChanceCard(gui.getUserString("Indtast en tekst"));

            if( choice.equals("Vis tekst") )
                gui.displayChanceCard();

            if( choice.equals("Sæt teksten og vis") )
                gui.displayChanceCard(gui.getUserString("Indtast en tekst"));
        }
    }

}
