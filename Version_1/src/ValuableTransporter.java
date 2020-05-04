public class ValuableTransporter implements Runnable
{
    private int targetValue;
    private int currentValue;
    private Deposit<Valuable> deposit;
    private Logger log;

    public ValuableTransporter()
    {
        this.targetValue = Math.round(50 + (int) (Math.random() * ((200 - 50) + 1)));
        this.currentValue = 0;
        this.deposit = new ValuableDepository<>(200);
        this.log = Logger.getInstance();
        log.log(targetValue+"");
    }

    @Override
    public void run() {
     int i = 0;
     while(true){

             if(currentValue <= targetValue){
                 Valuable valuable = deposit.getValuableAtIndex(i);
                 if(valuable != null){
                     currentValue += valuable.getValue();
                     System.out.println("valuable added");
                     i++;
                 }
             }
             else {
                 i =0;
                 deposit.clear();
                 System.out.println("shit delivered");
             }
         }


     }
    }

