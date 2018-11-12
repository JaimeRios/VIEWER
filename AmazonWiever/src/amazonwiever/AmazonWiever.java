/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonwiever;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import makefile.Report;
import model.Chapter;
import model.Movie;
import model.Serie;

public class AmazonWiever {

    public static void main(String[] args) {
       showMenu();  
    }
    
    
    
    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        int exit =0;
        do{
            System.out.println("BIENVENIDO A AMAZAON VIEWER");
            System.out.println("");
            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");
            exit= Integer.valueOf(sc.nextLine());
            
            
            switch(exit){
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3: 
                    showBooks();
                    break;
                case 4: 
                    showMagazines();
                    break;
                case 5: 
                    makeReport();
                    break;
                case 6: 
                    makeReport(new Date());
                    break;
                case 0:
                    System.out.println("Usted esta saliendo de AMAZON VIEWER");
                    break;
                default:
                    System.out.println("Opcion no disponible!");
            }   
        }while(exit!=0);
    }
    static ArrayList<Movie> movies;
    public static void showMovies(){
        int exit = 0;
        movies= Movie.makeMoviesList();
        do{
            System.out.println();
            System.out.println(".::MOVIES::.");
            System.out.println();
            for(int i=0;i<movies.size();i++){
                System.out.println(i+1+". "+movies.get(i).getTitle()+" Visto: "+movies.get(i).isViewed());
            }
            System.out.println("Desea Regresar al Menu Ingrese 0");
            System.out.println("");
            
            Scanner sc = new Scanner(System.in);
            exit = Integer.valueOf(sc.nextLine());
            
            if(exit!=0){
                Movie movieSelected= movies.get(exit-1);
                movieSelected.setViewed(true);
                Date dateI = movieSelected.startToSee(new Date());

                for(int i=0;i<100000;i++){
                    System.out.println("............");
                }

                //Termino de verla
                movieSelected.stopToSee(dateI, new Date());
                System.out.println("");
                System.out.println("viste: "+movieSelected);
                System.out.println("Por "+movieSelected.getTimeViewed()+" milisegundos");
            }
        }while(exit!=0);
    }
    
    public static void showSeries(){
        int exit = 0;
        ArrayList<Serie> series= Serie.makeSerieList();
        do{
            System.out.println();
            System.out.println(".::SERIES::.");
            System.out.println();
            for(int i=0;i<series.size();i++){
                System.out.println(i+1+". "+series.get(i).getTitle()+" Visto: "+series.get(i).isViewed());
            }
            System.out.println("Desea Regresar al Menu Ingrese 0");
            System.out.println("");
            
            Scanner sc = new Scanner(System.in);
            exit = Integer.valueOf(sc.nextLine());
            
            if(exit!=0){
                Serie serieSelected= series.get(exit-1);
                serieSelected.setChapter(showChapters(serieSelected));
                                
            }
            
        }while(exit!=0);
    }
    
    public static ArrayList<Chapter> showChapters(Serie se){
        int exit = 0;
 //       se.setChapter(Chapter.makeChapterList());
        do{
            System.out.println(se.getTitle());
            System.out.println(".::CHAPTERS::.");
            System.out.println();
            
            for(int i=0;i<se.getChapter().size();i++){
                System.out.println(i+1+". "+se.getChapter().get(i).getTitle()+" Visto: "+se.getChapter().get(i).isViewed());
            }
            System.out.println("Desea Regresar al Menu Series Ingrese 0");
            System.out.println("");
            
            Scanner sc = new Scanner(System.in);
            exit = Integer.valueOf(sc.nextLine());
            if(exit!=0){
                
                se.getChapter().get(exit-1).setViewed(true);
                Date dateI = se.getChapter().get(exit-1).startToSee(new Date());

                for(int i=0;i<100000;i++){
                    System.out.println("............");
                }

                //Termino de verla
                se.getChapter().get(exit-1).stopToSee(dateI, new Date());
                System.out.println("");
                System.out.println("viste: "+se);
                System.out.println("viste: "+se.getChapter().get(exit-1));
                System.out.println("Por "+se.getChapter().get(exit-1).getTimeViewed()+" milisegundos");
                
            }
            
        }while(exit!=0);
        
        return se.getChapter();
    }
    
    public static void showBooks(){
        int exit = 0;
        do{
            System.out.println();
            System.out.println(".::BOOKS::.");
            System.out.println();
            
        }while(exit!=0);
    }
    
    public static void showMagazines(){
        int exit = 0;
        do{
            System.out.println();
            System.out.println(".::MAGAZINES::.");
            System.out.println();
            
        }while(exit!=0);
    }
    
    public static void makeReport(){
        Report report = new Report();
        report.setNameFile("Reporte");
        report.setExtension("txt");
        report.setTitle(".:: VISTOS ::. \n");
        String contentReport = report.getTitle();
        for(Movie movie: movies){
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();
    }
    
    public static void makeReport(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("Reporte "+dateString);
        report.setExtension("txt");
        report.setTitle(".:: VISTOS ::. \n");
        String contentReport = report.getTitle();
        for(Movie movie: movies){
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();
    }
}
