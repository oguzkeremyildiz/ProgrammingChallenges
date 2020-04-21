package Sorting.S8;/* Created by oguzkeremyildiz on 16.03.2020 */

public class Team {

    String name;
    int goal;
    int games;
    int wins;
    int loses;
    int ties;
    int goalAgainst;

    public Team(String name, int goal, int games, int wins, int loses, int ties, int goalAgainst){
        this.name = name;
        this.goal = goal;
        this.games = games;
        this.wins = wins;
        this.loses = loses;
        this.ties = ties;
        this.goalAgainst = goalAgainst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(int goalAgainst) {
        this.goalAgainst = goalAgainst;
    }
}
