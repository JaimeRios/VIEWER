package model;

import java.util.ArrayList;

public class Serie extends Film{
    
    private int id;
    private int seasonQuantity;
    private ArrayList<Chapter> chapter;

    
    public Serie(String title, String genre, String creator, int duration, int seasonQuantity) {
        super(title, genre, creator, duration);
        this.seasonQuantity= seasonQuantity;
    }

    public int getId() {
        return id;
    }

    public int getSeasonQuantity() {
        return seasonQuantity;
    }

    public void setSeasonQuantity(int seasonQuantity) {
        this.seasonQuantity = seasonQuantity;
    }

    public ArrayList<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(ArrayList<Chapter> chapters) {
        this.chapter = chapters;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n .:: SERIE ::." + 
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() + 
                "\n Year: " + getYear() + 
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }
    
    
    public static ArrayList<Serie> makeSerieList(){
        ArrayList<Serie> series = new ArrayList<>();
        for(int i=1;i<6; i++){
            series.add(new Serie("Serie "+i, "Genero "+i, "Creador "+i, 120+i, (15+i)));
            series.get(i-1).setChapter(Chapter.makeChapterList());            
        }
        return series;
    }
    
    
}
