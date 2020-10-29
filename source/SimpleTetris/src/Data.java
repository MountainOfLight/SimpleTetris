import java.util.*;

public class Data
{
    private int current;
    private int direction;
    private int[][] index;
    private int[][] matrix;
    private int score;
    private Random random;
    private int[] nexts;
    private int next;

    public Data()
    {
        current=0;
        direction=0;
        index=new int[20][10];
        for (int i=0;i<index.length;i++)
        {
            for (int j=0;j<index[i].length;j++)
            {
                index[i][j]=0;
            }
        }
        matrix=new int[20][10];
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[i].length;j++)
            {
                matrix[i][j]=0;
            }
        }
        score=0;
        random=new Random();
        nexts=new int[3];
        int shape;
        boolean isDifferent;
        for (int i=0;i<nexts.length;i++)
        {
            do
            {
                shape=random.nextInt(7)+1;
                isDifferent=true;
                for (int j=0;j<i;j++)
                {
                    if (shape==nexts[j])
                    {
                        isDifferent=false;
                    }
                }
            } while (!isDifferent);
            nexts[i]=shape;
        }
        next=nexts[0];
    }

    public int[][] getMatrix()
    {
        int[][] tempMatrix=new int[20][10];
        for (int i=0;i<tempMatrix.length;i++)
        {
            for (int j=0;j<tempMatrix[i].length;j++)
            {
                tempMatrix[i][j]=matrix[i][j];
            }
        }
        return tempMatrix;
    }

    public int getScore()
    {
        return score;
    }

    public int getNext()
    {
        return next;
    }

    public boolean nextMove()
    {
        for (int i=index.length-1;i>=0;i--)
        {
            for (int j=0;j<index[i].length;j++)
            {
                if (index[i][j]==2&&(i==index.length-1||(i!=index.length-1&&index[i+1][j]==1)))
                {
                    boolean isFull;
                    for (int m=index.length-1;m>=0;m--)
                    {
                        isFull=true;
                        for (int n=0;n<index[m].length;n++)
                        {
                            if (index[m][n]==0)
                            {
                                isFull=false;
                            }
                        }
                        if (isFull)
                        {
                            if (m==0)
                            {
                                for (int n=0;n<index[m].length;n++)
                                {
                                    index[m][n]=0;
                                    matrix[m][n]=0;
                                }
                            }
                            else
                            {
                                for (int x=m-1;x>=0;x--)
                                {
                                    for (int y=0;y<index[x].length;y++)
                                    {
                                        index[x+1][y]=index[x][y];
                                        index[x][y]=0;
                                        matrix[x+1][y]=matrix[x][y];
                                        matrix[x][y]=0;
                                    }
                                }
                                m++;
                            }
                            score+=10;
                        }
                    }
                    for (int m=0;m<index.length;m++)
                    {
                        for (int n=0;n<index[m].length;n++)
                        {
                            if (index[m][n]==2)
                            {
                                index[m][n]=1;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        for (int i=index.length-1;i>=0;i--)
        {
            for (int j=0;j<index[i].length;j++)
            {
                if (index[i][j]==2)
                {
                    index[i+1][j]=index[i][j];
                    index[i][j]=0;
                    matrix[i+1][j]=matrix[i][j];
                    matrix[i][j]=0;
                }
            }
        }
        return true;
    }

    public boolean nextTurn()
    {
        current=next;
        direction=1;
        switch (current)
        {
            case 1:
            {
                index[0][3]+=2;
                index[1][3]+=2;
                index[1][4]+=2;
                index[1][5]+=2;
                matrix[0][3]=1;
                matrix[1][3]=1;
                matrix[1][4]=1;
                matrix[1][5]=1;
                break;
            }
            case 2:
            {
                index[0][5]+=2;
                index[1][3]+=2;
                index[1][4]+=2;
                index[1][5]+=2;
                matrix[0][5]=2;
                matrix[1][3]=2;
                matrix[1][4]=2;
                matrix[1][5]=2;
                break;
            }
            case 3:
            {
                index[0][3]+=2;
                index[0][4]+=2;
                index[1][4]+=2;
                index[1][5]+=2;
                matrix[0][3]=3;
                matrix[0][4]=3;
                matrix[1][4]=3;
                matrix[1][5]=3;
                break;
            }
            case 4:
            {
                index[0][4]+=2;
                index[0][5]+=2;
                index[1][3]+=2;
                index[1][4]+=2;
                matrix[0][4]=4;
                matrix[0][5]=4;
                matrix[1][3]=4;
                matrix[1][4]=4;
                break;
            }
            case 5:
            {
                index[0][3]+=2;
                index[0][4]+=2;
                index[0][5]+=2;
                index[0][6]+=2;
                matrix[0][3]=5;
                matrix[0][4]=5;
                matrix[0][5]=5;
                matrix[0][6]=5;
                break;
            }
            case 6:
            {
                index[0][4]+=2;
                index[0][5]+=2;
                index[1][4]+=2;
                index[1][5]+=2;
                matrix[0][4]=6;
                matrix[0][5]=6;
                matrix[1][4]=6;
                matrix[1][5]=6;
                break;
            }
            case 7:
            {
                index[0][4]+=2;
                index[1][3]+=2;
                index[1][4]+=2;
                index[1][5]+=2;
                matrix[0][4]=7;
                matrix[1][3]=7;
                matrix[1][4]=7;
                matrix[1][5]=7;
                break;
            }
            default:
            {
                //
            }
        }
        int shape;
        boolean isDifferent;
        do
        {
            shape=random.nextInt(7)+1;
            isDifferent=true;
            for (int i=0;i<nexts.length;i++)
            {
                if (shape==nexts[i])
                {
                    isDifferent=false;
                }
            }
        } while (!isDifferent);
        for (int i=0;i<nexts.length-1;i++)
        {
            nexts[i]=nexts[i+1];
        }
        nexts[nexts.length-1]=shape;
        next=nexts[0];
        for (int i=0;i<index.length;i++)
        {
            for (int j=0;j<index[i].length;j++)
            {
                if (index[i][j]==3)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotate()
    {
        int i=0,j=0,topLeftI=0,topLeftJ=0;
        outer:
        for (i=0;i<index.length;i++)
        {
            inner:
            for (j=0;j<index[i].length;j++)
            {
                if (index[i][j]==2)
                {
                    break outer;
                }
            }
        }
        if (i==index.length&&j==index[index.length-1].length)
        {
            return;
        }
        try
        {
            switch (current)
            {
                case 1:
                {
                    switch (direction)
                    {
                        case 1:
                        {
                            topLeftI=i;
                            topLeftJ=j;
                            if (index[topLeftI][topLeftJ+2]!=1&&index[topLeftI][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ+2]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                matrix[topLeftI][topLeftJ+2]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 2:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+2][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                matrix[topLeftI+2][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                            }
                            break;
                        }
                        case 3:
                        {
                            topLeftI=i-1;
                            topLeftJ=j;
                            if (index[topLeftI+2][topLeftJ]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                matrix[topLeftI+2][topLeftJ]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 4:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI][topLeftJ]!=1&&index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                matrix[topLeftI][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                            }
                            break;
                        }
                        default:
                        {
                            //
                        }
                    }
                    break;
                }
                case 2:
                {
                    switch (direction)
                    {
                        case 1:
                        {
                            topLeftI=i;
                            topLeftJ=j-2;
                            if (index[topLeftI+2][topLeftJ+2]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ+2]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                matrix[topLeftI+2][topLeftJ+2]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 2:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+2][topLeftJ]!=1&&index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ+2]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+2]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                matrix[topLeftI+2][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                            }
                            break;
                        }
                        case 3:
                        {
                            topLeftI=i-1;
                            topLeftJ=j;
                            if (index[topLeftI][topLeftJ]!=1&&index[topLeftI][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+2][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                matrix[topLeftI][topLeftJ]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 4:
                        {
                            topLeftI=i;
                            topLeftJ=j;
                            if (index[topLeftI][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                matrix[topLeftI][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                            }
                            break;
                        }
                        default:
                        {
                            //
                        }
                    }
                    break;
                }
                case 3:
                {
                    switch (direction)
                    {
                        case 1:
                        {
                            topLeftI=i;
                            topLeftJ=j;
                            if (index[topLeftI][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                matrix[topLeftI][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 2:
                        {
                            topLeftI=i;
                            topLeftJ=j-2;
                            if (index[topLeftI+2][topLeftJ+2]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+2]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                matrix[topLeftI+2][topLeftJ+2]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                            }
                            break;
                        }
                        case 3:
                        {
                            topLeftI=i-1;
                            topLeftJ=j;
                            if (index[topLeftI+2][topLeftJ]!=1&&index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ+2]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+2]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                matrix[topLeftI+2][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 4:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI][topLeftJ]!=1&&index[topLeftI][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                matrix[topLeftI][topLeftJ]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                            }
                            break;
                        }
                        default:
                        {
                            //
                        }
                    }
                    break;
                }
                case 4:
                {
                    switch (direction)
                    {
                        case 1:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+2][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                matrix[topLeftI+2][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 2:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+2][topLeftJ]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                matrix[topLeftI+2][topLeftJ]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                            }
                            break;
                        }
                        case 3:
                        {
                            topLeftI=i-1;
                            topLeftJ=j-1;
                            if (index[topLeftI][topLeftJ]!=1&&index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+2][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                matrix[topLeftI][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 4:
                        {
                            topLeftI=i;
                            topLeftJ=j;
                            if (index[topLeftI][topLeftJ+2]!=1&&index[topLeftI][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+2]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                matrix[topLeftI][topLeftJ+2]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                            }
                            break;
                        }
                        default:
                        {
                            //
                        }
                    }
                    break;
                }
                case 5:
                {
                    switch (direction)
                    {
                        case 1:
                        {
                            topLeftI=i-1;
                            topLeftJ=j;
                            if (index[topLeftI][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+2][topLeftJ+2]!=1&&index[topLeftI+3][topLeftJ+2]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+3]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+3]=0;
                                index[topLeftI][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+2][topLeftJ+2]=2;
                                index[topLeftI+3][topLeftJ+2]=2;
                                matrix[topLeftI][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+2][topLeftJ+2]=current;
                                matrix[topLeftI+3][topLeftJ+2]=current;
                            }
                            break;
                        }
                        case 2:
                        {
                            topLeftI=i;
                            topLeftJ=j-2;
                            if (index[topLeftI+2][topLeftJ+3]!=1&&index[topLeftI+2][topLeftJ+2]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+2][topLeftJ+2]=0;
                                index[topLeftI+3][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+2][topLeftJ+2]=0;
                                matrix[topLeftI+3][topLeftJ+2]=0;
                                index[topLeftI+2][topLeftJ+3]=2;
                                index[topLeftI+2][topLeftJ+2]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ]=2;
                                matrix[topLeftI+2][topLeftJ+3]=current;
                                matrix[topLeftI+2][topLeftJ+2]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ]=current;
                            }
                            break;
                        }
                        case 3:
                        {
                            topLeftI=i-2;
                            topLeftJ=j;
                            if (index[topLeftI+3][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ+3]=0;
                                index[topLeftI+2][topLeftJ+2]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+3]=0;
                                matrix[topLeftI+2][topLeftJ+2]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ]=0;
                                index[topLeftI+3][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                matrix[topLeftI+3][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 4:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+3]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+3][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+3][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+3]=2;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+3]=current;
                            }
                            break;
                        }
                        default:
                        {
                            //
                        }
                    }
                    break;
                }
                case 6:
                {
                    break;
                }
                case 7:
                {
                    switch (direction)
                    {
                        case 1:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+2][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 2:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                            }
                            break;
                        }
                        case 3:
                        {
                            topLeftI=i-1;
                            topLeftJ=j;
                            if (index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+2][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI][topLeftJ+1]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+2]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+2]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+2][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI][topLeftJ+1]=2;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+2][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI][topLeftJ+1]=current;
                            }
                            break;
                        }
                        case 4:
                        {
                            topLeftI=i;
                            topLeftJ=j-1;
                            if (index[topLeftI][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ]!=1&&index[topLeftI+1][topLeftJ+1]!=1&&index[topLeftI+1][topLeftJ+2]!=1)
                            {
                                direction++;
                                if (direction==5)
                                {
                                    direction=1;
                                }
                                index[topLeftI+1][topLeftJ]=0;
                                index[topLeftI+2][topLeftJ+1]=0;
                                index[topLeftI+1][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ]=0;
                                matrix[topLeftI+2][topLeftJ+1]=0;
                                matrix[topLeftI+1][topLeftJ+1]=0;
                                matrix[topLeftI][topLeftJ+1]=0;
                                index[topLeftI][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ]=2;
                                index[topLeftI+1][topLeftJ+1]=2;
                                index[topLeftI+1][topLeftJ+2]=2;
                                matrix[topLeftI][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ]=current;
                                matrix[topLeftI+1][topLeftJ+1]=current;
                                matrix[topLeftI+1][topLeftJ+2]=current;
                            }
                            break;
                        }
                        default:
                        {
                            //
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
        catch (ArrayIndexOutOfBoundsException exception)
        {
            //
        }
        finally
        {
            //
        }
    }

    public void moveLeft()
    {
        for (int i=0;i<index.length;i++)
        {
            if (index[i][0]==2)
            {
                return;
            }
            for (int j=1;j<index[i].length;j++)
            {
                if (index[i][j]==2&&index[i][j-1]==1)
                {
                    return;
                }
            }
        }
        for (int i=0;i<index.length;i++)
        {
            for (int j=1;j<index[i].length;j++)
            {
                if (index[i][j]==2)
                {
                    index[i][j-1]=index[i][j];
                    index[i][j]=0;
                    matrix[i][j-1]=matrix[i][j];
                    matrix[i][j]=0;
                }
            }
        }
    }

    public void moveRight()
    {
        for (int i=0;i<index.length;i++)
        {
            if (index[i][index[i].length-1]==2)
            {
                return;
            }
            for (int j=index[i].length-2;j>=0;j--)
            {
                if (index[i][j]==2&&index[i][j+1]==1)
                {
                    return;
                }
            }
        }
        for (int i=0;i<index.length;i++)
        {
            for (int j=index[i].length-2;j>=0;j--)
            {
                if (index[i][j]==2)
                {
                    index[i][j+1]=index[i][j];
                    index[i][j]=0;
                    matrix[i][j+1]=matrix[i][j];
                    matrix[i][j]=0;
                }
            }
        }
    }
}