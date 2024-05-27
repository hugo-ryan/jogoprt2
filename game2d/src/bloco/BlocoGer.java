package bloco;

import main.JogoPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BlocoGer {

    JogoPanel gp;
    Bloco[] bloco;

    int mapBlocoNum[][];

    public BlocoGer(JogoPanel gp) {
        this.gp = gp;

        bloco = new Bloco[10];
        mapBlocoNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getBlocoImage();
        loadMap();

    }
    public void getBlocoImage() {
        try {
            bloco[0] = new Bloco();
            bloco[0].image = ImageIO.read(getClass().getResourceAsStream("/blocos/grama.png"));
            bloco[1] = new Bloco();
            bloco[1].image = ImageIO.read(getClass().getResourceAsStream("/blocos/parede.png"));
            bloco[2] = new Bloco();
            bloco[2].image = ImageIO.read(getClass().getResourceAsStream("/blocos/agua.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap() {
        try{
            InputStream is = getClass().getResourceAsStream("/mapas/mapa001.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while (col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapBlocoNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int blocoNum = mapBlocoNum[col][row];

            g2.drawImage(bloco[blocoNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }

    }
}
