public class App {
    public static void main(String[] args) throws Exception {
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());

        RegionDAO rdao = new RegionDAO(connection.getConnection());
        // for(Region region : rdao.getAll()){
        //     System.out.println(region.getRegion_id());
        //     System.out.println(region.getRegion_name());
        // }

        // Region region = new Region();

        // Region region = new Region(12, "Palembang");
        // System.out.println(rdao.insert(region));
        // Integer getID = rdao.getIDbyID(13);
        // Region region = new Region(getID, "Jonggol");
        // System.out.println(rdao.update(region));
        // System.out.println(rdao.deleteData(region));
        Integer getID = rdao.getIDbyID(13);
        Region region2 = new Region(getID, "Kuta Bumi");
        // System.out.println(rdao.insert(region2));
         
        System.out.println(rdao.deleteData(region2));
}       


}
