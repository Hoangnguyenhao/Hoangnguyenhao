package Entity;

public class Security {
    private String type;

    public Security(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Security{" +
                "type='" + type + '\'' +
                '}';
    }
}