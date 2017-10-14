package ru.job4j.bunmachine;


public class MachineStore {
    private Coins coins;
    private Buns buns;

    public MachineStore(Coins coins, Buns buns) {
        this.buns = buns;
        this.coins = coins;
    }

    public void refillCoins(int tens, int fives, int twos, int ones) {
        this.coins.setTens(tens);
        this.coins.setFives(fives);
        this.coins.setTwos(twos);
        this.coins.setOnes(ones);
    }

    public void refillBuns(int count) {
        this.buns.setCountbuns(count);
    }

    public void setPrice(int price) {
        this.buns.setPrice(price);
    }

    public int getPrice() {
        return this.buns.getPrice();
    }

    public int[] getCoins() {
        int[] coins = new int[4];
        coins[0] = this.coins.getTens();
        coins[1] = this.coins.getFives();
        coins[2] = this.coins.getTwos();
        coins[3] = this.coins.getOnes();
        return coins;
    }

    public int getBuns(int count, int payment) {
        int change = 0;
        if (buns.getPrice() <= 0) {
            throw new NeedPriceForBunsException();
        }
        if (count * buns.getPrice() < payment) {
            if (count > buns.getCountbuns()) {
                throw new NeedMoreBunsException();
            } else {
                buns.setCountbuns(buns.getCountbuns() - count);
            }
            change = payment - count * buns.getPrice();
        } else if (count * buns.getPrice() > payment) {
            throw new NeedMorePaymentException();
        }
        return change;
    }

    public int[] divisionChange(int change) {
        int[] divchange = new int[4];
        int typecoin;
        int rest = change;
        int[] changecoins = new int[]{10, 5, 2, 1};
        int summ = 0;

        for (int i = 0; i < changecoins.length; i++) {
            if (rest >= changecoins[i]) {
                typecoin = rest / changecoins[i];
                rest = rest % changecoins[i];
                checkCoins(typecoin, changecoins[i]);
                divchange[i] = typecoin;
            }
        }
        for (int y = 0; y < changecoins.length; y++) {
            summ = summ + changecoins[y] * divchange[y];
        }
        if (summ < change) {
            throw new NeedMoreCoinsException();
        }
        return divchange;
    }

    private void checkCoins(int typecoin, int value) {
        int numbers = 0;
        switch (value) {
            case 10:
                numbers = coins.getTens();
                break;
            case 5:
                numbers = coins.getFives();
                break;
            case 2:
                numbers = coins.getTwos();
                break;
            case 1:
                numbers = coins.getOnes();
                break;
        }
        if (typecoin <= numbers) {
            int chng = numbers - typecoin;
            switch (value) {
                case 10:
                    coins.setTens(chng);
                    break;
                case 5:
                    coins.setFives(chng);
                    break;
                case 2:
                    coins.setTwos(chng);
                    break;
                case 1:
                    coins.setOnes(chng);
                    break;
            }

        }
    }
}
