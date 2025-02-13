package atl.ascii.controller;

import atl.ascii.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import atl.ascii.view.View;

import static java.util.regex.Pattern.compile;

public class Application {

    private static final Pattern patternCircle = Pattern.compile("^add circle\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\w)$");

    private static final Pattern patternRectangle = Pattern.compile("^add rectangle\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\w)$");
    private static final Pattern patternLine = Pattern.compile("^add line\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\w)$");

    private static final Pattern patternSquare = Pattern.compile("^add square\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\w)$");
    private static final Pattern patternShow = Pattern.compile("^show");
    private static final Pattern patternList = Pattern.compile("^list");
    private static final Pattern patternMove = Pattern.compile("^move\\s*(\\d)\\s*(\\d)\\s*(\\d)+$");
    private static final Pattern patternColor = Pattern.compile("^color\\s+(\\d+)\\s+([a-zA-Z])$");
    private static final Pattern patternDelete = Pattern.compile("^delete\\s+(\\d+)$");

    private static final Pattern patternQuit = Pattern.compile("^.*\\bquit\\b.*$");

    private static final Pattern patternUndo = Pattern.compile("^.*\\bundo\\b.*$");
    private static final Pattern patternRedo = Pattern.compile("^.*\\bredo\\b.*$");


    private static final Pattern patternGroup = Pattern.compile("^group(?:\\s+\\d+)*");

    private static final Pattern patternUngroup = Pattern.compile("^ungroup\\s+(\\d+)");


    private static AsciiPaint asciiPaint;

    private static int height;

    private static int width;
    public static void main(String[] args) {


        Scanner clavier = new Scanner(System.in);
        Scanner clv = new Scanner(System.in);
        Boolean game = true;

        System.out.println("\u001B[95m");
        System.out.println("Choose the Height of the board.");
         height = clv.nextInt();
        System.out.println("Choose the Width of the board.");
        System.out.print("\u001B[0m");
         width = clv.nextInt();
        View.startGame();

        while (height <= 0 || width <= 0){
            try {

            } catch (AsciiException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\u001B[95m");
            System.out.println("Choose the Height of the board.");
            height = clv.nextInt();
            System.out.println("Choose the Width of the board.");
            System.out.print("\u001B[0m");
            width = clv.nextInt();
            View.startGame();
        }
        asciiPaint = new AsciiPaint(width, height);
        while (game) {
            View.displayHelp();
            String ConsolInput = clavier.nextLine();

            if (patternCircle.matcher(ConsolInput).matches()) {
                Matcher matcher = patternCircle.matcher(ConsolInput);
                matcher.find();
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                int radius = Integer.parseInt(matcher.group(3));
                char color = matcher.group(4).charAt(0);
                asciiPaint.newCircle(x, y, radius, color);
            //    System.out.println(asciiPaint.ascii());


            } else if (patternRectangle.matcher(ConsolInput).matches()) {
                Matcher matcher = patternRectangle.matcher(ConsolInput);
                matcher.find();
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                int widht = Integer.parseInt(matcher.group(3));
                int height= Integer.parseInt(matcher.group(4));
                char color = matcher.group(5).charAt(0);
                asciiPaint.newRectangle(x,y,height,widht,color);
              //  System.out.println(asciiPaint.ascii());

            } else if (patternSquare.matcher(ConsolInput).matches()) {
                Matcher matcher = patternSquare.matcher(ConsolInput);
                matcher.find();
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                int side = Integer.parseInt(matcher.group(3));
                char color = matcher.group(4).charAt(0);
                asciiPaint.newSquare(x,y,side,color);
               // System.out.println(asciiPaint.ascii());


            } else if (patternLine.matcher(ConsolInput).matches()) {
                Matcher matcher = patternLine.matcher(ConsolInput);
                matcher.find();
                int x1 = Integer.parseInt(matcher.group(1));
                int y1 = Integer.parseInt(matcher.group(2));
                int x2 = Integer.parseInt(matcher.group(3));
                int y2= Integer.parseInt(matcher.group(4));
                char color = matcher.group(5).charAt(0);
                asciiPaint.newLine(x1,y1,x2,y2,color);
              //  System.out.println(asciiPaint.ascii());


            } else if (patternShow.matcher(ConsolInput).matches()) {
                System.out.println(asciiPaint.ascii());


            } else if (patternList.matcher(ConsolInput).matches()) {
                asciiPaint.displayShapes();


            } else if (patternMove.matcher(ConsolInput).matches()) {
                Matcher matcher = patternMove.matcher(ConsolInput);
                matcher.find();
                String[] split = ConsolInput.split("\\s");
                int index = Integer.parseInt(split[1]);
                int x = Integer.parseInt(split[3]);
                int y = Integer.parseInt(split[2]);
                asciiPaint.moveShape(index,x,y);
                //System.out.println(asciiPaint.ascii());

            } else if (patternGroup.matcher(ConsolInput).matches()) {
                String[] split = ConsolInput.split("\\s");
                int [] tabIndex = new int[split.length - 1];
                for (int i = 1; i <= tabIndex.length; i++) {
                    tabIndex[i-1] = Integer.parseInt(split[i]);
                }
                asciiPaint.group(tabIndex);

            } else if (patternUngroup.matcher(ConsolInput).matches()) {
                Matcher matcher = patternUngroup.matcher(ConsolInput);
                matcher.find();
                int index = Integer.parseInt(matcher.group(1));
                asciiPaint.ungroup(index);


            } else if (patternColor.matcher(ConsolInput).matches()) {
                Matcher matcher = patternColor.matcher(ConsolInput);
                matcher.find();
                int index = Integer.parseInt(matcher.group(1));
                System.out.println("delete");
                char color = matcher.group(2).charAt(0);
                asciiPaint.setColor(index,color);

            } else if (patternDelete.matcher(ConsolInput).matches()) {

                Matcher matcher = patternDelete.matcher(ConsolInput);
                matcher.find();
                int index = Integer.parseInt((matcher.group(1)));
                asciiPaint.deleteShape(index);

            } else if (patternUndo.matcher(ConsolInput).matches()) {

                asciiPaint.undo();

            } else if (patternRedo.matcher(ConsolInput).matches()) {

                asciiPaint.redo();

            } else if (patternQuit.matcher(ConsolInput).matches()) {

                game = false;
                View.endGame();

            } else {
                System.out.println("Error Retry");
            }
        }

    }


}
