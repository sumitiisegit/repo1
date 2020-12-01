import java.util.*;
import java.util.concurrent.Callable;

class Rate{
    double rate;
    String fromCurrency;
    String toCurrency;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
}
interface Sources{
    public double getConversionRate(String fromCurrency, String toCurrency);
}

class BBG implements Callable<Rate>{
    String fromCurrency;
    String toCurrency;

    public Rate getConversionRate(String fromCurrency, String toCurrency) {
        System.out.println("in BBB");
        //Thread.sleep(100);
        Rate r = new Rate();
        r.setRate(5.0);
        return r;
    }

    @Override
    public Rate call() throws Exception {
        Rate rate = new Rate();

        return getConversionRate(this.fromCurrency, this.toCurrency);
    }
}

class S1 implements Sources{
    @Override
    public double getConversionRate(String fromCurrency, String toCurrency) {
        return 6.0;
    }
}

//
//CacheService - 100 ms
//
//        sourceList.stream().anyMatch() ;
//        finalRate= i->getConversionRate();
//
//        source, from,to
//
//run(){
//        sourceList.stream().anyMatch() ;
//        finalRate= i->getConversionRate();
//sleep(100);
//        }


public class PricingService implements Sources{

    BBG bbg = new BBG();
    S1 s1 = new S1();
    List<Callable<Rate>> sourceList = new ArrayList();

    PricingService() {
        sourceList.add(bbg);
//        sourceList.add(s1);


    }

    public double getRate(String customerId, String fromCurrency, String toCurrency){
        double margin=0.0;

        double finalRate=0.0;

                //Optional<Sources> source =
        //finalRate= sourceList.forEach(i->i.getConversionRate(fromCurrency, toCurrency));
//
//        for(Callable s: sourceList) {
//            //s.getConversionRate(fromCurrency,toCurrency);
//            finalRate = s.call();
//        }

        //finalRate= source.getConversionRate(fromCurrency, toCurrency);

        List<Callable<Rate>> futures = sourceList.in

       Map<String, Double> custMargin = new HashMap<>(); // populate
       custMargin.put("1",1.0);

       margin = custMargin.get(customerId);

        return finalRate + margin;
    }

    public static void main(String[] args) {
        PricingService ps = new PricingService();
        System.out.println(ps.getRate("1","USD","INR"));
    }

    @Override
    public double getConversionRate(String fromCurrency, String toCurrency) {
        return 0;
    }
}

