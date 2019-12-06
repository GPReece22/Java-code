public class Output {

    public static void main(String[] args) {
        BankAccounts alan = new BankAccounts("0", "Alan", 0, false, 0.025);
        BankAccounts derek = new BankAccounts("1", "Derek", 0, true, 0.0275);
        System.out.println(alan.getAccountHolder());
        System.out.println(alan.getAccountNumber());
        System.out.println(alan.getBalance());
        System.out.println();

        System.out.println(derek.getAccountHolder());
        System.out.println(derek.getAccountNumber());
        System.out.println(derek.getBalance());
        System.out.println();

        alan.withdraw(10000);
        derek.withdraw(10000);

        alan.addInterest();
        derek.addInterest();
        System.out.println("Alan's balance is" + alan.getBalance());
        System.out.println("Derek's balance is" + derek.getBalance());

        alan.withdraw(1000);
        System.out.println("Alan's new balance is"+ alan.getBalance());


    }
}
