import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String userTrait = "";
        int userDominantAmount = -1;
        int userRecessiveAmount = -1;
        int userTotalPop = 0;


        double homoDomFreq, homoRecFreq, heteroFreq;
        double recAlleleFreq, domAlleleFreq;


        System.out.println("Are you entering a homozygous dominant or homozygous recessive number?");
        userTrait = input.nextLine();

        System.out.println("Enter the trait amount: ");
        if(userTrait.contains("dom") || userTrait.contains("Dom")){//dominant amount
            userDominantAmount = input.nextInt();
        }else if(userTrait.contains("rec") || userTrait.contains("Rec")){ //recessive amount
            userRecessiveAmount = input.nextInt();
        }

        System.out.println("Enter the total population: ");
        userTotalPop = input.nextInt();
        if(userTrait.contains("dom") || userTrait.contains("Dom")){//given dominant amount
            userRecessiveAmount = userTotalPop-userDominantAmount;
        }else if(userTrait.contains("rec") || userTrait.contains("Rec")){ //given recessive amount
            userDominantAmount = userTotalPop-userRecessiveAmount;
        }

        homoRecFreq = (double)userRecessiveAmount/userTotalPop;

        recAlleleFreq = Math.sqrt(homoRecFreq);

        domAlleleFreq = 1.0 - recAlleleFreq;

        homoDomFreq = domAlleleFreq*domAlleleFreq;

        heteroFreq = 2 * domAlleleFreq * recAlleleFreq;

        System.out.println("");

        System.out.println("Dominant allele frequency: " + domAlleleFreq);
        System.out.println("Recessive allele frequency: " + recAlleleFreq);
        
        System.out.println("");

        System.out.println("Homozygous Dominant Population: " + homoDomFreq*userTotalPop + "(" + homoDomFreq + ")");
        System.out.println("Heterozygous Population: " + heteroFreq*userTotalPop + "(" + heteroFreq + ")");
        System.out.println("Homozygous Recessive Population: " + homoRecFreq*userTotalPop + "(" + homoRecFreq + ")");



        
    }
}
