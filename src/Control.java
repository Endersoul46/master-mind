import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Control {

    int sizey = 1;
    Row [] board;
    CLI cli;
    CPU cpu;
    boolean infinite = false;
    boolean win = false;
    public Control(){
        cli = new CLI();
        cpu = new CPU();
    }



    public void player_guesses_Control(){
        System.out.println("Would you like to play with infinite guesses?: ");
        if(CLI.binary_question() == true){
            infinite = true;
        }
        if (infinite == false){
            System.out.println("then how many guesses would you like?: ");
            sizey = cli.number_question();
        }
        board = new Row[sizey];
        for (int i = 0; i < board.length;i++) {
            board[i] = new Row();
        }
        String[] solution = cpu.get_solution();
        //String[] solution = new String[]{"Red","Red","Green","Yellow"};
        for(int i = 0;i < sizey;i++) {
            System.out.println("what is your guess?:\n(possible colors:Red,Blue,Green,Yellow,Orange,Pink)");
            board[i].setColor(cli.input());
            int[] num_solution = cpu.convertToNumbers(solution);
            int[] num_colors = cpu.convertToNumbers(board[i].getColor());
            board[i].setGuesses(cpu.check(num_solution,num_colors),cpu.check_completely(num_solution,num_colors));
            cli.Print_bord(board);

            int[] guesses = board[i].getGuesses();
            if(infinite == true){
                board[0] = new Row();
                i--;
            }
            if(guesses[1] == 4) {
                cli.win();
                win = true;
            }

        }
        if(infinite == false && win == false){
            cli.game_over("you ran out of guesses!");
    }

    }

    public void cpu_guesses_Control(){
        int count = -1;
        boolean p_rate = false;
        int selection = 0;
        ArrayList<String[]> bad = new ArrayList<>();
        ArrayList<int[]> allCombinations_number = cpu.all_combinations();

        ArrayList<String[]> allCombinations = new ArrayList<String[]>();
        for(int i = 0; i < 1296;i++) {
            allCombinations.add(cpu.convertToColors(allCombinations_number.get(i)));
        }

        String[] cpu_guess = new String[4];
        Scanner select = new Scanner(System.in);
        System.out.println("how hard should the cpu be?");
        System.out.println("1 = Easy   2 = Medium   3 = Hard");
        switch (select.nextInt()){
            case 1: selection = 1; break;
            case 2: selection = 2; break;
            case 3: selection = 3; break;
        }

        System.out.println("do you want to rate the CPU by hand(y/n)?");
        if(CLI.binary_question()){
            p_rate = true;
        }
        System.out.println("do you want to give the cpu infinite guesses(y/n)?");
        if(CLI.binary_question()){
            infinite = true;
        }
        if(infinite == false){
            System.out.println("how many guesses should the cpu have?");
            sizey = select.nextInt();
        }

        board = new Row[sizey];
        for (int i = 0; i < board.length;i++) {
            board[i] = new Row();
        }

        System.out.println("Input the color combination the cpu should guess:\n(possible colors:Red,Blue,Green,Yellow,Orange,Pink)");
        String[] solution = cli.input();

        Row old_board = new Row();
        for(int i = 0;i < sizey;i++){

            count++;
            switch (selection){
                case 1: board[i].setColor(cpu.easy(bad));bad.add(board[i].getColor()); break;
                case 2: board[i].setColor(cpu.medium(count, allCombinations));break;
                case 3: if(count == 0){
                    board[i].setColor(new String[]{"Red","Red","Blue","Blue"});
                    old_board = board[i];
                }else {
                    board[i].setColor(cpu.convertToColors(cpu.hard(old_board, allCombinations_number)));
                    old_board = board[i];
                } break;

            }
            if (p_rate){
                cli.Print_bord(board);
                cli.p_rate(board,i,solution);
            }else{
                int[] num_solution = cpu.convertToNumbers(solution);
                int[] num_colors = cpu.convertToNumbers(board[i].getColor());
                board[i].setGuesses(cpu.check(num_solution,num_colors),cpu.check_completely(num_solution,num_colors));
            }

            int[] guesses = board[i].getGuesses();
            if(guesses[1] == 4) {
                win = true;
                break;
            }
            if(infinite){
                board[0] = new Row();
                i--;
            }
        }
        cli.Print_bord(board);
        if(win == true){
            cli.game_over("the CPU got it right, it took it " + (count+1) + " guesses");
        }else{
            cli.win();
        }
    }

}
