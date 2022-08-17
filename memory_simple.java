import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class memory_simple {

    // Stowrzenie obiektu random

    Random random = new Random();

    // Wyswietla zasady w gre memory
    static void zasady_gry() {

        System.out.println("*********************************************");
        System.out.println("**              MEMORY                     **");
        System.out.println("**                                         **");
        System.out.println("**            SIMPLE   GAME                **");
        System.out.println("**                                         **");
        System.out.println("**                                         **");
        System.out.println("*********************************************");
    }

    // Restart Planszy

    public static void ponowna() {

    }

    // rysowanie planszy
    public static void drawBoard(String[][] board) {

        System.out.println("Board:" + "\n" + "  012345");
        // for (int j = 0; j < board.length; j++) {

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                // for (int i = 0; i < board[j].length; i++) {

                if (i == 0 && j == 0) {

                    System.out.print("0 ");

                }

                if (i == 1 && j == 0) {

                    System.out.print("1 ");

                }

                if (i == 2 && j == 0) {

                    System.out.print("2 ");

                }

                if (i == 3 && j == 0) {

                    System.out.print("3 ");

                }

                if (i == 4 && j == 0) {

                    System.out.print("4 ");

                }

                if (i == 5 && j == 0) {

                    System.out.print("5 ");

                }

                System.out.print(board[i][j]);
                // System.out.print(i);
                // System.out.print(j);

            }

            System.out.println();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        int wyrazy = 0;
        int zgadula = 0;
        int losowex = 0;
        int losowey = 0;
        int losowe = 0;
        int n = 6;

        String[][] board = new String[n][n];

        String[][] tablica;
        tablica = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "X";
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablica[i][j] = "X";
            }
        }

        Random random = new Random();

        // Przypisanie wyrazów do miejsca w tabeli
        boolean pytanie2 = false;
        boolean pytanie1 = true;
        boolean easy = false;
        boolean hard = false;
        boolean end_game = false;
        int szanse = 0;
        int koniec = 0;
        int trybgry = 0;

        File file = new File("C:\\Roman\\Programowanie\\Java\\Words.txt");
        Scanner in = new Scanner(file);

        String[] word;
        word = new String[100];

        for (int i = 0; i < 100; i++) {

            String zdanie = in.nextLine();
            word[i] = zdanie;
            // System.out.println(i);
            // System.out.println(word[i]);

        }

        // Scanner scanner = new Scanner(s);

        zasady_gry();

        // Wybór trybu gry

        while (pytanie1) {

            System.out.println("Select Game Mode" + "\n" + "1 - Easy" + "\n" + "2 - Hard");
            Scanner myObj = new Scanner(System.in); // tworzymy obiekt myObj

            trybgry = myObj.nextInt(); // przechwytywanie znaku
            System.out.println(trybgry);

            System.out.println("Tu nie ma liczby :[");

            // trybgry = myObj.nextInt();
            System.out.println(trybgry);

            if (trybgry == 1 || trybgry == 2) {

                pytanie1 = false;

            }

        }

        // Losowanie wyrazów

        if (trybgry == 1) {

            System.out.println("EASY");
            easy = true;
            szanse = 10;
            wyrazy = 4;
            zgadula = 4;
        }

        else if (trybgry == 2) {

            System.out.println("HARD");
            hard = true;
            szanse = 15;
            wyrazy = 8;
            zgadula = 8;
        }

        // losowanie();

        // Losowanie wyrazów

        for (int i = 0; i < wyrazy; i++) {

            losowe = random.nextInt(100);

            for (int j = 0; j < 2; j++) {

                losowex = random.nextInt(5);
                losowey = random.nextInt(5);
                tablica[losowex][losowey] = word[losowe];
                System.out.println(word[losowe]);
                System.out.println(losowex);
                System.out.println(losowey);

            }

        }

        System.out.println(board[5][5]);

        while (!end_game) {

            drawBoard(board);
            end_game = true;

            while (true) {

                // Tworzenie zmiennych wierszy i kolumny
                // pozycja na planszy board
                int row = 0;
                int col = 0;
                int row2 = 0;
                int col2 = 0;
                // Podaj kordynaty pierwszego wyrazu

                System.out.println("Podaj kolumnę(col): ");

                Scanner mykord = new Scanner(System.in); // Znak
                col = mykord.nextInt();
                System.out.println("Podaj wiersz(row): ");

                // Scanner mykord = new Scanner(System.in); // Znak
                row = mykord.nextInt();

                board[col][row] = tablica[col][row];

                drawBoard(board);
                // Podaj kordynaty drugiego wyrazu
                System.out.println("Podaj kolumnę(col): ");

                // Scanner mykord2 = new Scanner(System.in); // Znak
                col2 = mykord.nextInt();

                System.out.println("Podaj wiersz(row): ");

                // Scanner mykordd2 = new Scanner(System.in); // Znak
                row2 = mykord.nextInt();

                board[col2][row2] = tablica[col2][row2];

                drawBoard(board);

                if (tablica[col][row] == tablica[col2][row2] && tablica[col][row] != "X") {
                    System.out.println("zgadza sie");
                    szanse = szanse - 1;
                    zgadula = zgadula - 1;

                }

                else {
                    board[col][row] = "X";
                    board[col2][row2] = "X";
                    szanse = szanse - 1;
                    drawBoard(board);

                }

                if (szanse == 0 || zgadula == 0) {

                    System.out.println("Gratulacje wygrales");

                    System.out.println("1 - Restart" + "\n" + "2 - Koniec Gry");
                    koniec = mykord.nextInt(); // przechwytywanie znaku

                }

                else if (szanse == 0) {

                    System.out.println("Tym razem przegrałeś");
                    System.out.println("1 - Restart" + "/n" + "2 - Koniec Gry");
                    koniec = mykord.nextInt(); // przechwytywanie znaku

                }

                if (koniec == 1) {

                    ponowna();

                }

                else if (koniec == 2) {

                    end_game = false;

                }

                // break;

            }

        }

        // zakończenie gry rysowanie planszy

    }

}
