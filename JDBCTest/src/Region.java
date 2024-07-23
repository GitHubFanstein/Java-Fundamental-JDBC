public class Region  {
    // Encapsulation Part
    private int regionDd;
    private String regionName;
    private String negara;

    public Region(int regionDd, String regionName, String negara) {
        this.regionDd = regionDd;
        this.regionName = regionName;
        this.negara = negara;
    }

    public int getRegionDd() {
        return regionDd;
    }

    public void setRegionDd(int regionDd) {
        this.regionDd = regionDd;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

   
    
    
  
}
