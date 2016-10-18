package com.company.app.mocks;

import com.company.app.Basket;
import com.company.app.Product;

import java.util.Date;
import java.util.Map;

public class BillableBasket extends Basket {
    private CreditCardProcessor creditCardProcessor;

    public void setCreditCardProcessor(CreditCardProcessor creditCardProcessor) {
        this.creditCardProcessor = creditCardProcessor;
    }

    public void checkout(Customer customer)
    {
        creditCardProcessor.sale(findOrderPrice(), customer);
        creditCardProcessor.shutdown();
    }

    public int findOrderPrice() {
        int sum = 0;
        for (Map.Entry<Product, Integer> entry : contents.entrySet()) {
            int count = entry.getValue();
            int price = entry.getKey().getPrice();
            sum = sum + (count * price);
        }
        return sum;
    }

    public boolean  fullCheckout(Customer customer)
    {
        CreditCardResult auth = creditCardProcessor.authorize(findOrderPrice(), customer);
        if(auth == CreditCardResult.INVALID_CARD || auth == CreditCardResult.NOT_ENOUGH_FUNDS )
        {
            return false;
        }
        boolean canShip = canShipCompletely();
        if(!canShip)
        {
            return false;
        }
        CreditCardResult capture = creditCardProcessor.capture(new Date().toString()+auth.getToken(), customer);
        if(capture == CreditCardResult.INVALID_CARD)
        {
            return false;
        }
        return true;

    }
}
