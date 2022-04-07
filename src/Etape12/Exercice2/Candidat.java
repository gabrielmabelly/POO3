package Etape12.Exercice2;

public class Candidat
{
    String name;
    volatile int votes;

    public Candidat(String name, int votes)
    {
        this.name = name;
        this.votes = votes;
    }

    @Override
    public String toString()
    {
        return "Candidat{" +
                "name='" + name + '\'' +
                ", votes='" + votes + '\'' +
                '}';
    }
}
