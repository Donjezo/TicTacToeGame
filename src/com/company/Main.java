package com.company;



import java.util.*;

public class Main {
    static ArrayList<Integer> pozitateLojtareve = new ArrayList<Integer>();
    static ArrayList<Integer> pozitateKompjuterit = new ArrayList<Integer>();



    public static void main(String[] args) {
	   char [] [] gameBoard = {
	           {' ','|',' ','|',' '},
               {'-','+','-','+','-'},
               {' ','|',' ','|',' '},
               {'-','+','-','+','-'},
               {' ','|',' ','|',' '},
	   };

	   printGameBoard(gameBoard);
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("Printo nje per pozitat  nga 1-9");
            int playerpos = scan.nextInt();
            while(pozitateLojtareve.contains(playerpos)||pozitateKompjuterit.contains(playerpos)){
                System.out.println("kjo pozite eshte marr! Sheno nje pozit te lire");
                playerpos = scan.nextInt();
            }

            placePiece(gameBoard, playerpos,"lojtari");
            Random rand = new Random ();
            int cpuPos = rand.nextInt(9)+1;
            while(pozitateLojtareve.contains(cpuPos)||pozitateKompjuterit.contains(cpuPos)){
                cpuPos = rand.nextInt(9)+1;
            }
            placePiece(gameBoard, cpuPos,"kopmjuteri");

            printGameBoard(gameBoard);
            String rezultati = checkWinner();
            System.out.println(rezultati);
            if(rezultati.contains("Urime ju keni fituar") || rezultati.contains("Sorry :/") || rezultati.contains("barazim")){
                break;
            }
        }

    }
    // metoda qe krijon tabelen
    public  static void printGameBoard (char[][] gameBoard){
        for(char[] row : gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void placePiece (char[][] gameBoard, int pos, String user){
       char symbol = ' ';
        if(user.equals("lojtari")){
            symbol = 'X';
            pozitateLojtareve.add(pos);
        }else if(user.equals("kopmjuteri")){
            symbol ='O';
            pozitateKompjuterit.add(pos);
        }
        switch (pos){
            case 1:
                gameBoard[0][0]= symbol;
                break;
            case 2:
                gameBoard[0][2]= symbol;
                break;
            case 3:
                gameBoard[0][4]= symbol;
                break;
            case 4:
                gameBoard[2][0]= symbol;
                break;
            case 5:
                gameBoard[2][2]= symbol;
                break;
            case 6:
                gameBoard[2][4]= symbol;
                break;
            case 7:
                gameBoard[4][0]= symbol;
                break;
            case 8:
                gameBoard[4][2]= symbol;
                break;
            case 9:
                gameBoard[4][4]= symbol;
                break;
            default:
                break;

        }
    }

    public  static String checkWinner() {
        //rastet e fitores
        List rreshtiPare= Arrays.asList(1,2,3);
        List rreshtiDyte = Arrays.asList(4,5,6);
        List rreshtiTrete = Arrays.asList(7,8,9);

        List kolonaPare= Arrays.asList(1,4,7);
        List kolonaDyte = Arrays.asList(2,5,8);
        List kolonaTrete = Arrays.asList(3,6,9);


        List diagonaljaPare = Arrays.asList(1,5,9);
        List diagonaljaDyte = Arrays.asList(7,5,3);

        List<List> rasteteFitores = new ArrayList<List>();
        rasteteFitores.add(rreshtiPare);
        rasteteFitores.add(rreshtiDyte);
        rasteteFitores.add(rreshtiTrete);

        rasteteFitores.add(kolonaPare);
        rasteteFitores.add(kolonaDyte);
        rasteteFitores.add(kolonaTrete);

        rasteteFitores.add(diagonaljaDyte);
        rasteteFitores.add(diagonaljaPare);

        for(List l :rasteteFitores){
            if(pozitateLojtareve.containsAll(l)){
                return "Urime ju keni fituar";
            }else if (pozitateKompjuterit.containsAll(l)){
                return "Sorry :/";
            }else if (pozitateLojtareve.size()+ pozitateKompjuterit.size()==9){
                return "barazim";
            }
        }

        return "hello";
    }

}
