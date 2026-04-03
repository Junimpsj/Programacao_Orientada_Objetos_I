public class App {
    public static void main(String[] args) throws Exception {

        Conta c1 = new Conta();
        Cliente cliente1 = new Cliente();
        cliente1.nome = ("Ana");
        cliente1.cpf = ("777.777.777.01");
        c1.titular = cliente1;
        c1.numero = 987;
        c1.saldo = 200.0;
        c1.deposita(150.0);

        Conta c2 = new Conta();
        Cliente cliente2 = new Cliente();
        c2.titular = cliente2;
        cliente2.nome = ("Carlos");
        cliente2.cpf = ("999.999.999-02");
        c2.numero = 123;
        c2.saldo = 500.0;
        c2.saca(80);

        System.out.println("Cliente: " + c1.titular.nome + "\n" + "Saldo atual: R$ " + c1.saldo);
        System.out.println();
        System.out.println("Cliente: " + c2.titular.nome + "\n" + "Saldo atual: R% " + c2.saldo);

        System.out.println();
        c2.transfere(c1, 100);
        System.out.println("Transferência relizada! Carlos (- R$100) -> Ana (+ R$100)");
        System.out.println();

        System.out.println("Cliente: " + c1.titular.nome + "\n" + "Saldo atual: R$ " + c1.saldo);
        System.out.println();
        System.out.println("Cliente: " + c2.titular.nome + "\n" + "Saldo atual: R% " + c2.saldo);

    }
}
