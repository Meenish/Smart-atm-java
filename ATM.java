import java.util.Scanner;
class ATM
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int choice,amt;
        int last_withdraw=0;
        System.out.println("Enter initial ATM load(count 500s and 100s):-");
        int a=sc.nextInt();
        int b=sc.nextInt();

        while (true)
        {
            System.out.println("\n\n-----ATM menu-----");
            System.out.println("1.Withdraw Amount");
            System.out.println("2.Check ATM status");
            System.out.println("3.Deposit Notes");
            System.out.println("4.Mini statement(last withdraw)");
            System.out.println("5.Exit");
            System.out.println("Enter your choice :-");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter withdrawal amount:-");
                    amt=sc.nextInt();
                    if (amt>10000) {
                        System.out.println("Remember ! withdraw only 10000 at a time.");
                        break;
                    }
                    if(amt % 100 != 0 ) {
                        System.out.println("Enter multiples of 100 only.");
                        break;
                    }
                    if (amt <= 500)
                    {
                        int need100=amt/100;
                        // availablity chedcking of 100s
                        if (need100>b)
                        {
                            System.out.println("ATM does not have enough 100s.");
                            break;
                        }
                        b-=need100;//internal updation.
                        System.out.println("cash dispensed");
                        System.out.println("no.of 500s = 0");
                        System.out.println("no.of 100s = "+need100);
                        last_withdraw=amt;
                        break;
                    }
                    int use500,need100;
                    need100=5;
                    use500=(amt-500)/500;
                    need100=need100+((amt-500)%500)/100;
                    if(need100>5)
                    {
                        need100=need100-5;
                        use500=use500+1;
                    }
                    if(use500>a)
                    {
                        System.out.println("ATM does not have enough 500s.");
                        break;
                    }
                    if(need100>b)
                    {
                        System.out.println("ATM does not have enough 100s");
                        break;
                    }
                    a-=use500;
                    b -=need100;
                    System.out.println("Cash Dispensed:");
                    System.out.println("500s = "+use500);
                    System.out.println("100s = "+need100);
                    last_withdraw=amt;
                    break;
                case 2:
                    System.out.println("----ATM status----");
                    System.out.println("500s available :"+a);
                    System.out.println("100s available :"+b);
                    System.out.println("Total cash  :"+((a*500)+(b*100))
                );
                    break;
                case 3:
                    System.out.println("Enter no.of 500s to deposit:");
                    int d500=sc.nextInt();
                    System.out.println("Enter no.of 100s to deposit:");
                    int d100=sc.nextInt();
                    a+=d500;
                    b+=d100;
                    System.out.println("Notes added successfully!");
                    break;
                case 4:
                    if(last_withdraw==0)
                    {
                        System.out.println("No transaction as of now");
                    }
                    else
                    {
                        System.out.println("Your last transaction amount is :"+last_withdraw);
                    }
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Enter the valid choice");
            }
        }
    }
}