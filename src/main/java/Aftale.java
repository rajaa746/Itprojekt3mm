import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aftale {

   // private String name;

   // public String getName() {
   //     return name;
   // }

   // public void setName(String name) {
   //     this.name = name;
  //  }
    private String Cpr;

    public String getCpr() {
        return Cpr;
    }

    public void setCpr(String Cpr) {
        this.Cpr = Cpr;
    }
}
