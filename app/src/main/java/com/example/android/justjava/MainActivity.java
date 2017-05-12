package com.example.android.justjava;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.jar.Attributes;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view){
        int  extraCost =0;

        CheckBox whippedCream= (CheckBox) findViewById(R.id.WhippedCream);
        CheckBox addChocolate = (CheckBox)findViewById(R.id.addChocolate);
        EditText NameOrder = (EditText)findViewById(R.id.Name);
        String nameReal = NameOrder.getText().toString();
        boolean hasWhippedCream = whippedCream.isChecked();
        boolean hasChocolate = addChocolate.isChecked();
        int price = 0;

        if (hasWhippedCream){
            extraCost +=  1;

        }
        if (hasChocolate){
            extraCost += 2;
        }

        price = calculatePrice(extraCost);


        String priceMessage = createOrderSummary(price,hasWhippedCream,hasChocolate,nameReal);
        //String priceMessage= "Total: $"+price+"\n Thank you !";
        //createOrderSummary();
        displayMessage(priceMessage);
    }

    public void increment(View view){

        quantity = quantity+1;
        displayQuantity(quantity);
    }

    public void decrement(View view){

        quantity = quantity -1;
        displayQuantity(quantity);

    }

    private void displayQuantity (int number){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayMessage (String message){
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    //
    private int calculatePrice(int extraCost){
        int totalPrice = (quantity*5)+ (extraCost*quantity);

        return totalPrice;
    }

    private String createOrderSummary(int price,boolean hasWhippedCream,boolean hasChocolate,String nameReal){

        return "Name: "+nameReal + "\n"+
                "Add Whipped Cream ? : "+hasWhippedCream+"\n"+
                "Add chocolate ? : "+hasChocolate+"\n"+
                "Quantity: "+quantity+"\n"+
                "Total: "+price+"\n "+
                "Thank you";
    }


}
