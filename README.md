# Guide til Matador GUI
Dette er en import- og brugsguide til [Matador GUI'en](https://github.com/diplom-dtu/Matador_GUI), der benyttes til CDIO projekterne på første semester.

__Kørbare eksempler__  
Repositoriet her er et projekt, der kan klones til IntelliJ, og indeholder forskellige eksekverbare eksempler på brugen af GUI'en i mappen `src/main/java`.



# Import
Matador GUI'en er online og offentligt et _Maven_ bibliotek (dependency), der kan benyttes i et vilkårlig Java-projekt.

 1. __Opret Projekt__  
    Det forventes at dit projekt er et _Maven_-projekt

 2. __Forbind til bibliotekets repository__  
    Dette gøres ved at indsætte følgende i din `pom.xml` et sted mellem `<project>` tagsene:

    ```xml
    <repositories>
        <repository>
            <id>Matador_GUI-repository</id>
            <url>https://github.com/diplomit-dtu/Matador_GUI/raw/repository</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
    ```

 3. __Indsæt dependency__  
    Biblioteket indsættes som et dependency ved at kopere følgende ind i `pom.xml` i mellem `<project>` tagsene:

    ```xml
    <dependencies>
        <dependency>
            <groupId>diplomitdtu</groupId>
            <artifactId>matadorgui</artifactId>
            <version>3.1.7</version>
        </dependency>
    </dependencies>
    ``` 

 4. __Opdatér dit projekt__  
    Højre klik på `pom.xml` og tryk på `Maven → Reload project`
    

 6. __Test at det virker__  
    Kopiér følgende ind i en klasse der hedder `Main`, og kør programmet:

    ```java
    import gui_main.GUI;

    public class Main {
        public static void main(String[] args) {
            GUI gui = new GUI();
        }
    }
    ```

    Der skulle gerne vises et Matador-plade i et nyt vindue

 5. __Du er nu klar til at bruge Matador GUI'en!__


 ___Tip:___ _Du kan se et eksempel på hele opsætning i [pom.xml](pom.xml)-filen i dette projekt._


# Brug af GUI


## Indhold
 - __[Start GUI](#start-gui)__  
 - __[Tilføj spillere](#tilføj-spillere)__
   - __[Placer bil](#placer-bil)__
   - __[Ryk bil](#ryk-bil)__


## Start GUI
_Eksekverbart eksempel: `SimpelStart.java`_

For at starte GUI'en opretter man et instans af `GUI`-klassen: 

```java
GUI gui = new GUI();
```

Dette åbner et nyt vindue med en standard Matador-plade.

`GUI`-klassen er den primære klasse i biblioteket, og man opretter kun én per spil. Det er via denne klasse man kan tilføjer spillere, manipulere felter og tage imod inputs og viser outputs.


## Tilføj Spillere
_Eksekverbart eksempel: `OpretSpillere.java`_

Man tilføjer spillere ved at oprette instanser af `GUI_Player`-klassen, og tilføjer dem til `GUI`.

_Her tilføjes en spiller med navnet _Stephen_ med en start balance (point) på 2000:_

```java
GUI gui = new GUI();
GUI_Player player1 = new GUI_Player("Stephen", 2000);
gui.addPlayer(player1);
```


### Placér bil
En spillers bil/brik er ikke på brættet før den manuelt bliver placeret. Dette gøres ved at hente feltet vi ønsker at placere spilleren på, og benytte feltets `setCar`-metode.

_Her vises Stephens bil på felt 5:_
```java
GUI gui = new GUI();
GUI_Player player1 = new GUI_Player("Stephen", 2000);
gui.addPlayer(player1);

// Henter feltet
GUI_Field field = gui.getFields()[4];

// Sæt bilen til at blive vist
field.setCar(player1, true);
```


### Ryk bil
Et felts `setCar`-metode, styrer om en spillers bil skal ___vises___ på et felt, og en spillers bil kan vises på _flere felter af gangen_. Man skal derfor huske at fjerne spillerens bil fra det gamle felt, før den vises på det nye:


```java
GUI gui = new GUI();

GUI_Player player1 = new GUI_Player("Stephen", 2000);
gui.addPlayer(player1);

gui.getFields()[4].setCar(player1, true);
gui.getFields()[5].setCar(player1, true);
// Forkert: Nu vises spillerns bil både på felt 5 og 6!

gui.getFields()[4].setCar(player1, false);
// Sådan, nu er bilen fjernet fra felt 5
```






