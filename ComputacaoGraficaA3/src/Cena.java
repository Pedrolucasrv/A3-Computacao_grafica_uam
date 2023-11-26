import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.newt.opengl.GLWindow;
import textura.Textura;

import javax.xml.xpath.XPath;

import static com.jogamp.opengl.GL.*;

public class Cena implements GLEventListener{    
    private float xMin, xMax, yMin, yMax, zMin, zMax;
    public float localizacaoXBarra = 0f;
    GLU glu;

    private Textura texturaCassio = null;
    private Textura texturaGol = null;
    private int totalTextura = 1;
    private GL2 barra;
    public static final String Cassio = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/cassio.jpg";
    public static final String Gol = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/gol.png";
    public int filtro = GL2.GL_LINEAR; ////GL_NEAREST ou GL_LINEAR
    public int wrap = GL2.GL_REPEAT;  //GL.GL_REPEAT ou GL.GL_CLAMP
    public int modo = GL2.GL_MODULATE; ////GL.GL_MODULATE ou GL.GL_DECAL ou GL.GL_BLEND
    @Override
    public void init(GLAutoDrawable drawable) {
        //dados iniciais da cena
        glu = new GLU();
        //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
        xMin = yMin = zMin = -1;
        xMax = yMax = zMax = 1;

        texturaCassio = new Textura(totalTextura);
        texturaGol = new Textura(totalTextura);
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

        barra = drawable.getGL().getGL2();
        barra.glClear(GL2.GL_COLOR_BUFFER_BIT);
        barra.glLoadIdentity(); //lê a matriz identidade

        GL2 gol = drawable.getGL().getGL2();
        gol.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gol.glLoadIdentity(); //lê a matriz identidade

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

        GL2 linhaGolV12 = drawable.getGL().getGL2();
        linhaGolV12.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV12.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV13 = drawable.getGL().getGL2();
        linhaGolV13.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV13.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV14 = drawable.getGL().getGL2();
        linhaGolV14.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV14.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV15 = drawable.getGL().getGL2();
        linhaGolV15.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV15.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV16 = drawable.getGL().getGL2();
        linhaGolV16.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV16.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV17 = drawable.getGL().getGL2();
        linhaGolV17.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV17.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV18 = drawable.getGL().getGL2();
        linhaGolV18.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV18.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV19 = drawable.getGL().getGL2();
        linhaGolV19.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV19.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV20 = drawable.getGL().getGL2();
        linhaGolV20.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV20.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV21 = drawable.getGL().getGL2();
        linhaGolV21.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV21.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV22 = drawable.getGL().getGL2();
        linhaGolV22.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV22.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV23 = drawable.getGL().getGL2();
        linhaGolV23.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV23.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV24 = drawable.getGL().getGL2();
        linhaGolV24.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV24.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV25 = drawable.getGL().getGL2();
        linhaGolV25.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV25.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV26 = drawable.getGL().getGL2();
        linhaGolV26.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV26.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV27 = drawable.getGL().getGL2();
        linhaGolV27.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV27.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV28 = drawable.getGL().getGL2();
        linhaGolV28.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV28.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV29 = drawable.getGL().getGL2();
        linhaGolV29.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV29.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV30 = drawable.getGL().getGL2();
        linhaGolV30.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV30.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV31 = drawable.getGL().getGL2();
        linhaGolV31.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV31.glLoadIdentity(); //lê a matriz identidade

        GL2 linhaGolV32 = drawable.getGL().getGL2();
        linhaGolV32.glClear(GL2.GL_COLOR_BUFFER_BIT);
        linhaGolV32.glLoadIdentity(); //lê a matriz identidade

        /*
            desenho da cena
        */

        texturaCassio.setAutomatica(false);
        texturaCassio.setFiltro(filtro);
        texturaCassio.setModo(modo);
        texturaCassio.setWrap(wrap);
        texturaCassio.gerarTextura(barra, Cassio, 0);

        //seta um quadrado para ser o fundo
        fundo.glColor3f(0.0f,0.5f, 0.0f);
        fundo.glBegin(GL2.GL_QUADS);

        fundo.glVertex2f(1f, 1f);
        fundo.glVertex2f(1f, -1f);
        fundo.glVertex2f(-1f, -1f);
        fundo.glVertex2f(-1f, 1f);
        fundo.glEnd();

        //desenha a barra do jogo

        barra.glColor3f(1,1,1);
        barra.glBegin(GL2.GL_QUADS);

        barra.glTexCoord2f(0.0f, 1.0f); barra.glVertex2f(localizacaoXBarra - 0.16f, -0.5f);
        barra.glTexCoord2f(0.0f, 0.0f); barra.glVertex2f(localizacaoXBarra - 0.16f, -0.6f);
        barra.glTexCoord2f(1.0f, 0.0f); barra.glVertex2f(localizacaoXBarra + 0.16f, -0.6f);
        barra.glTexCoord2f(1.0f, 1.0f); barra.glVertex2f(localizacaoXBarra + 0.16f, -0.5f);

        barra.glEnd();

        texturaCassio.desabilitarTextura(barra, 0);


        //desenha o gol do cenário

        texturaGol.setAutomatica(false);
        texturaGol.setFiltro(filtro);
        texturaGol.setModo(modo);
        texturaGol.setWrap(wrap);
        texturaGol.gerarTextura(gol, Gol, 0);

        gol.glEnable(GL_BLEND);
        gol.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        gol.glColor3f(1,1,1);
        gol.glBegin(GL2.GL_QUADS);

        gol.glTexCoord2f(1.0f, 0.0f); gol.glVertex2f(0.9f, -0.65f);
        gol.glTexCoord2f(1.0f, 1.0f); gol.glVertex2f(0.9f, -1f);
        gol.glTexCoord2f(0.0f, 1.0f); gol.glVertex2f(-0.9f, -1f);
        gol.glTexCoord2f(0.0f, 0.0f); gol.glVertex2f(-0.9f, -0.65f);

        gol.glEnd();

        texturaGol.desabilitarTextura(barra, 0);

//        traveD.glColor3f(1,1,1);
//        traveD.glBegin(GL2.GL_QUADS);
//        traveD.glVertex2f(0.9f, -0.65f);
//        traveD.glVertex2f(0.9f, -1f);
//        traveD.glVertex2f(0.85f, -1f);
//        traveD.glVertex2f(0.85f, -0.65f);
//        traveD.glEnd();
//
//        //desenha o gol do cenário
//        traveE.glColor3f(1,1,1);
//        traveE.glBegin(GL2.GL_QUADS);
//        traveE.glVertex2f(-0.9f, -0.65f);
//        traveE.glVertex2f(-0.9f, -1f);
//        traveE.glVertex2f(-0.85f, -1f);
//        traveE.glVertex2f(-0.85f, -0.65f);
//        traveE.glEnd();
//
//        //desenha o gol do cenário
//        travessao.glColor3f(1,1,1);
//        travessao.glBegin(GL2.GL_QUADS);
//        travessao.glVertex2f(0.9f, -0.65f);
//        travessao.glVertex2f(0.9f, -0.70f);
//        travessao.glVertex2f(-0.9f, -0.70f);
//        travessao.glVertex2f(-0.9f, -0.65f);
//        travessao.glEnd();


   /*     //desenha o gol do cenário
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

        //desenha o gol do cenário
        linhaGolV12.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV12.glBegin(GL2.GL_QUADS);
        linhaGolV12.glVertex2f(0.03f, -0.7f);
        linhaGolV12.glVertex2f(0.03f, -1f);
        linhaGolV12.glVertex2f(0.01f, -1f);
        linhaGolV12.glVertex2f(0.01f, -0.7f);
        linhaGolV12.glEnd();

        //desenha o gol do cenário
        linhaGolV13.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV13.glBegin(GL2.GL_QUADS);
        linhaGolV13.glVertex2f(-0.04f, -0.7f);
        linhaGolV13.glVertex2f(-0.04f, -1f);
        linhaGolV13.glVertex2f(-0.06f, -1f);
        linhaGolV13.glVertex2f(-0.06f, -0.7f);
        linhaGolV13.glEnd();

        //desenha o gol do cenário
        linhaGolV14.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV14.glBegin(GL2.GL_QUADS);
        linhaGolV14.glVertex2f(-0.11f, -0.7f);
        linhaGolV14.glVertex2f(-0.11f, -1f);
        linhaGolV14.glVertex2f(-0.13f, -1f);
        linhaGolV14.glVertex2f(-0.13f, -0.7f);
        linhaGolV14.glEnd();

        //desenha o gol do cenário
        linhaGolV15.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV15.glBegin(GL2.GL_QUADS);
        linhaGolV15.glVertex2f(-0.18f, -0.7f);
        linhaGolV15.glVertex2f(-0.18f, -1f);
        linhaGolV15.glVertex2f(-0.2f, -1f);
        linhaGolV15.glVertex2f(-0.2f, -0.7f);
        linhaGolV15.glEnd();

        //desenha o gol do cenário
        linhaGolV16.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV16.glBegin(GL2.GL_QUADS);
        linhaGolV16.glVertex2f(-0.25f, -0.7f);
        linhaGolV16.glVertex2f(-0.25f, -1f);
        linhaGolV16.glVertex2f(-0.27f, -1f);
        linhaGolV16.glVertex2f(-0.27f, -0.7f);
        linhaGolV16.glEnd();

        //desenha o gol do cenário
        linhaGolV17.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV17.glBegin(GL2.GL_QUADS);
        linhaGolV17.glVertex2f(-0.31f, -0.7f);
        linhaGolV17.glVertex2f(-0.31f, -1f);
        linhaGolV17.glVertex2f(-0.33f, -1f);
        linhaGolV17.glVertex2f(-0.33f, -0.7f);
        linhaGolV17.glEnd();

        //desenha o gol do cenário
        linhaGolV18.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV18.glBegin(GL2.GL_QUADS);
        linhaGolV18.glVertex2f(-0.38f, -0.7f);
        linhaGolV18.glVertex2f(-0.38f, -1f);
        linhaGolV18.glVertex2f(-0.40f, -1f);
        linhaGolV18.glVertex2f(-0.40f, -0.7f);
        linhaGolV18.glEnd();

        //desenha o gol do cenário
        linhaGolV19.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV19.glBegin(GL2.GL_QUADS);
        linhaGolV19.glVertex2f(-0.45f, -0.7f);
        linhaGolV19.glVertex2f(-0.45f, -1f);
        linhaGolV19.glVertex2f(-0.47f, -1f);
        linhaGolV19.glVertex2f(-0.47f, -0.7f);
        linhaGolV19.glEnd();

        //desenha o gol do cenário
        linhaGolV20.glColor3f(0.6f,0.6f,0.6f);
        linhaGolV20.glBegin(GL2.GL_QUADS);
        linhaGolV20.glVertex2f(-0.52f, -0.7f);
        linhaGolV20.glVertex2f(-0.52f, -1f);
        linhaGolV20.glVertex2f(-0.54f, -1f);
        linhaGolV20.glVertex2f(-0.54f, -0.7f);
        linhaGolV20.glEnd();*/

        barra.glFlush();

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //obtem o contexto grafico Opengl
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); //lê a matriz identidade
        gl.glOrtho(xMin, xMax, yMin, yMax, zMin, zMax);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
//
//        //evita a divisão por zero
//        if(height == 0) height = 1;
//        //calcula a proporção da janela (aspect ratio) da nova janela
//        float aspect = (float) width / height;
//
//        //seta o viewport para abranger a janela inteira
//        gl.glViewport(0, 0, width, height);
////
////        //ativa a matriz de projeção
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity(); //lê a matriz identidade
//
//        //Projeção ortogonal
//        //true:   aspect >= 1 configura a altura de -1 para 1 : com largura maior
//        //false:  aspect < 1 configura a largura de -1 para 1 : com altura maior
//        if(width >= height)            {
//            gl.glOrtho(xMin * aspect, xMax * aspect, yMin, yMax, zMin, zMax);
//        }
//        else
//            gl.glOrtho(xMin, xMax, yMin / aspect, yMax / aspect, zMin, zMax);
//
//        //ativa a matriz de modelagem
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity(); //lê a matriz identidade
//        System.out.println("Reshape: " + width + ", " + height);
    }    
       
    @Override
    public void dispose(GLAutoDrawable drawable) {}         
}
