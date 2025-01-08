# Programowanie aplikacji mobilnych

## Tabelka

| Data | dir | zadanie |
| --- | --- | --- |
| 11.09.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.09.11) | [zadanie](#zadanie-11092024) |
| 18.09.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.09.18) | [zadanie](#zadanie-18092024) |
| 09.10.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.10.09) | [zadanie](#zadanie-09102024) |
| 16.10.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.10.16) | [zadanie](#zadanie-16102024) |
| 23.10.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.10.23) | [zadanie](#zadanie-23102024) |
| 23.10.2024 | [link2](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.10.23a) |[zadanie](#zadanie-23102024) |
| 30.10.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.10.30) | [zadanie](#zadanie-30102024) |
| 06.11.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.11.06) | [zadanie](#zadanie-06112024) |
| 13.11.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.11.13) | [zadanie](#zadanie-13112024) |
| 20.11.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.11.20) | [zadanie](#zadanie-20112024) |
| 27.11.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.11.27) | [zadanie](#zadanie-27112024) |
| 11.12.2024 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2024.12.11) | [zadanie](#zadanie-11122024) |
| 08.01.2025 | [link](https://github.com/Kartonowy/coffee_and_cigarettes/tree/main/2025.01.08) | [zadanie](#zadanie-08012024) |

## Zadania

### Zadanie 11.09.2024

clueless

### Zadanie 18.09.2024

https://cke.gov.pl/egzamin-maturalny/egzamin-maturalny-w-formule-2015/arkusze/2022-2/
Informatyka - poziom rozszerzony. Arkusz 2; zadanie 4
 
### Zadanie 09.10.2024

https://www.testy.egzaminzawodowy.info/arkusz-20154-kwalifikacja-inf4-styczen-2022-zadanie-1
 
Zadanie z Adroida, tylko wygląd

### Zadanie 16.10.2024

Sprawdzić różne typy layoutów (ułożenia elementów na różnych typach layoutu).
Na Githuba wrzucić pliki XML z różnymi layoutami.

### Zadanie 23.10.2024

Zadanie 23.10
Wykonać długi formularz (nie mieszczący się na jednym ekranie, wymagający scrolla). Temat formularza dowolny.

Przygotujcie 4 widoki w XML.
Widok 1: Formularz logowania z wykorzystaniem Grid Layout
Widok 2: Formularz rejestracji z wykorzystaniem Grid Layout
Widok 3: Formularz logowania z wykorzystaniem Table Layout
Widok 4: Formularz rejestracji z wykorzystaniem Table Layout

### Zadanie 30.10.2024

Przygotuj arkusz stylów (minimum 3 style). Wykorzystaj style w kilku komponentach.

### Zadanie 06.11.2024

Przygotuj prostą aplikację w LinearLeayout (vertical).
Aplikacja powinna zawierać formularz z minimum 3 polami edycyjnymi, radio buttonami oraz checkboxem, a także minimum 2 przyciski.
Przetestuj aplikację na różnych tematach (themes). Wbudowane tematy znajdziesz w pliku: https://android.googlesource.com/platform/frameworks/base/+/refs/heads/master/core/res/res/values/themes.xml

### Zadanie 13.11.2024
Przygotuj prostą aplikację w Android.
Aplikacja składa się z następujących elementów
- pole edycyjne [1]
- przycisk [2]
- pole tekstowe [3]
- pole edycyjne [4]
- przycisk [5]
Po kliknięciu w przycisk oznaczony [2] pole tekstowe oznaczone [3] zostaje wypełnione tekstem wpisanym w pole edycyjne oznaczone [1]. Użyj onClick w XML
Po kliknięciu w przycisk oznaczony [5] zostaje wyświetlony Toast zawierający treść wpisaną w pole edycyjne oznaczone [4]. Użyj event listenera.
 
 

### Zadanie 20.11.2024

https://www.testy.egzaminzawodowy.info/arkusz-20154-kwalifikacja-inf4-styczen-2022-zadanie-1
 
Zadanie Android (tym razem całe)
 
### Zadanie 27.11.2024

Wykonaj kopię zadania z poprzedniej lekcji.
Wprowadź następujące zmiany:
- Utwórz nową aktywność
- Utwórz widok z dużym tekstem "Witamy w aplikacji" oraz małym tekstem "Zalogowano jako <email>, a także przyciskiem "Wyloguj"
- Po kliknięciu w przycisk "Zatwierdź"  przenieś użytkownika do nowej aktywności
- Do aktywności przekaż adres e-mail wpisany przez użytkownika
- Przed przeniesieniem sprawdź czy adres e-mail jest poprawny (regex) oraz czy hasło spełnia poniższe założenia:
    - minimum 8 znaków
    - minimum jedna cyfra
    - minimum jedna wielka litera
    - minimum jedna mała litera
    W przypadki błędów walidacji wyświetl informację czerwonym tekstem w miejscu tekstu "Witaj <email>"
- Kliknięcie przycisku "Wyloguj" przenosi do pierwszej aktywności

### Zadanie 27.11.2024

Przygotuj nową aplikację bazującą na Empty Views Activity.
Przygotuj dwa fragmenty.
Fragment 1:
Formularz z trzema polami:
- adres e-mail
- imię
- nazwisko
oraz przyciskiem

Fragment 2:
Dane podane na pierwszym fragmencie z labelami.
 
Działanie aplikacji:
Po załadowaniu wyświetlany jest fragment 1. Po kliknięciu przycisku na pierwszym fragmencie aplikacja sprawdza czy pola nie są puste oraz czy adres e-mail jest poprawny. W przypadku poprawnych danych ekran jest zmieniany na fragment 2 z uzupełnionymi danymi.

### Zadanie 8.01.2025

https://egzamin.it/Formula%202019/inf_04/2024/inf_04_2024_01_02_SG/

Zadanie z Androida + dodać powiadomienie o treści imię i nazwisko właściciela, gatunek, wiek, cel wizyty, czas zgodnie z założeniami tekstu wyświetlanego w zadaniu egzaminacyjnym pod formularzem.
Index of /Formula 2019/inf_04/2024/inf_04_2024_01_02_SG

