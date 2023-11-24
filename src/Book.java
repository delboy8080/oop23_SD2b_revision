public class Book implements MeasureTime
{
    String title;
    String author;
    int pages;
    int readingSpeed; // pages per minute

    public Book(String title, String author, int pages, int readingSpeed) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.readingSpeed = readingSpeed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getReadingSpeed() {
        return readingSpeed;
    }

    public void setReadingSpeed(int readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

    @Override
    public int measure() {
        return pages / readingSpeed;
    }
}
