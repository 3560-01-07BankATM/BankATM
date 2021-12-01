package edu.cpp.bankatm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountTransactionDAO {
    private int transactionID;
    private int toAccount;
    private int fromAccount;
    private int amount;
    private Timestamp dateTime;

    public AccountTransactionDAO(int transactionID, int amount, Timestamp dateTime) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    /*
     * Create a new record in the DB for an AccountTransaction
     * Also create a record in TransactionDetails
     * */
    public void create() {
        try {
            var txDate = new java.sql.Timestamp(dateTime.getTime());
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("INSERT INTO AccountTransaction (`Amount`, `Datetime`) VALUES (?,?)");
            preparedStatement.setInt(1, amount);
            preparedStatement.setTimestamp(2, txDate);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = DB.getConnection().prepareStatement("SELECT TransactionID FROM AccountTransaction ORDER BY TransactionID DESC LIMIT 1");
            preparedStatement2.execute();
            var resultSet = preparedStatement2.getResultSet();
            if (resultSet.next()) {
                this.transactionID = resultSet.getInt("TransactionID");
                preparedStatement.close();

                preparedStatement = DB.getConnection().prepareStatement("INSERT INTO TransactionDetails (`TransactionID`, `toAccountID`, `fromAccountID`) VALUES (?,?,?)");
                preparedStatement.setInt(1, transactionID);
                preparedStatement.setInt(2, toAccount);
                preparedStatement.setInt(3, fromAccount);
            }
            resultSet.close();
            preparedStatement2.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Fetch a transaction form the DB and return an AccountTransaction object
     * */
    public static AccountTransactionDAO report(int transactionID) {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM AccountTransaction WHERE TransactionID = ?");
            preparedStatement.setInt(1, transactionID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int Amount = resultSet.getInt("Amount");
                Timestamp DateTime = new java.sql.Timestamp(resultSet.getTimestamp("Datetime").getTime());
                preparedStatement.close();
                resultSet.close();
                AccountTransactionDAO accountTransactionDAO = new AccountTransactionDAO(transactionID, Amount, DateTime);

                preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM TransactionDetails WHERE TransactionID = ?");
                preparedStatement.setInt(1, transactionID);

                int toAccountID = resultSet.getInt("toAccountID");
                int fromAccountID = resultSet.getInt("fromAccountID");
                accountTransactionDAO.setFromAccount(fromAccountID);
                accountTransactionDAO.setToAccount(toAccountID);

                preparedStatement.close();
                resultSet.close();
                return accountTransactionDAO;
            } else {
                resultSet.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * Update the DB entries for an AccountTransaction object if its contents has changed
     * */
    public void update() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("UPDATE AccountTransaction SET `Amount` = ?, `Datetime` = ? WHERE `TransactionID` = ?");
            preparedStatement.setInt(1, amount);
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(dateTime.getTime()));
            preparedStatement.setInt(3, transactionID);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = DB.getConnection().prepareStatement("UPDATE TransactionDetails SET `toAccountID` = ?, `fromAccountID` = ? WHERE `TransactionID` = ?");
            preparedStatement.setInt(1, toAccount);
            preparedStatement.setInt(2, fromAccount);
            preparedStatement.setInt(3, transactionID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Remove a transaction and its details from the DB
     * */
    public void delete() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("DELETE FROM AccountTransaction WHERE TransactionID = ?");
            preparedStatement.setInt(1, transactionID);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = DB.getConnection().prepareStatement("DELETE FROM TransactionDetails WHERE TransactionID = ?");
            preparedStatement.setInt(1, transactionID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Fetch all transactions on an account in the DB
     * */
    public static List<AccountTransactionDAO> getTransactions(int accountNum) {
        List<AccountTransactionDAO> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM TransactionDetails WHERE toAccountID = ? OR fromAccountID = ?");
            preparedStatement.setInt(1, accountNum);
            preparedStatement.setInt(2, accountNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            do {
                int transactionID = resultSet.getInt("TransactionID");
                int toAccount = resultSet.getInt("toAccountID");
                int fromAccount = resultSet.getInt("fromAccountID");
                AccountTransactionDAO accountTransactionDAO = report(transactionID);
                accountTransactionDAO.setToAccount(toAccount);
                accountTransactionDAO.setFromAccount(fromAccount);

                list.add(accountTransactionDAO);
            } while (resultSet.next());
            resultSet.close();
            preparedStatement.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
        update();
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
        update();
    }

    public int getTransactionID() {
        return transactionID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        update();
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
        update();
    }
}
