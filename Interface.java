interface Movie
{
    public void Fight();
   public void Comedy();
}
public class Interface implements Movie
{
    public void Fight()
    {
        System.out.println("KGF");
    }
    public void Comedy()
    {
        System.out.println("Kithakithalu");
    }
    public static void main(String[] args) {
        Interface I=new Interface();
        I.Fight();
        I.Comedy();       
    }
}