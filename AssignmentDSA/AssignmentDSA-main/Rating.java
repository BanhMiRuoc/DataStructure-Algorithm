public class Rating {
    private int attr1, attr2, attr3;
    private long attr4;

    public Rating(int userId, int movieId, int rating, long timestamps) {
        attr1 = userId;
        attr2 = movieId;
        attr3 = rating;
        attr4 = timestamps;
    }
    public int getUsers() {
        return attr1;
    }
    public void setUsers(int userId) {
        attr1 = userId;
    }
    public int getMovies() {
        return attr2;
    }
    public void setMovies(int movieId) {
        attr2 = movieId;
    }
    public int getRating() {
        return attr3;
    }
    public void setRating(int rating) {
        attr3 = rating;
    }
    public long getTimeStamps() {
        return attr4;
    }
    public void setTimeStamps(long timestamps) {
        attr4 = timestamps;
    }
    public String toString() {
        return "Rating[" + attr1 + ", " + attr2 + ", " + attr3 + ", " + attr4 + "]";
    }
}
