package untitled;

public class Enemy {
    private int hp;
    private int ad;
    private int ad_def;
    private int ap_def;
    private int max_hp;

    public Enemy(int list_num) {
        this.max_hp = 100 * list_num;
        this.hp = 100 * list_num;
        this.ad = 25;
        this.ad_def = 7;
        this.ap_def = 7;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAdDef() {
        return ad_def;
    }

    public void setAdDef(int ad_def) {
        this.ad_def = ad_def;
    }

    public int getApDef() {
        return ap_def;
    }

    public void setApDef(int ap_def) {
        this.ap_def = ap_def;
    }

    public int getMaxHp() {
        return max_hp;
    }

    public void setMaxHp(int max_hp) {
        this.max_hp = max_hp;
    }

    public void doNothing() {
        System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
    }

    public void attack(Player player) {
        player.setHp(Math.max(player.getHp() - ad, 0));
        System.out.println(player.getId() + "번 유저에게 " + this.ad + "의 데미지. 적의 공격으로 현재 남은 체력은 " + player.getHp() + "입니다.");
    }


    public void heal() {

        if (this.hp + 7 <= this.max_hp) {
            this.hp = this.hp+7;
            System.out.println("적의 회복으로 현재 적의 체력은 " + this.hp + "입니다.");
        } else {
            this.hp = this.max_hp;
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.");
        }
    }
}

