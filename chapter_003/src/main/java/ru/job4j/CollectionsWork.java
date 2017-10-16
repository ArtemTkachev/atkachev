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
        long rtarlistadd = this.add(arrayList, 1000000);
        long rtarlistdel = this.delete(arrayList, 1000000);
        long rtlnklistadd = this.add(linkedList, 1000000);
        long rtlnklistdel = this.delete(linkedList, 1000000);
        long rtsetadd = this.add(treeSet, 1000000);
        long rtsetdel = this.delete(treeSet, 1000000);
        System.out.println(String.format("Время добавления:\n arrayList: %s \n LinkedList: %s \n TreeSet: %s ",
                String.valueOf(rtarlistadd), String.valueOf(rtlnklistadd), String.valueOf(rtsetadd)));
        System.out.println(String.format("Время удаления:\n arrayList: %s \n LinkedList: %s \n TreeSet: %s ",
                String.valueOf(rtarlistdel), String.valueOf(rtlnklistdel), String.valueOf(rtsetdel)));

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
