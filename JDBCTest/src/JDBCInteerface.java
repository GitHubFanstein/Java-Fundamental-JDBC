import java.util.List;

public interface JDBCInteerface {
    public List<Region> getAll();
    public boolean insert(Region region);
    public boolean get(Region regionID);
    public boolean update(Region regionNameUpdate2);
    public boolean deleteData(Region regionDelete);
}
