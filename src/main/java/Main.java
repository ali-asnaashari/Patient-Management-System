import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

         /** Line color */
         final String ANSI_RESET = "\u001B[0m";
         final String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_YELLOW + "Reception Three DO : ");
        System.out.print(ANSI_RESET);
        Reception receptionThree = new Reception();

        String contents = "";

        File file1 = new File("D:\\project\\DataStructureCourseProject2021-1400\\input\\DSinp2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file1));

        while ((contents = br.readLine()) != null) {
            String[] words = contents.split(" ");
            if (words[0].equals("Add")) {
                receptionThree.insertPatient(new Patient(Integer.parseInt(words[1]), Integer.parseInt(words[2])));
            } else if (words[0].equals("Update")) {
                receptionThree.updatePatient(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
            } else if (words[1].equals("Sickest")) {
                receptionThree.serveSickest();
            } else if (words[1].equals("First")) {
                receptionThree.serveFirst();
            }
        }


        System.out.println(ANSI_YELLOW + "Reception Three End Work ");
        System.out.print(ANSI_RESET);

















        /** Sample Input3 Corrected
         System.out.println(ANSI_YELLOW + "Reception Three DO : ");
         System.out.print(ANSI_RESET);
         Reception receptionThree = new Reception();
        receptionThree.insertPatient(new Patient(2, 3));
        receptionThree.insertPatient(new Patient(5, -12));
        receptionThree.insertPatient(new Patient(9, 6));
        receptionThree.insertPatient(new Patient(6, -2));

        receptionThree.serveSickest();
        receptionThree.serveSickest();
        receptionThree.serveSickest();
        receptionThree.serveSickest();

         System.out.println(ANSI_YELLOW + "Reception Three End Work ");
         System.out.print(ANSI_RESET);
         */
















        /** Sample Input4 Corrected
         System.out.println(ANSI_YELLOW + "Reception Four DO : ");
         System.out.print(ANSI_RESET);
         Reception receptionFour = new Reception();
         receptionFour.insertPatient(new Patient(2, 3));
         receptionFour.insertPatient(new Patient(5, -12));
         receptionFour.insertPatient(new Patient(9, 6));
         receptionFour.updatePatient(9,5);
         receptionFour.updatePatient(5,7);
         receptionFour.updatePatient(2,1);;
         receptionFour.serveSickest();
         receptionFour.serveSickest();
         receptionFour.serveSickest();

         System.out.println(ANSI_YELLOW + "Reception Four End Work ");
         System.out.print(ANSI_RESET);
         */













          /**
         System.out.println(ANSI_YELLOW + "Reception Five DO : ");
         System.out.print(ANSI_RESET);
         Reception receptionFive = new Reception();
         receptionFive.insertPatient(new Patient(2, 3));
         receptionFive.insertPatient(new Patient(5, -12));
         receptionFive.insertPatient(new Patient(9, 6));
         receptionFive.insertPatient(new Patient(6, -2));

         receptionFive.serveSickest();
         receptionFive.serveFirst();
         receptionFive.serveSickest();
         receptionFive.serveFirst();

         System.out.println(ANSI_YELLOW + "Reception Five End Work ");
         System.out.print(ANSI_RESET);
           */







          /**
         System.out.println(ANSI_YELLOW + "Reception Six DO : ");
         System.out.print(ANSI_RESET);
         Reception receptionSix = new Reception();
         receptionSix.insertPatient(new Patient(12345678, 5));
         receptionSix.insertPatient(new Patient(87654321, 3));

         receptionSix.updatePatient(87654321,6);
         receptionSix.updatePatient(12345678,4);

         receptionSix.serveFirst();
         receptionSix.serveFirst();


         System.out.println(ANSI_YELLOW + "Reception Six DO : ");
         System.out.print(ANSI_RESET);
         */






            /**
          System.out.println(ANSI_YELLOW + "Reception receptionSeven DO : ");
          System.out.print(ANSI_RESET);
          Reception receptionSeven = new Reception();
         receptionSeven.insertPatient(new Patient(12345678, 5));
         receptionSeven.insertPatient(new Patient(87654321, 3));

         receptionSeven.updatePatient(87654321,6);
         receptionSeven.updatePatient(12345678,4);

         receptionSeven.serveFirst();
         receptionSeven.serveFirst();


          System.out.println(ANSI_YELLOW + "Reception Six DO : ");
          System.out.print(ANSI_RESET);
             */




    }
}
