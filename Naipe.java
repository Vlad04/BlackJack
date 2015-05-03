import java.util.Random;
import javax.swing.ImageIcon;
import java.io.*;

public class Naipe {

	public static final String[] valores={"As","2","3","4","5","6","7","8","9","10","Joker","Reina","Rey"};
	public static final String[] figuras={"Corazaones","Diamantes","Picas","Treboles"};
	public static final ImageIcon[] naipesImg=new ImageIcon[52];

	private Random  rnd = new Random();
    public String BARAJA_FILE = "baraja.txt";

    private int figura=(int)(rnd.nextDouble()*4+0);
	private int valor=(int)(rnd.nextDouble()*13+0);

	public int getValor(){
		if ( valor == 0 ){
            return 11;
        }
        else{
            return valor;
        }
	}

	public String toString(){
		return valores[valor]+" de "+figuras[figura];
	}

    public void gen_naipe_file(){

        int pos_naipe = 0;
        String path = null;

		try {

            PrintWriter writer = new PrintWriter(BARAJA_FILE, "UTF-8");

		    for (int valor = 0; valor< valores.length; valor++){
		        for (int figura = 0; figura < figuras.length;figura++){
		            pos_naipe = valor + (figura * 13);
		            path="Blackjack/Cartas/" + figuras[figura] + "/" + (valor + 1) + ".png";
		            writer.println(pos_naipe + "," + path);
		        }
		    }

		    writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

    }
	public ImageIcon getImage(){
		String path;
        int pos_naipe= 0 ;

        path="Blackjack/Cartas/" + figuras[figura] + "/" + (valor + 1) + ".png";

        pos_naipe = valor + (figura * 13);
        naipesImg[pos_naipe]= new ImageIcon(path);
        valor = getValor();
        
        //System.out.println("Randome number:" +valor);
        //System.out.println("Randmob figure:" + figura);

        return naipesImg[pos_naipe];
	}

	public static void main(String[] args) {

        Naipe prueba = new Naipe();

        File f = new File(prueba.BARAJA_FILE);
        if(f.exists()== false){
            prueba.gen_naipe_file();
        }

		System.out.println(prueba.toString());
        System.out.println(prueba.getImage());

	}
}
