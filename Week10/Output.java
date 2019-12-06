public class Output {

    public static void main(String[] args) {
        BankAccount alan = new BankAccount("76654", "Alan", 10000, false, 2.5);

        System.out.println(alan.getAccountHolder());
        System.out.println(alan.getAccountNumber());
        System.out.println(alan.getBalance());

        alan.addInterest();
        System.out.println(alan.getBalance());


    }
}
