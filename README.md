# 📱 Android

Dieses Repository begleitet mich auf meinem Weg durch den offiziellen Android-Kurs [Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course).

Der Kurs richtet sich an Einsteiger in die Android-Entwicklung und vermittelt die Grundlagen moderner UI-Entwicklung mit **Jetpack Compose**.
In mehreren Projekten und Code-Labs werden Schritt für Schritt wichtige Konzepte wie UI-Komposition, Themes, Layouts und Navigation erarbeitet.

## 🚀 Ziel des Repositories ist es:
- Die einzelnen Projekte des Kurses zu dokumentieren
- Meinen Fortschritt festzuhalten
- Best Practices für Clean Code und UI-Design zu üben

---

## 📂 Projektübersicht
  - [Unit 1](#unit-1)
  - [Unit 2](#unit-2)
  - [Unit 3](#unit-3)

---

### <u>_UNIT 1_</u>

<br>

<table>

  <tr>
    <th>Projektname</th>
    <th>Beschreibung</th>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🔨 Tutorial</strong></td>
  </tr>
  <tr>
    <td><a href="./unit_1/helloandroid/">Hello Android</a></td>
    <td>
      Mein Einstieg in Jetpack Compose - basierend auf dem offiziellen "GreetingApp"-Projekt
    </td>
  </tr>
  <tr>
    <td><a href="./unit_1/HappyBirthday/">Happy Birthday Card</a></td>
    <td>
      Mein zweites Projekt in Jetpack Compose.
      Eine Geburtstagskarte mit Text und einem Hintergrundbild.
    </td>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🔧 Praxis</strong></td>
  </tr>
  <tr>
    <td>
      <a href="./unit_1/JetpackComposeTutorial/">Compose Article</a>
    </td>
    <td>
      Ein einfaches Projekt zur Darstellung eines Artikels mit Text und Bild, unter Einsatz von 
      <code>Column</code>, 
      <code>Image</code>, 
      <code>Text</code> und 
      <code>Modifier</code>. 
      <br><br>
      Schwerpunkt: <strong>Layouts, Padding, Textfluss</strong>
    </td>
  </tr>
  <tr>
    <td><a href="./unit_1/TaskManager/">Task Manager</a></td>
    <td>
      UI für eine To-do-App mit Fokus auf klare Struktur und visuelles Feedback.
      <br><br>
      Schwerpunkt: <strong>Image + Text-Kombination, Zentrierung, Semantische Struktur</strong>
    </td>
  </tr>
  <tr>
    <td><a href="./unit_1/Composequadrant/">Compose Quadrant</a></td>
    <td>
      Vier gleich große UI-Abschnitte mit je einer kurzen Beschreibung.
      <br><br>
      Schwerpunkt: 
      <strong>
        Grid-Struktur, 
      </strong>
        Verwendung von 
        <code>Row</code> und 
        <code>Column</code>, 
        gleichmäßige Verteilung mit 
        <code>weight</code>
    </td>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🛠️ Eigene Umsetzungen</strong></td>
  </tr>
  <tr>
    <td><a href="./unit_1/BusinessCardApp/">Business Card App</a></td>
    <td>
      Die
      <strong>
        Business Card App
      </strong>
      zeigt ein persönliches Profil im modernen Design mit 
      <strong>
        Bild, Name, Titel und Kontaktdaten
      </strong>
       - umgesetzt mit 
      <strong>
        Jetpack Compose
      </strong>.
      <br><br>
      Schwerpunkte & Learnings: 
      Verwendung von 
      <strong>
        <i>Compose UI-Komponenten</i> 
      </strong>
      wie
      <code>Box</code>, 
      <code>Column</code>, 
      <code>Image</code>, 
      <code>Text</code> 
      etc.
      <strong>
        Erstellung 
      </strong>
      eines eigenen 
      <strong>
        <i>Shapes</i>
      </strong>
      mit 
      <code>GenericShape</code> und 
      <code>cubicTo</code>.
      <strong>
        Anwendung
      </strong>
      von <code>Brush.linearGradient()</code> zur 
      <strong>
        Gestaltung eines sanften Farbverlaufs.
      </strong>
      <strong>
        Vertiefung
      </strong>
      der Nutzung von 
      <code>Box</code>-Komponenten & 
      <strong>
        Layout-Verständnis
      </strong>
    </td>
  </tr>

</table>


[⬆️](#-projektübersicht)

---

### <u>_UNIT 2_</u>

<br>

<table>

  <tr>
    <th>Projektname</th>
    <th>Beschreibung</th>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🔨 Tutorial</strong></td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/DiceRoller/">Dice Roller</a>
    </td>
    <td>
      Ziel dieser App ist es, eine einfache <strong>Würfel-App</strong> zu bauen, bei der durch einen Button-Klick ein Würfelwurf simuliert wird und ein entsprechendes Bild angezeigt wird.
      <br><br>
      Verwendung von <code>@Composable</code>-Funktionen
      <br>
      Umgang mit <strong>Zustandsverwaltung (State)</strong> mittels <code>remember</code> und <code>mutableStateOf</code>
      <br>
      Verwendung von <code>Image</code> mit Ressourcen aus <code>drawable</code>
      <br>
      UI-Aufbau mit <code>Column</code>, <code>Button</code> und <code>Modifier</code>
      <br>
      Dynamisches Aktualisieren der UI durch Zustandsänderungen
      <br>
      Einsatz von Material Design Komponenten
    </td>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🔧 Praxis</strong></td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/Lemonade/">Lemonade</a>
    </td>
    <td>
      Ein interaktives Lernprojekt mit Jetpack Compose: Nutzer klicken sich durch vier Phasen der Limonadenherstellung. Zum Üben von <strong>States</strong>, <strong>Click-Events</strong> und <strong>UI-Wechseln</strong>.
    </td>
  </tr>
  
  <tr>
    <td colspan="2" align="center"><strong>🛠️ Eigene Umsetzungen</strong></td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#temperature-converter">Temperature Converter</a>
    </td>
    <td>
      Konvertiere Temperaturangaben mithilfe einer übergebenen Lambda-Funktion:
      <br>
      <i>Celsius → Fahrenheit, Kelvin → Celsius, Fahrenheit → Kelvin</i>
      <br>
      Schwerpunkt:
      <strong>Höherordentliche Funktionen</strong>, 
      <strong>Lambda</strong>, 
      <strong>Typisierung</strong>, 
      <strong>String-Formatierung</strong>.
    </td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#mobile-notifications">Mobile Notifications</a>
    </td>
    <td>
      Zeige die Anzahl an Benachrichtigungen an:
      <br>
      <i>Bis 99: konkrete Zahl</i>
      <br>
      <i>Ab 100: „99+“</i>
      <br>
      Schwerpunkt: 
      <strong>if/else</strong>, 
      <strong>Vergleichsoperatoren</strong>, 
      <strong>einfache Ausgabelogik</strong>.
    </td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#internet-profile">Internet Profile</a>
    </td>
    <td>
      Beschreibe ein Profil inklusive optionalem Referrer:
      <br>
      <i>Nullprüfung mit <code>?.let</code> und Elvis-Operator</i>
      <br>
      <i>Dynamische Beschreibung mit verschachtelter Logik</i>
      <br>
      Schwerpunkt:
      <strong>Nullable Types</strong>, 
      <strong>Optionales Verhalten</strong>, 
      <strong>Smart Casts</strong>, 
      <strong>Lesbarkeit & Formatierung</strong>.
    </td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#movie-ticket-price">Movie Ticket Price</a>
    </td>
    <td>
      Berechne Ticketpreise abhängig vom Alter:
      <br>
      <i>Kinder ≤ 12: $15</i>
      <br>
      <i>Erwachsene 13–60: $30 (Mo: $25)</i>
      <br>
      <i>Senioren ≥ 61: $20</i>
      <br>
      Außerhalb des Bereichs: Rückgabe <code>-1</code>
      <br>
      Schwerpunkt: 
      <strong>when</strong>, 
      <strong>if</strong>, 
      <strong>Datum / Wochentag</strong>, 
      <strong>Kontrollfluss</strong>.
    </td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#foldable-phones">Foldable Phones</a>
    </td>
    <td>
      Simuliere ein faltbares Handy mit Vererbung:
      <br>
      <i>Bildschirm kann nur eingeschaltet werden, wenn Gerät entfaltet ist</i>
      <br>
      Schwerpunkt:
      <strong>Vererbung</strong>, 
      <strong>Methodenüberschreibung</strong>, 
      <strong>Zustandsänderung</strong>, 
      <strong>Encapsulation</strong>.
    </td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#song-catalog">Song Catalog</a>
    </td>
    <td>
      Datenklasse für Songs inkl. Beliebtheitslogik:
      <br>
      <i>Ab 1000 Plays: Song ist populär</i>
      <br>
      <i>Ausgabe via <code>toString()</code></i>
      <br>
      Schwerpunkt:
      <strong>Klassen & Properties</strong>, 
      <strong>Custom Setter</strong>, 
      <strong>Override</strong>, 
      <strong>Zustandslogik</strong>.
    </td>
  </tr>
  <tr>
    <td>
      <a href="./unit_2/KotlinFundamentals#special-auction">Special Auction</a>
    </td>
    <td>
      Berechne Auktionspreis anhand Gebot oder Mindestpreis:
      <br>
      <i>Kein Gebot? → „Auction House“ & Mindestpreis</i>
      <br>
      Schwerpunkt:
      <strong>Nullable Objekte</strong>, 
      <strong>höherordentliche Funktionen</strong>, 
      <strong>Fallback-Logik</strong>.
    </td>
  </tr>

</table>


[⬆️](#-projektübersicht)

---

### <u>_UNIT 3_</u>

<br>

<table>

  <tr>
    <th>Projektname</th>
    <th>Beschreibung</th>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🔨 Tutorial</strong></td>
  </tr>

  <tr>
    <td colspan="2" align="center"><strong>🔧 Praxis</strong></td>
  </tr>
  
  <tr>
    <td colspan="2" align="center"><strong>🛠️ Eigene Umsetzungen</strong></td>
  </tr>

</table>


[⬆️](#-projektübersicht)

---
📌 Weitere Projekte folgen entsprechend der Kursabschnitte.

