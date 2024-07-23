import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO implements JDBCInteerface  {
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
        Region region = new Region(resultSet.getInt("region_id"), resultSet.getString("region_name"), resultSet.getString("Negara"));
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
      preparedStatement.setInt(1, region.getRegionDd());
      preparedStatement.setString(2, region.getRegionName());
      preparedStatement.execute();
      return true;
    } catch(SQLException e){
      e.printStackTrace();
    }
    return false;
}

public boolean get(Region regionID) {
    String querySelect = "SELECT region_id, region_name FROM regions WHERE region_id = ?";
    List<String> results = new ArrayList<>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(querySelect);
        preparedStatement.setInt(1, regionID.getRegionDd());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean found = false;
        while (resultSet.next()) {
            int regionId = resultSet.getInt("region_id");
            String regionName = resultSet.getString("region_name");
            String hasilNya = "Region ID: " + regionId + ", Region Name: " + regionName;
            results.add(hasilNya);
            found = true;
        }
        for (String result : results) {
            System.out.println(result);
        }
        return found;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    

    public boolean updateV(Region regionNameUpdate) {
        String queryUpdate = "UPDATE regions SET region_name = ? WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, regionNameUpdate.getRegionName());
            preparedStatement.setInt(2, regionNameUpdate.getRegionDd());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Region regionNameUpdate2) {
        String queryUpdate = "UPDATE regions SET region_name = ?, Negara = ? WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, regionNameUpdate2.getRegionName());
            preparedStatement.setString(2, regionNameUpdate2.getNegara());
            preparedStatement.setInt(3, regionNameUpdate2.getRegionDd());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     public boolean deleteData(Region regionDelete) {
        String queryDelete = "delete from regions where region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, regionDelete.getRegionDd());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
     } 

}