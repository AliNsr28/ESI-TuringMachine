package atl.ascii.view;

/**
 * The {@code View} class provides methods for displaying information and messages in the ASCII paint application.
 */
public class View {

    /**
     * Displays the help menu with available commands and their descriptions.
     */
    public static void displayHelp() {
        System.out.println();
        //System.out.print("\u001B[38;2;255;165;0m");
        System.out.print("\u001B[34m");
        System.out.println("ASCIIPAINT \n" +
                "Asciipaint command:");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[35m");
        System.out.println(
                "- add circle  <x> <y> <radius> <color> \n" +
                        "- add rectangle  <x> <y> <width> <height> <color> \n" +
                        "- add line <x1> <y1> <x2> <y2> <color> \n" +
                        "- add square  <x> <y> <side> <color>  \n" +
                        "- show\n" +
                        "- list\n" +
                        "- move <shape number> <x> <y>\n" +
                        "- group <shape number> ...\n" +
                        "- ungroup <group number>\n" +
                        "- color <shape number> <color> \n" +
                        "- delete <shape number>\n" +
                        "- undo \n" +
                        "- redo \n" +
                        "- quit "
        );
        System.out.print("\u001B[0m");
        System.out.println();
    }


    /**
     * Displays a welcome message at the start of the ASCII paint application.
     */

    public static void startGame() {
        System.out.println("\u001B[36m");
        System.out.println("WELCOME TO ASCIIIIIIIIIII PAAAAAAAAINT");
        System.out.println("\u001B[0m");
    }

    /**
     * Displays a farewell message at the end of the ASCII paint application.
     */

    public static void endGame() {

        System.out.println("\033[1;35m");
        System.out.println("Bye and Have a nice day");
        System.out.println("\033[1;0m");
        System.out.println("\u001B[34m ");

        System.out.println("████████╗██╗   ██╗██████╗ ██╗███╗   ██╗ ██████╗     ███╗   ███╗ █████╗  ██████╗██╗  ██╗██╗███╗   ██╗███████╗\n" +
                "╚══██╔══╝██║   ██║██╔══██╗██║████╗  ██║██╔════╝     ████╗ ████║██╔══██╗██╔════╝██║  ██║██║████╗  ██║██╔════╝\n" +
                "   ██║   ██║   ██║██████╔╝██║██╔██╗ ██║██║  ███╗    ██╔████╔██║███████║██║     ███████║██║██╔██╗ ██║█████╗  \n" +
                "   ██║   ██║   ██║██╔══██╗██║██║╚██╗██║██║   ██║    ██║╚██╔╝██║██╔══██║██║     ██╔══██║██║██║╚██╗██║██╔══╝  \n" +
                "   ██║   ╚██████╔╝██║  ██║██║██║ ╚████║╚██████╔╝    ██║ ╚═╝ ██║██║  ██║╚██████╗██║  ██║██║██║ ╚████║███████╗\n" +
                "   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝╚══════");
    }
}

