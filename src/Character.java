public class Character implements Creature {
    private String name;
    private int hp;
    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        boolean isAlive = true;
}