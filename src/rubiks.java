import java.util.Scanner;
import java.util.Random;

class rubiks
{
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[92m";
    private static final String ANSI_YELLOW = "\u001B[93m";
    private static final String ANSI_ORANGE = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[94m";

    // public static final String ANSI_BLACK = "\u001B[30m";
    // private static final String ANSI_PURPLE = "\u001B[35m";
    // public static final String ANSI_CYAN = "\u001B[36m";
    // public static final String ANSI_WHITE = "\u001B[37m";

    private static String green[][] =
            {
                    {"G1","G2","G3"},
                    {"G4","G5","G6"},
                    {"G7","G8","G9"}
            };
    private static String yellow[][] =
            {
                    {"Y1","Y2","Y3"},
                    {"Y4","Y5","Y6"},
                    {"Y7","Y8","Y9"}
            };
    private static String red[][] =
            {
                    {"R1","R2","R3"},
                    {"R4","R5","R6"},
                    {"R7","R8","R9"}
            };
    private static String white[][] =
            {
                    {"W1","W2","W3"},
                    {"W4","W5","W6"},
                    {"W7","W8","W9"}
            };
    private static String blue[][] =
            {
                    {"B1","B2","B3"},
                    {"B4","B5","B6"},
                    {"B7","B8","B9"}
            };
    private static String orange[][] =
            {
                    {"O1","O2","O3"},
                    {"O4","O5","O6"},
                    {"O7","O8","O9"}
            };

    public static void main(String[] args)
    {
        System.out.println("Welcome!");

        printCube();

        while(true)
        {
            moveSelection();
        }
        
    }

    private static void color(String value)
    {
        if (value.contains("B"))
        {
            System.out.print(ANSI_BLUE + FormatLine(value) + ANSI_RESET);
        }
        if (value.contains("R"))
        {
            System.out.print(ANSI_RED + FormatLine(value) + ANSI_RESET);
        }
        if (value.contains("Y"))
        {
            System.out.print(ANSI_YELLOW + FormatLine(value) + ANSI_RESET);
        }
        if (value.contains("G"))
        {
            System.out.print(ANSI_GREEN + FormatLine(value) + ANSI_RESET);
        }
        if (value.contains("O"))
        {
            System.out.print(ANSI_ORANGE + FormatLine(value) + ANSI_RESET);
        }
        if (value.contains("W"))
        {
            System.out.print(/*ANSI_WHITE +*/ FormatLine(value) + ANSI_RESET);
        }
    }

    private static void moveSelection()
    {
        Scanner input = new Scanner(System.in);
        String selectionInput = input.next();
        selectionInput = selectionInput.toLowerCase();

        if (selectionInput.equals("l"))
        {
            moveL();
        }

        if (selectionInput.equals("l'"))
        {
            moveLinv();
        }

        if (selectionInput.equals("r"))
        {
            moveR();
        }

        if (selectionInput.equals("r'"))
        {
            moveRinv();
        }

        if (selectionInput.equals("f"))
        {
            moveF();
        }

        if (selectionInput.equals("f'"))
        {
            moveFinv();
        }

        if (selectionInput.equals("b"))
        {
            moveB();
        }

        if (selectionInput.equals("b'"))
        {
            moveBinv();
        }

        if (selectionInput.equals("u"))
        {
            moveU();
        }

        if (selectionInput.equals("u'"))
        {
            moveUinv();
        }

        if (selectionInput.equals("d"))
        {
            moveD();
        }

        if (selectionInput.equals("d'"))
        {
            moveDinv();
        }

        if (selectionInput.equals("random"))
        {
            jumble();
        }

        printCube();
    }

    private static void transpose(String array[][])
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[0].length; j++) {
                String x = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = x;
            }
        }
    }

    private static void rotateLeft(String array[][])
    {
        // transpose
        transpose(array);

        //  swap rows
        for (int  i = 0; i < array.length/2; i++) {
            for (int j = 0; j < array[0].length; j++) {
                String x = array[i][j];
                array[i][j] = array[array.length -1 -i][j];
                array[array.length -1 -i][j] = x;
            }
        }
    }

    private static void rotateRight(String array[][])
    {
        // transpose
        transpose(array);

        //  swap rows
        for (int  j = 0; j < array[0].length/2; j++) {
            for (int i = 0; i < array.length; i++) {
                String x = array[i][j];
                array[i][j] = array[i][array[0].length -1 -j];
                array[i][array[0].length -1 -j] = x;
            }
        }
    }

    static void printMatrix(String array[][])
    {
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array[0].length;j++)
                System.out.print(array[i][j] + " ");
                System.out.println();
        }
    }

    private static void printCube()
    {
        String blank[][] =
        {
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
        };

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(green[0][0]); color(green[0][1]); color(green[0][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(green[1][0]); color(green[1][1]); color(green[1][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(green[2][0]); color(green[2][1]); color(green[2][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        color(yellow[0][0]); color(yellow[0][1]); color(yellow[0][2]);
        color(red[0][0]); color(red[0][1]); color(red[0][2]);
        color(white[0][0]); color(white[0][1]); color(white[0][2]);
        System.out.println();

        color(yellow[1][0]); color(yellow[1][1]); color(yellow[1][2]);
        color(red[1][0]); color(red[1][1]); color(red[1][2]);
        color(white[1][0]); color(white[1][1]); color(white[1][2]);
        System.out.println();

        color(yellow[2][0]); color(yellow[2][1]); color(yellow[2][2]);
        color(red[2][0]); color(red[2][1]); color(red[2][2]);
        color(white[2][0]); color(white[2][1]); color(white[2][2]);
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(blue[0][0]); color(blue[0][1]); color(blue[0][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(blue[1][0]); color(blue[1][1]); color(blue[1][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(blue[2][0]); color(blue[2][1]); color(blue[2][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(orange[0][0]); color(orange[0][1]); color(orange[0][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(orange[1][0]); color(orange[1][1]); color(orange[1][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();

        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        color(orange[2][0]); color(orange[2][1]); color(orange[2][2]);
        System.out.print(FormatLine(blank[0][0])+ FormatLine(blank[0][1]) + FormatLine(blank[0][2]));
        System.out.println();
    }

    private static String FormatLine(String row)
    {
        String[] splits = row.split(":");
        String FormattedLine = "";
        int width = 5;
        int padding = 0;

        for(String item: splits)
        {
        padding = width - item.length();
            FormattedLine = FormattedLine + item;

            for(int i=0;i<padding;i++)
            {
            FormattedLine = FormattedLine + " ";
            }
        }
        return(FormattedLine);
    }

    private static void moveL()
    {
        String temp[][]=        
        {
            {"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}
        };

        temp[0][0] = orange[0][0];
        temp[1][0] = orange[1][0];
        temp[2][0] = orange[2][0];

        orange[0][0] = blue[0][0];
        orange[1][0] = blue[1][0];
        orange[2][0] = blue[2][0];

        blue[0][0] = red[0][0];
        blue[1][0] = red[1][0];
        blue[2][0] = red[2][0];

        red[0][0] = green[0][0];
        red[1][0] = green[1][0];
        red[2][0] = green[2][0];

        green[0][0] = temp[0][0];
        green[1][0] = temp[1][0];
        green[2][0] = temp[2][0];

        rotateRight(yellow);

    }

    private static void moveLinv()
    {
        String temp[][]=
            {
                {"-","-","-"},
                {"-","-","-"},
                {"-","-","-"}
            };

        temp[0][0] = green[0][0];
        temp[1][0] = green[1][0];
        temp[2][0] = green[2][0];

        green[0][0] = red[0][0];
        green[1][0] = red[1][0];
        green[2][0] = red[2][0];

        red[0][0] = blue[0][0];
        red[1][0] = blue[1][0];
        red[2][0] = blue[2][0];

        blue[0][0] = orange[0][0];
        blue[1][0] = orange[1][0];
        blue[2][0] = orange[2][0];

        orange[0][0] = temp[0][0];
        orange[1][0] = temp[1][0];
        orange[2][0] = temp[2][0];

        rotateLeft(yellow);

    }

    private static void moveR()
    {
        String temp[][]=        
        {
            {"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}
        };

        temp[0][2] = green[0][2];
        temp[1][2] = green[1][2];
        temp[2][2] = green[2][2];

        green[0][2] = red[0][2];
        green[1][2] = red[1][2];
        green[2][2] = red[2][2];

        red[0][2] = blue[0][2];
        red[1][2] = blue[1][2];
        red[2][2] = blue[2][2];

        blue[0][2] = orange[0][2];
        blue[1][2] = orange[1][2];
        blue[2][2] = orange[2][2];

        orange[0][2] = temp[0][2];
        orange[1][2] = temp[1][2];
        orange[2][2] = temp[2][2];

        rotateRight(white);
    }

    private static void moveRinv()
    {
        String temp[][]=
            {
                {"-","-","-"},
                {"-","-","-"},
                {"-","-","-"}
            };

        temp[0][2] = orange[0][2];
        temp[1][2] = orange[1][2];
        temp[2][2] = orange[2][2];

        orange[0][2] = blue[0][2];
        orange[1][2] = blue[1][2];
        orange[2][2] = blue[2][2];

        blue[0][2] = red[0][2];
        blue[1][2] = red[1][2];
        blue[2][2] = red[2][2];

        red[0][2] = green[0][2];
        red[1][2] = green[1][2];
        red[2][2] = green[2][2];

        green[0][2] = temp[0][2];
        green[1][2] = temp[1][2];
        green[2][2] = temp[2][2];

        rotateRight(white);
    }

    private static void moveF()
    {
        String temp[][]=        
        {
            {"-","-","-"},
            {"-","-","-"},
            {"-","-","-"}
        };

        temp[2][0] = green[2][0];
        temp[2][1] = green[2][1];
        temp[2][2] = green[2][2];
        
        green[2][0] = yellow[2][2];
        green[2][1] = yellow[1][2];
        green[2][2] = yellow[0][2];

        yellow[2][2] = blue[0][2];
        yellow[1][2] = blue[0][1];
        yellow[0][2] = blue[0][0];
        
        blue[0][2] = white[0][0];
        blue[0][1] = white[1][0];
        blue[0][0] = white[2][0];

        white[0][0] = temp[2][0];
        white[1][0] = temp[2][1];
        white[2][0] = temp[2][2];

        rotateRight(red);
    }

    private static void moveFinv()
    {
        String temp[][]=
                {
                        {"-","-","-"},
                        {"-","-","-"},
                        {"-","-","-"}
                };

        temp[2][0] = green[2][0];
        temp[2][1] = green[2][1];
        temp[2][2] = green[2][2];

        green[2][0] = yellow[2][2];
        green[2][1] = yellow[1][2];
        green[2][2] = yellow[0][2];

        yellow[2][2] = blue[0][2];
        yellow[1][2] = blue[0][1];
        yellow[0][2] = blue[0][0];

        blue[0][2] = white[0][0];
        blue[0][1] = white[1][0];
        blue[0][0] = white[2][0];

        white[0][0] = temp[2][0];
        white[1][0] = temp[2][1];
        white[2][0] = temp[2][2];

        rotateLeft(red);
    }

    private static void moveB()
    {
        String temp[][]=
                {
                        {"-","-","-"},
                        {"-","-","-"},
                        {"-","-","-"}
                };

        temp[2][0] = blue[2][0];
        temp[2][1] = blue[2][1];
        temp[2][2] = blue[2][2];

        blue[2][2] = yellow[2][0];
        blue[2][1] = yellow[1][0];
        blue[2][0] = yellow[0][0];

        yellow[2][0] = green[0][2];
        yellow[1][0] = green[0][1];
        yellow[0][0] = green[0][0];

        green[0][2] = white[2][2];
        green[0][1] = white[1][2];
        green[0][0] = white[0][2];

        white[2][2] = temp[2][0];
        white[1][2] = temp[2][1];
        white[0][2] = temp[2][2];

        rotateRight(orange);
    }

    private static void moveBinv()
    {
        String temp[][]=
                {
                        {"-","-","-"},
                        {"-","-","-"},
                        {"-","-","-"}
                };

        temp[0][0] = green[0][0];
        temp[0][1] = green[0][1];
        temp[0][2] = green[0][2];


        green[0][0] = yellow[2][0];
        green[0][1] = yellow[1][0];
        green[0][2] = yellow[0][0];

        yellow[2][0] = blue[2][2];
        yellow[1][0] = blue[2][1];
        yellow[0][0] = blue[2][0];

        blue[2][2] = white[0][2];
        blue[2][1] = white[1][2];
        blue[2][0] = white[2][2];

        white[0][2] = temp[0][0];
        white[1][2] = temp[0][1];
        white[2][2] = temp[0][2];

        rotateLeft(orange);
    }

    private static void moveU()
    {
        String temp[][]=
                {
                        {"-","-","-"},
                        {"-","-","-"},
                        {"-","-","-"}
                };

        temp[0][0] = red[0][0];
        temp[0][1] = red[0][1];
        temp[0][2] = red[0][2];

        red[0][0] = white[0][0];
        red[0][1] = white[0][1];
        red[0][2] = white[0][2];

        white[0][0] = orange[2][0];
        white[0][1] = orange[2][1];
        white[0][2] = orange[2][2];

        orange[2][0] = yellow[0][0];
        orange[2][1] = yellow[0][1];
        orange[2][2] = yellow[0][2];

        yellow[0][0] = temp[0][0];
        yellow[0][1] = temp[0][1];
        yellow[0][2] = temp[0][2];

        rotateRight(green);
    }

    private static void moveUinv()
    {
        String temp[][]=
                {
                        {"-","-","-"},
                        {"-","-","-"},
                        {"-","-","-"}
                };

        temp[0][0] = red[0][0];
        temp[0][1] = red[0][1];
        temp[0][2] = red[0][2];

        red[0][0] = yellow[0][0];
        red[0][1] = yellow[0][1];
        red[0][2] = yellow[0][2];

        yellow[0][0] = orange[2][0];
        yellow[0][1] = orange[2][1];
        yellow[0][2] = orange[2][2];

        orange[2][0] = white[0][0];
        orange[2][1] = white[0][1];
        orange[2][2] = white[0][2];

        white[0][0] = temp[0][0];
        white[0][1] = temp[0][1];
        white[0][2] = temp[0][2];

        rotateLeft(green);
    }

    private static void moveD()
    {
        String temp[][]=
            {
                {"-","-","-"},
                {"-","-","-"},
                {"-","-","-"}
            };

        temp[2][0] = red[2][0];
        temp[2][1] = red[2][1];
        temp[2][2] = red[2][2];

        red[2][0] = yellow[2][0];
        red[2][1] = yellow[2][1];
        red[2][2] = yellow[2][2];

        yellow[2][0] = orange[0][0];
        yellow[2][1] = orange[0][1];
        yellow[2][2] = orange[0][2];

        orange[0][0] = white[2][0];
        orange[0][1] = white[2][1];
        orange[0][2] = white[2][2];

        white[2][0] = temp[2][0];
        white[2][1] = temp[2][1];
        white[2][2] = temp[2][2];

        rotateRight(blue);
    }

    private static void moveDinv()
    {
        String temp[][]=
            {
                {"-","-","-"},
                {"-","-","-"},
                {"-","-","-"}
            };

        temp[2][0] = red[2][0];
        temp[2][1] = red[2][1];
        temp[2][2] = red[2][2];

        red[2][0] = white[2][0];
        red[2][1] = white[2][1];
        red[2][2] = white[2][2];

        white[2][0] = orange[0][0];
        white[2][1] = orange[0][1];
        white[2][2] = orange[0][2];

        orange[0][0] = yellow[2][0];
        orange[0][1] = yellow[2][1];
        orange[0][2] = yellow[2][2];

        yellow[2][0] = temp[2][0];
        yellow[2][1] = temp[2][1];
        yellow[2][2] = temp[2][2];

        rotateLeft(blue);
    }

    private static void jumble()
    {
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            int roll = random.nextInt(6) + 1;
            System.out.println(roll);

            if (roll == 1)
            {
                moveU();
            }
            if (roll == 2)
            {
                moveD();
            }
            if (roll == 3)
            {
                moveF();
            }
            if (roll == 4)
            {
                moveR();
            }
            if (roll == 5)
            {
                moveL();
            }
            if (roll == 6)
            {
                moveB();
            }
        }
    }
}