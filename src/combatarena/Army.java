package combatarena;

import static combatarena.CombatArena.random;
import java.util.ArrayList;

/**
 *
 * @author seb
 */
public class Army {

    String name;
    ArrayList<Soldier> activeSoldiers;
    ArrayList<Soldier> wounded;
    ArrayList<Soldier> dead;
    ArrayList<Soldier> deserters;
    
    public Army(String name) {
        this.name = name;
        this.activeSoldiers = new ArrayList<>();
        this.wounded = new ArrayList<>(); 
        this.dead = new ArrayList<>(); 
        this.deserters = new ArrayList<>(); 
        generate();
    }

    
    public void generate (){
        for (int i = 0; i < (10 + random.nextInt(10)); i++) {
            Soldier soldier = new Soldier( Integer.toString(i) );
            soldier.soldierID = i;
            
            activeSoldiers.add(soldier);
        }
        
        System.out.println("");
        System.out.println("Army Size:" + activeSoldiers.size());
        
    }
    
    public void rollCall () {
        System.out.println("Living soldiers:");
        for(Soldier soldier : activeSoldiers){
            System.out.print(String.format("%8s", !soldier.dead ? "true" : "false"));
        }
        System.out.println("");
    }
    
    public void filterCasualties() {
        
        ArrayList <Soldier> filteredSoldiers = new ArrayList<>();
        
        for(Soldier soldier : activeSoldiers){
            if (soldier.dead){
                dead.add(soldier);
            }
            else if (soldier.wounded){
                wounded.add(soldier);
            }
            else if (soldier.deserter){
                deserters.add(soldier);
            }
            else {
                filteredSoldiers.add(soldier);
            }
        }

        activeSoldiers = filteredSoldiers;
    }
    
}
