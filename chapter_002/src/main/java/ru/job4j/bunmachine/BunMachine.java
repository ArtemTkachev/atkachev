package ru.job4j.bunmachine;

public class BunMachine {

    private Input input;
    private MachineStore machineStore;
    private BaseAction[] userActions = new BaseAction[6];

    public BunMachine(Input input, MachineStore machineStore) {
        this.input = input;
        this.machineStore = machineStore;
    }

    public void fillActions() {
        this.userActions[0] = new RefillCoins("Пополнить автомат монетами", 0);
        this.userActions[1] = new RefillBuns("Пополнить автомат пончиками", 1);
        this.userActions[2] = new SetPrice("Назначить цену пончика", 2);
        this.userActions[3] = new GetPrice("Показать цену пончика", 3);
        this.userActions[4] = new GetCoins("Показать монеты на сдачу", 4);
        this.userActions[5] = new GetBuns("Купить пончики", 5);
    }

    public void show() {
        for (BaseAction action : this.userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void selectAction(int key) {
        this.userActions[key].execute(this.input, this.machineStore);
    }

    public int[] actionkeys() {
        int[] keys = new int[this.userActions.length];
        for (int i = 0; i < this.userActions.length; i++) {
            keys[i] = userActions[i].GetKey();
        }
        return keys;
    }


    private class RefillCoins extends BaseAction {

        public RefillCoins(String name, int key) {
            this.setKey(key);
            this.setName(name);
        }

        public void execute(Input input, MachineStore machineStore) {
            int answtens = input.ask("Введите кол-во 10's монет: ");
            int answfives = input.ask("Введите кол-во 5's монет: ");
            int answtwos = input.ask("Введите кол-во 2's монет: ");
            int answones = input.ask("Введите кол-во 1's монет: ");
            machineStore.refillCoins(answtens, answfives, answtwos, answones);
        }

    }

    private class RefillBuns extends BaseAction {

        public RefillBuns(String name, int key) {
            this.setKey(key);
            this.setName(name);
        }

        public void execute(Input input, MachineStore machineStore) {
            int buns = input.ask("Введите кол-во пончиков: ");
            machineStore.refillBuns(buns);
        }

    }

    private class SetPrice extends BaseAction {

        public SetPrice(String name, int key) {
            this.setKey(key);
            this.setName(name);
        }

        public void execute(Input input, MachineStore machineStore) {
            int price = input.ask("Введите цену пончика: ");
            machineStore.setPrice(price);
        }

    }

    private class GetPrice extends BaseAction {

        public GetPrice(String name, int key) {
            this.setKey(key);
            this.setName(name);
        }

        public void execute(Input input, MachineStore machineStore) {
            System.out.println("Цена пончика: "+machineStore.getPrice());
        }

    }

    private class GetCoins extends BaseAction {

        public GetCoins(String name, int key) {
            this.setKey(key);
            this.setName(name);
        }

        public void execute(Input input, MachineStore machineStore) {
            int[] cns = machineStore.getCoins();
            StringBuilder moneys = new StringBuilder();
            moneys.append("10's: ");
            moneys.append(cns[0]);
            moneys.append("\r\n");
            moneys.append("5's: ");
            moneys.append(cns[1]);
            moneys.append("\r\n");
            moneys.append("2's: ");
            moneys.append(cns[2]);
            moneys.append("\r\n");
            moneys.append("1's: ");
            moneys.append(cns[3]);
            System.out.println(moneys.toString());
        }

    }

    private class GetBuns extends BaseAction {

        public GetBuns(String name, int key) {
            this.setKey(key);
            this.setName(name);
        }

        public void execute(Input input, MachineStore machineStore) {
            int countbuns = input.ask("Введите кол-во пончиков, которые хотите купить: ");
            int payment = input.ask("Введите информацию об оплате: ");
            try {
                int chng = machineStore.getBuns(countbuns, payment);
                if (chng != 0) {
                    int[] cns = machineStore.divisionChange(chng);
                    StringBuilder money = new StringBuilder();
                    money.append("Возьмите сдачу: \r\n");
                    money.append("10's: ");
                    money.append(cns[0]);
                    money.append("\r\n");
                    money.append("5's: ");
                    money.append(cns[1]);
                    money.append("\r\n");
                    money.append("2's: ");
                    money.append(cns[2]);
                    money.append("\r\n");
                    money.append("1's: ");
                    money.append(cns[3]);
                    System.out.println(money.toString());
                }
                System.out.println("Спасибо за покупку!");
            } catch (NeedPriceForBunsException npfb) {
                System.out.println(npfb.toString());
            } catch (NeedMoreBunsException nmb) {
                System.out.println(nmb.toString());
            } catch (NeedMorePaymentException nmp) {
                System.out.println(nmp.toString());
            } catch (NeedMoreCoinsException nmc) {
                System.out.println(nmc.toString());
            }

        }

    }


}
