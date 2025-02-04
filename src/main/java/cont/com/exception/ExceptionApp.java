package cont.com.exception;

public class ExceptionApp extends RuntimeException {
    private String description;

    public ExceptionApp(String message) {
        super(message);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
