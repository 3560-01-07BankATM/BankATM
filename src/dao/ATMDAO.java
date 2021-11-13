package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ATMDAO {
    private int ID;
    private String address;
    private int ones;
    private int fives;
    private int twenties;
    private int hundreds;

    public ATMDAO(int ID, String address, int ones, int fives, int twenties, int hundreds) {
        this.ID = ID;
        this.address = address;
        this.ones = ones;
        this.fives = fives;
        this.twenties = twenties;
        this.hundreds = hundreds;
    }
    /*
     * Create a new record in the DB for an ATM
     * */
    public void create() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("INSERT INTO ATM.ATM (Address, Ones, Fives, Twenties, Hundreds) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, ones);
            preparedStatement.setInt(3, fives);
            preparedStatement.setInt(4, twenties);
            preparedStatement.setInt(5, hundreds);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Fetch an atm record form the DB and return an ATMDAO object
     * */
    public static ATMDAO report(int ID) {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM ATM.ATM WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            String address = resultSet.getString("Address");
            int ones = resultSet.getInt("Ones");
            int fives = resultSet.getInt("Fives");
            int twenties = resultSet.getInt("Twenties");
            int hundreds = resultSet.getInt("Hundreds");

            return new ATMDAO(
                    ID,
                    address,
                    ones,
                    fives,
                    twenties,
                    hundreds
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Update the DB entry for an ATMDAO object if its contents has changed
     * */
    public void update() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("UPDATE ATM.ATM SET Address = ?, Ones = ?, Fives = ?, Twenties = ?, Hundreds = ? WHERE ID = ?");
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, ones);
            preparedStatement.setInt(3, fives);
            preparedStatement.setInt(4, twenties);
            preparedStatement.setInt(5, hundreds);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Remove an ATM from the DB
     * */
    public void delete() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("DELETE FROM ATM.ATM WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        update();
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
        update();
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
        update();
    }

    public int getTwenties() {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
        update();
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
        update();
    }
}
