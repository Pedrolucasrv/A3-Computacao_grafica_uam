import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.newt.opengl.GLWindow;

/**
 *
 * @author Kakugawa
 */
public class Cena implements GLEventListener{    
    private float xMin, xMax, yMin, yMax, zMin, zMax;
    public float localizacaoXBarra = 0f;
    GLU glu;

    @Override
    public void init(GLAutoDrawable drawable) {
        //dados iniciais da cena
        glu = new GLU();
        //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
        xMin = yMin = zMin = -1;
        xMax = yMax = zMax = 1;

    }

    @Override
    public void display(GLAutoDrawable drawable) {  
        //obtem o contexto Opengl

        GL2 fundo = drawable.getGL().getGL2();
        //define a cor da janela (R, G, G, alpha)
        fundo.glClearColor(1, 1, 1, 1);
        //limpa a janela com a cor especificada
        fundo.glClear(GL2.GL_COLOR_BUFFER_BIT);
        fundo.glLoadIdentity(); //lê a matriz identidade

        GL2 barra = drawable.getGL().getGL2();
        //define a cor da janela (R, G, G, alpha)
        barra.glClearColor(1, 1, 1, 1);
        //limpa a janela com a cor especificada
        barra.glClear(GL2.GL_COLOR_BUFFER_BIT);
        barra.glLoadIdentity(); //lê a matriz identidade

        /*
            desenho da cena
        */

        //seta um quadrado para ser o fundo
        fundo.glColor3f(0.0f,0.5f, 0.0f);
        fundo.glBegin(GL2.GL_QUADS);
        fundo.glVertex2f(1f, 1f);
        fundo.glVertex2f(1f, -1f);
        fundo.glVertex2f(-1f, -1f);
        fundo.glVertex2f(-1f, 1f);
        fundo.glEnd();

        //desenha um quadrado AZUL
        barra.glColor3f(0,0,1);
        barra.glBegin(GL2.GL_QUADS);
        barra.glVertex2f(localizacaoXBarra - 0.15f, -0.7f);
        barra.glVertex2f(localizacaoXBarra - 0.15f, -0.8f);
        barra.glVertex2f(localizacaoXBarra + 0.15f, -0.8f);
        barra.glVertex2f(localizacaoXBarra + 0.15f, -0.7f);
        barra.glEnd();

        barra.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {    
        //obtem o contexto grafico Opengl
        GL2 gl = drawable.getGL().getGL2();  
        
        //evita a divisão por zero
        if(height == 0) height = 1;
        //calcula a proporção da janela (aspect ratio) da nova janela
        float aspect = (float) width / height;
        
        //seta o viewport para abranger a janela inteira
        gl.glViewport(0, 0, width, height);
                
        //ativa a matriz de projeção
        gl.glMatrixMode(GL2.GL_PROJECTION);      
        gl.glLoadIdentity(); //lê a matriz identidade
        
        //Projeção ortogonal
        //true:   aspect >= 1 configura a altura de -1 para 1 : com largura maior
        //false:  aspect < 1 configura a largura de -1 para 1 : com altura maior
        if(width >= height)            
            gl.glOrtho(xMin * aspect, xMax * aspect, yMin, yMax, zMin, zMax);
        else        
            gl.glOrtho(xMin, xMax, yMin / aspect, yMax / aspect, zMin, zMax);
                
        //ativa a matriz de modelagem
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); //lê a matriz identidade
        System.out.println("Reshape: " + width + ", " + height);
    }    
       
    @Override
    public void dispose(GLAutoDrawable drawable) {}         
}
