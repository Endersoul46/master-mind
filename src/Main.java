import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
       startUp();
    }

    public static void startUp() {
        int input = -23;
        int select = 0;
        {
            System.out.println(" ___      ___       __        ________  ___________  _______   _______       ___      ___   __    _____  ___   ________   ");
            System.out.println("|\"  \\    /\"  |     /\"\"\\      /\"       )(\"     _   \")/\"     \"| /\"      \\     |\"  \\    /\"  | |\" \\  (\"   \\|\"  \\ |\"      \"\\  ");
            System.out.println(" \\   \\  //   |    /    \\    (:   \\___/  )__/  \\\\__/(: ______)|:        |     \\   \\  //   | ||  | |.\\\\   \\    |(.  ___  :) ");
            System.out.println(" /\\\\  \\/.    |   /' /\\  \\    \\___  \\       \\\\_ /    \\/    |  |_____/   )     /\\\\  \\/.    | |:  | |: \\.   \\\\  ||: \\   ) || ");
            System.out.println("|: \\.        |  //  __'  \\    __/  \\\\      |.  |    // ___)_  //      /     |: \\.        | |.  | |.  \\    \\. |(| (___\\ || ");
            System.out.println("|.  \\    /:  | /   /  \\\\  \\  /\" \\   :)     \\:  |   (:      \"||:  __   \\     |.  \\    /:  | /\\  |\\|    \\    \\ ||:       :) ");
            System.out.println("|___|\\__/|___|(___/    \\___)(_______/       \\__|    \\_______)|__|  \\___)    |___|\\__/|___|(__\\_|_)\\___|\\____\\)(________/  ");
            System.out.println("                                                                                                                           ");
        }
        System.out.println("                                      what game mode would you like to play?: \n" +
                "                                      1 = classic           2 = CPU vs YOU");
        Scanner question = new Scanner(System.in);
        if(question.hasNextInt()){
            input = question.nextInt();
        }else {
            System.out.println("this is not a valid game mode please try again");
            startUp();
        }

        if(input == 1){
            Control Start = new Control();
            Start.player_guesses_Control();
        }
        if(input == 2){
            Control Start = new Control();
            Start.cpu_guesses_Control();
        }


    }

}
