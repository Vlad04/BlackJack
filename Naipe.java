import java.util.Random;
import javax.swing.ImageIcon;

public class Naipe {

	public static final String[] valores={"As","2","3","4","5","6","7","8","9","10","Joker","Reina","Rey"};
	public static final String[] figuras={"Corazaones","Diamantes","Picas","Treboles"};
	public static final ImageIcon[] naipesImg=new ImageIcon[52];

	private Random  rnd = new Random();

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
		System.out.println(prueba.toString());
        System.out.println(prueba.getImage());

	}
}
