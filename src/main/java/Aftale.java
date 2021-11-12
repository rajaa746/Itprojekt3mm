import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aftale {

    private String name;

   public String getName() {
       return name;
   }

    public void setName(String name) {
        this.name = name;
   }

    private String Cpr;

    public String getCpr() {
        return Cpr;
    }

    public void setCpr(String Cpr) {
        this.Cpr = Cpr;
    }

    private String tidspunkt;

    public String gettidspunkt() {
        return tidspunkt;
    }

    public void settidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    private String dato;

    public String getdato() {
        return dato;
    }

    public void setdato(String dato) {
        this.dato = dato;
    }

    private String notat;

    public String getnotat() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }

}


