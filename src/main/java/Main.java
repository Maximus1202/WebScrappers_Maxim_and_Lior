import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Web scrappers - by Maxim and Lior:\n");
        System.out.println("Hello and welcome to the guessing game !!!\n");
        System.out.println("Which website would you like to play with ?\n ");
        System.out.println("1 - Mako");
        System.out.println("2 - Ynet");
        System.out.println("3 - Walla");
        System.out.print("\nYour choice is :");
        int userOption = scanner.nextInt();
        int numOfTries = 5;
        int points = 0;
        switch (userOption) {
            case Options.MAKO_BOT:
                MakoBot makoBot = new MakoBot();
                Map<String, Integer> makoMap = makoBot.getWordsStatistics();
                System.out.println("\nYou will get points for the number of word exist in the articles.");
                System.out.println("For example, title of the longest article:\n ");
                System.out.println(makoBot.getLongestArticleTitle() + "\n");

                while (numOfTries > 0) {
                    System.out.println("You have 5 tries at start.\ntries left: " + numOfTries + "\n");
                    System.out.print("Your word: ");
                    String userWord = scanner.next();
                    if (makoMap.containsKey(userWord)) {
                        points += makoMap.get(userWord);
                    }
                    if (makoMap.get(userWord) != null) {
                        System.out.println("You get " + makoMap.get(userWord) + " points !!!");
                    } else {
                        System.out.println("No points earned!");
                    }
                    numOfTries--;
                }
                System.out.println("Total amount of points that you accumulated for now: " + points);
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Now a chance to try you luck !");
                System.out.println("Enter a text between 1-20 characters, that you think will appear in the titles of the site. ");
                System.out.println("guess how many times the text you entered appears. ");
                System.out.println("If you guess right, you will earn extra 250 points!\n");
                System.out.print("enter your text: ");
                String userMakoArticleText = scanner.next();
                int numsMakoAppearances = makoBot.countInArticlesTitles(userMakoArticleText);
                System.out.print("Guess how many times it appeared: ");
                int userNumForArticlesMako = scanner.nextInt();
                if (userMakoArticleText.length() < 1 || userMakoArticleText.length() > 20) {
                    System.out.println("\nThe text you entered is incorrect so you have gained 0 points.");
                    System.out.println("Your total score: " + points);
                    System.out.println("Nice try, until next time!");
                } else if (userNumForArticlesMako < 0) {
                    System.out.println("\nNegative numbers are not allowed");
                    System.out.println("Your total score: " + points);
                    System.out.println("You guess wrong, so you got no points.");
                } else if (userNumForArticlesMako > numsMakoAppearances - 2 && userNumForArticlesMako < numsMakoAppearances + 2) {
                    System.out.println("\nGreat job!\n250 points added!!!");
                    points += 250;
                    System.out.println("Your total score: " + points);
                    System.out.println("See you soon!");
                } else {
                    System.out.println("\nClose , but not enough!");
                    System.out.println("Your total score is: " + points);
                    System.out.println("Good luck next time!");
                }
                break;

            case Options.YNET_BOT:
                YnetBot ynetBot = new YnetBot();
                Map<String, Integer> ynetMap = ynetBot.getWordsStatistics();
                System.out.println("\nYou will get points for the number of word exist in the articles.");
                System.out.print("For example, title of the longest article:\n ");
                System.out.println(ynetBot.getLongestArticleTitle());
                points = 0;
                while (numOfTries > 0) {
                    System.out.println("\nYou have 5 tries at start.\ntries left: " + numOfTries + "\n");
                    System.out.print("Your word: ");
                    String userWord = scanner.next();
                    if (ynetMap.containsKey(userWord)) {
                        points += ynetMap.get(userWord);
                    }
                    if (ynetMap.get(userWord) != null) {
                        System.out.println("You get " + ynetMap.get(userWord) + " points!");
                    } else {
                        System.out.println("No points earned!");
                    }
                    numOfTries--;
                }
                System.out.println("Total amount of points for now: " + points);
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Try your luck now !!!");
                System.out.println("Enter a text between 1-20 characters, that you think will appear in the titles of the site. ");
                System.out.println("guess how many times the text you entered appears. ");
                System.out.println("If you guess right, you will earn extra 250 points!\n");
                System.out.print("your text: ");
                String userTextForArticles = scanner.next();
                int numOfAppearsInTitles = ynetBot.countInArticlesTitles(userTextForArticles);
                System.out.print("Guess how many times it appeared: ");
                int userNumForArticles = scanner.nextInt();
                if (userTextForArticles.length() < 1 || userTextForArticles.length() > 20) {
                    System.out.println("Incorrect text!\nno points earned!");
                    System.out.println("Your total score: " + points);
                    System.out.println("Better luck next time!\nsee you soon!");
                } else if (userNumForArticles < 0) {
                    System.out.println("You cannot enter a negative number !");
                    System.out.println("Your total score: " + points);
                    System.out.println("No points earned , try your best next time !");
                } else if (userNumForArticles > numOfAppearsInTitles - 3 && userNumForArticles < numOfAppearsInTitles + 3) {
                    System.out.println("Great job !!!\n250 points added!");
                    points += 250;
                    System.out.println("Your total score: " + points);
                    System.out.println("See you soon!");
                } else {
                    System.out.println("Close , but not enough!");
                    System.out.println("Your total score: " + points);
                    System.out.println("You might get more lucky next time!\nSee you soon!");
                }
                break;
            case Options.WALLA_BOT:
                WallaBot wallaBot = new WallaBot();
                Map<String, Integer> wallaMap = wallaBot.getWordsStatistics();
                System.out.println("\nYou will get points for the number of word exist in the articles.");
                System.out.print("For example, title of the longest article:\n ");
                System.out.println(wallaBot.getLongestArticleTitle());
                points = 0;
                while (numOfTries > 0) {
                    System.out.println("\nYou have 5 tries at start.\ntries left: " + numOfTries + "\n");
                    System.out.print("Your word: ");
                    String userWord = scanner.next();
                    if (wallaMap.containsKey(userWord)) {
                        points += wallaMap.get(userWord);
                    }
                    if (wallaMap.get(userWord) != null) {
                        System.out.println("You get " + wallaMap.get(userWord) + " points !");
                    } else {
                        System.out.println("No points earned!");
                    }
                    numOfTries--;
                }
                System.out.println("Total amount of points for now: " + points);
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Try your luck now !!!");
                System.out.println("Enter a text between 1-20 characters, that you think will appear in the titles of the site. ");
                System.out.println("guess how many times the text you entered appears. ");
                System.out.println("If you guess right, you will earn extra 250 points!\n");
                System.out.print("your text: ");
                String userTextForArticlesWalla = scanner.next();
                int numOfAppearsInTitlesWalla = wallaBot.countInArticlesTitles(userTextForArticlesWalla);
                System.out.print("Guess how many times it appeared: ");
                int userNumForArticlesWalla = scanner.nextInt();
                if (userTextForArticlesWalla.length() < 1 || userTextForArticlesWalla.length() > 20) {
                    System.out.println("Incorrect input.\nYou have not earned points.");
                    System.out.println("Your total score: " + points);
                    System.out.println("Better luck next time!\nSee you soon!");
                } else if (userNumForArticlesWalla < 0) {
                    System.out.println("You can't enter negative numbers.");
                    System.out.println("Your total score: " + points);
                    System.out.println("You have not earned points.\nTry your best next time!");
                } else if (userNumForArticlesWalla > numOfAppearsInTitlesWalla - 3 && userNumForArticlesWalla < numOfAppearsInTitlesWalla + 3) {
                    System.out.println("Great job!\n250 points added!!!");
                    points += 250;
                    System.out.println("Your total score: " + points);
                    System.out.println("See you soon!");
                } else {
                    System.out.println("Close , but not enough!");
                    System.out.println("Your total score: " + points);
                    System.out.println("You might get more lucky next time!\nSee you soon!");
                }
                break;

            default:
                System.out.println("Incorrect , choose only 1-3 options.\n");
                main(args);
        }
    }
}
