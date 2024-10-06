package cso.computerscience.csolevel;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
//import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {
    private int dpHeight;
    private int dpWidth;
    private float dDensity;
    private final int designWidth=375;
    private final int designHeight=812;
    //PDFView pdfView;
    private RecyclerView pRecyclerView;
    private RecyclerView.Adapter pAdapter;
    private RecyclerView.LayoutManager pLayoutManager;
    CardView cardView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        addTestDevice("d0dd4def-71cd-4a6c-9abd-48843099fabf");
        mAdView.loadAd(adRequest);


//        if(IsNetworkAvailable())
//        {
//
//        }
//
//        else if(!IsNetworkAvailable())
//        {
//            Toast.makeText(MainActivity.this,"Network Connection is not Available!",Toast.LENGTH_SHORT).show();
//        }
//
//
//
//        private boolean IsNetworkAvailable(){
//            boolean foundWIFI=false;
//            boolean foundMobileData=false;
//            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//            NetworkInfo[] networkInfo=connectivityManager.getAllNetworkInfo();
//            for(NetworkInfo ntInfo:networkInfo)
//            {
//                if(ntInfo.getTypeName().equalsIgnoreCase("WIFI"));
//                if(ntInfo.isConnected())
//                    foundWIFI=true;
//                if(ntInfo.getTypeName().equalsIgnoreCase("MOBILE"));
//                if(ntInfo.isConnected())
//                    foundMobileData=true;
//            }
//            return foundMobileData || foundWIFI;
//
//        }






        // pdfView=(PDFView) findViewById(pView);
        // pdfView.fromAsset(TARRIF.pdf).load();

        //Controlling Screen Sizes
        DisplayMetrics displayMetrics= getResources().getDisplayMetrics();
        dpHeight=(displayMetrics.heightPixels);
        dpWidth=(displayMetrics.widthPixels);
        dDensity=(displayMetrics.scaledDensity);

       // ViewGroup.LayoutParams backgroundParams = (ViewGroup.MarginLayoutParams) background.getLayoutParams();
       // backgroundParams.height=calcHeight(value, 707);

        //relativeLayoutWrapperButtons.setPadding(left, 0, calcHeight(value, 20),right, 0, bottom, 0);

//        ViewGroup.LayoutParams buttonLogInParams = (ViewGroup.MarginLayoutParams) buttonLogIn.getLayoutParams();
  //      backgroundParams.height=calcHeight(value, 707);

    //    ViewGroup.LayoutParams buttonRegisterParams = (ViewGroup.MarginLayoutParams) background.getLayoutParams();
      //  backgroundParams.height=calcHeight(value, 707);

        cardView = findViewById(R.id.aboutcsacademy);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        ArrayList<PseudoItems> pseudoItemslist = new ArrayList<>();
        pseudoItemslist.add(new PseudoItems(R.drawable.topics_vector_dt_01, "Data Types", "Integer | Long | Double | String | Boolean"));
        pseudoItemslist.add(new PseudoItems(R.drawable.ic_topics_vector_case_01, "Line 3", "Line 4"));
        pseudoItemslist.add(new PseudoItems(R.drawable.ic_topics_vector_operators_01, "Line 5", "Line 6"));

       /* pRecyclerView=findViewById(R.id.recyclerView);
        pRecyclerView.setHasFixedSize(true);
        pLayoutManager=new LinearLayoutManager(this);
        pAdapter=new PseudoItemsAdapter(pseudoItemslist);
        pRecyclerView.setLayoutManager(pLayoutManager);
        pRecyclerView.setAdapter(pAdapter);*/

    }

    private void addTestDevice(String s) {
    }

    public void TheoryTopics(View view) {
        Intent theorytopics = new Intent(this, Theory.class);
        startActivity(theorytopics);
    }

    public void prglistTopics(View view) {
        Intent prgtopics = new Intent(this, Programming.class);
        startActivity(prgtopics);
    }

    public void aboutMessage(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "This is The CS Academy of Computer Sciences and Application Development!", Toast.LENGTH_SHORT);
        toast.setMargin(50, 50);
        toast.show();
    }

    public void exitApp(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Thanks for using The CS Academy App on Computer Science For O'Level!", Toast.LENGTH_SHORT);
        toast.setMargin(50, 50);
        toast.show();
        finish();
        System.exit(0);
    }

    public void AboutDiag(View view) {
        Intent abtdialog = new Intent(this, ExitDialog.class);
        startActivity(abtdialog);
    }

    private void openDialog() {
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "About");
    }

    public void ShowExitAppDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Exit Application");
        builder.setMessage("Are your Sure? Exit Application!");
        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Thanks for Using the App!",Toast.LENGTH_LONG).show();
                finish();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You are not gonna leave the App!",Toast.LENGTH_LONG).show();
                //finish();
            }
        });

        builder.create().show();
    }


    public void DataTypes(View view) {
        Intent datatypes = new Intent(this, Data_Types.class);
        startActivity(datatypes);
    }
    public void VariablesConstants(View view) {
        Intent variableconstants = new Intent(this, Variables_Identifiers.class);
        startActivity(variableconstants);
    }
    public void OperatorsALR(View view) {
        Intent operatorsalr = new Intent(this, OperatorsAll.class);
        startActivity(operatorsalr);
    }
    public void Calculations(View view) {
        Intent calculations = new Intent(this, CalculationsSums.class);
        startActivity(calculations);
    }
    public void LoopsIterations(View view) {
        Intent loopsiterations = new Intent(this, LoopsRepetition.class);
        startActivity(loopsiterations);
    }
    public void SelectionConditionals(View view) {
        Intent selectionconditionals = new Intent(this, SelectionConditions.class);
        startActivity(selectionconditionals);
    }
    public void CaseValueOf(View view) {
        Intent casevalueof = new Intent(this, CaseValueOf.class);
        startActivity(casevalueof);
    }
    public void DataValidations(View view) {
        Intent datavalidations = new Intent(this, ValidationChecks.class);
        startActivity(datavalidations);
    }
    public void CountersCounting(View view) {
        Intent counterscounting = new Intent(this, CountersIncDec.class);
        startActivity(counterscounting);
    }

//    public void DryRun(View view) {
//        Intent dryrun = new Intent(this, DryRuns.class);
//        startActivity(dryrun);
//    }
//
//    public void TraceTables(View view) {
//        Intent tracetables = new Intent(this, TraceTable.class);
//        startActivity(tracetables);
//    }


    public int calcHeight(float value){
        return (int)(dpHeight*(value/designHeight));
    }

    public int calcWidth(float value){
        return (int)(dpWidth * (value/designWidth));
    }


}