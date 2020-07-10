public class GregorianDate extends Date {

    private static final int[] MONTH_LENGTHS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }


    // YOUR CODE HERE
    @Override

    public Date nextDate() {
    int new_year = this.year;
    int new_month = this.month;
    int new_date = this.dayOfMonth + 1;
    if (new_date > getMonthLength(new_month)) {
        new_month += 1;
        new_date = 1;
    }
    if (new_month > 12) {
        new_year += 1;
        new_month = 1;
    }
    return new GregorianDate(new_year, new_month, new_date);
    }

    @Override
    public int dayOfYear() {
        int precedingMonthDays = 0;
        for (int m = 1; m < month; m += 1) {
            precedingMonthDays += getMonthLength(m);
        }
        return precedingMonthDays + dayOfMonth;
    }

    private static int getMonthLength(int m) {
        return MONTH_LENGTHS[m - 1];
    }
}