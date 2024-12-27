public class Monster {
    //setup
    public  String name;
    public int health;
    public int strength;
    public String species;

    //getter
    public int getStrength() {
        return (strength);
    }

    //constructor
    public Monster(String name, String species, int health, int strength) {
        this.name = name;
        this.species = species;
        this.health = health;
        this.strength = strength;
    }
    public Monster(){ }

    //print monster stats
    public void printMonsterInfo() {
        System.out.println(this.name + " the " + this.species + " has " + this.health + " health and " + this.strength + " strength.");
    }

    public boolean monsterAlive(){
        if(health > 0){
            return(true);
        } else {
            return(false);
        }
    }

    public int getHealth(){
        return(health);
    }

    public int playerAttacked() {
        health -= Player.getPlayerAtk();
        return(health);
    }

    public int damageCalc() {
        System.out.println(name + " the Monster attacked you! -" + strength + " health");
        return(strength);
    }

    public void makeSound() {
        System.out.println("Grrrr!");
    }

    //testing
    public static void main(String[] args) {
        Monster fred = new Monster("Fred", "Monster",10, 3);
        fred.printMonsterInfo();
        System.out.println(fred.damageCalc());
        fred.makeSound();
    }
}




