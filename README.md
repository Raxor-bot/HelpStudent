# HelpStudent
Zum Ausführen des Projektes kann ein lokales MySql Schema unter
dem Namen helpstudent angelegt werden oder der Name in der application.properties 
Datei zu einer bereits existierenden __leeren__ MySql Datenbank geändert werden um diese zu nutzen.
Der Nutzer der Datenbank ist der normale root Nutzer und

>Datenbank Namen hinter dem localhost:3306/ einfügen

spring.datasource.url=jdbc:mysql:// *localhost:3306/helpstudent* 

>Eigenes erstellten Nutzernamen einsetzen oder Nutzer mit Namen root verwenden

spring.datasource.username=root

>Eigenes erstelltes Passwort einsetzen oder Nutzer mit passwort root erstellen

spring.datasource.password=root
