interface CharacterAbility {
    void useAbility();
    int getCooldown();
}

class FireballAbility implements CharacterAbility {
    public void useAbility() {
        System.out.println("Casting Fireball! Damage: 50");
    }
    
    public int getCooldown() {
        return 5; 
    }
}

public class GameDemo {
    public static void main(String[] args) {
        CharacterAbility ability = new FireballAbility();
        
        System.out.println("Testing character ability:");
        ability.useAbility();
        System.out.println("Cooldown: " + ability.getCooldown() + " seconds");
        
        System.out.println("\nUsing ability in combat:");
        for(int i = 0; i < 3; i++) {
            ability.useAbility();
            System.out.println("Waiting " + ability.getCooldown() + " seconds...");
        }
    }
}
