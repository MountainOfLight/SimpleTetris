import java.awt.*;
import javax.swing.*;

public class MinorPanel extends JPanel
{
    private int score;
    private int next;

    public MinorPanel(int score0,int next0)
    {
        super();

        setBackground(ColorsAndFonts.BackgroundColor);
        setForeground(ColorsAndFonts.ForegroundColor);

        score=score0;
        next=next0;
    }

    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        graphics.setColor(getForeground());
        graphics.setFont(ColorsAndFonts.FontSmall);
        graphics.drawString("SCORE",0,78);
        graphics.setFont(ColorsAndFonts.FontBig);
        String str=Integer.toString(score);
        FontMetrics fm=graphics.getFontMetrics();
        graphics.drawString(str,110/2-fm.stringWidth(str)/2,121);

        graphics.setColor(getForeground());
        graphics.setFont(ColorsAndFonts.FontSmall);
        graphics.drawString("NEXT",0,208);
        switch (next)
        {
            case 1:
            {
                int topLeftX=110/2-3*20/2+1;
                int topLeftY=240-2*20/2+1;
                graphics.setColor(ColorsAndFonts.Color1);
                graphics.fillRect(topLeftX,topLeftY,19,19);
                graphics.fillRect(topLeftX,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+20,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+40,topLeftY+20,19,19);
                break;
            }
            case 2:
            {
                int topLeftX=110/2-3*20/2+1;
                int topLeftY=240-2*20/2+1;
                graphics.setColor(ColorsAndFonts.Color2);
                graphics.fillRect(topLeftX+40,topLeftY,19,19);
                graphics.fillRect(topLeftX,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+20,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+40,topLeftY+20,19,19);
                break;
            }
            case 3:
            {
                int topLeftX=110/2-3*20/2+1;
                int topLeftY=240-2*20/2+1;
                graphics.setColor(ColorsAndFonts.Color3);
                graphics.fillRect(topLeftX,topLeftY,19,19);
                graphics.fillRect(topLeftX+20,topLeftY,19,19);
                graphics.fillRect(topLeftX+20,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+40,topLeftY+20,19,19);
                break;
            }
            case 4:
            {
                int topLeftX=110/2-3*20/2+1;
                int topLeftY=240-2*20/2+1;
                graphics.setColor(ColorsAndFonts.Color4);
                graphics.fillRect(topLeftX+20,topLeftY,19,19);
                graphics.fillRect(topLeftX+40,topLeftY,19,19);
                graphics.fillRect(topLeftX,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+20,topLeftY+20,19,19);
                break;
            }
            case 5:
            {
                int topLeftX=110/2-4*20/2+1;
                int topLeftY=240-1*20/2+1;
                graphics.setColor(ColorsAndFonts.Color5);
                graphics.fillRect(topLeftX,topLeftY,19,19);
                graphics.fillRect(topLeftX+20,topLeftY,19,19);
                graphics.fillRect(topLeftX+40,topLeftY,19,19);
                graphics.fillRect(topLeftX+60,topLeftY,19,19);
                break;
            }
            case 6:
            {
                int topLeftX=110/2-4*20/2+1;
                int topLeftY=240-2*20/2+1;
                graphics.setColor(ColorsAndFonts.Color6);
                graphics.fillRect(topLeftX+20,topLeftY,19,19);
                graphics.fillRect(topLeftX+40,topLeftY,19,19);
                graphics.fillRect(topLeftX+20,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+40,topLeftY+20,19,19);
                break;
            }
            case 7:
            {
                int topLeftX=110/2-3*20/2+1;
                int topLeftY=240-2*20/2+1;
                graphics.setColor(ColorsAndFonts.Color7);
                graphics.fillRect(topLeftX+20,topLeftY,19,19);
                graphics.fillRect(topLeftX,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+20,topLeftY+20,19,19);
                graphics.fillRect(topLeftX+40,topLeftY+20,19,19);
                break;
            }
            default:
            {
                //
            }
        }

        graphics.setColor(getForeground());
        graphics.setFont(ColorsAndFonts.FontSmall);
        graphics.drawString("P-PAUSE",0,348);
        graphics.drawString("R-RESTART",0,378);
    }

    public void setScore(int value)
    {
        score=value;
    }

    public void setNext(int shape)
    {
        next=shape;
    }
}