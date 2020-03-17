package Sorting.S8;/* Created by oguzkeremyildiz on 16.03.2020 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Football {
    private static void reserve(String line, ArrayList<String> features){
        String element = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != '#' && line.charAt(i) != '@'){
                element += line.charAt(i);
            } else {
                features.add(element);
                element = "";
            }
        }
        features.add(element);
    }
    private static void print(Teams teams){
        int i = 0;
        while (teams.size() != 0){
            i++;
            Teams team = new Teams();
            if (teams.mostPoint(team) == 1){
                System.out.println(i + ") " + team.getTeam(0).getName() + " " + (team.getTeam(0).getWins() * 3 + (team.getTeam(0).getTies())) + "p, " + team.getTeam(0).getGames() + "g " + "(" + team.getTeam(0).getWins() + "-" + team.getTeam(0).getTies() + "-" + team.getTeam(0).getLoses() + "), " + (team.getTeam(0).getGoal() - team.getTeam(0).getGoalAgainst()) + "gd (" + team.getTeam(0).getGoal() + "-" + team.getTeam(0).getGoalAgainst() + ")");
                teams.removeTeam(team.getTeam(0));
            } else if (teams.mostPoint(team) > 1){
                team.clear();
                if (teams.mostWins(team) == 1){
                    System.out.println(i + ") " + team.getTeam(0).getName() + " " + (team.getTeam(0).getWins() * 3 + (team.getTeam(0).getTies())) + "p, " + team.getTeam(0).getGames() + "g " + "(" + team.getTeam(0).getWins() + "-" + team.getTeam(0).getTies() + "-" + team.getTeam(0).getLoses() + "), " + (team.getTeam(0).getGoal() - team.getTeam(0).getGoalAgainst()) + "gd (" + team.getTeam(0).getGoal() + "-" + team.getTeam(0).getGoalAgainst() + ")");
                    teams.removeTeam(team.getTeam(0));
                } else if (teams.mostWins(team) > 1){
                    team.clear();
                    if (teams.mostGoalDifference(team) == 1){
                        System.out.println(i + ") " + team.getTeam(0).getName() + " " + (team.getTeam(0).getWins() * 3 + (team.getTeam(0).getTies())) + "p, " + team.getTeam(0).getGames() + "g " + "(" + team.getTeam(0).getWins() + "-" + team.getTeam(0).getTies() + "-" + team.getTeam(0).getLoses() + "), " + (team.getTeam(0).getGoal() - team.getTeam(0).getGoalAgainst()) + "gd (" + team.getTeam(0).getGoal() + "-" + team.getTeam(0).getGoalAgainst() + ")");
                        teams.removeTeam(team.getTeam(0));
                    } else if (teams.mostGoalDifference(team) > 1){
                        team.clear();
                        if (teams.mostGoal(team) == 1){
                            System.out.println(i + ") " + team.getTeam(0).getName() + " " + (team.getTeam(0).getWins() * 3 + (team.getTeam(0).getTies())) + "p, " + team.getTeam(0).getGames() + "g " + "(" + team.getTeam(0).getWins() + "-" + team.getTeam(0).getTies() + "-" + team.getTeam(0).getLoses() + "), " + (team.getTeam(0).getGoal() - team.getTeam(0).getGoalAgainst()) + "gd (" + team.getTeam(0).getGoal() + "-" + team.getTeam(0).getGoalAgainst() + ")");
                            teams.removeTeam(team.getTeam(0));
                        } else if (teams.mostGoal(team) > 1){
                            team.clear();
                            if (teams.mostGamePlayed(team) == 1){
                                System.out.println(i + ") " + team.getTeam(0).getName() + " " + (team.getTeam(0).getWins() * 3 + (team.getTeam(0).getTies())) + "p, " + team.getTeam(0).getGames() + "g " + "(" + team.getTeam(0).getWins() + "-" + team.getTeam(0).getTies() + "-" + team.getTeam(0).getLoses() + "), " + (team.getTeam(0).getGoal() - team.getTeam(0).getGoalAgainst()) + "gd (" + team.getTeam(0).getGoal() + "-" + team.getTeam(0).getGoalAgainst() + ")");
                                teams.removeTeam(team.getTeam(0));
                            } else if (teams.mostGamePlayed(team) > 1){
                                team.clear();
                                teams.lexicographic(team);
                                teams.removeTeam(team.getTeam(0));
                                team.clear();
                            }
                        }
                    }
                }
            }
        }
    }
    private static void setTeam(Teams teams, ArrayList<String> matches){
        ArrayList<String> features = new ArrayList<>();
        for (String match : matches) {
            features.clear();
            reserve(match, features);
            if (teams.containTeam(features.get(0))) {
                for (int j = 0; j < teams.size(); j++) {
                    int wins = 0;
                    int loses = 0;
                    int ties = 0;
                    if (Integer.parseInt(features.get(1)) > Integer.parseInt(features.get(2))) {
                        wins = 1;
                    } else if (Integer.parseInt(features.get(1)) < Integer.parseInt(features.get(2))) {
                        loses = 1;
                    } else {
                        ties = 1;
                    }
                    if (teams.getTeam(j).getName().equals(features.get(0))) {
                        teams.getTeam(j).setGoal(teams.getTeam(j).getGoal() + Integer.parseInt(features.get(1)));
                        teams.getTeam(j).setGames(teams.getTeam(j).getGames() + 1);
                        teams.getTeam(j).setWins(teams.getTeam(j).getWins() + wins);
                        teams.getTeam(j).setLoses(teams.getTeam(j).getLoses() + loses);
                        teams.getTeam(j).setTies(teams.getTeam(j).getTies() + ties);
                        teams.getTeam(j).setGoalAgainst(teams.getTeam(j).getGoalAgainst() + Integer.parseInt(features.get(2)));
                        break;
                    }
                }
            } else {
                int wins = 0;
                int loses = 0;
                int ties = 0;
                if (Integer.parseInt(features.get(1)) > Integer.parseInt(features.get(2))) {
                    wins = 1;
                } else if (Integer.parseInt(features.get(1)) < Integer.parseInt(features.get(2))) {
                    loses = 1;
                } else {
                    ties = 1;
                }
                teams.addTeam(new Team(features.get(0), Integer.parseInt(features.get(1)), 1, wins, loses, ties, Integer.parseInt(features.get(2))));
            }
            if (teams.containTeam(features.get(3))) {
                for (int j = 0; j < teams.size(); j++) {
                    int wins = 0;
                    int loses = 0;
                    int ties = 0;
                    if (Integer.parseInt(features.get(2)) > Integer.parseInt(features.get(1))) {
                        wins = 1;
                    } else if (Integer.parseInt(features.get(2)) < Integer.parseInt(features.get(1))) {
                        loses = 1;
                    } else {
                        ties = 1;
                    }
                    if (teams.getTeam(j).getName().equals(features.get(3))) {
                        teams.getTeam(j).setGoal(teams.getTeam(j).getGoal() + Integer.parseInt(features.get(2)));
                        teams.getTeam(j).setGames(teams.getTeam(j).getGames() + 1);
                        teams.getTeam(j).setWins(teams.getTeam(j).getWins() + wins);
                        teams.getTeam(j).setLoses(teams.getTeam(j).getLoses() + loses);
                        teams.getTeam(j).setTies(teams.getTeam(j).getTies() + ties);
                        teams.getTeam(j).setGoalAgainst(teams.getTeam(j).getGoalAgainst() + Integer.parseInt(features.get(1)));
                        break;
                    }
                }
            } else {
                int wins = 0;
                int loses = 0;
                int ties = 0;
                if (Integer.parseInt(features.get(2)) > Integer.parseInt(features.get(1))) {
                    wins = 1;
                } else if (Integer.parseInt(features.get(2)) < Integer.parseInt(features.get(1))) {
                    loses = 1;
                } else {
                    ties = 1;
                }
                teams.addTeam(new Team(features.get(3), Integer.parseInt(features.get(2)), 1, wins, loses, ties, Integer.parseInt(features.get(1))));
            }
        }
    }
    public static void main(String[]args){
        try {
            int times;
            int time;
            String line;
            String teamName;
            Teams teams = new Teams();
            ArrayList<String> matches = new ArrayList<>();
            Scanner source = new Scanner(new File("Football.txt"));
            line = source.nextLine();
            time = Integer.parseInt(line);
            for (int i = 0; i < time; i++) {
                teamName = source.nextLine();
                line = source.nextLine();
                times = Integer.parseInt(line);
                for (int j = 0; j < times; j++) {
                    line = source.nextLine();
                }
                line = source.nextLine();
                times = Integer.parseInt(line);
                for (int t = 0; t < times; t++) {
                    matches.add(line = source.nextLine());
                }
                System.out.println(teamName);
                setTeam(teams, matches);
                print(teams);
                matches.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
