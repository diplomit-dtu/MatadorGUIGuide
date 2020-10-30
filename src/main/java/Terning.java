import gui_main.GUI;

public class Terning {


    public static void main(String[] args) {

        GUI gui = new GUI();

        while(true){
            // Tag i mod input fra brugeren
            String choice = gui.getUserButtonPressed("Tag et valg", "Slå med én terning", "Slå med to terninger");
            if( choice.equals("Slå med én terning") )
                gui.setDie(6); // Vis en terning med værdien 6
            if( choice.equals("Slå med to terninger") )
                gui.setDice(1, 2); // Vis to terninger med værdierne 1 og 2
        }
    }

}
