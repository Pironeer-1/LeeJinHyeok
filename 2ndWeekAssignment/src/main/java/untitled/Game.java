package untitled;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Enemy enemy;

    public Game(int players_num) {
        Scanner scanner = new Scanner(System.in);
        enemy = new Enemy(players_num);

        players = new ArrayList<Player>();
        for (int i = 0; i<players_num; i++) {
            int hp;
            int ad;
            int ap;

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("13만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요.");
            System.out.println("(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)");
            System.out.println();
            System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.");

            while (true) {
                hp = scanner.nextInt();
                ad = scanner.nextInt();
                ap = scanner.nextInt();

                if ((hp + ad + ap) == 13) {
                    players.add(new Player(i+1,50+3*hp,10+ad, 5+ap));
                    System.out.println("체력: " + (50+3*hp) + ", 공격력: " + (10+ad) + ", 마법력: " + (5+ap));
                    break;
                } else {
                    System.out.println("입력한 능력치의 총합이 13와 같아야 합니다. 다시 입력해주세요.");
                }
            }
        }
    }

    public void playGame() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            for (int index = 0; index <players.size(); index++) {
                Player player = players.get(index);

                while (true) {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println(player.getId() + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
                    System.out.println();
                    String action = scanner.nextLine();
                    if (action.equals("exit")) {
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    } else if (action.equals("1")) {
                        player.checkStatusAndAttack(enemy);
                        break;
                    } else if (action.equals("2")) {
                        player.normalAttack(enemy);
                        break;
                    } else if (action.equals("3")) {
                        player.magicAttack(enemy);
                        break;
                    } else if (action.equals("4")) {
                        player.heal();
                        break;
                    } else{
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }
                }


                if (enemy.getHp() == 0) {
                    System.out.println("축하합니다. 승리하셨습니다.");
                    System.exit(0);
                }
            }
            // enemy's turn
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("적의 차례입니다.");
            System.out.println();
            int randInt = random.nextInt(10) + 1;

            if (randInt == 1) {
                enemy.doNothing();
            } else if (randInt>= 9) {
                enemy.heal();
            } else {
                Player player = players.get(random.nextInt(players.size()));
                enemy.attack(player);

                if (player.getHp() == 0) {
                    players.remove(player);
                }
                if (players.isEmpty()) {
                    System.out.println("아쉽지만 패배하였습니다.");
                    System.exit(0);
                }
            }
        }
    }
}
