public class Review {


    private String Review;
    private String Star;
    private String Date;



    public Review() {
        // this empty constructor is required
    }

    public Review(String Review, String Star, String Date) {
        this.Review = Review;
        this.Star = Star;
        this.Date = Date;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStar() {
        return Star;
    }

    public void setStar(String star) {
        Star = star;
    }
    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }


}