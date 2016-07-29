package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static int trialCheck = 0;
    public static int Credit = 0;

    public static void main(String[] args) {
        // write your code here
        System.out.println("Do U Want to Play this Number Guessing Game? Enter Y/N");
            PlayGameTrial();
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void PlayGameTrial(){

        Scanner scan = new Scanner(System.in);
        String userResponse = scan.nextLine();
        int random_Number = randInt(1,10);

        if (userResponse.toLowerCase().equals("y")) {
            trialCheck++;
            System.out.println("Guess a number between 1 to 10");
            int guessed_Num = getUserInputInt();

            if (guessed_Num == random_Number){
                System.out.println("You Won");
            }
            else{
                System.out.println("You Lose");
            }

            if (trialCheck < 3){
                System.out.println("Do U Want to Try Again? Enter Y/N");
//                userResponse = scan.nextLine();
                if (userResponse.toLowerCase().equals("y")) {
                    PlayGameTrial();
                    return;
                }else {
                    Credit = 0;
                    trialCheck = 0;
                    System.out.print("Game Ended");
                }

            }else {
                    add_credit("Trial Version Ended , if u want to play more add Credit between rupees 1 to 10 ");

            }
        }
        else {
            System.out.println("Game Ended");

        }


    }
    public static void PlayGameCredit(){
        int random_Number = randInt(1,10);
        Scanner scan = new Scanner(System.in);


        Scanner scanInt = new Scanner(System.in);

            Credit--;
            System.out.println("Guess a number between 1 to 10");
            int guessed_Num = getUserInputInt();

            if (guessed_Num == random_Number){
                System.out.println("You Won");
            }
            else{
                System.out.println("You Lose");
            }

            if (Credit > 0){
                System.out.println("Do U Want to Try Again? Enter Y/N, You have "+Credit+ " Chances remaining");
                String userResponse = scan.nextLine();
                if (userResponse.toLowerCase().equals("y")) {
                    PlayGameCredit();
                    return;
                }else {
                    Credit = 0;
                    trialCheck = 0;
                    System.out.print("Game Ended");
                }

            }else {
                add_credit("Your Credit has ended , if u want to play again,add more Credit between 1 to 10 or press any other key to exit");
            }



    }


    public static String getUserInputStr( String userResponse){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do U Want to Try Again? Enter Y/N");
        userResponse ="";
        try {
            userResponse = scan.nextLine();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return  userResponse;
    }

    public static int getUserInputInt(){
        Scanner scan = new Scanner(System.in);
        int userResponse = 0;
//        System.out.println("Guess a number between 1 to 10");
        try {
            userResponse = scan.nextInt();
        }
        catch (Exception e){
//            System.out.println(e.getLocalizedMessage());
        }
        return  userResponse;
    }

    public static void add_credit(String str){
        Scanner scan = new Scanner(System.in);
        System.out.println(str);
            Credit = getUserInputInt();
        if (Credit > 0 &&  Credit < 11){
            System.out.println("you can now continue playing");
            PlayGameCredit();
        }
        else{
//            System.out.println("you can add only between 1 to 10 rupees");
            System.out.println("Game Ended");
//            add_credit("");
        }
    }
}
