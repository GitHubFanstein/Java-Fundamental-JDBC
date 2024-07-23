public class App {
    public static void main(String[] args) throws Exception {
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());

        RegionDAO rdao = new RegionDAO(connection.getConnection());
        // for(Region region : rdao.getAll()){
        //     System.out.println(region.getRegionName() + " " + region.getRegionDd());
        // }

        // Region region = new Region();

        // Region region = new Region(12, "Palembang");
        // System.out.println(rdao.insert(region));
        // Integer getID = rdao.getIDbyID(13);
        // Region region = new Region(getID, "Jonggol");
        // System.out.println(rdao.update(region));
        // System.out.println(rdao.deleteData(region));
        Region region2 = new Region(11 , " Asia Barat ", " Korea Barat Daya ");
        // System.out.println(rdao.update(region, region));

        // JDBCInteerface jdbcInteerface = new RegionDAO(connection.getConnection());
        // System.out.println(jdbcInteerface.update(region));

        // Get ID
        
        boolean result = rdao.get(region2);
        System.out.println("Result: " + result);
    }

        
}       

   
