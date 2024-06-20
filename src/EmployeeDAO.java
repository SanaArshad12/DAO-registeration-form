import java.sql.SQLException;

public interface EmployeeDAO {
    public int read(employee employee,DB c)throws SQLException, ClassNotFoundException;
    public  int insert(employee employee,DB c)throws SQLException, ClassNotFoundException ;
    public int update(employee employee,DB c)throws SQLException, ClassNotFoundException;
    public int delete(int id)throws SQLException, ClassNotFoundException;

}
