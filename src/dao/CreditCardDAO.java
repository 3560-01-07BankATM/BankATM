package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class CreditCardDAO {

    private String CardNum;
    private AccountDAO accountDAO;
    private int fee;
    private Date expirationDate;
    private String cvv;
    private boolean chipAndPin;
    private int creditLimit;
    private int creditUsed;

    public CreditCardDAO(String cardNum, AccountDAO accountDAO, int fee, Date expirationDate, String cvv, boolean chipAndPin, int creditLimit, int creditUsed) {
        CardNum = cardNum;
        this.accountDAO = accountDAO;
        this.fee = fee;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.chipAndPin = chipAndPin;
        this.creditLimit = creditLimit;
        this.creditUsed = creditUsed;
    }
    /*
     * Create a new record in the DB for a CreditCardDAO
     * */
    public void create() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("INSERT INTO CreditCards (`AccountID`, `fee`, `expirationDate`, `chipAndPin`, `cvv`, `creditLimit`, `creditUsed`) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, accountDAO.getAccountNum());
            preparedStatement.setInt(2, fee);
            preparedStatement.setDate(3, new java.sql.Date(expirationDate.getTime()));
            preparedStatement.setBoolean(4, chipAndPin);
            preparedStatement.setString(5, cvv);
            preparedStatement.setInt(6, creditLimit);
            preparedStatement.setInt(7, creditUsed);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Fetch a credit card record form the DB and return a CreditCardDAO object
     * */
    public static CreditCardDAO report(String CardNum) {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM CreditCards WHERE CardNum = ?");
            preparedStatement.setString(1, CardNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            AccountDAO accountDAO = AccountDAO.report(resultSet.getInt("AccountID"));
            int fee = resultSet.getInt("fee");
            String cvv = resultSet.getString("cvv");
            boolean chipAndPin = resultSet.getBoolean("chipAndPin");
            java.sql.Date expirationDate = resultSet.getDate("expirationDate");
            int creditLimit = resultSet.getInt("creditLimit");
            int creditUsed = resultSet.getInt("creditUsed");
            return new CreditCardDAO(
                    CardNum,
                    accountDAO,
                    fee,
                    new Date(expirationDate.getTime()),
                    cvv,
                    chipAndPin,
                    creditLimit,
                    creditUsed
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Update the DB entry for a CreditCardDAO object if its contents has changed
     * */
    public void update() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("UPDATE CreditCards SET AccountID = ?, fee = ?, expirationDate = ?, cvv = ?, chipAndPin = ?, creditLimit = ?, creditUsed = ? WHERE CardNum = ?");
            preparedStatement.setInt(1, accountDAO.getAccountNum());
            preparedStatement.setInt(2, fee);
            preparedStatement.setDate(3, new java.sql.Date(expirationDate.getTime()));
            preparedStatement.setString(4, cvv);
            preparedStatement.setBoolean(5, chipAndPin);
            preparedStatement.setInt(6, creditLimit);
            preparedStatement.setInt(7, creditUsed);
            preparedStatement.setString(8, CardNum);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Remove a credit card from the DB
     * */
    public void delete() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("DELETE FROM CreditCards WHERE CardNum = ?");
            preparedStatement.setString(1, CardNum);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCardNum() {
        return CardNum;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
        update();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        update();
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
        update();
    }

    public boolean isChipAndPin() {
        return chipAndPin;
    }

    public void setChipAndPin(boolean chipAndPin) {
        this.chipAndPin = chipAndPin;
        update();
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
        update();
    }

    public int getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(int creditUsed) {
        this.creditUsed = creditUsed;
        update();
    }
}
