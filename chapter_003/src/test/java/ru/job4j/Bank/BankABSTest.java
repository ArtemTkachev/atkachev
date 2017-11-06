package ru.job4j.Bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankABSTest {
    private BankABS bankABS = new BankABS();

    @Test
    public void whenAddUserThenMapHaveUser() {
        try {
            User user = new User("Петрович", "600315637");
            bankABS.addUser(user);
            TreeMap<User, ArrayList<Account>> testMap = bankABS.getMap();
            assertThat(testMap.containsKey(user), is(true));
        } catch (UserPresentException upe) {
            System.out.println(upe);
        }
    }

    @Test
    public void whenDeleteUserThenMapHaveNotUser() {
        try {
            User user = new User("Петрович", "600315637");
            bankABS.addUser(user);
            bankABS.deleteUser(user);
            TreeMap<User, ArrayList<Account>> testMap = bankABS.getMap();
            assertThat(testMap.containsKey(user), is(false));
        } catch (UserNotPresentException | UserPresentException unpe) {
            System.out.println(unpe);
        }
    }

    @Test
    public void whenAddAccountToUserThenUserHaveAccount() {
        try {
            User user = new User("Петрович", "600315637");
            bankABS.addUser(user);
            Account account = new Account(10000, String.valueOf(System.currentTimeMillis() + new Random(100).nextInt()));
            bankABS.addAccountToUser(user, account);
            TreeMap<User, ArrayList<Account>> testMap = bankABS.getMap();
            assertThat(testMap.get(user).contains(account), is(true));
        } catch (UserNotPresentException | UserPresentException unpe) {
            System.out.println(unpe);
        }
    }

    @Test
    public void whenDeleteAccountFromUserThenUserHaveNotAccount() {
        try {
            User user = new User("Петрович", "600315637");
            bankABS.addUser(user);
            Account account = new Account(10000, String.valueOf(System.currentTimeMillis() + new Random(100).nextInt()));
            bankABS.addAccountToUser(user, account);
            bankABS.deleteAccountFromUser(user, account);
            TreeMap<User, ArrayList<Account>> testMap = bankABS.getMap();
            assertThat(testMap.get(user).contains(account), is(false));
        } catch (UserNotPresentException | UserPresentException | UserHaveNotAccountException uhnae) {
            System.out.println(uhnae);
        }
    }

    @Test
    public void whenUserHaveAccountsThenReturnThem() {
        try {
            User user = new User("Петрович", "600315637");
            bankABS.addUser(user);
            Account account = new Account(10000, String.valueOf(System.currentTimeMillis() + new Random(100).nextInt()));
            bankABS.addAccountToUser(user, account);
            ArrayList<Account> result = (ArrayList<Account>) bankABS.getUserAccounts(user);
            TreeMap<User, ArrayList<Account>> testMap = bankABS.getMap();
            ArrayList<Account> except = new ArrayList<Account>(Arrays.asList(
                    new Account(0, testMap.get(user).get(0).getRequisites()),
                    new Account(10000, testMap.get(user).get(1).getRequisites())));
            assertThat(result, is(except));
        } catch (UserNotPresentException | UserPresentException unpe) {
            System.out.println(unpe);
        }
    }

    @Test
    public void whenTransferMoneyFromUserAccountToUserAccountThenTrue() {
        try {
            User srcUser = new User("Петрович", "600315637");
            bankABS.addUser(srcUser);
            Account srcAccount = new Account(10000, String.valueOf(System.currentTimeMillis() + new Random(100).nextInt()));
            bankABS.addAccountToUser(srcUser, srcAccount);
            User dstUser = new User("Денисович", "600315637");
            bankABS.addUser(dstUser);
            Account dstAccount = new Account(2000, String.valueOf(System.currentTimeMillis() + new Random(100).nextInt()));
            bankABS.addAccountToUser(dstUser, dstAccount);
            Boolean res = bankABS.transferMoney(srcUser, srcAccount, dstUser, dstAccount, 750);
            TreeMap<User, ArrayList<Account>> testMap = bankABS.getMap();
            assertThat(10000 - testMap.get(srcUser).get(1).getValue(), is(750.0));
            assertThat(testMap.get(dstUser).get(1).getValue() - 2000, is(750.0));
        } catch (UserNotPresentException | UserPresentException | NoSuchMoneyOnAccountException unpe) {
            System.out.println(unpe);
        }
    }


}
