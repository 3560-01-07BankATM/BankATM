package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AccountDAO {
    private int accountNum;
    private CustomerDAO customerDAO;
    private String type;
    private int balance;
    private boolean overdraftProtected;

    public AccountDAO(int accountNum, CustomerDAO customerDAO, String type, int balance, boolean overdraftProtected) {
        this.accountNum = accountNum;
        this.customerDAO = customerDAO;
        this.type = type;
        this.balance = balance;
        this.overdraftProtected = overdraftProtected;
    }

    /*
    * Create a new record in the DB for an Account
    * */
    public void create() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("INSERT INTO Accounts (CustomerID, `Type`, Balance, OverdraftProtected) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, customerDAO.getCustomerID());
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, balance);
            preparedStatement.setBoolean(4, overdraftProtected);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * Fetch an account form the DB and return an AccountDAO object
    * */
    public static AccountDAO report(int accountNum) {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM Accounts WHERE AccountNum = ?");
            preparedStatement.setInt(1, accountNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerDAO customerDAO = CustomerDAO.report(resultSet.getInt("CustomerID"));
            String Type = resultSet.getString("Type");
            int Balance = resultSet.getInt("Balance");
            boolean OverdraftProtected = resultSet.getBoolean("OverdraftProtected");
            return new AccountDAO(
                    accountNum,
                    customerDAO,
                    Type,
                    Balance,
                    OverdraftProtected
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    * Update the DB entry for an AccountDAO object if its contents has changed
    * */
    public void update() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("UPDATE Accounts SET `CustomerID` = ?, `Type` = ?, Balance = ?, OverdraftProtected = ? WHERE AccountNum = ?");
            preparedStatement.setInt(1, customerDAO.getCustomerID());
            preparedStatement.setString(2, type);
            preparedStatement.setInt(3, balance);
            preparedStatement.setBoolean(4, overdraftProtected);
            preparedStatement.setInt(5, accountNum);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * Remove an account from the DB
    * */
    public void delete() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("DELETE FROM Accounts WHERE AccountNum = ?");
            preparedStatement.setInt(1, accountNum);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * Fetch all transactions for an account in the DB
    * */
    public List<AccountTransactionDAO> getTransactions() {
        return AccountTransactionDAO.getTransactions(accountNum);
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
        update();
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        update();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        update();
    }

    public boolean isOverdraftProtected() {
        return overdraftProtected;
    }

    public void setOverdraftProtected(boolean overdraftProtected) {
        this.overdraftProtected = overdraftProtected;
        update();
    }
}
