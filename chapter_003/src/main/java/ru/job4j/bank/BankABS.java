package ru.job4j.bank;

import java.util.*;

public class BankABS {
    private TreeMap<User, ArrayList<Account>> bankDbAccs = new TreeMap<User, ArrayList<Account>>();
    private Random rnd = new Random(100);

    public TreeMap<User, ArrayList<Account>> getMap() {
        return this.bankDbAccs;
    }

    public void addUser(User user) {
        if (!bankDbAccs.containsKey(user)) {
            ArrayList<Account> accountArrayList = new ArrayList<Account>();
            accountArrayList.add(new Account(0, String.valueOf(System.currentTimeMillis() + rnd.nextInt())));
            bankDbAccs.put(user, accountArrayList);
        } else {
            throw new UserPresentException();
        }
    }

    public void deleteUser(User user) {
        ArrayList<Account> retList = this.bankDbAccs.getOrDefault(user, new ArrayList<Account>());
        retList.clear();
        if (!bankDbAccs.remove(user, retList)) {
            throw new UserNotPresentException(user.getName());
        }
    }

    public void addAccountToUser(User user, Account account) {
        ArrayList<Account> retList = this.bankDbAccs.getOrDefault(user, new ArrayList<Account>());
        if (!retList.isEmpty()) {
            retList.add(account);
        } else {
            throw new UserNotPresentException(user.getName());
        }
    }

    public void deleteAccountFromUser(User user, Account account) {
        if (!this.bankDbAccs.getOrDefault(user, new ArrayList<Account>()).remove(account)) {
            throw new UserNotPresentException(user.getName());
        }
    }

    public List<Account> getUserAccounts(User user) {
        ArrayList<Account> retList = this.bankDbAccs.getOrDefault(user, new ArrayList<Account>());
        if (!retList.isEmpty()) {
            return retList;
        } else {
            throw new UserNotPresentException(user.getName());
        }
    }

    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        ArrayList<Account> retListsrc = this.bankDbAccs.getOrDefault(srcUser, new ArrayList<Account>());
        ArrayList<Account> retListdst = this.bankDbAccs.getOrDefault(dstUser, new ArrayList<Account>());
        if (!retListsrc.isEmpty() && !retListdst.isEmpty()) {
            if (retListsrc.contains(srcAccount) && retListdst.contains(dstAccount)) {
                Account srcacc = retListsrc.get(retListsrc.indexOf(srcAccount));
                if (srcacc.getValue() >= amount) {
                    srcacc.setValue(srcacc.getValue() - amount);
                    Account dstacc = retListdst.get(retListdst.indexOf(dstAccount));
                    dstacc.setValue(dstacc.getValue() + amount);
                    result = true;
                } else {
                    throw new NoSuchMoneyOnAccountException();
                }
            }
        } else {
            if (retListsrc.isEmpty()) {
                throw new UserNotPresentException(srcUser.getName());
            } else {
                throw new UserNotPresentException(dstUser.getName());
            }
        }
        return result;
    }

}
