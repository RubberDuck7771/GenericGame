public class Slime extends Monster{

    //variables
    private final boolean mergability;

    //constructor
    public Slime(String name, String species, int health, int strength, boolean mergability) {
        this.name = name;
        this.species = "Slime";
        this.health = health;
        this.strength = strength;
        this.mergability = mergability;
    }

    //getter
    public boolean isMergable() {
        return mergability;
    }

    public void dieToMerge(){
        if(isMergable() && health > 0){
            health = 0;
            System.out.println(name + " the Slime dissolves...");
        }
    }

    public void doubleHpMerge(){
        if(isMergable() && health > 0){
            health *= 2;
            System.out.println("...and merges with " + name + " the Slime!");
        }
    }

    public int damageCalc(){
        int damage;
        int chance = ((int)(Math.random()*2)+1);
        damage = strength;
        System.out.println(name + " the Slime slammed into you! -" + damage + " health");
        if (chance == 1){
            damage += 2;
            System.out.println("You were poisoned! -2 health");
        }
        return damage;
    }

    public void makeSound(){
        System.out.println("Goop goop!");
    }


    //testing
    public static void main(String[] args) {
        Slime fred = new Slime("Fred", "Slime", 10, 3, true);
        Slime greg = new Slime("Greg", "Slime", 10, 3, true);
        System.out.println(fred.damageCalc());
        fred.makeSound();
        fred.dieToMerge();
        greg.doubleHpMerge();
        fred.printMonsterInfo();
        greg.printMonsterInfo();
    }
}

