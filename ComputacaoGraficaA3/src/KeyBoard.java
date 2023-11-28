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
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_A:
                if (cena.userBarMove > -0.8 && !cena.jogoPause) {
                    cena.userBarMove = cena.userBarMove - 0.1f;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (cena.userBarMove > -0.8 && !cena.jogoPause) {
                    cena.userBarMove = cena.userBarMove - 0.1f;
                }
                break;
            case KeyEvent.VK_D:
                if (cena.userBarMove < 0.8 && !cena.jogoPause) {
                    cena.userBarMove = cena.userBarMove + 0.1f;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (cena.userBarMove < 0.8 && !cena.jogoPause) {
                    cena.userBarMove = cena.userBarMove + 0.1f;
                }
                break;
            case KeyEvent.VK_P:
                cena.jogoPause = !cena.jogoPause;
                break;
            case KeyEvent.VK_S:
                if (cena.gameLevel == 0) {
                    cena.gameLevel = 1;
                }
                break;
            case KeyEvent.VK_X:
                if (cena.gameLevel > 0) {
                    cena.gameLevel = 0;
                    cena.reseta();
                }
                break;
            case KeyEvent.VK_Y:
                if (cena.gameLevel == 3) {
                    cena.gameLevel = 0;
                    cena.reseta();
                }
                break;
            case KeyEvent.VK_K:
                if (cena.gameLevel == 3) {
                    System.exit(0);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
