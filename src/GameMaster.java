import java.util.ArrayList;

public class GameMaster {

    public static void main(String[] args) {
        Hero hero = new Hero("勇者", 100, "剣");
        Wizard wizard = new Wizard("魔法使い", 60, 20);
        Thief thief = new Thief("盗賊", 70);

        ArrayList<Character> party = new ArrayList<>();
        party.add(hero);
        party.add(wizard);
        party.add(thief);

        Matango matangoA = new Matango('A', 45);
        Goblin goblinA = new Goblin('A', 50);
        Slime slimeA = new Slime('A', 40);

        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(matangoA);
        monsters.add(goblinA);
        monsters.add(slimeA);

        System.out.println("味方パーティー");
        for (Character c : party) {
            c.showStatus();
        }

        System.out.println("---敵グループ---");
        for (Monster m : monsters) {
            m.showStatus();
        }

        System.out.println("味方の総攻撃!");
        for (Character c : party) {
            for (Monster m : monsters) {
                if (m.isAlive()) {
                    c.attack(m);
                }
            }
        }

        System.out.println("敵の総攻撃!");
        for (Monster m : monsters) {
            if (m.isAlive()) {
                for (Character c : party) {
                    if (c.isAlive()) {
                        m.attack(c);
                    }
                }
            }
        }

        System.out.println("ダメージを受けた勇者が突然光だした!");
        SuperHero superHero = new SuperHero(hero);
        party.set(0, superHero);  // 勇者 → スーパーヒーローに差し替え
        System.out.println("勇者はスーパーヒーローに進化した!");

        // スーパーヒーローの強力な攻撃
        for (Monster m : monsters) {
            if (m.isAlive()) {
                superHero.attack(m);
            }
        }

        System.out.println("味方パーティ最終ステータス");
        for (Character c : party) {
            c.showStatus();
            System.out.println("生存状況: " + (c.isAlive() ? "生存" : "戦闘不能"));
        }

        System.out.println("---敵グループ最終ステータス---");
        for (Monster m : monsters) {
            m.showStatus();
            System.out.println("生存状況: " + (m.isAlive() ? "生存" : "討伐済み"));
        }
    }
}
