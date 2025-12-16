import java.util.ArrayList;
public class Row {
    private String[] color;
    private int[] guesses = new int[]{0,0};
    public Row() {
        color = new String[]{"empty", "empty", "empty", "empty"};
    }

    public void setColor(String[] array1) {
        color = array1;
  }

    public void setGuesses(int correct,int completely_correct) {
        guesses[0] = correct;
        guesses[1] = completely_correct;
    }

    public String[] getColor(){
        return color;
    }


    public int[] getGuesses(){
        return guesses;
    }

}