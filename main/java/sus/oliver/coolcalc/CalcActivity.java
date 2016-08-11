package sus.oliver.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    TextView resultsView;

    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNumber = "";
    // String storedNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    String resultNumber = "";
    // String method = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button zeroButton  = (Button) findViewById(R.id.zeroButton);
        Button oneButton   = (Button) findViewById(R.id.oneButton);
        Button twoButton   = (Button) findViewById(R.id.twoButton);
        Button threeButton = (Button) findViewById(R.id.threeButton);
        Button fourButton  = (Button) findViewById(R.id.fourButton);
        Button fiveButton  = (Button) findViewById(R.id.fiveButton);
        Button sixButton   = (Button) findViewById(R.id.sixButton);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button eightButton = (Button) findViewById(R.id.eightButton);
        Button nineButton  = (Button) findViewById(R.id.nineButton);
        Button clearButton = (Button) findViewById(R.id.clearButton);

        ImageButton calcButton = (ImageButton) findViewById(R.id.calcButton);
        ImageButton divideButton = (ImageButton) findViewById(R.id.divideButton);
        ImageButton multiplyButton = (ImageButton) findViewById(R.id.multiplyButton);
        ImageButton addButton = (ImageButton) findViewById(R.id.addButton);
        ImageButton subtractButton = (ImageButton) findViewById(R.id.subtractButton);

        resultsView = (TextView) findViewById(R.id.resultsText);
        /* initialise resultsView to empty string */
        resultsView.setText("");

        // set onClickListeners

        zeroButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!runningNumber.equals("0") & !runningNumber.equals("")) {
                    numberPressed(0);
                    // resultsView.setText(runningNumber);
                }
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);
                // resultsView.setText(runningNumber);
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(2);
                // resultsView.setText(runningNumber);
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);
                // resultsView.setText(runningNumber);
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(4);
                // resultsView.setText(runningNumber);
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);
                // resultsView.setText(runningNumber);
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);
                // resultsView.setText(runningNumber);
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);
                // resultsView.setText(runningNumber);
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);
                // resultsView.setText(runningNumber);
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);
                // resultsView.setText(runningNumber);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                runningNumber = "";
                leftValueStr = "";
                rightValueStr = "";
                resultsView.setText(runningNumber);
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
/*
                if (!storedNumber.equals("") & !runningNumber.equals("")) {
                    if (method.equals("divide")) {
                        resultNumber = String.valueOf(Integer.parseInt(storedNumber) / Integer.parseInt(runningNumber));
                        runningNumber = resultNumber;
                        storedNumber = "";
                        resultsView.setText(resultNumber);
                    }
                    if (method.equals("multiply")) {
                        resultNumber = String.valueOf(Integer.parseInt(storedNumber) * Integer.parseInt(runningNumber));
                        runningNumber = resultNumber;
                        storedNumber = "";
                        resultsView.setText(resultNumber);
                    }
                    if (method.equals("add")) {
                        resultNumber = String.valueOf(Integer.parseInt(storedNumber) + Integer.parseInt(runningNumber));
                        runningNumber = resultNumber;
                        storedNumber = "";
                        resultsView.setText(resultNumber);
                    }
                    if (method.equals("subtract")) {
                        resultNumber = String.valueOf(Integer.parseInt(storedNumber) - Integer.parseInt(runningNumber));
                        runningNumber = resultNumber;
                        storedNumber = "";
                        resultsView.setText(resultNumber);
                    }

                }
*/
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.MULTIPLY);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.ADD);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.SUBTRACT);
            }
        });

    }

    void processOperation(Operation operation){
        if (currentOperation != null){ // operator has been pressed previously
            if (!runningNumber.equals("")){ // need number to operate on
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                resultNumber = String.valueOf(result);
                leftValueStr = resultNumber;
                rightValueStr = "";
                resultsView.setText(resultNumber);
            }


        } else { // operator pressed first time

            leftValueStr = runningNumber;
            runningNumber = "";

        }

        currentOperation = operation;

    }

    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);
    }

}












