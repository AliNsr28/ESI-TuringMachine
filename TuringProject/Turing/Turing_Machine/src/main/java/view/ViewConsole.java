package view;

import model.Facade;
import util.Observer;

public class ViewConsole implements Observer {


 private Facade facade;

    public static void startGame() {
        System.out.println("\u001B[36m");
        System.out.println("WELCOME TO TURIIIIIING MACHIIIIIIINE");
        System.out.println("\u001B[0m");
    }

    /**
     * Displays a welcome message at the start of the Turing application.
     */

    public static void displayHelp() {
        System.out.println();
        //System.out.print("\u001B[38;2;255;165;0m");
        System.out.print("\u001B[34m");
        System.out.println("TURING MACHINE \n" +
                "Turing Machine command:");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[35m");
        System.out.println(
                "- code <xxx> (To enter your code) \n" +
                        "- select <x> (To select your validator) \n" +
                        "- next (If you want to move on to the next round) \n" +
                        "- guess (If you want to test your code)  \n" +
                        "- display (If you want to check what validators do\n" +
                        "- quit (If you want to leave)"

        );
        System.out.print("\u001B[0m");
        System.out.println();

    }

    /**
     * Prints a representation of the game over message when the player win.
     * Displays ASCII art with a message indicating the game over condition.
     */

    public static void  winGame(){
        System.out.println("                                                                                                                                                              \n" +
                "                                                                                                                                                              \n" +
                "____     ___               68b                                                          ___                         ____         _     ___       ____________ \n" +
                "`MM(     )M'               Y89                              68b                         `MM                        6MMMMb/      dM.    `MMb     dMM`MMMMMMMMM \n" +
                " `MM.    d'                 9                               Y89                   /      MM                       8P    YM     ,MMb     MMM.   ,PMM MM      \\ \n" +
                "  `MM.  d' _____  ___   ___/ ___  __       ____    _    ___ ___ ___  __          /M      MM  __     ____         6M      Y     d'YM.    M`Mb   d'MM MM        \n" +
                "   `MM d' 6MMMMMb `MM    MM  `MM 6MM       `MM(   ,M.   )M' `MM `MM 6MMb        /MMMMM   MM 6MMb   6MMMMb        MM           ,P `Mb    M YM. ,P MM MM    ,   \n" +
                "    `MM' 6M'   `Mb MM    MM   MM69 \"        `Mb   dMb   d'   MM  MMM9 `Mb        MM      MMM9 `Mb 6M'  `Mb       MM           d'  YM.   M `Mb d' MM MMMMMMM   \n" +
                "     MM  MM     MM MM    MM   MM'            YM. ,PYM. ,P    MM  MM'   MM        MM      MM'   MM MM    MM       MM     ___  ,P   `Mb   M  YM.P  MM MM    `   \n" +
                "     MM  MM     MM MM    MM   MM             `Mb d'`Mb d'    MM  MM    MM        MM      MM    MM MMMMMMMM       MM     `M'  d'    YM.  M  `Mb'  MM MM        \n" +
                "     MM  MM     MM MM    MM   MM              YM,P  YM,P     MM  MM    MM        MM      MM    MM MM             YM      M  ,MMMMMMMMb  M   YP   MM MM        \n" +
                "     MM  YM.   ,M9 YM.   MM   MM              `MM'  `MM'     MM  MM    MM        YM.  ,  MM    MM YM    d9        8b    d9  d'      YM. M   `'   MM MM      / \n" +
                "    _MM_  YMMMMM9   YMMM9MM_ _MM_              YP    YP     _MM__MM_  _MM_        YMMM9 _MM_  _MM_ YMMMM9          YMMMM9 _dM_     _dMM_M_      _MM_MMMMMMMMM \n" +
                "                                                                                                                                                             ");
    }
    /**
     * Prints a representation of the game over message when the player loses.
     * Displays ASCII art with a message indicating the game over condition.
     */
    public static void loseGame(){
        System.out.println("       ,.  '              , ·. ,.-·~·.,   ‘                 ,. -,                   _,.,  °         ,. -  .,              \n" +
                "       /   ';\\             /  ·'´,.-·-.,   `,'‚           ,.·'´,    ,'\\           ,.·'´  ,. ,  `;\\ '     ,' ,. -  .,  `' ·,       \n" +
                "     ,'   ,'::'\\           /  .'´\\:::::::'\\   '\\ °     ,·'´ .·´'´-·'´::::\\'       .´   ;´:::::\\`'´ \\'\\     '; '·~;:::::'`,   ';\\    \n" +
                "    ,'    ;:::';'       ,·'  ,'::::\\:;:-·-:';  ';\\‚    ;    ';:::\\::\\::;:'       /   ,'::\\::::::\\:::\\:'     ;   ,':\\::;:´  .·´::\\'  \n" +
                "    ';   ,':::;'       ;.   ';:::;´       ,'  ,':'\\‚   \\·.    `·;:'-·'´         ;   ;:;:-·'~^ª*';\\'´       ;  ·'-·'´,.-·'´:::::::'; \n" +
                "    ;  ,':::;' '        ';   ;::;       ,'´ .'´\\::';‚   \\:`·.   '`·,  '         ;  ,.-·:*'´¨'`*´\\::\\ '    ;´    ':,´:::::::::::·´'  \n" +
                "   ,'  ,'::;'           ';   ':;:   ,.·´,.·´::::\\;'°     `·:'`·,   \\'         ;   ;\\::::::::::::'\\;'      ';  ,    `·:;:-·'´       \n" +
                "   ;  ';_:,.-·´';\\‘     \\·,   `*´,.·'´::::::;·´         ,.'-:;'  ,·\\        ;  ;'_\\_:;:: -·^*';\\      ; ,':\\'`:·.,  ` ·.,      \n" +
                "   ',   _,.-·'´:\\:\\‘     \\\\:¯::\\:::::::;:·´       ,·'´     ,.·´:::'\\       ';    ,  ,. -·:*'´:\\:'\\°    \\·-;::\\:::::'`:·-.,';    \n" +
                "    \\¨:::::::::::\\';      `\\:::::\\;::·'´  °         \\`*'´\\::::::::;·'‘       \\`*´ ¯\\:::::::::::\\;' '    \\::\\:;'` ·:;:::::\\::\\'  \n" +
                "     '\\;::_;:-·'´‘            ¯                     \\::::\\:;:·´              \\:::::\\;::-·^*'´          '·-·'       `' · -':::'' \n" +
                "       '¨                      ‘                       '`*'´‘                    `*´¯                                         ");
    }
    /**
     * Prints a farewell message when the game ends.
     * Displays a friendly message and colorful formatting.
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
    @Override
    public void update() {
            System.out.println("ROUND :  " + facade.getNumberRound());
            System.out.println("number of verifications : "+ facade.getVerificationsnumber());
            System.out.println("size of the validator's list :  " +  facade.getValidators().size());
        }
    }

