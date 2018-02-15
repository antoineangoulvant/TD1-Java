import java.util.*;
import java.util.function.Predicate;

public class BaseDeNews{
    private TreeSet<News> maBase;

    public BaseDeNews(){}

    public void initialise(){
        this.maBase = new TreeSet<News>();
    }

    public void ajouterNews(News n){
        this.maBase.add(n);
    }

    public TreeSet<News> getMaBase() {
        return maBase;
    }

    public void supprimerNews(int id){
        Predicate<News> newsPredicate = n -> n.getId() == id;
        maBase.removeIf(newsPredicate);
    }
}
