package me.regos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random random = new Random();
    static int range;
    static ArrayList<String> list;
    static ArrayList<String> list2;
    static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        list = new ArrayList<>();
        list2 = new ArrayList<>();

        System.out.print("Number of people to divide = ");
        n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
            list2.add(list.get(i));
        }

        range = n;

        for(int i = 0; i < n-2; i++) {
            print(i+1, i, draw(list2.get(i)));
        }

        finish();
    }

    private static String draw(String duplicate){
        String person;
        int generated;
        do {
            generated = random.nextInt(range);
            person = list.get(generated);
        }while (person == duplicate);

        range--;
        list.remove(generated);

        return person;
    }

    private static void finish(){
        if(list2.get(n-2) == list.get(0) || list2.get(n-1) == list.get(1)) {
            print(n - 1, n-2, list.get(1));
            print(n, n-1, list.get(0));
        }
        else if(list2.get(n-2) == list.get(1) || list2.get(n-1) == list.get(0)){
            print(n - 1, n-2, list.get(0));
            print(n, n-1, list.get(1));
        }
        else{
            print(n - 1, n - 2, draw(list2.get(n-2)));
            print(n, n - 1, draw(list2.get(n-1)));
        }
    }

    private static void print(int i, int j, String drawn){
        System.out.println(i + ". " + list2.get(j) + " -> " + drawn);
    }
}
