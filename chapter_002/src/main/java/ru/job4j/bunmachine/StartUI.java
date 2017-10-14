package ru.job4j.bunmachine;


public class StartUI {
    private Input input;
    private MachineStore machineStore;

    public StartUI(Input input, MachineStore machineStore) {
        this.input = input;
        this.machineStore = machineStore;
    }

    public void init() {
        boolean selectexit = true;
        int answer;
        BunMachine bunMachine = new BunMachine(this.input, this.machineStore);
        bunMachine.fillActions();
        while (selectexit) {
            bunMachine.show();
            System.out.println("6 - Выйти из меню");
            answer = input.ask("Введите номер действия: ", bunMachine.actionkeys());
            if (6==answer)
                selectexit = false;
            else
                bunMachine.selectAction(answer);
        }


    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        MachineStore machineStore = new MachineStore(new Coins(),new Buns());
        StartUI sui = new StartUI(input, machineStore);
        sui.init();
    }

}
