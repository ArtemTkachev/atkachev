package ru.job4j.Bank;

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
        if (bankDbAccs.containsKey(user)) {
            if (bankDbAccs.get(user) != null) {
                ArrayList<Account> accountArrayList = bankDbAccs.get(user);
                accountArrayList.clear();
            }
            bankDbAccs.remove(user);
        } else {
            throw new UserNotPresentException(user.getName());
        }
    }

    public void addAccountToUser(User user, Account account) {
        if (bankDbAccs.containsKey(user)) {
            if (bankDbAccs.get(user) != null) {
                ArrayList<Account> accountArrayList = bankDbAccs.get(user);
                accountArrayList.add(account);
            }
        } else {
            throw new UserNotPresentException(user.getName());
        }
    }

    public void deleteAccountFromUser(User user, Account account) {
        if (bankDbAccs.containsKey(user)) {
            if (bankDbAccs.get(user) != null) {
                ArrayList<Account> accountArrayList = bankDbAccs.get(user);
                if (accountArrayList.contains(account)) {
                    accountArrayList.remove(account);
                } else {
                    throw new UserHaveNotAccountException();
                }
            }
        } else {
            throw new UserNotPresentException(user.getName());
        }
    }

    public List<Account> getUserAccounts(User user) {
        ArrayList<Account> accountArrayList = new ArrayList<Account>();
        if (bankDbAccs.containsKey(user)) {
            if (bankDbAccs.get(user) != null) {
                accountArrayList = bankDbAccs.get(user);
            }
        } else {
            throw new UserNotPresentException(user.getName());
        }
        return accountArrayList;
    }

    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        if (bankDbAccs.containsKey(srcUser) && bankDbAccs.containsKey(dstUser)) {
            if (bankDbAccs.get(srcUser) != null && bankDbAccs.get(dstUser) != null) {
                ArrayList<Account> accountArrayListsrc = bankDbAccs.get(srcUser);
                ArrayList<Account> accountArrayListdst = bankDbAccs.get(dstUser);
                if (accountArrayListsrc.contains(srcAccount) && accountArrayListdst.contains(dstAccount)) {
                    Account srcacc = accountArrayListsrc.get(accountArrayListsrc.indexOf(srcAccount));
                    if (srcacc.getValue() >= amount) {
                        srcacc.setValue(srcacc.getValue() - amount);
                        Account dstacc = accountArrayListdst.get(accountArrayListdst.indexOf(dstAccount));
                        dstacc.setValue(dstacc.getValue() + amount);
                        result = true;
                    } else {
                        throw new NoSuchMoneyOnAccountException();
                    }
                }
            }
        } else {
            if (!bankDbAccs.containsKey(srcUser)) {
                throw new UserNotPresentException(srcUser.getName());
            } else {
                throw new UserNotPresentException(dstUser.getName());
            }
        }
        return result;
    }

}
