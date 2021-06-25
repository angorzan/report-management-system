# report-management-system
![UML Diagram](./raport_godzin.svg)
 
## Start aplikacji

### Uruchom App.java, po otwarciu menu podaj ścieżkę do katalogu resources, tj.
```console
${ścieżkadoaplikacjinadysku}\report-management-system\src\test\resources\reporter-dane
```
### Uruchom bezpośrednio z konsoli, np. 
Docelowy wygląd menu:

```console
mvn package -Dmaven.test.skip=true
java -jar ${nazwapliku.jar} tutajSciezkaDanych
```

Witaj!

Wybierz opcje:
1. Generuj alfabetyczny raport godzin pracowników w danym roku (pytanie o rok - jakie lata, )
		a. Zakończ program
		b. Wróć do menu głównego
2. Generuj raport godzin projektowych w podanym roku
	2.1. Wygeneruj wykres kołowy procentowego udziału pracownika w projekcie w skali wybranego roku
		a. Zakończ program
		b. Wróć do menu głównego
3. Generuj miesięczny raport godzin przepracowanych przez wybranego pracownika
		a. Zakończ program
		b. Wróć do menu głównego
4. Generuj procentowy udział godzinowy w projektach dla danego pracownika
	4.1.Wygeneruj wykres - słupkowy godzin projektowych w danym roku
		a. Zakończ program
		b. Wróć do menu głównego
5. Generuj sumaryczny raport godzin projektowych 
		a. Zakończ program
		b. Wróć do menu głównego
6. Wygeneruj całościowy raport
0. Zakończ prace z progrmaem 

==============================================================================================================================================================================

eksportowanie danych do pliku xls


1 OKNO:
	Witaj uzytkowniku! To super raport do generowania statystyk w Twojej firmie!
	Wybierz scieżkę do pliku z ktorego chcesz stworzyc raport: ....


2 OKNO:
	Wybierz opcje:
	1. Generuj alfabetyczny raport godzin pracowników w danym roku (pytanie o rok - jakie lata, )
	2. Generuj raport godzin projektowych w podanym roku
		2.1. Wygeneruj wykres kołowy procentowego udziału pracownika w projekcie w skali wybranego roku
	3. Generuj miesięczny raport godzin przepracowanych przez wybranego pracownika
	4. Generuj procentowy udział godzinowy w projektach dla danego pracownika
		4.1.Wygeneruj wykres - słupkowy godzin projektowych w danym roku
	5. Generuj sumaryczny raport godzin projektowych 
	6. Wygeneruj całościowy raport
	0. Zakończ prace z programem 

3 OKNO (wynik wywolania klasy: raport_godziny_pracownika_wroku.java):
	1. Generuj alfabetyczny raport godzin pracowników w danym roku (pytanie o rok - jakie lata, )
		-Podaj rok (wyświetlanie jakie są dostępne?)
		-....
		-"Raport godzin pracowników w roku: ...."
			
			Lp |	nazwisko i imię 	|     h/rok	|
			1. |	Kowalski Jan		|	ilość	|
			2. |	Kwiatkowska Monika	|	ilość	|

			0 - zmien rok
			1 - czy wyeksportowac raport do pliku pdf? (T - TAK, N - NIE)	// nacisniecie klawisza powoduje wygenerowanie/lub nie raportu i przejscie do OKNO 2
																			// czy mozna otworzyc raport z poziomu javy?


4 OKNO (wynik wywolania klasy: raport_godziny_projektowych_wroku.java): - SORTOWANIE ALFABETYCZNE
	2. Generuj raport godzin projektowych w podanym roku
		-Podaj rok (wyświetlanie jakie są dostępne?)
		-....
		-"Raport godzin projektowych w roku: ...."

						jakiego roku dotyczy
			Lp	| nazwa projektu |  ilość godzin |
			1.	| nazwa projektu |  	ilość    |
			2.	| nazwa projektu |  	ilość    |

			0 - zmien rok
			1 - czy wyeksportowac raport do pliku xls? (T - TAK, N - NIE)	// nacisniecie klawisza powoduje wygenerowanie/lub nie raportu i przejscie do OKNO 2
																			// czy mozna otworzyc raport z poziomu javy?
			2 - czy wygenerowac wykres kolowy? (!!!OPCJA!!!)

5 OKNO (wynik wywolania klasy: raport_godziny_przepracowanych_pracownik_wroku.java): - SORTOWANIE PO MIESIACACH
	3. Generuj miesięczny raport godzin przepracowanych przez wybranego pracownika
		-Podaj rok (wyświetlanie jakie są dostępne?)
		-....
		-Podaj nazwisko i imie pracownika (wyświetlanie jakie są dostępne?)
		-....
		-"Raport godzin przepracowanych przez pracownika ... miesiecznie w danym projekcie w danym roku ..."

			Lp	| miesiąc | 	projekt 		| 	lp. godzin	|
			1.	|   01	  |	nazwa projektu_1	|	   ilość	|
			2.	|   01	  |	nazwa projektu_2	|	   ilość	|
			3.	|   02	  |	nazwa projektu_1	|	   ilość	|

			0 - zmien rok
			1 - zmien pracownika (nazwisko i imie)
			2 - czy wyeksportowac raport do pliku pdf? (T - TAK, N - NIE)	// nacisniecie klawisza powoduje wygenerowanie/lub nie raportu i przejscie do OKNO 2

6 OKNO (wynik wywolania klasy: raport_procentowy_zaangazowania_pracownikow_rok.java): - SORTOWANIE ALFABETYCZNE (po nazwisku), suma w wierszach ma byc 100%
	4. Generuj procentowy udział godzinowy w projektach dla danego pracownika
		-Podaj rok (wyświetlanie jakie są dostępne?)
		-....
		-"Raport procentowego udzialu zaangazowania pracownikow w projektach w danym roku ..."

		4. Raport: zaangażowanie w projekcie
			Lp | nazwisko i imię 		| PROJEKT 1	/ udzial procentowy	 | PROJEKT 2	/ udzial procentowy		| 
			1. |  Kowalski Jan 			| 10 % 							 |	 15 % 								| 
			2. | Kwiatkowska Monika 	| 20 %			 				 |	 20 %								| 

			0 - zmien rok
			1 - czy wyeksportowac raport do pliku pdf? (T - TAK, N - NIE)	// nacisniecie klawisza powoduje wygenerowanie/lub nie raportu i przejscie do OKNO 2
																			// czy mozna otworzyc raport z poziomu javy?
			2 - czy wygenerowac wykres slupkowy? (!!!OPCJA!!!)

7 OKNO (wynik wywolania klasy: raport_sumaryczny_godzin_projektowych_w_projekcieX.java): - SORTOWANIE ALFABETYCZNE PO NAZWISKACH
	5. Generuj sumaryczny raport godzin projektowych
		-Wybierz projekt (wyświetlanie jakie są dostępne?)
		-....
		-"Raport sumaryczny godzin projektowych w danym roku ..."

		Lp |	nazwisko i imię			|	łączna suma godzin
		1. |  Kowalski Jan				|	  ilość godzin
		2. |  Kwiatkowska Monika		|	  ilość godzin
		....

		99.|  SUMA						|	  ilość godzin dla wszystkich pracownikow

			0 - zmien projekt
			1 - czy wyeksportowac raport do pliku pdf? (T - TAK, N - NIE)	// nacisniecie klawisza powoduje wygenerowanie/lub nie raportu i przejscie do OKNO 2


==============================================================================================================================================================================															

Wybierz opcje:
1. Generuj alfabetyczny raport godzin pracowników w danym roku (pytanie o rok - jakie lata, )
-Podaj rok(wyświetlanie jakie są dostępne?)
-....
-"Raport godzin pracowników w roku: ...."
	TABELA
	0 - zmien rok


2. Generuj raport godzin projektowych w podanym roku
2.1. Wygeneruj wykres kołowy procentowego udziału pracownika w projekcie w skali wybranego roku
	a. Zakończ program
	b. Wróć do menu głównego
3. Generuj miesięczny raport godzin przepracowanych przez wybranego pracownika
	a. Zakończ program
	b. Wróć do menu głównego
4. Generuj procentowy udział godzinowy w projektach dla danego pracownika
4.1.Wygeneruj wykres - słupkowy godzin projektowych w danym roku
	a. Zakończ program
	b. Wróć do menu głównego
5. Generuj sumaryczny raport godzin projektowych 
	a. Zakończ program
	b. Wróć do menu głównego
6. Wygeneruj całościowy raport
0. Zakończ prace z progrmaem 

----------
eksportowanie danych do pliku xls