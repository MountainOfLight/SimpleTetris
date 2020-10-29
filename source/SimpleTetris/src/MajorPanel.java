import java.awt.*;
import javax.swing.*;

public class MajorPanel extends JPanel
{
    private int[][] matrix;

    public MajorPanel(int[][] matrix0)
    {
        super();

        setBackground(ColorsAndFonts.BackgroundColor);
        setForeground(ColorsAndFonts.ForegroundColor);

        matrix=matrix0;
    }

    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        graphics.setColor(getForeground());
        graphics.drawRect(19,19,202,402);

        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[i].length;j++)
            {
                switch (matrix[i][j])
                {
                    case 1:
                    {
                        graphics.setColor(ColorsAndFonts.Color1);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
                        break;
                    }
                    case 2:
                    {
                        graphics.setColor(ColorsAndFonts.Color2);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
                        break;
                    }
                    case 3:
                    {
                        graphics.setColor(ColorsAndFonts.Color3);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
                        break;
                    }
                    case 4:
                    {
                        graphics.setColor(ColorsAndFonts.Color4);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
                        break;
                    }
                    case 5:
                    {
                        graphics.setColor(ColorsAndFonts.Color5);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
                        break;
                    }
                    case 6:
                    {
                        graphics.setColor(ColorsAndFonts.Color6);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
                        break;
                    }
                    case 7:
                    {
                        graphics.setColor(ColorsAndFonts.Color7);
                        graphics.fillRect(20*(j+1)+1,20*(i+1)+1,19,19);
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

    public void setMatrix(int[][] newMatrix)
    {
        matrix=newMatrix;
    }
}