package ru.job4j;


public class AsinClass {


    public static class Calculate implements Runnable {
        private String symbls;

        public Calculate(String symbls) {
            this.symbls = symbls;
        }

        @Override
        public void run() {
            String content = "Что и делать уж не знаю";
            String answ = "";
            int cntSpaces = 0, cntWords = 0;
            for (char sd : content.toCharArray()) {
                if (sd == ' ') {
                    if (this.symbls.equals("spcs")) {
                        cntSpaces++;
                    } else if (this.symbls.equals("words")) {
                        cntWords++;
                    }
                }
            }
            if (this.symbls.equals("spcs")) {
                answ = String.valueOf(cntSpaces);
            } else if (this.symbls.equals("words")) {
                answ = String.valueOf(++cntWords);
            }
            System.out.println(String.format("%s штук", symbls + ' ' + answ));
        }
    }

    public static void main(String[] args) {

        Thread tStart = new Thread() {
            @Override
            public void run() {
                System.out.println("Start");
            }
        };
        Thread tSpcs =  new Thread(new Calculate("spcs"));
        Thread tWords = new Thread(new Calculate("words"));
        Thread tFinish = new Thread() {
            @Override
            public void run() {
                System.out.println("Finish");
            }
        };

        try {
            tStart.start();
            tStart.join();
            tSpcs.start();
            tWords.start();
            tSpcs.join();
            tWords.join();
            tFinish.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
