import java.awt.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class CLI {
    public CLI() {


    }
    
    
    public static boolean binary_question(){
        Scanner question = new Scanner(System.in);
        String input = question.next();
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
            return true;
        }
        else if(input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")){
            return false;
        }else{
            System.out.println("this is not a valid input,please try again(y/n): ");
            return binary_question();
        }
        
    }
    
    
    public String[] input() {
        String[] selection = new String[4];
        int tempi = 0;
        Scanner question = new Scanner(System.in);
        
        for (int i = 4; i > 0; i--) {
            String input = question.next();
            if (input.equalsIgnoreCase("Red") || input.equalsIgnoreCase("r")) {
                selection[tempi] = "Red";
                tempi++;
            } else if (input.equalsIgnoreCase("Yellow") || input.equalsIgnoreCase("y")) {
                selection[tempi] = "Yellow";
                tempi++;
            } else if (input.equalsIgnoreCase("Blue") || input.equalsIgnoreCase("b")) {
                selection[tempi] = "Blue";
                tempi++;
            } else if (input.equalsIgnoreCase("Green") || input.equalsIgnoreCase("g")) {
                selection[tempi] = "Green";
                tempi++;
            } else if (input.equalsIgnoreCase("Orange") || input.equalsIgnoreCase("o")) {
                selection[tempi] = "Orange";
                tempi++;
            } else if (input.equalsIgnoreCase("Pink") || input.equalsIgnoreCase("p")) {
                selection[tempi] = "Pink";
                tempi++;
            } else {
                System.out.println("This is not a valid color.");
                i++;
            }
            if(tempi < 4){
                System.out.println("You need " + (i - 1) + " more. Your current selection is:");
                StringJoiner joiner = new StringJoiner(" | ");
                for (String color : selection) {
                    joiner.add(color);
                }
                System.out.println(joiner);
            }
            else{
                System.out.println("Your final selection is:");
                StringJoiner joiner = new StringJoiner(" | ");
                for (String color : selection) {
                    joiner.add(color);
                }
                System.out.println(joiner);
                System.out.println("do you want to use this selection?:");
                if(binary_question() == true){
                    return selection;
                } else{
                    System.out.println("then please redo the selection.");
                    input();
                }
            }
        }
        
        return selection;
                
        
    }

    public int number_question(){
        Scanner num = new Scanner(System.in);
        return num.nextInt();
    }



    public void Print_bord(Row[] board){
        System.out.println("(========================================================================)");

        for (Row row : board) {
            StringJoiner joinerColor = new StringJoiner(" | ");
            for (String color : row.getColor()) {
                joinerColor.add(color);
            }

            int[] guesses = row.getGuesses();
            int correct = guesses[0];
            int completely_correct = guesses[1];
            System.out.println("{ " + joinerColor + " } " + "{ " + "correct: " + (correct - completely_correct) + " | completely_correct: " + completely_correct + " }");

        }
        System.out.println("(========================================================================)");
    }



    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void p_rate(Row[] board,int j,String[] solution){
        Scanner question = new Scanner(System.in);
        int correct = 0;
        int completely_correct = 0;
        System.out.println("check if its correct,your combination was:");
        StringJoiner joiner = new StringJoiner(" | ");
        for (String color : solution) {
            joiner.add(color);
        }
        System.out.println(joiner);
        for(int i = 0;i < 4;i++){
            System.out.println("is color " + (i + 1) + " correct(c),completely correct(cc) or none of them(f)?: ");
            String input = question.next();
            if (input.equalsIgnoreCase("correct") || input.equalsIgnoreCase("c")){
                correct++;
            }else if (input.equalsIgnoreCase("completely correct") || input.equalsIgnoreCase("cc")){
                completely_correct++;
            }else if (input.equalsIgnoreCase("false") || input.equalsIgnoreCase("f")){
        }
        }
        board[j].setGuesses(correct + completely_correct,completely_correct);
    }

    public void win(){
        {
            System.out.println("(========================================================================)");
            System.out.println(" __     ______  _    _  __          ______  _   _   _ ");
            System.out.println(" \\ \\   / / __ \\| |  | | \\ \\        / / __ \\| \\ | | | |");
            System.out.println("  \\ \\_/ / |  | | |  | |  \\ \\  /\\  / / |  | |  \\| | | |");
            System.out.println("   \\   /| |  | | |  | |   \\ \\/  \\/ /| |  | | . ` | | |");
            System.out.println("    | | | |__| | |__| |    \\  /\\  / | |__| | |\\  | |_|");
            System.out.println("    |_|  \\____/ \\____/      \\/  \\/   \\____/|_| \\_| (_)");
            System.out.println("                                                       ");
            System.out.println("(========================================================================)");
        }
        System.out.println("would you like to play again?: ");
        if(binary_question() == true){
            Main.startUp();
        }else{
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }

    public void game_over(String info){
        {
            System.out.println("(========================================================================)");
            System.out.println("  _____          __  __ ______    ______      ________ _____  ");
            System.out.println(" / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ ");
            System.out.println("| |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |");
            System.out.println("| | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / ");
            System.out.println("| |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ ");
            System.out.println(" \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
            System.out.println("                                                            ");
            System.out.println(info);
            System.out.println("                                                            ");
            System.out.println("(========================================================================)");
        }
        System.out.println("would you like to play again?: ");
        if(binary_question() == true){
            Main.startUp();
        }else{
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }
}
