package MathsL3Projet2;

/**
 * Point d'entrée
 *
 */
public class Run
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!\n"+args[0]+args[1]+args[2] );
        Projet2 projet = new Projet2(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));

    }
}
