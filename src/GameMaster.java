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
        for (Character character : party) {
            character.showStatus();
        }

        System.out.println("---敵グループ---");
        for (Monster monster : monsters) {
            monster.showStatus();
        }

        System.out.println("味方の総攻撃!");
        for (Character attacker : party) {
            for (Monster target : monsters) {
                if (target.isAlive()) {
                    attacker.attack(target);
                }
            }
        }

        System.out.println("敵の総攻撃!");
        for (Monster enemy : monsters) {
            if (enemy.isAlive()) {
                for (Character target : party) {
                    if (target.isAlive()) {
                        enemy.attack(target);
                    }
                }
            }
        }

        System.out.println("ダメージを受けた勇者が突然光だした!");
        SuperHero superHero = new SuperHero(hero);
        party.set(0, superHero);  // 勇者 → スーパーヒーローに差し替え
        System.out.println("勇者はスーパーヒーローに進化した!");

        System.out.println("スーパーヒーローの強力な攻撃!");
        for (Monster target : monsters) {
            if (target.isAlive()) {
                superHero.attack(target);
            }
        }

        System.out.println("味方パーティ最終ステータス");
        for (Character member : party) {
            member.showStatus();
            System.out.println("生存状況: " + (member.isAlive() ? "生存" : "戦闘不能"));
        }

        System.out.println("---敵グループ最終ステータス---");
        for (Monster monster : monsters) {
            monster.showStatus();
            System.out.println("生存状況: " + (monster.isAlive() ? "生存" : "討伐済み"));
        }
    }
}
