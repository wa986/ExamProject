public abstract class Character implements Creature {
    private String name;
    private int hp;

    public Character(String name, int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.name = name;
        this.hp = hp;

    }

    public final boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println(name + "：HP " + hp);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }
    public abstract void attack(Creature target);
}