package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.ManageableTeam;
import hr.fer.oop.lab3.welcomepack.Manager;

/**
 * TODO: Document this class
 */
public class Coach extends Person implements Manager {

    private int coachingSkill = Constants.DEFAULT_COACHING_SKILL;
    private Formation formation = Constants.DEFAULT_FORMATION;
    private ManageableTeam managingTeam;

    public Coach(String name, String country) {
    	super(name, country);
    }        
    
    public Coach(String name, String country, int emotion, int coachingSkill, Formation formation) {
        super(name, country, emotion);
        setCoachingSkill(coachingSkill);
        setFormation(formation);
    }

    public void setCoachingSkill(int coachingSkill) {
        if (coachingSkill >= Constants.MIN_COACHING_SKILL && coachingSkill <= Constants.MAX_COACHING_SKILL)
            this.coachingSkill = coachingSkill;
        else System.err.println("Coaching skill out of range! :(");
    }
    
    public int getCoachingSkill() {
        return coachingSkill;
    }

    public Formation getFormation() {
        return formation;
    }
    public void setFormation(Formation formation) {
        this.formation = formation;        
    }

    @Override
    public void pickStartingEleven() {
        int gk = managingTeam.getFormation().getNoGK();
        int df = managingTeam.getFormation().getNoDF();
        int mf = managingTeam.getFormation().getNoMF();
        int fw = managingTeam.getFormation().getNoFW();

        managingTeam.clearStartingEleven();
        for(FootballPlayer player : managingTeam.getRegisteredPlayers().getPlayers()){

            if(player != null && managingTeam.getStartingEleven().size() != managingTeam.getStartingEleven().getMaxSize()){
                switch (player.getPlayingPosition()){
                    case GK:
                        if(gk>0){
                            managingTeam.addPlayerToStartingEleven(player);
                            gk--;
                        }
                        break;
                    case DF:
                        if(df>0){
                            managingTeam.addPlayerToStartingEleven(player);
                            df--;
                        }
                        break;
                    case MF:
                        if(mf>0){
                            managingTeam.addPlayerToStartingEleven(player);
                            mf--;
                        }
                        break;
                    case FW:
                        if(fw>0){
                            managingTeam.addPlayerToStartingEleven(player);
                            fw--;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void forceMyFormation() {
        managingTeam.setFormation(formation);
    }

    @Override
    public void setManagingTeam(ManageableTeam team) {
        this.managingTeam = team;        
    }
}
