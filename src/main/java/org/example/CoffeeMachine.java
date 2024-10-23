package org.example;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;

    public CoffeeMachine(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public void makeCoffee(String type) {
        switch (type.toLowerCase()) {     // privodit k verhnemu registru
            case "espresso":
                if (checkResources(250, 0, 16)) {    //trebuetsya
                    prepareCoffee(250, 0, 16);   //vichitaem iz zapasov
                    System.out.println("Here is your espresso!");
                }
                break;
            case "latte":
                if (checkResources(350, 75, 20)) {   //trebuetsya
                    prepareCoffee(350, 75, 20);    //vichitaem iz zapasov
                    System.out.println("Here is your latte!");
                }
                break;
            case "cappuccino":
                if (checkResources(200, 100, 12)) {   //trebuetsya
                    prepareCoffee(200, 100, 12);     //vichitaem iz zapasov
                    System.out.println("Here is your cappuccino!");
                }
                break;
            default:
                System.out.println("Unknown coffee type!");
        }
    }

    private boolean checkResources(int waterNeeded, int milkNeeded, int coffeeBeansNeeded) {   //proverka resursov
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans < coffeeBeansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        return true;
    }

    private void prepareCoffee(int waterUsed, int milkUsed, int coffeeBeansUsed) {    //istratili resursov
        water -= waterUsed;
        milk -= milkUsed;
        coffeeBeans -= coffeeBeansUsed;
    }

    public void refill(int water, int milk, int coffeeBeans) {            //dobavili resursov
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        System.out.println("Thank you for using the coffee machine!");
    }

    public void displayResources() {      //vivodim kolichestvo resursov na ekran
        System.out.println("Current resources:");
        System.out.println("Water: " + water + "ml");
        System.out.println("Milk: " + milk + "ml");
        System.out.println("Coffee Beans: " + coffeeBeans + "g");
    }
}