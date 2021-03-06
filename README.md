# SeleniumExercise

## Opis:

SeleniumExercise jest to repozytorium z testami automatycznymi. Jeden z nich sprawdza poprawność wykonania metody, której zadaniem jest zwrócenie liczb parzystych w postaci ArrayList<Integer>. Pozostałe testy sprawdzają kilka funkcjonalności aplikacji My Store dostępnej pod adresem http://automationpractice.com/index.php. M.in. są to:
```
- rejestracja użytkownika,
- logowanie,
- dodawanie produktu do koszyka używając opcji "Quick view".
```
 
Testy automatyczne korzystają m.in. z poniższych bibliotek:
```
- Selenium v.4.1.2,
- TestNG v.7.5,
- ReportNG v.1.1.4,
- Log4j 1.2.17.
```

Podczas implementacji testów automatycznych został użyty wzorzec Page Object Model.
 
## Wymagania:
JDK8, maven.
 
## Uruchomienie testów:

Do zbudowania projektu należy użyc polecenia:
```
mvn clean install -DskipTests
```
 
Aby uruchomić test sprawdzający poprawność wykonania metody zwracającej liczby parzyste w postaci ArrayList<Integer> można użyć polecenia:
 ```
mvn test -DsuiteFile=exercise1.xml
```
 
Aby uruchomić pozostałe testy sprawdzające GUI aplikacji My Store można użyć poniższych poleceń. Parametr `browser` wyznacza przeglądarke na której zostanie wykonany test(domyślnie jest to przeglądarka Chrome).
```
mvn test -DsuiteFile=exercise2.xml
mvn test -DsuiteFile=exercise2.xml -Dbrowser=chrome
mvn test -DsuiteFile=exercise2.xml -Dbrowser=firefox
mvn test -DsuiteFile=exercise2.xml -Dbrowser=edge
```
 
Do uruchomienia wszystkich testów w tym repozytorium można użyć polecenia:
```
mvn test
```
 
 ## Pozostałe informacje:
 
 Testy korzystają z biblioteki `ReportNG`. Po wykonaniu testów w lokalizacji `.\target\surefire-reports` znajduje się raport w postaci plików HTML oraz XML.
 
 Jeśli test nie wykona się poprawnie to zostanie wykonany zrzut ekranu. Screenshoty dostępne są w lokalizacji `.\target\screenshots`.
 
 W projekcie zastosowana została biblioteka`Log4j`. Za jej pośrednictwem logowane są zdarzenia i zapisywane w lokalizacji `.\logs`.
