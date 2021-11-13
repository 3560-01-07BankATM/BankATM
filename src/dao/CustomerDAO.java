package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {
    private int CustomerID;
    private String Name;
    private String PhysicalAddress;
    private String PhoneNumber;
    private String EmailAddress;


    public CustomerDAO(int customerID, String name, String physicalAddress, String phoneNumber, String emailAddress) {
        CustomerID = customerID;
        Name = name;
        PhysicalAddress = physicalAddress;
        PhoneNumber = phoneNumber;
        EmailAddress = emailAddress;
    }
    /*
     * Create a new record in the DB for an Customer
     * */
    public void create() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("INSERT INTO Customers (`Name`, PhysicalAddress, PhoneNumber, EmailAddress) VALUES (?,?,?,?)");
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, PhysicalAddress);
            preparedStatement.setString(3, PhoneNumber);
            preparedStatement.setString(4, EmailAddress);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Fetch a customer form the DB and return a CustomerDAO object
     * */
    public static CustomerDAO report(int CustomerID) {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("SELECT * FROM Customers WHERE CustomerID = ?");
            preparedStatement.setInt(1, CustomerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            String Name = resultSet.getString("Name");
            String PhysicalAddress = resultSet.getString("PhysicalAddress");
            String PhoneNumber = resultSet.getString("PhoneNumber");
            String EmailAddress = resultSet.getString("EmailAddress");
            return new CustomerDAO(
                    CustomerID,
                    Name,
                    PhysicalAddress,
                    PhoneNumber,
                    EmailAddress
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Update the DB entry for a CustomerDAO object if its contents has changed
     * */
    public void update() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("UPDATE Customers SET `Name` = ?, PhysicalAddress = ?, PhoneNumber = ?, EmailAddress = ? WHERE CustomerID = ?");
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, PhysicalAddress);
            preparedStatement.setString(3, PhoneNumber);
            preparedStatement.setString(4, EmailAddress);
            preparedStatement.setInt(5, CustomerID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * Remove a customer from the DB
     * */
    public void delete() {
        try {
            PreparedStatement preparedStatement = DB.getConnection().prepareStatement("DELETE FROM Customers WHERE CustomerID = ?");
            preparedStatement.setInt(1, CustomerID);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
        update();
    }

    public String getPhysicalAddress() {
        return PhysicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        PhysicalAddress = physicalAddress;
        update();
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
        update();
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
        update();
    }
}
