package sg.edu.rp.c346.ps_sgholiday;

public class Holiday {

    private String category;
    private String holiName;
    private String date;
    private String imageName;

    public Holiday(String category, String holiName, String date, String imageName) {
        this.category = category;
        this.holiName = holiName;
        this.date = date;
        this.imageName = imageName;
    }

    public String getCategory() {
        return category;
    }

    public String getHoliName() {
        return holiName;
    }

    public String getDate() {
        return date;
    }

    public String getImageName() {
        return imageName;
    }

}
