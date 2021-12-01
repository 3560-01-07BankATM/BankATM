package edu.cpp.bankatm;

import edu.cpp.bankatm.dao.ATMDAO;
import edu.cpp.bankatm.dao.AccountDAO;
import edu.cpp.bankatm.dao.AccountTransactionDAO;
import edu.cpp.bankatm.dao.DebitCardDAO;
import edu.cpp.bankatm.gui.*;

public class Controller {

    private static DebitCardDAO activeCard = null;
    private static ATMDAO thisATM = null;

    public static void init() {
        thisATM = ATMDAO.report(1);
        // first, display the login screen
        java.awt.EventQueue.invokeLater(() -> new LoginScreen().setVisible(true));
    }

    public static void login(LoginScreen loginScreen) {
        // Fetch the credit card from the database
        activeCard = DebitCardDAO.report(loginScreen.getEnteredCardNumber());

        if (activeCard == null) {
            System.out.println("Incorrect");
        } else if (activeCard.getPin().equals(loginScreen.getEnteredPin())) {
            var menu = new MenuScreen();   //will open the menu screen upon successful login and dispose of login screen
            menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
            menu.setVisible(true);
            loginScreen.dispose();
        } else {
            System.out.println("Incorrect");  //incorrect card number/password
        }
    }

    public static void logout() {
        activeCard = null;
    }


    public static void deposit(DepositScreen depositScreen) {

        int amount = depositScreen.getOnes()
                + depositScreen.getFives() * 5
                + depositScreen.getTens() * 10
                + depositScreen.getTwenties() * 20
                + depositScreen.getFifties() * 50
                + depositScreen.getHundreds() * 100;

        // update balance
        activeCard.getAccountDAO().setBalance(
                activeCard.getAccountDAO().getBalance() + amount
        );

        int to = activeCard.getAccountDAO().getAccountNum();
        int from = 6;
        var when = new java.sql.Date(new java.util.Date().getTime());
        // create transaction
        var transaction = new AccountTransactionDAO(-1, amount, when);
        transaction.setFromAccount(from);
        transaction.setToAccount(to);
        System.out.printf("create transaction amount:%d to:%d from:%d when:%d%n", amount, to, from, when.getTime());
        transaction.create();

        // add bills to ATM
        thisATM.setOnes(thisATM.getOnes() + depositScreen.getOnes());
        thisATM.setFives(thisATM.getFives() + depositScreen.getFives());
        thisATM.setTens(thisATM.getTens() + depositScreen.getTens());
        thisATM.setTwenties(thisATM.getTwenties() + depositScreen.getTwenties());
        thisATM.setFifties(thisATM.getFifties() + depositScreen.getFifties());
        thisATM.setHundreds(thisATM.getHundreds() + depositScreen.getHundreds());

        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        depositScreen.dispose();
    }

    private static int bills(int denomination, int amount) {
        int count = 0;
        while (amount >= denomination) {
            count++;
            amount -= denomination;
        }
        return count;
    }

    public static void withdrawCustom(CustomWithdrawalScreen customWithdrawalScreen) {
        int withdrawal = customWithdrawalScreen.getWithdrawAmount();
        if (withdrawal == 0) return;
        int hundreds = bills(100, withdrawal);
        withdrawal -= hundreds * 100;
        int fifties = bills(50, withdrawal);
        withdrawal -= fifties * 50;
        int twenties = bills(20, withdrawal);
        withdrawal -= twenties * 20;
        int tens = bills(10, withdrawal);
        withdrawal -= tens * 10;
        int fives = bills(5, withdrawal);
        withdrawal -= fives * 5;
        int ones = bills(1, withdrawal);

        // update balance
        activeCard.getAccountDAO().setBalance(
                activeCard.getAccountDAO().getBalance() - withdrawal
        );

        // create transaction
        var transaction = new AccountTransactionDAO(-1, withdrawal, new java.sql.Date(new java.util.Date().getTime()));
        transaction.setToAccount(5);
        transaction.setFromAccount(activeCard.getAccountDAO().getAccountNum());
        transaction.create();

        // remove bills from ATM
        thisATM.setOnes(thisATM.getOnes() - ones);
        thisATM.setFives(thisATM.getFives() - fives);
        thisATM.setTens(thisATM.getTens() - tens);
        thisATM.setTwenties(thisATM.getTwenties() - twenties);
        thisATM.setFifties(thisATM.getFifties() - fifties);
        thisATM.setHundreds(thisATM.getHundreds() - hundreds);

        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        customWithdrawalScreen.dispose();
    }

    public static void withdrawTwenties(int i, FastWithdrawScreen fastWithdrawScreen) {

        int withdrawal = i * 20;

        // update balance
        activeCard.getAccountDAO().setBalance(
                activeCard.getAccountDAO().getBalance() - withdrawal
        );

        // remove bills from ATM
        thisATM.setTwenties(thisATM.getTwenties() - i);

        // create transaction
        var transaction = new AccountTransactionDAO(-1, withdrawal, new java.sql.Date(new java.util.Date().getTime()));
        transaction.setToAccount(5);
        transaction.setFromAccount(activeCard.getAccountDAO().getAccountNum());
        transaction.create();

        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        fastWithdrawScreen.dispose();
    }

    public static void transfer(TransferFundsScreen transferFundsScreen) {
        int amount = transferFundsScreen.getTransferAmount();
        AccountDAO toAccount = AccountDAO.report(transferFundsScreen.getTransferToAccountNumber());

        if (amount <= 0) return;

        activeCard.getAccountDAO().setBalance(
                activeCard.getAccountDAO().getBalance() - amount
        );

        toAccount.setBalance(toAccount.getBalance() + amount);

        // create transaction
        var transaction = new AccountTransactionDAO(-1, amount, new java.sql.Date(new java.util.Date().getTime()));
        transaction.setToAccount(transferFundsScreen.getTransferToAccountNumber());
        transaction.setFromAccount(activeCard.getAccountDAO().getAccountNum());
        transaction.create();

        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        transferFundsScreen.dispose();
    }

    public static void backButton(DepositScreen depositScreen) {
        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        depositScreen.dispose();
    }

    public static void backButton(FastWithdrawScreen fastWithdrawScreen) {
        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        fastWithdrawScreen.dispose();
    }

    public static void backButton(CustomWithdrawalScreen customWithdrawalScreen) {
        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        customWithdrawalScreen.dispose();
    }

    public static void backButton(TransferFundsScreen transferFundsScreen) {
        // go back to main menu
        var menu = new MenuScreen();
        menu.setAccountBalance(activeCard.getAccountDAO().getBalance());
        menu.setVisible(true);
        transferFundsScreen.dispose();
    }


}
