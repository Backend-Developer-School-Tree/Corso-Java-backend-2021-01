public class BookEntry implements Comparable<BookEntry>{

    private String fileName;
    private double distance;

    public BookEntry(String fileName, double distance) {
        this.fileName = fileName;
        this.distance = distance;
    }

    public String getFileName() {
        return fileName;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(BookEntry o) {
        return Double.compare(distance, o.distance);
    }

    @Override
    public String toString() {
        return fileName + "--" + distance;
    }
}
