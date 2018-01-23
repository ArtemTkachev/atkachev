package ru.job4j;


public class AsinClass {

    public class CountChar implements Runnable {
        @Override
        public void run() {
            String content = "Что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю " +
                    "что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю что и делать уж не знаю ";
            int cntSymbls = 0;
            for (char s : content.toCharArray()) {
                if (Thread.interrupted())
                    return;
                cntSymbls++;
            }
            System.out.println(String.format("%s штук символов", String.valueOf(cntSymbls)));
        }
    }

    public class Time implements Runnable {
        private long timeOut;
        private Thread countChar;

        public Time(long timeOut, Thread countChar) {
            this.timeOut = timeOut;
            this.countChar = countChar;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeOut);
                this.countChar.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static class Calculate implements Runnable {
        private String symbls;

        public Calculate(String symbls) {
            this.symbls = symbls;
        }

        @Override
        public void run() {
            String content = "Что и делать уж не знаю";
            String answ = "";
            int cnt = 0;
            for (char sd : content.toCharArray()) {
                if (sd == ' ')
                    cnt++;
            }
            if (this.symbls.equals("spcs")) {
                answ = String.valueOf(cnt);
            } else if (this.symbls.equals("words")) {
                answ = String.valueOf(++cnt);
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
        Thread tSpcs = new Thread(new Calculate("spcs"));
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


        Thread cH = new Thread(new AsinClass().new CountChar());
        Thread t = new Thread(new AsinClass().new Time(1, cH));
        cH.start();
        t.start();
    }


}
