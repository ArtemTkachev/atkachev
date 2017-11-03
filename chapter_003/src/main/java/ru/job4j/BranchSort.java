package ru.job4j;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class BranchSort {
    public ArrayList<String> sorted(ArrayList<String> branch, boolean asc) {

        ArrayList<String> fill = this.sort(branch);

        if (!asc) {
            fill.sort(new Comparator<String>() {
                          @Override
                          public int compare(String o1, String o2) {
                              int beginif1 = 0, beginif2 = 0;
                              int ret = 0, ret1 = 0;
                              int cntsints;
                              boolean flag = true;
                              int indx1, indx2;
                              int cntbr1 = 0, cntbr2 = 0;
                              String smbl1, smbl2;
                              while (flag) {
                                  cntbr1 = o1.length() - o1.replace("\\", "").length();
                                  indx1 = o1.indexOf('\\', beginif1);
                                  if (indx1 != -1) {
                                      smbl1 = o1.substring(0, indx1);
                                      beginif1 = indx1 + 1;
                                  } else {
                                      smbl1 = o1;
                                  }
                                  cntbr2 = o2.length() - o2.replace("\\", "").length();
                                  indx2 = o2.indexOf('\\', beginif2);
                                  if (indx2 != -1) {
                                      smbl2 = o2.substring(0, indx2);
                                      beginif2 = indx2 + 1;
                                  } else {
                                      smbl2 = o2;
                                  }
                                  if (indx1 == -1 || indx2 == -1) {
                                      ret1 = smbl2.compareTo(smbl1);
                                      if (ret1 == 0) {
                                          cntsints = Integer.compare(cntbr1, cntbr2);
                                          ret = cntsints;
                                      } else {
                                          ret = ret1;
                                      }
                                      flag = false;
                                  }

                              }

                              return ret;
                          }
                      }
            );
        }
        return fill;
    }

    private ArrayList<String> sort(ArrayList<String> alist) {
        TreeSet<String> tset = new TreeSet<String>();
        TreeSet<String> tsetdbls = new TreeSet<String>();
        boolean flag;
        int indx, beginif;
        String smbl;
        for (String str : alist) {
            flag = true;
            beginif = 0;
            indx = 0;
            while (flag) {
                indx = str.indexOf('\\', beginif);
                if (indx != -1) {
                    smbl = str.substring(0, indx);
                    beginif = indx + 1;
                    tset.add(smbl);
                } else {
                    smbl = str;
                    flag = false;
                    tsetdbls.add(smbl);
                }
            }
        }
        tsetdbls.addAll(tset);
        return new ArrayList<String>(tsetdbls);
    }

}
