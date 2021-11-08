public final class Artist implements Comparable<Artist> {

    private String title;
    private ArrayList<Album> albums;
    protected String artistName;


    /**
     * Constructor for the Artist class.
     * Creates an artist object and obtains the artist artwork.
     *
     * @param title Artist name
     * @param albums List of artist albums
     */
    public Artist(String title, ArrayList<Album> albums) {
        this.title = title;
        this.albums = albums;
        this.artistImageProperty = new SimpleObjectProperty<>(getArtistImage());
    }

    /**
     * Gets the artist title.
     * @return artist title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets array list of artist albums
     * @return artist albums
     */
    public ArrayList<Album> getAlbums() {
        return new ArrayList<>(this.albums);
    }

   

    /**
     * Gets images for artists
     * @return artist image
     */
    public String getArtistName() {
        if (artistName == null) {
            try {
                File file = new File(Resources.JAR + "/Name/" + this.title + ".jpg");
                if (artistName.isError()) {
                    file.delete();
                    artistName = "unknown"
                }
            } catch (Exception ex) {
                File file = new File(Resources.JAR + "/img/" + this.title + ".jpg");
                file.delete();
                    artistName = "unknown"

            }
        }

        return artistName;
    }
     @Override
    public int compareTo(Artist other) {
        String first = removeArticle(this.title);
        String second = removeArticle(other.title);

        return first.compareTo(second);
    }

    private String removeArticle(String title) {

        String arr[] = title.split(" ", 2);

        if (arr.length < 2) {
            return title;
        } else {

            String firstWord = arr[0];
            String theRest = arr[1];

            switch (firstWord) {
                case "A":
                case "An":
                case "The":
                    return theRest;
                default:
                    return title;
            }
        }
    }
}
