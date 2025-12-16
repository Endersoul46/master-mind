import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class CPU {

    public CPU() {


    }

    public String[] get_solution() {
        String[] solution;
        solution = new String[4];
        String[] options = new String[]{"Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
        Random rand = new Random();
        for (int i = 0; i < solution.length; i++) {
            int index = rand.nextInt(options.length);
            solution[i] = options[index];
        }
        return solution;
    }


    public int check(int[] solution, int[] user_try) {


        int correct = 0;
        boolean[] used = new boolean[4];
        for (int i = 0; i < solution.length; i++) {
            for (int d = 0; d < user_try.length; d++) {
                if (solution[i] == user_try[d] && used[d] == false) {
                    correct++;
                    used[d] = true;
                    break;
                }
            }
        }
        return correct;
    }

    public int check_completely(int[] solution, int[] user_try) {
        int completely_correct = 0;
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == user_try[i]) {
                completely_correct++;
            }
        }
        return completely_correct;
    }

    public String[] easy(ArrayList<String[]> bad) {
        String[] solution = get_solution();
        for (int i = 0; i < bad.size(); i++) {
            if (bad.get(i) == solution) {
                solution = get_solution();
            }
        }
        return solution;

    }
    public String[] medium(int count,ArrayList<String[]> allCombinations){
        return allCombinations.get(count);
    }




    public int[] hard(Row board,ArrayList<int[]> allCombinations) {
        int[] solution = convertToNumbers(board.getColor());
        int cc = board.getGuesses()[1];
        int c = board.getGuesses()[0];
        int best_worst_score = 0;

        check_possible(allCombinations,cc,c,solution);


        for(int i = 0; i < allCombinations.size();i++){
            int temp_c = -1;
            int temp_cc = 0;
            int worst = 1296;
            for(int j = 0;j < 8;j++){
                ArrayList<int[]> temp = new ArrayList<>(allCombinations);
                check_possible(temp,temp_cc,temp_c,solution);
                if(temp.size() < worst){
                    worst = temp.size();
                }
                switch (j % 2) {
                    case 0:
                        temp_c++;
                        break;
                    case 1:
                        temp_cc++;
                        break;
                }
            }
            if(worst >= best_worst_score){
                best_worst_score = worst;
                solution = allCombinations.get(i);
            }
        }
        allCombinations.remove(solution);
        return solution;
    }


    private void check_possible(ArrayList<int[]> allCombinations, int cc, int c, int[] solution) {
        allCombinations.removeIf(temp -> c != check(temp, solution) && cc != check_completely(temp, solution));
    }

    public ArrayList<int[]> all_combinations() {
        ArrayList<int[]> allCombinations = new ArrayList<>();

        int[] numbers = {1, 2, 3, 4, 5, 6};

        for (int num1 : numbers) {
            for (int num2 : numbers) {
                for (int num3 : numbers) {
                    for (int num4 : numbers) {
                        allCombinations.add(new int[]{num1, num2, num3, num4});
                    }
                }
            }
        }
        return allCombinations;
    }

    public String[] convertToColors(int[] numberCombination) {

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Pink"};


        String[] colorCombination = new String[numberCombination.length];
        for (int i = 0; i < numberCombination.length; i++) {
            colorCombination[i] = colors[numberCombination[i] - 1];
        }

        return colorCombination;
    }

    public int[] convertToNumbers(String[] colorCombination) {

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Pink"};


        int[] numberCombination = new int[colorCombination.length];
        for (int i = 0; i < colorCombination.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                if (colorCombination[i].equals(colors[j])) {
                    numberCombination[i] = j + 1;
                    break;
                }
            }
        }

        return numberCombination;
    }
}


