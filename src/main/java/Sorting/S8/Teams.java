package Sorting.S8;/* Created by oguzkeremyildiz on 16.03.2020 */

import java.util.ArrayList;
import java.util.Collections;

public class Teams {

    ArrayList<Team> teams = new ArrayList<>();

    public Teams(){
    }

    public boolean containTeam(String name){
        boolean bool = false;
        for (Team value : teams) {
            if (value.getName().equals(name)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public void removeTeam(Team team){
        teams.remove(team);
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public Team getTeam(int index){
        return teams.get(index);
    }

    public int size(){
        return teams.size();
    }

    public void clear(){
        teams.clear();
    }

    public int mostPoint(Teams team){
        int biggestPoint = 0;
        for (Team value : teams) {
            if ((value.getWins() * 3) + (value.getTies()) > biggestPoint) {
                team.clear();
                biggestPoint = (value.getWins() * 3) + (value.getTies());
                team.addTeam(value);
            } else if ((value.getWins() * 3) + (value.getTies()) == biggestPoint) {
                team.addTeam(value);
            }
        }
        return team.size();
    }

    public int mostWins(Teams team){
        int biggestWins = 0;
        for (Team value : teams) {
            if (value.getWins() > biggestWins) {
                team.clear();
                biggestWins = value.getWins();
                team.addTeam(value);
            } else if (value.getWins() == biggestWins) {
                team.addTeam(value);
            }
        }
        return team.size();
    }

    public int mostGoalDifference(Teams team){
        int biggestDifference = 0;
        for (Team value : teams) {
            if (value.getGoal() - value.getGoalAgainst() > biggestDifference) {
                team.clear();
                biggestDifference = value.getGoal() - value.getGoalAgainst();
                team.addTeam(value);
            } else if (value.getGoal() - value.getGoalAgainst() == biggestDifference) {
                team.addTeam(value);
            }
        }
        return team.size();
    }

    public int mostGoal(Teams team){
        int mostGoal = 0;
        for (Team value : teams) {
            if (value.getGoal() > mostGoal) {
                team.clear();
                mostGoal = value.getGoal();
                team.addTeam(value);
            } else if (value.getGoal() == mostGoal) {
                team.addTeam(value);
            }
        }
        return team.size();
    }

    public int mostGamePlayed(Teams team){
        int mostGamePlayed = 0;
        for (Team value : teams) {
            if (value.getGames() > mostGamePlayed) {
                team.clear();
                mostGamePlayed = value.getGames();
                team.addTeam(value);
            } else if (value.getGames() == mostGamePlayed) {
                team.addTeam(value);
            }
        }
        return team.size();
    }

    public void lexicographic(Teams team){
        ArrayList<String> names = new ArrayList<>();
        for (Team value : teams) {
            names.add(value.getName());
        }
        Collections.sort(names);
        for (Team value : teams) {
            if (value.getName().equals(names.get(0))) {
                team.addTeam(value);
                break;
            }
        }
    }
}
