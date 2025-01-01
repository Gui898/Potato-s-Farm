import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int money = 20000;
        int fields = 15;
        List<Integer> wheatFields = new ArrayList<>();
        List<Integer> potatoFields = new ArrayList<>();
        int roundCounter = 1;
        int wheatCounter = 0;
        int potatoCounter = 0;

        System.out.println("""
                ****************************
                * Welcome to Potato's Farm *
                ****************************""");

        while(true){
            System.out.println("\nCurrent Money: " + money);
            System.out.println("Current Fields: " + fields);
            System.out.println("\n[MENU]");
            System.out.println("Select an option");
            System.out.println("""
                1- Plant Wheat (200kg of wheat, use 1 field and $2000)
                2- Plant Potato (150kg of potato, use 1 field and $1000)
                3- Harvest Wheat (Only if you planted at least 3 rounds ago, use $500)
                4- Harvest Potato (Only if you planted at least 2 rounds ago, use $1000)
                5- Sell Wheat (Each kg is $150)
                6- Sell Potato (Each kg is $200)
                7- Expand Field (Use $1000)
                """);

            int option = scan.nextInt();

            switch (option){
                case 1:
                    fields--;
                    money-=2000;
                    wheatFields.add(roundCounter);
                    roundCounter++;
                    break;
                case 2:
                    fields--;
                    money-=1000;
                    potatoFields.add(roundCounter);
                    roundCounter++;
                    break;
                case 3:
                    for(int a : wheatFields){
                        if(roundCounter-a >= 3 && a !=0){
                            System.out.println("Able to harvest the Wheat field(s)");
                            System.out.println("Do you want to collect? (Y/N)");
                            String ans = scan.next();
                            if(ans.equalsIgnoreCase("Y")){
                                wheatFields.set(wheatFields.indexOf(a), 0);
                                wheatFields.remove((Integer) a);
                                System.out.println("+200kg of Wheat");
                                wheatCounter += 200;
                            }else {
                                System.out.println("OK");
                                break;
                            }
                        }else {
                            System.out.println("You need to pass more rounds to collect");
                        }
                    }
                    roundCounter++;
                    break;
                case 4:
                    for(int a : potatoFields){
                        if(roundCounter-a >= 2 && a != 0){
                            System.out.println("Able to harvest Potato field(s)");
                            System.out.println("Do you want to collect? (Y/N)");
                            String ans = scan.next();
                            if(ans.equalsIgnoreCase("Y")){
                                potatoFields.set(potatoFields.indexOf(a), 0);
                                potatoFields.remove((Integer) a);
                                System.out.println("+150kg of Potato");
                                potatoCounter += 150;
                            }else {
                                System.out.println("OK");
                                break;
                            }
                        }else {
                            System.out.println("You need to pass more rounds to collect");
                        }
                    }
                    roundCounter++;
                    break;
                case 5:
                    if(wheatCounter > 0){
                        money += (wheatCounter * 150);
                    }else {
                        System.out.println("You don't have nothing to sell");
                    }
                    roundCounter++;
                    break;
                case 6:
                    if(potatoCounter > 0){
                        money += (potatoCounter * 150);
                    }else {
                        System.out.println("You don't have nothing to sell");
                    }
                    roundCounter++;
                    break;
                case 7:
                    fields++;
                    money-=1000;
                    roundCounter++;
                    break;
                default:
                    break;
            }

            if(roundCounter%5 == 0){
                money-=2000;
                System.out.println("\nPay the tax. Lose $2000\n");
            }
            if(roundCounter%15 == 0){
                money-=8000;
                System.out.println("\nA tornado destroy your fields. Lose $10000\n");
            }

            if(fields == 200){
                System.out.println(">>>YOU ARE A WINNER!<<<");
                break;
            }
            if(money<150){
                System.out.println("YOU ARE A LOSER");
                break;
            }
        }



    }
}