
public class Airport {
    private String code;
    private String name;
    private String country;
    private String city;

    // Default constructor
    public Airport() {
        this.code = null;
        this.name = null;
        this.country = null;
        this.city = null;
    }

    // Parameterized constructor
    public Airport(String code, String name, String country, String city) {
        this.code = code;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" + "code=" + code + ", name=" + name + ", country=" + country + ", city=" + city + '}';
    }
    
}