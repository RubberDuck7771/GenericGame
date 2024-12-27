public class Player {

    //variables for health
    public int maxPlayerHealth = 30;
    public int playerHealth = 30;
    private boolean alive = true;

    //variables for attack
    public static int playerAtk = 5;

    //variables for level up
    public static int playerLevel = 1;
    public static int kills = 0;
    private static int killsToLevel = 2;


    //constructor
    public Player(){ }

    //getters/setters
    public static int getPlayerAtk(){
        return(playerAtk);
    }
    public int getPlayerHealth(){
        return(playerHealth);
    }
    public int getMaxPlayerHealth(){
        return(maxPlayerHealth);
    }
    public int getPlayerStrength(){
        return(playerAtk);
    }
    public static int getPlayerLevel(){
        return(playerLevel);
    }
    public static int getKills(){
        return(kills);
    }
    public static void setKills(int killNum){
        kills = killNum;
    }
    public static int getKillsToLevel(){
        return(killsToLevel);
    }


    //return if the player is alive or not
    public boolean alive(){
        if(playerHealth <= 0){
            alive = false;
        }
        return(alive);
    }

    public int monsterAttacked(int damage){
        playerHealth -= damage;
        return(playerHealth);
    }

    public void playerHealed(){
        if(playerHealth + 15 <= maxPlayerHealth){
            playerHealth += 15;
        } else {
            playerHealth = maxPlayerHealth;
        }
    }

    //level up system (player gains health and atk upon lvl up)
    public void calcLevel(){
        if(kills == killsToLevel){ //if the player reaches a certain amt of kills, they level up
            killsToLevel = kills + (killsToLevel * 2);
            playerLevel++;
            System.out.println("You leveled up to level " + playerLevel + "!");
            int healthAddedLvl = 4 + (int)((Math.random()*6)+1); //player gains 5 to 10 max health
            if(maxPlayerHealth == playerHealth){
                playerHealth += healthAddedLvl; //if player was at maxHP before lvl up, their health will update w/ stat boost
            } else {
                playerHealth += (int) healthAddedLvl / 3; //else, player heals about a third of the hp they gained from leveling up
            }
            maxPlayerHealth += healthAddedLvl;
            playerAtk++;
            System.out.println("Health: " + playerHealth + "/" + maxPlayerHealth);
            System.out.println("Strength: " + playerAtk);
        }
    }


    //testing
    public static void main(String[] args) {
        Player fred = new Player();
        System.out.println(fred.getPlayerHealth());
        System.out.println("Fred got hit and now has " + fred.monsterAttacked(1) + " health points!");
        System.out.println(fred.getPlayerHealth());
        fred.setKills(2);
        fred.calcLevel();
    }
}