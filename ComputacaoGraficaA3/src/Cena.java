import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import textura.Textura;

import java.util.Locale;

import static com.jogamp.opengl.GL.*;

public class Cena implements GLEventListener{    
    public float xMin, xMax, yMin, yMax, zMin, zMax;
    GLU glu;
    public GL2 gl;
    public GLUT glut;
    public int toning = GL2.GL_SMOOTH;
    public boolean lightOn = true;
    public float gameSpeed = 0.02f;
    public char xDirection;
    public char yDirection = 'd';
    public int vida = 5;
    public int pontuacao = 0;
    public float xTranslateBall = 0;
    public float yTranslateBall = 1f;
    public float localizacaoXBarra = 0f;
    public boolean jogoPause = false;
    public int gameLevel = 0;
    public Textura texturaCassio = null;
    public Textura texturaGol = null;
    public Textura texturaCorinthians = null;
    public Textura texturaEndrick = null;
    public Textura texturaPalmeiras = null;
    public int totalTextura = 1;
    public GL2 barra;
    public GL2 corinthians;
    public static final String Cassio = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/cassio.jpg";
    public static final String Gol = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/gol.png";
    public static final String Corinthians = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/corinthians.png";
    public static final String Endrick = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/endrick.jpg";
    public static final String Palmeiras = "E:/Materias uam/A3ComputacaoGrafica/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/palmeiras.png";
    public int filtro = GL2.GL_LINEAR; ////GL_NEAREST ou GL_LINEAR
    public int wrap = GL2.GL_REPEAT;  //GL.GL_REPEAT ou GL.GL_CLAMP
    public int modo = GL2.GL_MODULATE; ////GL.GL_MODULATE ou GL.GL_DECAL ou GL.GL_BLEND
    @Override
    public void init(GLAutoDrawable drawable) {
        randomRunBall();
        //dados iniciais da cena
        glu = new GLU();
        //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
        xMin = yMin = zMin = -1;
        xMax = yMax = zMax = 1;

        texturaCassio = new Textura(totalTextura);
        texturaGol = new Textura(totalTextura);
        texturaCorinthians = new Textura(totalTextura);
        texturaEndrick = new Textura(totalTextura);
        texturaPalmeiras = new Textura(totalTextura);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        glut = new GLUT();

        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
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

        corinthians = drawable.getGL().getGL2();
        corinthians.glClear(GL2.GL_COLOR_BUFFER_BIT);
        corinthians.glLoadIdentity(); //lê a matriz identidade

        GL2 gol = drawable.getGL().getGL2();
        gol.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gol.glLoadIdentity(); //lê a matriz identidade

        GL2 palmeiras = drawable.getGL().getGL2();
        gol.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gol.glLoadIdentity(); //lê a matriz identidade


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


        texturaCorinthians.setAutomatica(false);
        texturaCorinthians.setFiltro(filtro);
        texturaCorinthians.setModo(modo);
        texturaCorinthians.setWrap(wrap);
        texturaCorinthians.gerarTextura(corinthians, Corinthians, 0);

        corinthians.glColor3f(1,1,1);
        corinthians.glBegin(GL2.GL_QUADS);

        corinthians.glTexCoord2f(0.0f, 1.0f); corinthians.glVertex2f( 0.9f, 0.2f);
        corinthians.glTexCoord2f(0.0f, 0.0f); corinthians.glVertex2f(0.9f, -0.1f);
        corinthians.glTexCoord2f(1.0f, 0.0f); corinthians.glVertex2f(0.6f, -0.1f);
        corinthians.glTexCoord2f(1.0f, 1.0f); corinthians.glVertex2f( 0.6f, 0.2f);

        corinthians.glEnd();

        texturaCorinthians.desabilitarTextura(barra, 0);

        texturaPalmeiras.setAutomatica(false);
        texturaPalmeiras.setFiltro(filtro);
        texturaPalmeiras.setModo(modo);
        texturaPalmeiras.setWrap(wrap);
        texturaPalmeiras.gerarTextura(palmeiras, Palmeiras, 0);

        palmeiras.glColor3f(1,1,1);
        palmeiras.glBegin(GL2.GL_QUADS);

        palmeiras.glTexCoord2f(0.0f, 1.0f); palmeiras.glVertex2f( -0.9f, 0.2f);
        palmeiras.glTexCoord2f(0.0f, 0.0f); palmeiras.glVertex2f(-0.9f, -0.1f);
        palmeiras.glTexCoord2f(1.0f, 0.0f); palmeiras.glVertex2f(-0.6f, -0.1f);
        palmeiras.glTexCoord2f(1.0f, 1.0f); palmeiras.glVertex2f( -0.6f, 0.2f);

        palmeiras.glEnd();

        texturaPalmeiras.desabilitarTextura(palmeiras, 0);


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

        barra.glFlush();

        switch (gameLevel) {
            case 0:
                rodaMenu();
                break;
            case 1:
                rodaLevelUm();
                break;
            case 2:
                rodaLevelDois();
                break;
            case 3:
                gameOver();
                break;
        }
        if (lightOn) {
            lithingScheme();
            turnLightOn();
        }
        if (!lightOn) {
            turnLightOff();
        }

        gl.glFlush();
    }

    public void lithingScheme(){
        float[] ambientLight = { 0.7f, 0.7f, 0.7f, 1f };
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);

        float difuseLight[] = {0.8f, 0.8f, 0.8f, 1.0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, difuseLight, 0);

        float lightPosition[] = {-50.0f, 0.0f, 100.0f, 1.0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightPosition, 0);
    }

    public void turnLightOn() {
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glShadeModel(toning);
    }

    public void turnLightOff() {
        gl.glDisable(GL2.GL_LIGHT0);
        gl.glDisable(GL2.GL_LIGHTING);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //obtem o contexto grafico Opengl
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); //lê a matriz identidade
        gl.glOrtho(xMin, xMax, yMin, yMax, zMin, zMax);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    public void rodaMenu() {
        String size = "helv_18";
        float left = -0.3f;
        float begin = 0.9f;

        drawText(left, begin -= 0.1f, size, "PONG DO CÁSSIO");
        drawText(left, begin -= 0.1f, size, "-----------------------------");
        drawText(left, begin -= 0.1f, size, "# Comandos:");
        drawText(left, begin -= 0.1f, size, "- Mover o Cássio = A (Esquerda) - D (Direita)");
        drawText(left, begin -= 0.1f, size, "- Pausar jogo = P");
        drawText(left, begin -= 0.1f, size, "- Reiniciar o jogo = R");
        drawText(left, begin -= 0.1f, size, "- Sair para a área de trabalho = ESC");
        drawText(left, begin -= 0.1f, size, "-----------------------------");
        drawText(left, begin -= 0.1f, size, "# Como que o jogo funciona?:");
        drawText(left, begin -= 0.1f, size, "- Você tem apenas 5 vidas! A cada gol sofrido, você perde uma vida. NÃO É POSSÍVEL RECUPERÁ-LAS!");
        drawText(left, begin -= 0.1f, size, "- A cada defesa do Cássio, são computados 10 pontos. Ao acumular 200 pontos você passa para a segunda fase.");
        drawText(left, begin -= 0.1f, size, "- Na segunda fase os pontos são infinitos!");
        drawText(left, begin -= 0.1f, size, "-----------------------------");
        drawText(left, begin -= 0.1f, size, "PRESSIONE C PARA INICIAR O JOGO");
    }

    public void rodaLevelUm() {
        if (!jogoPause) {
            ballPhysicsEngine();
        } else {
            drawText(-0.1f, 0, "helv_18", "JOGO PAUSADO");
        }

        drawBola();

        if (pontuacao == 200) {
            gameLevel = 2;
        }

        if (vida == 0) {
            gameLevel = 3;
        }

        drawText(-0.95f, 0.9f, "helv_18", "Pontuação: " + pontuacao);

        for (int i = 1; i <= 5; i++) {
            if (vida >= i)
                drawVida(0.1f * i, true);
            else
                drawVida(0.1f * i, false);
        }
    }

    public void rodaLevelDois() {
        gameSpeed = 0.05f;
        if (!jogoPause) {
            ballPhysicsEngine();
        } else {
            drawText(-0.2f, 0, "helv_18", "JOGO PAUSADO");
        }

        drawBola();
        drawObstaculo1();

        if (vida == 0) {
            gameLevel = 3;
        }

        drawText(-0.95f, 0.9f, "helv_18", "Pontuação: " + pontuacao);

        for (int i = 1; i <= 5; i++) {
            if (vida >= i)
                drawVida(0.1f * i, true);
            else
                drawVida(0.1f * i, false);
        }
    }

    public void gameOver() {
        String size = "helv_18";
        float begin = 0.8f;
        float left = -0.1f;
        drawText(left, begin -= 0.1f, size, " -----------");
        drawText(left, begin -= 0.1f, size, "| FIM DO JOGO |");
        drawText(left, begin -= 0.1f, size, " -----------");
        drawText(left, begin -= 0.1f, size, "Pontuação final: " + pontuacao);
        drawText(left, begin -= 0.1f, size, "Y - Menu inicial");
        drawText(left, begin -= 0.1f, size, "L | ESC - Sair para a área de trabalho");
    }

    public void drawText(float x, float y, String size, String phrase) {
        gl.glRasterPos2f(x, y);
        if (size.equals("helv_18")) {
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, phrase);
        }
    }

    public boolean isObjectInYRange(float xObj, float yObj, float bLimit, float tLimit, float xPoint) {
        if (tLimit >= yObj && bLimit <= yObj && xObj == xPoint) {
            return true;
        }

        return false;
    }

    public boolean isObjectInXRange(float xObj, float heightObj, float lLimit, float rLimit, float tLimit) {
        if (lLimit <= xObj && rLimit >= xObj && heightObj == tLimit) {
            return true;
        }

        return false;
    }

    public void randomRunBall() {
        double xRandom = -0.8f + Math.random() * 1.6f;
        if (xRandom > 0) {
            xDirection = 'r';
        } else {
            xDirection = 'l';
        }
        xTranslateBall = Float.valueOf(String.format(Locale.US, "%.2f", xRandom));
    }

    public void ballPhysicsEngine() {
        float xTransBallFixed = Float.valueOf(String.format(Locale.US, "%.1f", xTranslateBall));
        float yTransBallFixed = Float.valueOf(String.format(Locale.US, "%.1f", yTranslateBall));

        if (gameLevel == 2 && xDirection == 'l'
                && isObjectInYRange(xTransBallFixed, yTransBallFixed, -0.1f, 0.5f, 0.2f)) {
            xDirection = 'r';
        }
        if (gameLevel == 2 && xDirection == 'r'
                && isObjectInYRange(xTransBallFixed, yTransBallFixed, -0.1f, 0.5f, -0.2f)) {
            xDirection = 'l';
        } else if (xTransBallFixed > -1f && xDirection == 'l') {
            xTranslateBall -= gameSpeed/2;
        } else if (xTransBallFixed == -1f && xDirection == 'l') {
            xDirection = 'r';
        } else if (xTransBallFixed < 1f && xDirection == 'r') {
            xTranslateBall += gameSpeed/2;
        } else if (xTransBallFixed == 1f && xDirection == 'r') {
            xDirection = 'l';
        }

        if (gameLevel == 2 && yDirection == 'u'
                && isObjectInXRange(xTransBallFixed, yTransBallFixed, -0.2f, 0.2f, -0.2f)) {
            yDirection = 'd';
        } else if (gameLevel == 2 && yDirection == 'd'
                && isObjectInXRange(xTransBallFixed, yTransBallFixed, -0.2f, 0.2f, 0.4f)) {
            yDirection = 'u';
        } else if (yTransBallFixed == -0.5f && yDirection == 'd'
                && isBallInRangeOfBar(xTransBallFixed)) {
            yDirection = 'u';
            lightOn = false;
            toning = toning == GL2.GL_SMOOTH ? GL2.GL_FLAT : GL2.GL_SMOOTH;
            pontuacao += 10;
        } else if (yTransBallFixed < 0.9f && yDirection == 'u') {
            yTranslateBall += gameSpeed;
        } else if (yTransBallFixed == 0.9f && yDirection == 'u') {
            yDirection = 'd';
        } else if (yTransBallFixed < -1f) {
            yTranslateBall = 1f;
            xTranslateBall = 0;
            vida--;
            randomRunBall();
        } else {
            yTranslateBall -= gameSpeed;
            lightOn = true;
            toning = toning == GL2.GL_SMOOTH ? GL2.GL_FLAT : GL2.GL_SMOOTH;
        }
    }

    public void drawObstaculo1() {

        texturaEndrick.setAutomatica(false);
        texturaEndrick.setFiltro(filtro);
        texturaEndrick.setModo(modo);
        texturaEndrick.setWrap(wrap);
        texturaEndrick.gerarTextura(barra, Endrick, 0);

        gl.glPushMatrix();
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1, 1, 1);
        gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex2f(0.2f, 0.35f);
        gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex2f(0.2f, -0.1f);
        gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex2f(-0.2f, -0.1f);
        gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex2f(-0.2f, 0.35f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glEnd();

        texturaEndrick.desabilitarTextura(barra, 0);


    }

    public boolean isBallInRangeOfBar(float xTranslatedBallFixed) {
        float leftBarLimit = Float.valueOf(String.format(Locale.US, "%.1f", localizacaoXBarra - 0.2f));
        float rightBarLimit = Float.valueOf(String.format(Locale.US, "%.1f", localizacaoXBarra + 0.2f));

        if (leftBarLimit <= xTranslatedBallFixed && rightBarLimit >= xTranslatedBallFixed) {
            return true;
        }

        return false;
    }

    public void drawBola() {
        gl.glPushMatrix();
        gl.glTranslatef(xTranslateBall, yTranslateBall, 1);
        gl.glColor3f(1, 1, 1);

        double limit = 2 * Math.PI;
        double i;
        double cX = 0;
        double cY = 0;
        double rX = 0.1f / 2;
        double rY = 0.1f;

        gl.glBegin(GL2.GL_POLYGON);
        for (i = 0; i < limit; i += 0.01) {
            gl.glVertex2d(cX + rX * Math.cos(i), cY + rY * Math.sin(i));
        }
        gl.glEnd();

        gl.glPopMatrix();
    }

    public void drawVida(float pos, boolean filled) {
        gl.glPushMatrix();
        if (filled)
            gl.glColor3f(1, 0.5f, 0);
        else
            gl.glColor3f(0, 0.5f, 0);

        gl.glTranslatef(0.425f + pos, 0.9f, 0);

        glut.glutSolidCone(0.05, 0.1, 3, 3);
        gl.glPopMatrix();
    }

    public void reseta() {
        xTranslateBall = 0;
        yTranslateBall = 1f;
        yDirection = 'd';

        jogoPause = false;
        gameLevel = 0;

        localizacaoXBarra = 0;
        pontuacao = 0;
        vida = 5;
    }
       
    @Override
    public void dispose(GLAutoDrawable drawable) {}         
}
