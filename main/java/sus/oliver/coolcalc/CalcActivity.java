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
    String leftValueStr = "";
    String rightValueStr = "";
    String resultNumber = "";
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
                }
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(2);
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(4);
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                runningNumber = "";
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                resultNumber = "";
                resultsView.setText(runningNumber);
                currentOperation = null;
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.EQUAL);
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
                    default:
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












