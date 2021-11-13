package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class DebitCardDAO {
    private String CardNum;
    private AccountDAO accountDAO;
    private int fee;
    private Date expirationDate;
    private String cvv;
    private boolean chipAndPin;

    public DebitCardDAO(String cardNum, AccountDAO accountDAO, int fee, Date expirationDate, String cvv, boolean chipAndPin) {
        CardNum = cardNum;
        this.accountDAO = accountDAO;
        this.fee = fee;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.chipAndPin = chipAndPin;
    }
    /*
     * Create a new record in the DB for a DebitCard
     * */
    public void create() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("INSERT INTO DebitCards (AccountID, fee, expirationDate, cvv, chipAndPin) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, accountDAO.getAccountNum());
            preparedStatement.setInt(2, fee);
            preparedStatement.setDate(3, new java.sql.Date(expirationDate.getTime()));
            preparedStatement.setString(4, cvv);
            preparedStatement.setBoolean(5, chipAndPin);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Fetch a debit card form the DB and return an DebitCardDAO object
     * */
    public static DebitCardDAO report(String CardNum) {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM DebitCards WHERE CardNum = ?");
            preparedStatement.setString(1, CardNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            AccountDAO accountDAO = AccountDAO.report(resultSet.getInt("AccountID"));
            int fee = resultSet.getInt("fee");
            String cvv = resultSet.getString("cvv");
            boolean chipAndPin = resultSet.getBoolean("chipAndPin");
            java.sql.Date expirationDate = resultSet.getDate("expirationDate");
            return new DebitCardDAO(
                    CardNum,
                    accountDAO,
                    fee,
                    new java.util.Date(expirationDate.getTime()),
                    cvv,
                    chipAndPin
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Update the DB entry for an DebitCardDAO object if its contents has changed
     * */
    public void update() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("UPDATE DebitCards SET AccountID = ?, fee = ?, expirationDate = ?, cvv = ?, chipAndPin = ? WHERE CardNum = ?");
            preparedStatement.setInt(1, accountDAO.getAccountNum());
            preparedStatement.setInt(2, fee);
            preparedStatement.setDate(3, new java.sql.Date(expirationDate.getTime()));
            preparedStatement.setString(4, cvv);
            preparedStatement.setBoolean(5, chipAndPin);
            preparedStatement.setString(6, CardNum);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Remove a debit card from the DB
     * */
    public void delete() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("DELETE FROM DebitCards WHERE CardNum = ?");
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
}
