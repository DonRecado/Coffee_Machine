package machine;

enum Coffees {
    ESPRESSO(250, 0, 16),
    LATTE(350, 75, 20),
    CAPPUCCINO(200, 100, 12);

    int water;
    int milk;
    int beans;

    Coffees(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    ;

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }
}


public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int disposableCups;
    private int money;

    public Machine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public void buy(int type) {
        boolean process = false;

        switch (type) {
            case 1:
                if (checkResources(type)) {
                    this.water -= 250;
                    this.beans -= 16;
                    this.money += 4;
                    process = true;
                }
                break;
            case 2:
                if (checkResources(type)) {
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.money += 7;
                    process = true;
                }
                break;
            case 3:
                if (checkResources(type)) {
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.money += 6;
                    process = true;
                }
                break;
        }
        if (process) {
            this.disposableCups--;
            System.out.println("I have enough resources, making you a coffee!\n");
        }

    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.disposableCups += cups;
    }

    public void take() {
        System.out.println("I gave you $" + this.money + "\n");
        this.money = 0;
    }

    private boolean checkResources(int type) {
        boolean water = true;
        boolean milk = true;
        boolean beans = true;

        switch (type) {

            case 1: // espresso
                water = this.water - Coffees.ESPRESSO.getWater() > 0;
                milk = this.milk - Coffees.ESPRESSO.getMilk() > 0;
                beans = this.beans - Coffees.ESPRESSO.getBeans() > 0;
                break;
            case 2: // latte
                water = this.water - Coffees.LATTE.getWater() > 0;
                milk = this.milk - Coffees.LATTE.getMilk() > 0;
                beans = this.beans - Coffees.LATTE.getBeans() > 0;
                break;
            case 3: // cappuccino
                water = this.water - Coffees.CAPPUCCINO.getWater() > 0;
                milk = this.milk - Coffees.CAPPUCCINO.getMilk() > 0;
                beans = this.beans - Coffees.CAPPUCCINO.getBeans() > 0;
                break;

        }

        if (!water) {
            System.out.println("Sorry, not enough water!\n");
        }

        if (!milk) {
            System.out.println("Sorry, not enough milk!\n");
        }

        if (!beans) {
            System.out.println("Sorry, not enough beans!\n");
        }

        if (this.disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough cups!\n");
        }

        if (water && milk && beans && this.disposableCups - 1 > 0) {
            return true;
        }

        return false;

    }


    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.beans + " g of coffee beans\n" +
                this.disposableCups + " disposable cups\n" +
                "$" + this.money + " of money\n";
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }
}
