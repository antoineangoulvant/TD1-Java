import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.net.URL;
import java.util.Iterator;

public class MesNews{
    private static Scanner sc;
    private static BaseDeNews bdNews;

    public static void main(String[] args){
        afficher_menu();
    }

    private static void afficher_menu(){
        int choix;
        sc = new Scanner(System.in);

        do {
            System.out.print("\n#### Veuillez faire un choix ####\n\n" +
                    "1 - Creer\n" +
                    "2 - Ouvrir\n" +
                    "3 - Sauvegarder\n" +
                    "4 - Inserer\n" +
                    "5 - Supprimer\n" +
                    "6 - Afficher\n" +
                    "7 - Rechercher\n" +
                    "8 - Quitter\n\n" +
                    "Votre choix : "
            );
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    creer();
                    break;
                case 2:
                    ouvrir();
                    break;
                case 3:
                    sauvegarder();
                    break;
                case 4:
                    try {
                        inserer();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    supprimer();
                    break;
                case 6:
                    afficher();
                    break;
                case 7:
                    rechercher();
                    break;
                case 8:
                    System.exit(0);
                default:
                    ;
                    System.out.print("Erreur de saisie, veuillez reessayer");
            }
        }while(choix != 8);
    }

    private static void creer(){
        bdNews = new BaseDeNews();
        bdNews.initialise();
        System.out.println("Base initialise");
    }

    private static void ouvrir(){

    }

    private static void sauvegarder(){

    }

    private static void inserer() throws MalformedURLException {
        if(bdNews != null) {

            LocalDate date = LocalDate.now();
            sc = new Scanner(System.in);

            System.out.print("Veuillez saisir les informations suivantes : \n\nTitre : ");
            String titre = sc.nextLine();

            System.out.print("Auteur : ");
            String auteur = sc.nextLine();

            System.out.print("URL : ");
            URL source = new URL(sc.nextLine());

            News n = new News(titre,date,auteur,source);

            bdNews.ajouterNews(n);
        }else System.out.print("Attention aucune base initialisee\n");
    }

    private static void supprimer(){
        if(bdNews != null) {
            if (!bdNews.getMaBase().isEmpty()) {
                afficher();
                sc = new Scanner(System.in);
                System.out.print("Quelle news voulez-vous supprimer ? ");
                int id = sc.nextInt();
                bdNews.supprimerNews(id);
                System.out.println("News supprimee\n");
            } else System.out.println("Aucune news enregistree");
        }else System.out.print("Attention aucune base initialisee\n");
    }

    private static void afficher(){
        //for(News n : bdNews.getMaBase()) n.afficher();1

        if(bdNews != null) {
            if (bdNews.getMaBase().isEmpty()) System.out.println("Aucune news enregistree");
            else {
                Iterator<News> itr = bdNews.getMaBase().iterator();
                while (itr.hasNext()) {
                    itr.next().afficher();
                }
            }
        }else System.out.print("Attention aucune base initialisee\n");
    }

    private static void rechercher() {

    }
}
