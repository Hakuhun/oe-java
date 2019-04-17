package service;

import java.util.ArrayList;
import java.util.List;
import model.SuperHero;
import model.SuperTeam;

public class TeamArranger {
    
    private static TeamArranger instance;
    
    private List<SuperHero> heroes = new ArrayList<>();
    
    private List<SuperTeam> teams = new ArrayList<>();

    private TeamArranger() {
    //csapatok és hősök megadása
        SuperHero im = new SuperHero("Iron Man", "Genius billionaire playboy philanthropist.");
        SuperHero thor = new SuperHero("Thor Odinson", "God of thunders. Literally a GOD");
        SuperHero hulk = new SuperHero("Hulk","SMASH!!");
        
        this.addHero(hulk); this.addHero(im); this.addHero(thor);
        
        SuperTeam avangers = new SuperTeam("Avangers!");
        this.addTeam(avangers);
        
        this.addMemberToTeam(avangers, hulk);
        this.addMemberToTeam(avangers, im);
        this.addMemberToTeam(avangers, thor);
    
    }
    
    public static TeamArranger getInstance(){
        if (instance == null) {
            instance = new TeamArranger();
        }
        return instance;
    }
    
    /*
        TEAM MANAGEMENT
    */
    public void addTeam(SuperTeam team){
        teams.add(team);
    }
    
    public void addMemberToTeam(SuperTeam team, SuperHero hero){
        team.getHeroes().add(hero);
    }
    
    public SuperTeam getTeamByName(String name) throws NullPointerException{
        for (SuperTeam t : teams) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        throw new NullPointerException();
    }
    
    public SuperTeam getTeamById(int id) throws NullPointerException{
        for (SuperTeam t : teams) {
            if (t.getId() == id) {
                return t;
            }
        }
        throw new NullPointerException();
    }
    
    /*
        HERO MANAGEMENT
    */
    
    public void addHero(SuperHero hero){
        heroes.add(hero);
    }
    
    public SuperHero getHeroById(int id) throws NullPointerException{
        for (SuperHero heroe : heroes) {
            if (heroe.getId() == id) {
                return heroe;
            }
        }
        throw new NullPointerException();
    }
    
    public SuperHero getHeroByName(String name) throws NullPointerException{
        for (SuperHero heroe : heroes) {
            if (heroe.getName().equals(name)) {
                return heroe;
            }
        }
        throw new NullPointerException();
    }
    
    public String getTeamsByHero(SuperHero hero){
        String heroTeams = "";
        for (SuperTeam team : teams) {
            if (team.getHeroes().contains(hero)) {
                heroTeams += team.getName() + System.lineSeparator(); /*\n*/
            }
        }
        if (heroTeams.isEmpty()) {
            heroTeams = hero.getName()  + " még nem tagja egy csapatnak sem";
        }
        
        return heroTeams;
    }

    public List<SuperHero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<SuperHero> heroes) {
        this.heroes = heroes;
    }

    public List<SuperTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<SuperTeam> teams) {
        this.teams = teams;
    }
    
    
    
}
