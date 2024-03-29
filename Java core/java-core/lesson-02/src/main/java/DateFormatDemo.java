import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatDemo {
    public static void main(String[] args) {
        formatByCountry();
        formatByPattern();
    }

    public static void formatByPattern() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("EEEE, MMM d, yyyy");
        String formatted = now.format(formatter);
        System.out.println("formatted = " + formatted);
    }

    public static void formatByCountry() {
        Locale vi = new Locale("zh");
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(vi);
        String formatted = now.format(formatter);
        System.out.println("formatted = " + formatted);
    }
}
