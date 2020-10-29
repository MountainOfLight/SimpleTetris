import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class WinMain extends JFrame
{
    private Data data;
    private MajorPanel majorPanel;
    private MinorPanel minorPanel;
    private boolean isLanded;
    private boolean isGameOver;
    private Timer timer;

    public WinMain()
    {
        super("Simple Tetris V1.0");

        ImageIcon icon=new ImageIcon("resource/tetris.png");
        setIconImage(icon.getImage());
        setSize(368,480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setFocusable(true);
        addKeyListener(new KeyPressedListener());

        data=new Data();

        majorPanel=new MajorPanel(data.getMatrix());
        majorPanel.setBounds(0,0,240,440);
        add(majorPanel);

        minorPanel=new MinorPanel(data.getScore(),data.getNext());
        minorPanel.setBounds(240,0,110,440);
        add(minorPanel);

        isLanded=false;
        isGameOver=false;

        timer=new Timer(500,new TimeLapsedListener());
    }

    public void start()
    {
        data.nextTurn();
        majorPanel.setMatrix(data.getMatrix());
        majorPanel.repaint();
        minorPanel.setScore(data.getScore());
        minorPanel.setNext(data.getNext());
        minorPanel.repaint();
        isLanded=false;
        isGameOver=false;
        timer.start();
    }

    public void restart()
    {
        data=new Data();
        start();
    }

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception)
        {
            //
        }
        finally
        {
            WinMain app=new WinMain();
            app.setVisible(true);
            app.start();
        }
    }

    private class TimeLapsedListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (!data.nextMove())
            {
                isLanded=true;
                if (!data.nextTurn())
                {
                    isGameOver=true;
                }
            }
            majorPanel.setMatrix(data.getMatrix());
            majorPanel.repaint();
            if (isLanded)
            {
                minorPanel.setScore(data.getScore());
                minorPanel.setNext(data.getNext());
                minorPanel.repaint();
                isLanded=false;
            }
            if (isGameOver)
            {
                timer.stop();
                JOptionPane.showMessageDialog(WinMain.this,"点击“确定”以重新开始","游戏结束",JOptionPane.INFORMATION_MESSAGE);
                restart();
            }
        }
    }

    private class KeyPressedListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent event)
        {
            switch (event.getKeyCode())
            {
                case KeyEvent.VK_UP:
                {
                    data.rotate();
                    majorPanel.setMatrix(data.getMatrix());
                    majorPanel.repaint();
                    break;
                }
                case KeyEvent.VK_DOWN:
                {
                    for (int i=0;i<2;i++)
                    {
                        if (!data.nextMove())
                        {
                            isLanded=true;
                            if (!data.nextTurn())
                            {
                                isGameOver=true;
                            }
                        }
                        majorPanel.setMatrix(data.getMatrix());
                        majorPanel.repaint();
                        if (isLanded)
                        {
                            minorPanel.setScore(data.getScore());
                            minorPanel.setNext(data.getNext());
                            minorPanel.repaint();
                            isLanded=false;
                        }
                        if (isGameOver)
                        {
                            timer.stop();
                            JOptionPane.showMessageDialog(WinMain.this,"点击“确定”以重新开始","游戏结束",JOptionPane.INFORMATION_MESSAGE);
                            restart();
                        }
                    }
                    break;
                }
                case KeyEvent.VK_LEFT:
                {
                    data.moveLeft();
                    majorPanel.setMatrix(data.getMatrix());
                    majorPanel.repaint();
                    break;
                }
                case KeyEvent.VK_RIGHT:
                {
                    data.moveRight();
                    majorPanel.setMatrix(data.getMatrix());
                    majorPanel.repaint();
                    break;
                }
                case KeyEvent.VK_P:
                {
                    if (timer.isRunning())
                    {
                        timer.stop();
                    }
                    else
                    {
                        timer.start();
                    }
                    break;
                }
                case KeyEvent.VK_R:
                {
                    boolean isPaused=true;
                    if (timer.isRunning())
                    {
                        isPaused=false;
                        timer.stop();
                    }
                    int option=JOptionPane.showConfirmDialog(WinMain.this,"是否重新开始？","游戏暂停",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if (option==JOptionPane.YES_OPTION)
                    {
                        restart();
                    }
                    else
                    {
                        if (!isPaused)
                        {
                            timer.start();
                        }
                    }
                    break;
                }
                default:
                {
                    //
                }
            }
        }
    }
}