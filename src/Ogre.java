public class Ogre extends Monster{

    //variables
    private final int cooldown;

    //constructor
    public Ogre(String name, String species, int health, int strength, int cooldown) {
        this.name = name;
        this.species = "Ogre";
        this.health = health;
        this.strength = strength;
        this.cooldown = cooldown;
    }

    public int damageCalc(int turn){
        int damage;
        int chance = ((int)(Math.random()*2)+1);
        if(turn % cooldown == 0){
            if(chance == 1){
                damage = strength;
                System.out.println(name + " the Ogre pummeled you with its axe! -" + damage + " health");
            } else {
                damage = 0;
                System.out.println(name + " the Ogre missed its attack!");
            }
        } else {
            damage = 0;
            System.out.println(name + " the Ogre is readying an attack.");
        }
        return damage;
    }

    public void makeSound(){
        System.out.println("ROARRRR!");
    }


    //testing
    public static void main(String[] args) {
        Ogre fred = new Ogre("Fred", "Ogre", 10, 3, 2);
        System.out.println(fred.damageCalc(2));
        System.out.println(fred.damageCalc(1));
        fred.makeSound();
        fred.printMonsterInfo();
    }
}

