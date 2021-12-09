package jdbcapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import jdbcapp.impl.ProductInterface;
import jdbcapp.model.Product;
import jdbcapp.service.GetConnection;

public class ProductDAO implements ProductInterface{

    @Override
    public  int insert(Product p) {
        Connection con = null;
        int x = 0;
        try{
            con = GetConnection.getConnection();
            String sql = "insert into product(name,price,description) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setFloat(2, p.getPrice());
            ps.setString(3, p.getDescription());
            x = ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return x;
    }

    @Override
    public int delete(Product p) {
    }

    @Override
    public int update(Product p) {
    }
    
}
