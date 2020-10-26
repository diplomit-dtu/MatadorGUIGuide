# Guide til Matador GUI
Dette er en import- og brugsguide til [Matador GUI'en](https://github.com/diplom-dtu/Matador_GUI), der benyttes til CDIO projekterne på første semester.


# Import
Matador GUI'en er et _Maven_ bibliotek (dependency), der ligger online og benyttes i et vilkårlig maven projekt

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
    

 5. __Du er nu klar til at bruge Matador GUI'en!__


# Brug af GUI
