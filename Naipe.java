import java.util.Random;
import java.io.BufferedReader;
import javax.swing.ImageIcon;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Naipe {

	public static final String[] valores={"As","2","3","4","5","6","7","8","9","10","Joker","Reina","Rey"};
	public static final String[] figuras={"Corazaones","Diamantes","Picas","Treboles"};
	public static final ImageIcon[] naipesImg=new ImageIcon[52];

	private Random  rnd = new Random();
    public String BARAJA_FILE = "baraja.txt";

    private int figura=(int)(rnd.nextDouble()*4+0);
	private int valor=(int)(rnd.nextDouble()*13+0);

    public Naipe(){

        File f = new File(BARAJA_FILE);
        if(f.exists()== false){
            gen_naipe_file();
        }

        read_baraja();

    }

    private void read_baraja(){

		BufferedReader br;
        String curline;
        String[] line_split;
        int pos_naipe = 0 ;
        String path;

        try {
            br = new BufferedReader(new FileReader(BARAJA_FILE));
            while ((curline = br.readLine()) != null) {
               line_split = curline.split(",");
               pos_naipe = Integer.parseInt(line_split[0]);
               path = line_split[1];
               naipesImg[pos_naipe]= new ImageIcon(path);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        int pos_naipe= 0 ;
        pos_naipe = valor + (figura * 13);
        return naipesImg[pos_naipe];
	}

	public static void main(String[] args) {

        Naipe prueba = new Naipe();
		System.out.println(prueba.toString());
        System.out.println(prueba.getImage());

	}
}
