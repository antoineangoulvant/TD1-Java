import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;

public class News implements Comparable<News> {
    private static int count = 0;
    private int id;
    private String titre;
    private LocalDate date;
    private String auteur;
    private URL source;
    private Scanner sc = new Scanner(System.in);

    public News(String titre, LocalDate date, String auteur, URL source){
        this.id = ++count;
        this.titre = titre;
        this.date = date;
        this.auteur = auteur;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void afficher(){
        System.out.println( "ID : " + this.id + "\n" +

                "Titre : " + this.titre + "\n" +
                "Date : " + this.date.toString() + "\n" +
                "Auteur : " + this.auteur + "\n" +
                "URL : " + this.source + "\n\n");
    }

    /*public void saisir() throws MalformedURLException {
        this.date = LocalDate.now();

        System.out.print("Veuillez saisir les informations suivantes : \n\nTitre :");
        this.titre = sc.nextLine();

        System.out.print("Auteur :");
        this.auteur = sc.nextLine();

        System.out.print("URL : ");
        this.source = new URL(sc.nextLine());
    }*/

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public URL getSource() {
        return source;
    }

    public void setSource(URL source) {
        this.source = source;
    }


    public int compareTo(News n2){
        if( this.date.isAfter(n2.getDate())){
            return 1;
        }
        else{
            return -1;
        }
    }

    public String toString(){
        return "Titre : " + this.titre + "\n" +
                "Date : " + this.date.toString() + "\n" +
                "Auteur : " + this.auteur + "\n" +
                "URL : " + this.source + "\n\n";
    }
}
