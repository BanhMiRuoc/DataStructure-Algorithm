import java.io.*;
import java.util.*;

public class RatingManagement {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        ArrayList<Rating> edgeRatings = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader(ratingPath));
            String line = sc.nextLine();
            String[] values = line.split(",");
            int userIndex = 0, movieIndex = 0, ratingIndex = 0, timeIndex = 0;
            for(int i = 0; i < values.length; i++) {
                if(values[i].equals("UserID"))
                    userIndex = i;
                if(values[i].equals("MovieID"))
                    movieIndex = i;
                if(values[i].equals("Rating"))
                    ratingIndex = i;
                if(values[i].equals("Timestamp"))
                    timeIndex = i;
            }
            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] attr = data.split(",");
                edgeRatings.add(new Rating(Integer.parseInt(attr[userIndex]), Integer.parseInt(attr[movieIndex]), Integer.parseInt(attr[ratingIndex]), Long.parseLong(attr[timeIndex])));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return edgeRatings;
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        /* code here */
        ArrayList<Movie> edgeMovies = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader(moviePath));
            String line = sc.nextLine();
            String[] values = line.split(",");
            int movieIndex = 0, titleIndex = 0, genresIndex = 0;
            for(int i = 0; i < values.length; i++) {
                if(values[i].equals("MovieID"))
                    movieIndex = i;
                if(values[i].equals("Title"))
                    titleIndex = i;
                if(values[i].equals("Genres"))
                    genresIndex = i;
            }
            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] attr = data.split(",");
                ArrayList<String>gen = new ArrayList<String>();
                String[] g = attr[genresIndex].split("-");
                for(String t: g) {
                    gen.add(t);
                }
                edgeMovies.add(new Movie(Integer.parseInt(attr[movieIndex]), attr[titleIndex], gen));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return edgeMovies;
    }

    private ArrayList<User> loadUsers(String userPath) {
        /* code here */
        ArrayList<User> edgeUsers = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader(userPath));
            String line = sc.nextLine();
            String[] values = line.split(",");
            int userIndex = 0, genderIndex = 0, ageIndex = 0, occupationIndex = 0, zipIndex = 0;
            for(int i = 0; i < values.length; i++) {
                if(values[i].equals("UserID"))
                    userIndex = i;
                if(values[i].equals("Gender"))
                    genderIndex = i;
                if(values[i].equals("Age"))
                    ageIndex = i;
                if(values[i].equals("Occupation"))
                    occupationIndex = i;
                if(values[i].equals("Zip-code"))
                    zipIndex = i;
            }
            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] attr = data.split(",");
                edgeUsers.add(new User(Integer.parseInt(attr[userIndex]), attr[genderIndex], Integer.parseInt(attr[ageIndex]), attr[occupationIndex], attr[zipIndex]));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return edgeUsers;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Rating> getRating() {
        return ratings;
    }

    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {
        ArrayList<Movie> rs = new ArrayList<>();
        for(Rating r: getRating()) {
            if(r.getUsers() == userId && r.getRating() >= rating)
            for(Movie m: getMovies())
                if(r.getMovies() == m.getId())
                    rs.add(m);
        }
        Collections.sort(rs, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return rs;
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
        ArrayList<Integer> nUsers = new ArrayList<>();
        ArrayList<User> Users = new ArrayList<>();
        int point = 0;
        for(Rating r: getRating())
            if(r.getMovies() == movieId && r.getUsers() == userId) {
                point = r.getRating();
                break;
            }
        for(Rating m: getRating())
            if(m.getRating() == point && m.getMovies() == movieId)
                nUsers.add(m.getUsers());
        for(User u: getUsers())
            for(Integer i: nUsers)
                if(i == u.getId() && i != userId)
                    Users.add(u);
        return Users;
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {
        ArrayList<String> lovMovies = new ArrayList<>();
        ArrayList<Integer> ratingBetterThan3 = new ArrayList<>();
        for(Rating r: getRating())
            if(r.getRating() > 3)
                ratingBetterThan3.add(r.getMovies());
        for(Movie n: getMovies()) {
            int count = 0;
            for(Integer i: ratingBetterThan3)
                if(n.getId() == i)
                    count++;
            if(count > 1)
                lovMovies.add(n.getName());
        }
        Collections.sort(lovMovies, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return lovMovies;
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        /* code here */
        ArrayList<Integer> kUsers = new ArrayList<>();
        Set<Integer> kMovies = new HashSet<>();
        ArrayList<String> kMoviesBefore = new ArrayList<>();
        ArrayList<String> kMoviesAfter = new ArrayList<>();
        for(User u: getUsers()) {
            if(u.getOccupation().equals(occupation) && u.getGender().equals(gender)) {
                kUsers.add(u.getId());
            }
        }
        for(Rating r: getRating()) {
            for(Integer u: kUsers) {
                if(u == r.getUsers() && r.getRating() == rating) {
                    kMovies.add(r.getMovies());
                }
            }
        }
        for(Movie m: getMovies()) {
            for(Integer t: kMovies) {
                if(m.getId() == t) {
                    kMoviesBefore.add(m.getName());
                }
            }
        }
        Collections.sort(kMoviesBefore, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int count = 0;
        for(String a: kMoviesBefore) {
            if(count == k) break;
            kMoviesAfter.add(a);
            count++;
        }
        return kMoviesAfter;
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        ArrayList<Integer> kUsers = new ArrayList<>();
        Set<Integer> kMovies = new HashSet<>();
        ArrayList<String> kMoviesBefore = new ArrayList<>();
        ArrayList<String> kMoviesAfter = new ArrayList<>();
        for(User u: getUsers())
            if(u.getOccupation().equals(occupation))
                kUsers.add(u.getId());
        for(Rating r: getRating())
            for(Integer u: kUsers)
                if(u == r.getUsers() && r.getRating() < rating)
                    kMovies.add(r.getMovies());
        for(Movie m: getMovies())
            for(Integer t: kMovies)
                if(m.getId() == t)
                    kMoviesBefore.add(m.getName());
        Collections.sort(kMoviesBefore, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int count = 0;
        for(String a: kMoviesBefore) {
            if(count == k) break;
            kMoviesAfter.add(a);
            count++;
        }
        return kMoviesAfter;
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        ArrayList<Integer> genUsers = new ArrayList<>();
        Set<Integer> ratingGenMovies = new HashSet<>();
        String gen = "";
        ArrayList<String> type = new ArrayList<>();
        ArrayList<String> movies = new ArrayList<>();
        ArrayList<String> kMovieAfter = new ArrayList<>();
        //tim gender
        for(User u: getUsers())
            if(u.getId() == userId) {
                gen = u.getGender();
                break;
            }
        for(User u: getUsers())
            if(u.getGender().equals(gen))
                genUsers.add(u.getId());
        long max = 0;
        int movie = 0;
        for(Rating r: getRating()) {
            if(userId == r.getUsers() && r.getTimeStamps() > max)
                max = r.getTimeStamps();
            if(r.getTimeStamps() == max && r.getUsers() == userId)
                movie = r.getMovies();
        }
        for(Movie m: getMovies())
            if(m.getId() == movie)
                for(String a: m.getGenres())
                    type.add(a);
        for(Rating r: getRating())
            for(Integer n: genUsers)
                if(r.getRating() >= rating && n == r.getUsers())
                    ratingGenMovies.add(r.getMovies());
        for(Movie u: getMovies())
            for(Integer b: ratingGenMovies)
                if(u.getId() == b) {
                    boolean check = false;
                    for(String a: type)
                        for(String c: u.getGenres())
                            if(a.equals(c))
                                check = true;
                    if(check)
                        movies.add(u.getName());
                }
        Collections.sort(movies, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int count = 0;
        for(String a: movies) {
            if(count == k) break;
            kMovieAfter.add(a);
            count++;
        }
        return kMovieAfter;
    }
}

