package model;

import java.util.ArrayList;
import java.util.List;

public class SuperTeam {
    
    private static int nextID;
    
    private int id;
    
    private String name;
    
    List<SuperHero> heroes = new ArrayList<>();

    public SuperTeam(String name) {
        this.name = name;
        this.id = nextID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuperHero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<SuperHero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SuperTeam other = (SuperTeam) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
