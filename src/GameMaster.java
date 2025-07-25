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

        System.out.println("---味方パーティ---");
        for (Character character : party) {
            character.showStatus();
        }

        System.out.println("---敵グループ---");
        for (Monster monster : monsters) {
            monster.showStatus();
        }

        System.out.println("\n味方の総攻撃!");
        for (Character attacker : party) {
            for (Monster target : monsters) {
                attacker.attack(target);
            }
        }

        System.out.println("\n敵の総攻撃!");
        for (Monster enemy : monsters) {
            for (Character target : party) {
                enemy.attack(target);
            }
        }


        System.out.println("\nダメージを受けた勇者が突然光だした!");
        SuperHero superHero = new SuperHero(hero);
        System.out.println("勇者はスーパーヒーローに進化した!");
        party.set(0, superHero);
        for (Monster target : monsters) {
            superHero.attack(target);
        }

        System.out.println("\n---味方パーティ最終ステータス---");
        for (Character member : party) {
            member.showStatus();
            if (member.isAlive()){
                System.out.println("生存状況:生存");
            } else {
                System.out.println("生存状況:戦闘不能");
            }
        }

        System.out.println("\n---敵グループ最終ステータス---");
        for (Monster monster : monsters) {
            monster.showStatus();
            if (monster.isAlive()) {
                System.out.println("生存状況:生存");
            } else {
                System.out.println("生存状況:討伐済み");
            }
        }
    }
}