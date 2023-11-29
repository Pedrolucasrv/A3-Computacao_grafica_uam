import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyBoard implements KeyListener {
    public Cena cena;

    public KeyBoard(Cena cena) {
        this.cena = cena;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_A: //Mover para esquerda
                if (cena.localizacaoXBarra > -0.8 && !cena.jogoPause) {
                    cena.localizacaoXBarra = cena.localizacaoXBarra - 0.1f;
                }
                break;

            case KeyEvent.VK_D: // Mover para direita
                if (cena.localizacaoXBarra < 0.8 && !cena.jogoPause) {
                    cena.localizacaoXBarra = cena.localizacaoXBarra + 0.1f;
                }
                break;

            case KeyEvent.VK_P: //Pausar o jogo
                cena.jogoPause = !cena.jogoPause;
                break;

            case KeyEvent.VK_C: //Começar o jogo
                if (cena.gameLevel == 0) {
                    cena.gameLevel = 1;
                }
                break;

            case KeyEvent.VK_R: // Reiniciar o jogo
                if (cena.gameLevel > 0) {
                    cena.gameLevel = 0;
                    cena.reseta();
                }
                break;
            case KeyEvent.VK_Y: // Menu principal
                if (cena.gameLevel == 3) {
                    cena.gameLevel = 0;
                    cena.reseta();
                }
                break;
            case KeyEvent.VK_L: // Sair para a área de trabalho
                if (cena.gameLevel == 3) {
                    System.exit(0);
                }
                break;

            case KeyEvent.VK_ESCAPE: // Sair para a área de trabalho
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
