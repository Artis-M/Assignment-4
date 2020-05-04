public class Test
{
    public static void main(String[] args)
    {
        Deposit<Valuable> deposit = new ValuableDepository<>(16) {
        };
        Miner miner1 = new Miner("Bob1", deposit);
        Miner miner2 = new Miner("Bob2", deposit);
        Miner miner3 = new Miner("Bob3", deposit);
        ValuableTransporter valuableTransporter = new ValuableTransporter(deposit);
        Thread t1 = new Thread(miner1);
        Thread t2 = new Thread(miner2);
        Thread t3 = new Thread(miner3);
        Thread t4 = new Thread(valuableTransporter);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
