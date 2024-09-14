package untitled;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       System.out.print("플레이어 인원을 정하세요: ");
       int playersNum = scanner.nextInt();

       Game game = new Game(playersNum);

       game.playGame();
    }
}
