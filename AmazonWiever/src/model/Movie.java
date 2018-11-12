package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


public class Movie extends Film implements IVisualizable{
    
    private int id;
    private int timeViewed;

    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        super.setYear(year);
    }

    public void showData(){
        //System.out.println("Title: "+this.title);
        //System.out.println("Genre: "+this.genre);
        //System.out.println("Year: "+this.year);
    }

    public int getId() {
        return id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n .:: MOVIE ::." + 
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() + 
                "\n Year: " + getYear() + 
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    } 

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(dateI);
        end.setTime(dateF);
        /*if(end.get(Calendar.SECOND)>start.get(Calendar.SECOND)){
            setTimeViewed(end.get(Calendar.SECOND)-start.get(Calendar.SECOND));
        }else{
            setTimeViewed(0);
        }*/
        if(dateF.getTime()>dateI.getTime()){
            setTimeViewed((int)(dateF.getTime()-dateI.getTime()));
        }else{
            setTimeViewed(0);
        }
    }
    
    public static ArrayList<Movie> makeMoviesList(){
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i=1;i<6; i++){
            movies.add(new Movie("Movie "+i, "Genero "+i, "Creador "+i, 120+i, (short)(2017+i)));
        }
        return movies;
    }
}
