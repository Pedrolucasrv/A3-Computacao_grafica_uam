import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
/**
 *
 * @author Kakugawa
 */
public class KeyBoard implements KeyListener {
    private Cena cena;

    public KeyBoard(Cena cena) {
        this.cena = cena;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            System.exit(0);

        if (e.getKeyChar() == 'a')
            System.out.println("Pressionou tecla a");

        if (e.getKeyChar() == 'p') {
            if (cena.localizacaoXBarra <= 1) {
                cena.localizacaoXBarra += 0.1f;
            }
        }
        if (e.getKeyChar() == 'u') {
            if (cena.localizacaoXBarra >= -1) {
                cena.localizacaoXBarra -= 0.1f;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
