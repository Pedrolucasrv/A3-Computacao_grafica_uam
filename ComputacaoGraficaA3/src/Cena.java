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
    public float localizacaoXBarra = 0f;
    GLU glu;
    public GL2 gl;
    public GLUT glut;
    public float aspect;

    public int toning = GL2.GL_SMOOTH;
    public boolean lightOn = true;
    public float gameSpeed = 0.02f;
    public char xDirection;
    public char yDirection = 'd';
    public int vida = 5;
    public int pontuacao = 0;
    public float xTranslateBall = 0;
    public float yTranslateBall = 1f;
    public float userBarMove = 0;
    public boolean jogoPause = false;
    public int gameLevel = 0;
    public Textura texturaCassio = null;
    public Textura texturaGol = null;
    public int totalTextura = 1;
    public GL2 barra;
    public static final String Cassio = "C:/Users/SAITO/IdeaProjects/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/cassio.jpg";
    public static final String Gol = "C:/Users/SAITO/IdeaProjects/A3-Computacao_grafica_uam/ComputacaoGraficaA3/imagens/gol.png";
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

        //draw a barra do jogo

        barra.glColor3f(1,1,1);
        barra.glBegin(GL2.GL_QUADS);

        barra.glTexCoord2f(0.0f, 1.0f); barra.glVertex2f(localizacaoXBarra - 0.16f, -0.5f);
        barra.glTexCoord2f(0.0f, 0.0f); barra.glVertex2f(localizacaoXBarra - 0.16f, -0.6f);
        barra.glTexCoord2f(1.0f, 0.0f); barra.glVertex2f(localizacaoXBarra + 0.16f, -0.6f);
        barra.glTexCoord2f(1.0f, 1.0f); barra.glVertex2f(localizacaoXBarra + 0.16f, -0.5f);

        barra.glEnd();

        texturaCassio.desabilitarTextura(barra, 0);


        //draw o gol do cenário

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
        String size = "big";
        float left = -0.3f;
        float begin = 0.8f;

        drawText(left, begin -= 0.1f, size, "Bem vindo ao Pong Maroto");
        drawText(left, begin -= 0.1f, size, "O propósito desse jogo é realizar o maior número de pontuação");
        drawText(left, begin -= 0.1f, size, "com a rebatida da bola.");
        drawText(left, begin -= 0.1f, size, "-----------------------------");
        drawText(left, begin -= 0.1f, size, "# Comandos:");
        drawText(left, begin -= 0.1f, size, "- Mover bastão = < > ou A D");
        drawText(left, begin -= 0.1f, size, "- Pausar jogo = P");
        drawText(left, begin -= 0.1f, size, "- Parar o jogo e ir para tela inicial = X");
        drawText(left, begin -= 0.1f, size, "-----------------------------");
        drawText(left, begin -= 0.1f, size, "# Regras:");
        drawText(left, begin -= 0.1f, size, "- A cada rebatida da bolinha, são computados 10 pontos");
        drawText(left, begin -= 0.1f, size, "- Ao acumular 200 pontos o usuário passa para a segunda fase");
        drawText(left, begin -= 0.1f, size, "- Na segunda fase os pontos são infinitos \\o/");
        drawText(left, begin -= 0.1f, size, "-----------------------------");
        drawText(left, begin -= 0.1f, size, "PRESSIONE S PARA INICIAR O JOGO");
    }

    public void rodaLevelUm() {
        if (!jogoPause) {
            ballPhysicsEngine();
        } else {
            drawText(-0.2f, 0, "big", "JOGO PAUSADO");
        }

        drawBola();

        if (pontuacao == 200) {
            gameLevel = 2;
        }

        if (vida == 0) {
            gameLevel = 3;
        }

        drawText(0.8f, 0.9f, "big", "Score: " + pontuacao);

        for (int i = 1; i <= 5; i++) {
            if (vida >= i)
                drawVida(0.1f * i, true);
            else
                drawVida(0.1f * i, false);
        }
    }

    public void rodaLevelDois() {
        gameSpeed = 0.03f;
        if (!jogoPause) {
            ballPhysicsEngine();
        } else {
            drawText(-0.2f, 0, "big", "JOGO PAUSADO");
        }

        drawBola();
        drawObstaculo();

        if (vida == 0) {
            gameLevel = 3;
        }

        drawText(0.8f, 0.9f, "big", "Pontuação: " + pontuacao);

        for (int i = 1; i <= 5; i++) {
            if (vida >= i)
                drawVida(0.1f * i, true);
            else
                drawVida(0.1f * i, false);
        }
    }

    public void gameOver() {
        float begin = 0.8f;
        float left = -0.1f;
        drawText(left, begin -= 0.1f, "big", " -----------");
        drawText(left, begin -= 0.1f, "big", "| GAME OVER |");
        drawText(left, begin -= 0.1f, "big", " -----------");
        drawText(left, begin -= 0.1f, "big", "Pontuação final: " + pontuacao);
        drawText(left, begin -= 0.1f, "big", "Y - Menu inicial");
        drawText(left, begin -= 0.1f, "big", "K - Fechar o jogo");
    }

    public void drawText(float x, float y, String size, String phrase) {
        gl.glRasterPos2f(x, y);
        switch (size) {
            case "small":
                glut.glutBitmapString(GLUT.BITMAP_8_BY_13, phrase);
                break;
            case "big":
                glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, phrase);
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
                && isObjectInXRange(xTransBallFixed, yTransBallFixed, -0.2f, 0.2f, 0.6f)) {
            yDirection = 'u';
        } else if (yTransBallFixed == -0.7f && yDirection == 'd'
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

    public void drawObstaculo() {
        gl.glPushMatrix();
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1, 1, 1);
        gl.glVertex2f(-0.2f, 0.5f);
        gl.glVertex2f(0.2f, 0.5f);
        gl.glVertex2f(0.2f, -0.1f);
        gl.glVertex2f(-0.2f, -0.1f);
        gl.glEnd();
        gl.glPopMatrix();
    }

    public boolean isBallInRangeOfBar(float xTranslatedBallFixed) {
        float leftBarLimit = Float.valueOf(String.format(Locale.US, "%.1f", userBarMove - 0.2f));
        float rightBarLimit = Float.valueOf(String.format(Locale.US, "%.1f", userBarMove + 0.2f));

        if (leftBarLimit <= xTranslatedBallFixed && rightBarLimit >= xTranslatedBallFixed) {
            return true;
        }

        return false;
    }

    public void drawBola() {
        gl.glPushMatrix();
        gl.glTranslatef(xTranslateBall, yTranslateBall, 0);
        gl.glColor3f(1, 1, 1);

        double limit = 2 * Math.PI;
        double i;
        double cX = 0;
        double cY = 0;
        double rX = 0.1f / aspect;
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
            gl.glColor3f(1, 0.2f, 0);
        else
            gl.glColor3f(1, 1, 1);

        gl.glTranslatef(0.4f + pos, 0.8f, 0);

        glut.glutSolidTeapot(0.03f);
        gl.glPopMatrix();
    }

    public void reseta() {
        xTranslateBall = 0;
        yTranslateBall = 1f;
        yDirection = 'd';

        jogoPause = false;
        gameLevel = 0;

        userBarMove = 0;
        pontuacao = 0;
        vida = 5;
    }
       
    @Override
    public void dispose(GLAutoDrawable drawable) {}         
}
