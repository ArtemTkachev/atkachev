package ru.job4j;

import java.util.*;
import java.util.Collections.*;

public class CollectionsWork {
    /*
        private static final String[] mayak = new String[]{"Я сразу смазал карту будня",
                "плеснувши краску из стакана;",
                "я показал на блюде студня",
                "косые скулы океана.",
                "На чешуе жестяной рыбы",
                "прочел я зовы новых губ.",
                "А вы",
                "ноктюрн сыграть",
                "могли бы",
                "на флейте водосточных труб?"};
                */
    private static final String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int STR_LENGTH = 9; // длина генерируемой строки
    private Random random = new Random();

    //   private String[] arrayMain;
/*
    public CollectionsWork(int amount) {
        this.arrayMain = new String[amount];
        for (int i = 0; i < arrayMain.length; i++) {
            char ch = mCHAR.charAt(random.nextInt(mCHAR.length()));
            arrayMain[i] = String.valueOf(ch);
        }
    }
*/
    private void collectionTests() {

        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        Set<String> treeSet = new TreeSet<String>();
        long[] rtarlistadds = new long[5];
        long[] rtarlistdels = new long[5];
        long[] rtlnklistadds = new long[5];
        long[] rtlnklistdels = new long[5];
        long[] rtsetadds = new long[5];
        long[] rtsetdels = new long[5];

        long rtarlistadd = 0, rtarlistdel = 0, rtlnklistadd = 0, rtlnklistdel = 0, rtsetadd = 0, rtsetdel = 0;

        for (int z = 0; z < 5; z++) {
            rtarlistadds[z] = this.add(arrayList, 1000000);
            rtarlistdels[z] = this.delete(arrayList, 1000000);
            rtlnklistadds[z] = this.add(linkedList, 1000000);
            rtlnklistdels[z] = this.delete(linkedList, 1000000);
            rtsetadds[z] = this.add(treeSet, 1000000);
            rtsetdels[z] = this.delete(treeSet, 1000000);
            rtarlistadd = rtarlistadd + rtarlistadds[z];
            rtarlistdel = rtarlistdel + rtarlistdels[z];
            rtlnklistadd = rtlnklistadd + rtlnklistadds[z];
            rtlnklistdel = rtlnklistdel + rtlnklistdels[z];
            rtsetadd = rtsetadd + rtsetadds[z];
            rtsetdel = rtsetdel + rtsetdels[z];
        }

        System.out.println(String.format("Время добавления:\n arrayList: %s \n LinkedList: %s \n TreeSet: %s ",
                String.valueOf(rtarlistadd/5), String.valueOf(rtlnklistadd/5), String.valueOf(rtsetadd/5)));
        System.out.println(String.format("Время удаления:\n arrayList: %s \n LinkedList: %s \n TreeSet: %s ",
                String.valueOf(rtarlistdel/5), String.valueOf(rtlnklistdel/5), String.valueOf(rtsetdel/5)));

    }

    /*
        private String[] ar() {
            String[] retar = new String[CollectionsWork.AMOUNT];
            for (int i = 0; i < retar.length; i++) {
                char ch = CollectionsWork.mCHAR.charAt(random.nextInt(CollectionsWork.mCHAR.length()));
                retar[i] = String.valueOf(ch);
            }
            return retar;
        }
    */
    private long add(Collection<String> collection, int amount) {
        long runtimestart = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(mCHAR.charAt(random.nextInt(mCHAR.length()))));
        }
        long runtimefinish = System.currentTimeMillis();
        return runtimefinish - runtimestart;
    }

    private long delete(Collection<String> collection, int amount) {
        long runtimestart = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.remove(String.valueOf(mCHAR.charAt(random.nextInt(mCHAR.length()))));
        }
        long runtimefinish = System.currentTimeMillis();
        return runtimefinish - runtimestart;
    }

    public static void main(String[] args) {
        new CollectionsWork().collectionTests();
    }

}
