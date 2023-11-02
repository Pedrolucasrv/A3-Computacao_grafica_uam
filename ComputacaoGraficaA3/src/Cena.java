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
        barra.glClear(GL2.GL_COLOR_BUFFER_BIT);
        barra.glLoadIdentity(); //lê a matriz identidade

        GL2 traveD = drawable.getGL().getGL2();
        traveD.glClear(GL2.GL_COLOR_BUFFER_BIT);
        traveD.glLoadIdentity(); //lê a matriz identidade

        GL2 travessao = drawable.getGL().getGL2();
        travessao.glClear(GL2.GL_COLOR_BUFFER_BIT);
        travessao.glLoadIdentity(); //lê a matriz identidade

        GL2 traveE = drawable.getGL().getGL2();
        traveE.glClear(GL2.GL_COLOR_BUFFER_BIT);
        traveE.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGol1 = drawable.getGL().getGL2();
        linhaGol1.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGol1.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGol2 = drawable.getGL().getGL2();
        linhaGol2.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGol2.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGol3 = drawable.getGL().getGL2();
        linhaGol3.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGol3.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGol4 = drawable.getGL().getGL2();
        linhaGol4.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGol4.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV1 = drawable.getGL().getGL2();
        linhaGolV1.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV1.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV2 = drawable.getGL().getGL2();
        linhaGolV2.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV2.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV3 = drawable.getGL().getGL2();
        linhaGolV3.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV3.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV4 = drawable.getGL().getGL2();
        linhaGolV4.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV4.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV5 = drawable.getGL().getGL2();
        linhaGolV5.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV5.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV6 = drawable.getGL().getGL2();
        linhaGolV6.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV6.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV7 = drawable.getGL().getGL2();
        linhaGolV7.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV7.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV8 = drawable.getGL().getGL2();
        linhaGolV8.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV8.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV9 = drawable.getGL().getGL2();
        linhaGolV9.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV9.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV10 = drawable.getGL().getGL2();
        linhaGolV10.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV10.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV11 = drawable.getGL().getGL2();
        linhaGolV11.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV11.glLoadIdentity(); //lê a matriz identidade

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

        //desenha a barra do jogo
        barra.glColor3f(0,0,1);
        barra.glBegin(GL2.GL_QUADS);
        barra.glVertex2f(localizacaoXBarra - 0.15f, -0.5f);
        barra.glVertex2f(localizacaoXBarra - 0.15f, -0.6f);
        barra.glVertex2f(localizacaoXBarra + 0.15f, -0.6f);
        barra.glVertex2f(localizacaoXBarra + 0.15f, -0.5f);
        barra.glEnd();

        //desenha o gol do cenário
        traveD.glColor3f(1,1,1);
        traveD.glBegin(GL2.GL_QUADS);
        traveD.glVertex2f(0.9f, -0.65f);
        traveD.glVertex2f(0.9f, -1f);
        traveD.glVertex2f(0.85f, -1f);
        traveD.glVertex2f(0.85f, -0.65f);
        traveD.glEnd();

        //desenha o gol do cenário
        traveE.glColor3f(1,1,1);
        traveE.glBegin(GL2.GL_QUADS);
        traveE.glVertex2f(-0.9f, -0.65f);
        traveE.glVertex2f(-0.9f, -1f);
        traveE.glVertex2f(-0.85f, -1f);
        traveE.glVertex2f(-0.85f, -0.65f);
        traveE.glEnd();

        //desenha o gol do cenário
        travessao.glColor3f(1,1,1);
        travessao.glBegin(GL2.GL_QUADS);
        travessao.glVertex2f(0.9f, -0.65f);
        travessao.glVertex2f(0.9f, -0.70f);
        travessao.glVertex2f(-0.9f, -0.70f);
        travessao.glVertex2f(-0.9f, -0.65f);
        travessao.glEnd();

        //desenha o gol do cenário
        linhaGol1.glColor3f(0.6f,0.6f,0.6f);
        linhaGol1.glBegin(GL2.GL_QUADS);
        linhaGol1.glVertex2f(0.85f, -0.75f);
        linhaGol1.glVertex2f(0.85f, -0.77f);
        linhaGol1.glVertex2f(-0.85f, -0.77f);
        linhaGol1.glVertex2f(-0.85f, -0.75f);
        linhaGol1.glEnd();

        //desenha o gol do cenário
        linhaGol2.glColor3f(0.6f,0.6f,0.6f);
        linhaGol2.glBegin(GL2.GL_QUADS);
        linhaGol2.glVertex2f(0.85f, -0.82f);
        linhaGol2.glVertex2f(0.85f, -0.84f);
        linhaGol2.glVertex2f(-0.85f, -0.84f);
        linhaGol2.glVertex2f(-0.85f, -0.82f);
        linhaGol2.glEnd();

        //desenha o gol do cenário
        linhaGol3.glColor3f(0.6f,0.6f,0.6f);
        linhaGol3.glBegin(GL2.GL_QUADS);
        linhaGol3.glVertex2f(0.85f, -0.89f);
        linhaGol3.glVertex2f(0.85f, -0.91f);
        linhaGol3.glVertex2f(-0.85f, -0.91f);
        linhaGol3.glVertex2f(-0.85f, -0.89f);
        linhaGol3.glEnd();

        //desenha o gol do cenário
        linhaGol4.glColor3f(0.6f,0.6f,0.6f);
        linhaGol4.glBegin(GL2.GL_QUADS);
        linhaGol4.glVertex2f(0.85f, -0.96f);
        linhaGol4.glVertex2f(0.85f, -0.98f);
        linhaGol4.glVertex2f(-0.85f, -0.98f);
        linhaGol4.glVertex2f(-0.85f, -0.96f);
        linhaGol4.glEnd();

        //desenha o gol do cenário
        linhaGolV1.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV1.glBegin(GL2.GL_QUADS);
        linhaGolV1.glVertex2f(0.80f, -0.7f);
        linhaGolV1.glVertex2f(0.80f, -1f);
        linhaGolV1.glVertex2f(0.78f, -1f);
        linhaGolV1.glVertex2f(0.78f, -0.7f);
        linhaGolV1.glEnd();

        //desenha o gol do cenário
        linhaGolV2.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV2.glBegin(GL2.GL_QUADS);
        linhaGolV2.glVertex2f(0.73f, -0.7f);
        linhaGolV2.glVertex2f(0.73f, -1f);
        linhaGolV2.glVertex2f(0.71f, -1f);
        linhaGolV2.glVertex2f(0.71f, -0.7f);
        linhaGolV2.glEnd();

        //desenha o gol do cenário
        linhaGolV3.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV3.glBegin(GL2.GL_QUADS);
        linhaGolV3.glVertex2f(0.66f, -0.7f);
        linhaGolV3.glVertex2f(0.66f, -1f);
        linhaGolV3.glVertex2f(0.64f, -1f);
        linhaGolV3.glVertex2f(0.64f, -0.7f);
        linhaGolV3.glEnd();

        //desenha o gol do cenário
        linhaGolV4.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV4.glBegin(GL2.GL_QUADS);
        linhaGolV4.glVertex2f(0.59f, -0.7f);
        linhaGolV4.glVertex2f(0.59f, -1f);
        linhaGolV4.glVertex2f(0.57f, -1f);
        linhaGolV4.glVertex2f(0.57f, -0.7f);
        linhaGolV4.glEnd();

        //desenha o gol do cenário
        linhaGolV5.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV5.glBegin(GL2.GL_QUADS);
        linhaGolV5.glVertex2f(0.52f, -0.7f);
        linhaGolV5.glVertex2f(0.52f, -1f);
        linhaGolV5.glVertex2f(0.50f, -1f);
        linhaGolV5.glVertex2f(0.50f, -0.7f);
        linhaGolV5.glEnd();

        //desenha o gol do cenário
        linhaGolV6.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV6.glBegin(GL2.GL_QUADS);
        linhaGolV6.glVertex2f(0.45f, -0.7f);
        linhaGolV6.glVertex2f(0.45f, -1f);
        linhaGolV6.glVertex2f(0.43f, -1f);
        linhaGolV6.glVertex2f(0.43f, -0.7f);
        linhaGolV6.glEnd();

        //desenha o gol do cenário
        linhaGolV7.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV7.glBegin(GL2.GL_QUADS);
        linhaGolV7.glVertex2f(0.38f, -0.7f);
        linhaGolV7.glVertex2f(0.38f, -1f);
        linhaGolV7.glVertex2f(0.36f, -1f);
        linhaGolV7.glVertex2f(0.36f, -0.7f);
        linhaGolV7.glEnd();

        //desenha o gol do cenário
        linhaGolV8.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV8.glBegin(GL2.GL_QUADS);
        linhaGolV8.glVertex2f(0.31f, -0.7f);
        linhaGolV8.glVertex2f(0.31f, -1f);
        linhaGolV8.glVertex2f(0.29f, -1f);
        linhaGolV8.glVertex2f(0.29f, -0.7f);
        linhaGolV8.glEnd();

        //desenha o gol do cenário
        linhaGolV9.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV9.glBegin(GL2.GL_QUADS);
        linhaGolV9.glVertex2f(0.24f, -0.7f);
        linhaGolV9.glVertex2f(0.24f, -1f);
        linhaGolV9.glVertex2f(0.22f, -1f);
        linhaGolV9.glVertex2f(0.22f, -0.7f);
        linhaGolV9.glEnd();

        //desenha o gol do cenário
        linhaGolV10.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV10.glBegin(GL2.GL_QUADS);
        linhaGolV10.glVertex2f(0.17f, -0.7f);
        linhaGolV10.glVertex2f(0.17f, -1f);
        linhaGolV10.glVertex2f(0.15f, -1f);
        linhaGolV10.glVertex2f(0.15f, -0.7f);
        linhaGolV10.glEnd();

        //desenha o gol do cenário
        linhaGolV11.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV11.glBegin(GL2.GL_QUADS);
        linhaGolV11.glVertex2f(0.10f, -0.7f);
        linhaGolV11.glVertex2f(0.10f, -1f);
        linhaGolV11.glVertex2f(0.08f, -1f);
        linhaGolV11.glVertex2f(0.08f, -0.7f);
        linhaGolV11.glEnd();

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
//
//        //ativa a matriz de projeção
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
