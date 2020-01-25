package DataStructures;/* Created by oguzkeremyildiz on 23.01.2020 */

import java.io.File;
import java.util.*;

public class ErdösNumbers {
    private static void print(ArrayList<String> outputs, HashMap<Integer, HashSet<String>> listOfNames, int scenario){
        System.out.println("Scenario " + scenario);
        for (int i = 0; i < outputs.size(); i++){
            if (listOfNames.get(100000).contains(outputs.get(i))){
                System.out.println(outputs.get(i) + " infinity");
            } else {
                for (Integer key : listOfNames.keySet()){
                    if (listOfNames.get(key).contains(outputs.get(i))){
                        System.out.println(outputs.get(i) + " " + key);
                    }
                }
            }
        }
    }
    private static void setListForOnes(HashMap<Integer,HashSet<String>> listOfNames, List<String> persons, HashSet<String> allPersons, HashMap<String, ArrayList<String>> graphEdges){
        HashSet<String> personsHash = new HashSet<>(persons);
        allPersons.addAll(personsHash);
        if (personsHash.contains("Erdos")){
            personsHash.remove("Erdos");
            ArrayList<String> personsHashContain = new ArrayList<>(personsHash);
            for (int i = 0; i < personsHash.size(); i++){
                listOfNames.get(1).add(personsHashContain.get(i));
            }
        } else {
            addEdges(persons, graphEdges);
        }
    }
    private static void setListsForInfinities(HashSet<String> allPersons, HashMap<Integer,HashSet<String>> listOfNames){
        ArrayList<String> persons = new ArrayList<>(allPersons);
        for (int i = 0; i < persons.size(); i++){
            if (!listOfNames.get(1).contains(persons.get(i)) && !persons.get(i).equals("Erdos")){
                listOfNames.get(100000).add(persons.get(i));
            }
        }
    }
    private static void addEdges(List<String> persons, HashMap<String, ArrayList<String>> graphEdges){
        ArrayList<String> connectedList;
        for (int j = 0; j < persons.size(); j++){
            String fromPerson = persons.get(j);
            for (int i = 0; i < persons.size(); i++){
                String toPerson = persons.get(i);
                if (i != j){
                    if (graphEdges.containsKey(fromPerson)) {
                        connectedList = graphEdges.get(fromPerson);
                    } else {
                        connectedList = new ArrayList<>();
                    }
                    connectedList.add(toPerson);
                    graphEdges.put(fromPerson, connectedList);
                }
            }
        }
    }
    private static boolean listOfNamesForOne(HashMap<String, ArrayList<String>> graphEdges, HashMap<Integer,HashSet<String>> listOfNames){
        ArrayList<String> listOne = new ArrayList<>(listOfNames.get(1));
        for (String onePerson : listOne){
            if (graphEdges.containsKey(onePerson)){
                for (String second : graphEdges.get(onePerson))
                    if (graphEdges.get(onePerson).contains(second)){
                        return true;
                    }
            }
        }
        return false;
    }
    private static boolean setList(int index, HashMap<String, ArrayList<String>> graphEdges,  HashMap<Integer,HashSet<String>> listOfNames){
        boolean added = false;
        listOfNames.put(index + 1, new HashSet<>());
        ArrayList<String> listOne = new ArrayList<>(listOfNames.get(index));
        HashSet<String> listInfinity = listOfNames.get(100000);
        ArrayList<String> removed = new ArrayList<>();
        for (String onePerson : listOne){
            if (listOfNamesForOne(graphEdges, listOfNames)){
                for (String person : listInfinity){
                    if (graphEdges.containsKey(onePerson)){
                        if (graphEdges.get(onePerson).contains(person)){
                            listOfNames.get(index + 1).add(person);
                            removed.add(person);
                            added = true;
                        }
                    }
                }
            }
        }
        listInfinity = listOfNames.get(100000);
        listInfinity.removeAll(removed);
        listOfNames.put(100000, listInfinity);
        return added;
    }
    public static void main(String[]args){
        String scenarioString;
        int scenario;
        String worksNumberString;
        int worksNumber;
        String outputString;
        int output;
        String readNext;
        try {
            int t = 0;
            String readOutput;
            ArrayList<String> outputs = new ArrayList<>();
            Scanner source = new Scanner(new File("Erdös.txt"));
            String[] split;
            List<String> persons;
            scenarioString = source.nextLine();
            scenario = Integer.parseInt(scenarioString);
            worksNumberString = source.nextLine();
            worksNumber = Integer.parseInt(worksNumberString);
            outputString = source.nextLine();
            output = Integer.parseInt(outputString);
            for (int j = 0; j < scenario; j++){
                t++;
                HashSet<String> allPersons = new HashSet<>();
                HashMap<Integer, HashSet<String>> listOfNames = new HashMap<>();
                listOfNames.put(1, new HashSet<>());
                listOfNames.put(100000, new HashSet<>());
                HashMap<String, ArrayList<String>> graphEdges = new HashMap<>();
                for (int i = 0; i < worksNumber; i++){
                    readNext = source.nextLine();
                    split = readNext.split(" ");
                    persons = new ArrayList<>(Arrays.asList(split));
                    setListForOnes(listOfNames, persons, allPersons, graphEdges);
                }
                setListsForInfinities(allPersons,listOfNames);
                int index = 1;
                while (setList(index, graphEdges,listOfNames)){
                    index++;
                }
                for (int k = 0; k < output; k++){
                    readOutput = source.next();
                    outputs.add(readOutput);
                }
                print(outputs,listOfNames,scenario);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
