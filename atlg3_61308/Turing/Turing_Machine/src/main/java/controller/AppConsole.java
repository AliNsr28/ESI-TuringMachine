package controller;

import commande.CommandManager;
import model.*;
import model.validator.Validator;
import util.CSVReader;
import view.ViewConsole;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppConsole {


    private static final Pattern patternEnter_Code = Pattern.compile("^code (\\d{3})*$");

    private static final Pattern patternSelect_Validator = Pattern.compile("^select ([0-5])*$");
    private static final Pattern patternNext_Round = Pattern.compile("^.*\\bnext\\b.*$");
    private static final Pattern patternQuit = Pattern.compile("^.*\\bquit\\b.*$");
    private static final Pattern patterGuess = Pattern.compile("^.*\\bguess\\b.*$");

    private static final Pattern patternDysplayValidator = Pattern.compile("^.*\\bdisplay\\b.*$");

    private static final Pattern patterUndo = Pattern.compile("^.*\\bundo\\b.*$");
    private static final Pattern patterRedo = Pattern.compile("^.*\\bredo\\b.*$");



    private static Facade facade;
    private static Game game = new Game();

    private static int number_Probleme;


    private static Code code_User;


    public static void main(String[] args) {
        game();
    }
    private static void game() {

        Scanner clavier = new Scanner(System.in);
        Scanner clv = new Scanner(System.in);
        boolean codeRound = false;
        ViewConsole.startGame();
        System.out.println("Choose the problem number.");
        number_Probleme = clv.nextInt();
        facade = new Facade(game);
        facade.startNewGame(number_Probleme);
        while (!(facade.getGame().isFind())) {

            ViewConsole.displayHelp();
            String ConsolInput = clavier.nextLine();
            if (patternEnter_Code.matcher(ConsolInput).matches()) {
                if (codeRound){
                    throw  new TuringException("You can change the code in the same Round");
                }
                Matcher matcher = patternEnter_Code.matcher(ConsolInput);
                matcher.find();
                int x = Integer.parseInt(matcher.group(1));
                code_User = new Code(x);
                facade.enterCode(code_User);
                facade.getGame().getUser().getCode();
                codeRound = true;
            }
            else if (patternDysplayValidator.matcher(ConsolInput).matches()) {
                facade.getGame().getRound().toStringValidators();
            }
            else if (patternSelect_Validator.matcher(ConsolInput).matches()) {
                Matcher matcher = patternSelect_Validator.matcher(ConsolInput);
                matcher.find();
                int x = Integer.parseInt(matcher.group(1));
                facade.selectValidateur(x);
            }
            else if (patternNext_Round.matcher(ConsolInput).matches()) {
                codeRound = false;
                facade.nextRound();
            }
            else if (patterUndo.matcher(ConsolInput).matches()) {
                facade.undo();
            }
            else if(patterRedo.matcher(ConsolInput).matches()){
                facade.redo();
            }
            else if (patterGuess.matcher(ConsolInput).matches()) {
                facade.getGame().verificationCode(code_User);
                if(facade.getGame().isFind()){
                    System.out.println("You find the code");
                    ViewConsole.winGame();
                }
                else {
                    ViewConsole.loseGame();
                }
                facade.endGame();
                ViewConsole.endGame();

            }
            else if (patternQuit.matcher(ConsolInput).matches()) {
                facade.endGame();
                ViewConsole.endGame();
            }
            else {
                System.out.println("Error Retry");
            }
        }
    }
}
