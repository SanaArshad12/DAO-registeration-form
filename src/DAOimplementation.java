import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DAOimplementation implements EmployeeDAO{

    public int read(employee employee,DB c)throws SQLException, ClassNotFoundException {
        Connection connection=DB.getConnection();
        int i=employee.id;
        String n=employee.name;
        if (employee.NoofTickets<=8){
            PreparedStatement preparedStatement=connection.prepareStatement("Select no from aooplab where id=?");
            preparedStatement.setInt(1,i);
            ResultSet resultSet=preparedStatement.executeQuery();
            int Current=resultSet.getInt(2);
            if(employee.NoofTickets<=Current){
                Current-=employee.NoofTickets;
                PreparedStatement preparedStatement1=connection.prepareStatement("update aooplab set no=? where id=?");
                preparedStatement1.setInt(1,Current);
                preparedStatement1.setInt(2,employee.id);
                preparedStatement1.execute();
                return Current;
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong no of tickets were Selected");
                return -1;
            }

        }
        return 0;
    }


    public int insert(employee employee,DB c)throws SQLException, ClassNotFoundException {
        if(!checkTickets(employee.NoofTickets)){
            return -1;
        }
        Connection connection=DB.getConnection();
        int i=employee.id;
        String n=employee.name;

        String sql="insert into aooplab values(?,?,?)";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(3,employee.NoofTickets);
        ps.setInt(2,i);
        ps.setString(1,n);

        int rowsAffected=ps.executeUpdate();
        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
        }else{
            JOptionPane.showMessageDialog(null,"Error in database");
        }
        return 0;
    }

    private boolean checkTickets(int NoofTickets) throws SQLException, ClassNotFoundException {
        Connection con = DB.getConnection();
        PreparedStatement ps = con.prepareStatement("select NoofTickets from aooplab");
        ResultSet rs = ps.executeQuery();
        int tickets =0;
        while(rs.next()){
            tickets+= rs.getInt("NoofTickets");
        }
        if(NoofTickets+tickets >8){
            JOptionPane.showMessageDialog(null,"You can't book more than 8 tickets");
            return false;
        }
        return true;
    }

    public int update(employee employee,DB c)throws SQLException, ClassNotFoundException {
        Connection connection=DB.getConnection();
        int i=employee.id;
        String n=employee.name;
        String sql="UPDATE aooplab SET name = ? WHERE id = ?";
        PreparedStatement ps1=connection.prepareStatement(sql);
        ps1.setInt(2,i);
        ps1.setString(1,n);
        int rowsAffected=ps1.executeUpdate();
        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null,"Data updated Successfully");
        }else{
            JOptionPane.showMessageDialog(null,"Error in database");
        }
        return 0;
    }

    @Override
    public  int delete(int id)throws SQLException, ClassNotFoundException {
        Connection connection=DB.getConnection();

        String sql = "DELETE FROM aooplab WHERE id = ?";
        PreparedStatement ps1=connection.prepareStatement(sql);
        ps1.setInt(1,id);

        int rowsAffected=ps1.executeUpdate();
        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null,"Data deleted Successfully");
        }else{
            JOptionPane.showMessageDialog(null,"Error in database");
        }
        return 0;
    }
}
