import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO {
  private Connection connection;

  public RegionDAO(Connection connection) {
    this.connection = connection;
  }

  

  public List<Region> getAll() {
    List<Region> regions = new ArrayList<>();
    String query = "SELECT * FROM regions";
    try {
      ResultSet resultSet = connection.prepareStatement(query).executeQuery();

      while (resultSet.next()) {
        Region region = new Region(resultSet.getInt("region_id"), resultSet.getString("region_name"));
        regions.add(region);
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
      return regions;
    }

  public boolean insert(Region region){
    try{
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO regions (region_id, region_name) VALUES (?,?)");
      preparedStatement.setInt(1, region.getRegion_id());
      preparedStatement.setString(2, region.getRegion_name());
      preparedStatement.execute();
      return true;
    } catch(SQLException e){
      e.printStackTrace();
    }
    return false;
}

    public Integer getIDbyID(Integer regionID){
        String querySelect = "select region_id from regions where region_id = ? ";
        String messageFailed = "Failed";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querySelect);
            preparedStatement.setInt(1, regionID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("region_id");
            } else {
                return resultSet.getInt(messageFailed); // Return null if no matching region_id is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public boolean update(Region regionUpdate) {
        String queryUpdate = "UPDATE regions SET region_name = ? WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, regionUpdate.getRegion_name());
            preparedStatement.setInt(2, regionUpdate.getRegion_id());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     public String deleteData(Region regionDelete) {
        String queryDelete = "delete from regions where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, regionDelete.getRegion_id());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {  
                return "Delete successful.";
            } else {
                return "No rows deleted.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Deletion failed: " + e.getMessage();
        }
     } 

     
    
    
}