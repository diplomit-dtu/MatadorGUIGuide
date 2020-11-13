# Guide til Matador GUI 3.1.7

Dette er en import- og brugsguide til [Matador GUI'en](https://github.com/diplomit-dtu/Matador_GUI), der benyttes til CDIO projekterne på første semester.

__Eksekverbare eksempler__  
Repositoriet her er et projekt, der kan klones til IntelliJ, og indeholder forskellige eksekverbare eksempler på brugen af GUI'en i mappen `src/main/java`.

## Indhold
__[Import](#import)__  
__[Brug af GUI](#brug-af-gui)__
 - __[JavaDoc i IntelliJ](#javadoc-i-intellij)__
 - __[Start GUI](#start-gui)__  
 - __[Spillere](#spillere)__
   - __[Opret og tilføj](#opret-og-tilføj)__
   - __[Ændre balance/point](#ændre-balance/point)__
   - __[Placer bil](#placer-bil)__
   - __[Ryk bil](#ryk-bil)__
 - __[Bræt og felter](#bræt-og-felter)__
     - __[Tilgå felter](#tilgå-felter)__
     - __[Ændre feltinformationer](#ændre-feltinformationer)__
     - __[Ejendomme](#ejendomme)__
     - __[Huse og hoteller](#huse-og-hoteller)__
     - __[Brugerdefineret bræt](#brugerdefineret-bræt)__
 - __[Input og output](#input-og-output)__
     - __[Vis tekst](#vis-tekst)__
     - __[Vis terninger](#vis-terninger)__
     - __[Tag imod et valg](#tag-imod-et-valg)__
     - __[Tag imod tekst](#tag-imod-tekst)__
     - __[Tag imod tal](#tag-imod-tal)__
     - __[Boolsk-knap](#boolsk-knap)__
     - __[Tekst i centerfeltet](#tekst-i-centerfeltet)__


# Import
Matador GUI'en er et online og offentligt _Maven_ bibliotek (dependency), der kan benyttes i et vilkårlig Java-projekt:

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
    Biblioteket indsættes som et dependency ved at kopiere følgende ind i `pom.xml` i mellem `<project>` tagsene:

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

 ## JavaDoc i IntelliJ
 Udover denne guide medfølger der også JavaDoc af de vigtigste metoder i biblioteket. For at tilgå disse, skal du gøre følgende:
 
 1. Gå ind i én af klasserne fra biblioteket (`CTRL + Venstre-klik` på klassens navn).
 
 2. Tryk på `Download sources` i den blå bjælke i toppen af vinduet.
 
 3. Du har nu kildekoden til biblioteket, samt dokumentation af metoderne.
 
 4. Tilgå let dokumentation ved at trykke `CTRL + Q` i Windows og `CTRL + B` 
 på macOS, når du holder musen på en metode eller klasse.


## Start GUI
_Eksekverbart eksempel: `SimpelStart.java`_

For at starte GUI'en opretter man et instans af `GUI`-klassen: 

```java
GUI gui = new GUI();
```

Dette åbner et nyt vindue med en standard Matador-plade.

`GUI`-klassen er den primære klasse i biblioteket, og man opretter kun én per spil. Det er via denne klasse man kan tilføjer spillere, manipulere felter og tage imod inputs og vise outputs.


## Spillere
_Eksekverbart eksempel: `OpretSpillere.java`_

En spiller består af et _navn_, en _bil_ og en _balance_ (pengebeholdning/point).

### Opret og tilføj
Man tilføjer spillere ved at oprette instanser af `GUI_Player`-klassen, og tilføjer dem til `GUI`-objektet.

```java
// Opretter spiller med navnet Stephen og start balance på 2000
GUI_Player player = new GUI_Player("Stephen", 2000);

// Tilføjer ham til spillet
gui.addPlayer(player);
```

### Ændre balance/point
En spillers balance/point kan ændres ved at bruge metoden `setBalance(..)` på spillerobjektet.

```java
// Ændrer spillerens balance til 10000
player.setBalance(10000);
```

### Placér bil
En spillers bil/brik er ikke på brættet før den manuelt bliver placeret. Dette gøres ved at hente feltet vi ønsker at placere spilleren på (se '[Tilgå felter](#tilgå-felter)'), og benytter feltets `setCar`-metode.

```java
// Opretter spiller
GUI_Player player = new GUI_Player("Stephen", 2000);
gui.addPlayer(player);

// Henter feltet
GUI_Field field = gui.getFields()[4];

// Sæt bilen til at blive vist
field.setCar(player, true);
```


### Ryk bil
En spillers bil rykkes også med `setCar`-metoden. ___Men!___

En spillers bil kan vises på _flere felter af gangen_. Man skal derfor huske at fjerne spillerens bil fra det gamle felt, før den vises på det nye:


```java
GUI_Player player = new GUI_Player("Stephen", 2000);
gui.addPlayer(player);

// Sætter spillerens bil på felt 5 og 6
gui.getFields()[4].setCar(player, true);
gui.getFields()[5].setCar(player, true);
// Forkert: Nu vises spillerns bil på begge felter!

gui.getFields()[4].setCar(player, false);
// Sådan, nu er bilen fjernet fra felt 5
```

## Bræt og felter

### Tilgå felter
Man kan tilgå felterne på brættet ved at bruge `GUI`-objektets `getFields()`-metode. Den returnerer et _array_ af felterne, hvor indeks 0 er startfeltet.

```java
GUI_Field field;

// Tilgår start feltet
GUI_Field[] fields = gui.getFields();
field = fields[0];

// ... Eller i kortere version:
field = gui.getFields()[0];
```

### Ændre feltinformation
_Eksekverbart eksempel: `FeltInformation.java`_ 

Alle felter nedarver fra `GUI_Field` klassen og de har derfor nogle fælles metoder, man kan bruge til at ændre feltets informationer:

 - __Sæt navn:__  `field.setTitle("My title")`  
    Sætter navnet/titlen på feltet. Bemærk at dette ikke ændrer på navnet for en ejendomme, der vises i centerfeltet. Dette ændres med beskrivelsen. 

 - __Sæt undertitel:__ `field.setSubText("My subtext")`  
    Sætter undertitlen på feltet. Dette står i bunden af felterne, og under navnet når der klikkes på feltet. Bruges bl.a. til at vise prisen på ejendomme.

 - __Sæt beskrivelse:__ `field.setDescription("My description")`  
    Sætter beskrivelsen af et felt, der vises i centerfeltet, når der trykkes på feltet.

 - __Sæt tekstfarve:__ `field.setForegroundColor(Color.BLACK)`  
    Sætter tekstfarven for feltet.

 - __Sæt baggrundsfarve:__ `field.setBackgroundColor(Color.WHITE)`  
    Sætter baggrundsfarven for feltet.


### Ejendomme
_Eksekverbart eksempel: `Ejendomme.java`_ 

Ejendomme kendetegnes ved at de har en _pris_, en _ejer_ samt en _leje_, og nedarver fra klassen `GUI_Ownable`. Følgende felttyper er ejendomme:
 - Veje (`GUI_Street`)
 - Bryggerier (`GUI_Brewery`)
 - Rederier (`GUI_Shipping`)

Disse felttyper har nogle yderligere metoder til fælles, der kan tilgås ved at _caste_ et `GUI_Field` til et `GUI_Ownable`:

```java
// Cast felt til GUI_Ownable
GUI_Field field = gui.getFields()[1];
GUI_Ownable ownable = (GUI_Ownable) field;
```

De fælles metoder er:

 - __Sæt pris:__ `ownable.setSubText("Pris: 1000")`  
    Ejendomme benytter undertitlen til sin pris, og prisen kan derfor ændres med denne metode.

 - __Sæt ejer:__ `ownable.setOwnerName("Albert")`  
    Sætter navnet på spilleren, der ejer feltet. Brug `setOwnerName(null)` for at fjerne nuværende ejer.  
    Når et felt er ejet, vil der vises yderligere information om feltet i centerfeltet, når der trykkes på felter, såsom ejerens navn og leje.

 - __Sæt leje:__ `ownable.setRent("1000")`  
    Sætter lejen på feltet, som vises i centerfeltet, når der trykkes feltet, og feltet har en ejer.

 - __Sæt kantfarve:__ `ownable.setBorder(Color.GREEN)`  
    Dette kan eventuelt benyttes til at markere hvem der ejer et felt.
    


### Huse og hoteller
_Eksekverbart eksempel: `HuseOgHoteller.java`_ 

Veje, der har typen `GUI_Street` kan have huse eller et hotel på sig. For at tilgå dette, skal man _caste_ feltet til `GUI_Street`:

```java
// Caster felt 1 til GUI_Street
GUI_Field field = gui.getFields()[1];
GUI_Street street = (GUI_Street) field;
```

Nu kan man ændre antallet af huse og hoteller:

 - __Sæt huse:__ `street.setHouses(3)`  
   Der kan maks være 4 huse på en vej, og man kan fjerne husene ved at sætte antallet til 0.

 - __Sæt hotel:__ `street.setHotel(true)`  
    Der kan kun være ét hotel på en vej, og det kan fjernes ved at skrive `false` i stedet for `true`.
    

### Brugerdefineret bræt
_Eksekverbart eksempel: `BrugerdefineretBraet.java`_ 

Man kan selv vælge hvilke felter man ønsker på brættet ved at lave sit eget _array_ af felter og give det til `GUI`-konstruktøren: 

```java
// Laver ét af hvert felt 
GUI_Field[] fields = {
    new GUI_Start(),
    new GUI_Street(),
    new GUI_Chance(),
    new GUI_Jail(),
    new GUI_Shipping(),
    new GUI_Brewery(),
    new GUI_Refuge()
};

GUI gui = new GUI(fields);
```


## Input og output
_Eksekverbart eksempel: `InputOutput.java`_ 

Alle metoder der tager imod inputs og viser output har følgende tilfælles:
 - De ligger i GUI-objektet
 - De blokerer indtil brugeren har taget et valg eller trykket _Ok_


### Vis tekst
Man kan vise en tekstbesked til brugeren med metoden `showMessage(..)`. Teksten vises indtil brugeren trykker _OK_ 

```java
    gui.showMessage("Hello World");
```


### Vis terninger
_Eksekverbart eksempel: `Terning.java`_

Metoderne `setDie(..)` og `setDice(..)` viser hhv. én eller to terninger de med givne værdier.  Når terningen/terningerne sættes til nye værdier, fjernes de gamle.

```java
gui.setDie(6); // Viser én terning med værdien 6

gui.setDice(1, 2); // Viser to terninger med værdierne 1 og 2
```

### Tag imod et valg
Man kan bede brugere om at vælge mellem flere valgmuligheder med de to metoder:

 - __Knapper:__ `getUserButtonPressed(..)`  
    Beder brugeren om at trykke på én af de viste knapper:

    ```java
    String chosenButton = gui.getUserButtonPressed(
        "Click a button",
        "Button 1", "Button 2"
    );
    ```

 - __Dropdown-liste__: `getUserSelection(..)`  
    Beder brugeren om at vælge et element i en dropdown-liste:
    ```java
        String chosenElement = gui.getUserSelection(
            "Choose an element",
            "Element 1", "Element 2"
        ); 
    ```

__Fælles for begge metoder er at:__
 - Første argument er beskeden der skal vises til brugeren
 - Alle argumenter derefter er valgmuligheder (knapper/elementer)
 - Man kan angive så mange valgmuligheder man har lyst til, og de kan også angives via et array. Dette kaldes _variable arguments_ eller _varargs_ i Java
 - Returværdien er teksten på den valgte knap/element


### Tag imod tekst
Metoden `getUserString(..)` beder brugeren om at indtaste en vilkårlig tekststreng. 

```java
String stringInput = gui.getUserString("Enter some text");
```

Returværdien kan være en tom tekststreng, da brugeren kan undlade at indtaste noget.


### Tag imod tal
Metoden `getUserInteger(..)` beder brugeren om at indtaste en vilkårlig tal-værdi:

```java
int numberInput = gui.getUserInteger("Enter a number");
```

___OBS:___ Man kan angive en grænse for værdierne brugeren kan indtaste, men dette anbefales __ikke__ da der er en bug i metoden på nuværende tidspunkt.


### Boolsk-knap
Metoden `getUserLeftButtonPressed(..)` beder brugeren om at vælge én af to knapper, og returnerer en _boolean_ værdi i stedet for _string_:

```java
// En Ja/Nej-knap
boolean yes  = gui.getUserLeftButtonPressed(
    "Choose yes or no",
    "Yes", "No"
);
```

Returværdien er _true_ hvis den venstre knap ("Yes" i ovenstående tilfælde) vælges, og _false_ hvis den højre knap vælges.


### Tekst i centerfeltet
_Eksekverbart eksempel: `Centerfelt.java`_ 

Udover at centerfeltet bruges til at vise information om et felt der trykkes på, så kan det vise vilkårlig tekst. 
Her skal man være opmærksom på:

 - Standardteksten er '_Prøv lykken_'
 - Den nuværende tekst vises når der trykkes på centerfeltet
 - Den nuværende tekst skjules når musen fjernes fra centerfeltet
 - Teksten bevares medmindre den ændres manuelt

__Metoder__  
Man kan bruge følgende metoder for at ændre/vise teksten:

 - `gui.setChanceCard("My message")`  
   Sætter teksten i centerfelter til '_My message_'

 - `gui.displayChanceCard()`  
   Viser teksten der står i centerfeltet  

 - `gui.displayChanceCard("_My message_")`  
   Kombinere ovenstående, og sætter teksten til '_My message_' og viser teksten der står i centerfeltet.