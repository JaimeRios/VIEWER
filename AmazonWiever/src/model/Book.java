package model;

import java.util.Calendar;
import java.util.Date;

public class Book extends Publication implements IVisualizable{
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;


    public Book(String title, Date edititionDate, String editorial, String[] authors) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
        setAuthors(authors);
    }


    public int getId() {
        return id;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public boolean isReaded() {
        return readed;
    }


    public void setReaded(boolean readed) {
        this.readed = readed;
    }


    public int getTimeReaded() {
        return timeReaded;
    }


    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    @Override
    public String toString() {
            // TODO Auto-generated method stub
        String detailBook = "\n .:: BOOK ::." + 
                            "\n Title: " + getTitle() +
                            "\n Editorial: " + getEditorial() + 
                            "\n Edition Date: " + getEditionDate() +
                            "\n Authors: ";
        for (int i = 0; i < getAuthors().length; i++) {
                detailBook += "\t" + getAuthors()[i];
        }
        return  detailBook;
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
        if(end.get(Calendar.SECOND)>start.get(Calendar.SECOND)){
            setTimeReaded(end.get(Calendar.SECOND)-start.get(Calendar.SECOND));
        }else{
            setTimeReaded(0);
        }
    }
     
}
