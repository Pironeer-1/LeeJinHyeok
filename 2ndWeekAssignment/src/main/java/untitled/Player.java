package untitled;

import java.util.Random;

public class Player {
    private int id;
    private int hp;
    private int ad;
    private int ap;

    public Player(int id, int hp, int ad, int ap) {
        this.id = id;
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAd() {
        return this.ad;
    }

    public int getAp() {
        return this.ap;
    }

    public void checkStatusAndAttack(Enemy enemy) {
        System.out.println("현재 유저: 체력 " + this.hp + ", 공격력 " + this.ad + ", 마법력 " + this.ap);
        System.out.println("적: 체력 " + enemy.getHp() + ", 공격력 " + enemy.getAd() + ", 방어력 " + enemy.getAdDef() + ", 마법방어력 " + enemy.getApDef());

        generalAttack(enemy);
    }

    public void generalAttack(Enemy enemy) { //일반 공격
        enemy.setHp(Math.max((enemy.getHp() - (this.ad - enemy.getAdDef())), 0));
        System.out.println("일반 공격으로 " + (this.ad - enemy.getAdDef()) + "의 데미지를 주었습니다.");
    }

    public void criticalAttack(Enemy enemy) {
        enemy.setHp(Math.max(enemy.getHp() - 2 * (this.ad - enemy.getAdDef()), 0));
        System.out.println("치명타가 적용되어 " + (2 * (this.ad - enemy.getAdDef())) + "의 데미지를 주었습니다.");
    }

    public void normalAttack(Enemy enemy) { // 기본 공격
        Random random = new Random();

        int critical = random.nextInt(10) + 1; //1에서 10까지의 랜덤 숫자
        if (critical > 2) {
            generalAttack(enemy);
        } else {
            criticalAttack(enemy);
        }
    }

    public void magicAttack(Enemy enemy) {
        enemy.setHp(Math.max((enemy.getHp() - (2 * ap - enemy.getApDef())), 0));
        System.out.println("마법 공격으로 " + (2 * ap - enemy.getApDef()) + "의 데미지를 주었습니다.");
    }

    public void heal() {
        Random random = new Random();

        int randInt = random.nextInt(6) + 5;
        this.hp = this.hp + randInt;

        System.out.println("체력을 회복합니다. 현재 hp는 " + this.hp + "입니다.");
    }
}