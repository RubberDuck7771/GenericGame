import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //construct player and monsters
        Player hero = new Player();
        Slime Goomy = new Slime("Goomy","Slime",10, 2,true);
        Slime Splotch = new Slime("Splotch","Slime",10,2,true);
        Slime Slimey = new Slime("Slimey","Slime",5,1,true);
        Ogre Shrek = new Ogre ("Shrek","Ogre",20,10,3);
        Ogre Trollie = new Ogre ("Trollie","Ogre",15,10,4);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Welcome to the ReneeKaty Game!");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("You ambush a monster encampment and attack several monsters!");
        Goomy.printMonsterInfo();
        Splotch.printMonsterInfo();
        Slimey.printMonsterInfo();
        Shrek.printMonsterInfo();
        Trollie.printMonsterInfo();

        boolean fightOccuring = true;
        int turn = 1;
        int damage = 0;
        int kills = 0;
        boolean goomyCount = true; //to add a kill only when the monster initially dies, not every time code checks if alive
        boolean splotchCount = true;
        boolean slimeyCount = true;
        boolean shrekCount = true;
        boolean trollieCount = true;
        boolean merged = false;

        //fight starts
        while(fightOccuring){
            Scanner s = new Scanner(System.in);

            System.out.println();
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Turn " + turn + ":");
            turn++;
            damage = 0;

            //player action
            System.out.println("What do you do next?");
            System.out.println("[A] Attack: Deal 5 damage to all the monsters.");
            System.out.println("[B] Heal: Gain 15 health back.");
            String choice = s.nextLine();
            if(choice.equals("A")){ //slash
                int hitChanceSlash = (int) (Math.random()*5)+1;
                if(hitChanceSlash == 1){ //slash has a 4 in 5 hit chance
                    System.out.println("Uh oh, your attack missed!");
                } else {
                    System.out.println("You slash at the monsters!");
                    Goomy.playerAttacked();
                    Splotch.playerAttacked();
                    Slimey.playerAttacked();
                    Shrek.playerAttacked();
                    Trollie.playerAttacked();
                }
            } else if (choice.equals("B")){ //heal
                System.out.println("You chug a potion. +15 health");
                hero.playerHealed();
            }


            //monster action
            int chanceMerge = (int) (Math.random()*3+1);
            if(chanceMerge == 1 && !merged){ //1 in 3 chance for merging to happen each turn, until it happens
                Goomy.dieToMerge();
                Splotch.doubleHpMerge();
                merged = true;
            }

            if (Goomy.monsterAlive()) {
                damage += Goomy.damageCalc();
            }
            if (Splotch.monsterAlive()) {
                damage += Splotch.damageCalc();
            }
            if (Slimey.monsterAlive()) {
                damage += Slimey.damageCalc();
            }
            if (Shrek.monsterAlive()) {
                damage += Shrek.damageCalc(turn);
            }
            if (Trollie.monsterAlive()) {
                damage += Trollie.damageCalc(turn);
            }
            hero.monsterAttacked(damage);


            //printing all the healths
            if (Goomy.monsterAlive()) { //slime attacks every turn if alive
                System.out.println("Goomy the Slime: " + Goomy.getHealth());
            } else {
                if(goomyCount){
                    hero.setKills(kills++);
                    goomyCount = false;
                }
                System.out.println("Goomy: dead");
            }
            if (Splotch.monsterAlive()) {
                System.out.println("Splotch the Slime: " + Splotch.getHealth());
            } else {
                if(splotchCount){
                    hero.setKills(kills++);
                    splotchCount = false;
                }
                System.out.println("Splotch: dead");
            }
            if (Slimey.monsterAlive()) {
                System.out.println("Slimey the Slime: " + Slimey.getHealth());
            } else {
                if(slimeyCount){
                    hero.setKills(kills++);
                    slimeyCount = false;
                }
                System.out.println("Slimey: dead");
            }
            if (Shrek.monsterAlive()) {
                System.out.println("Shrek the Ogre: " + Shrek.getHealth());
            } else {
                if(shrekCount){
                    hero.setKills(kills++);
                    shrekCount = false;
                }
                System.out.println("Shrek: dead");
            }
            if (Trollie.monsterAlive()) {
                System.out.println("Trollie the Ogre: " + Trollie.getHealth());
            } else {
                if(trollieCount){
                    hero.setKills(kills++);
                    trollieCount = false;
                }
                System.out.println("Trollie: dead");
            }
            hero.calcLevel();
            System.out.println("You:");
            System.out.println("(Level): " + hero.getPlayerLevel());
            System.out.println("(Kills): " + hero.getKills() + ", " + hero.getKillsToLevel() + " total kills needed to level up");
            System.out.println("(Health): " + hero.getPlayerHealth() + "/" + hero.getMaxPlayerHealth());
            System.out.println("(Strength): " + hero.getPlayerStrength());


            //lose condition
            if(!hero.alive()){
                fightOccuring = false;
            } else if (hero.alive() && (!Goomy.monsterAlive() && !Splotch.monsterAlive() && !Slimey.monsterAlive() && !Shrek.monsterAlive() && !Trollie.monsterAlive())){
                System.out.println("You defeated all the monsters!");
                fightOccuring = false;
            }
        }

        if(!hero.alive()){ //messages when you lose
            System.out.println("YOU DIED!");
            System.out.println("Rerun this program if you want to try again!");
        } else {
            System.out.println("You win!! Good job!");
        }
    }
}
