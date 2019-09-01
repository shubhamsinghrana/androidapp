package com.example.startuppunjab;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class graphs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);
        BarChart barChart = (BarChart) findViewById(R.id.barchart);
        BarChart barChart2 = (BarChart) findViewById(R.id.barchart2);
        BarChart barChart3 = (BarChart) findViewById(R.id.barchart3);
        setTitle("");
        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();

        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(15f, 4));
        entries.add(new BarEntry(19f, 5));
        entries.add(new BarEntry(17f, 6));
        entries.add(new BarEntry(12f, 7));
        entries.add(new BarEntry(15f, 3));
        entries.add(new BarEntry(20f, 2));
        entries.add(new BarEntry(15f, 1));
        entries.add(new BarEntry(19f, 0));
        entries.add(new BarEntry(0f, 10));
        entries.add(new BarEntry(0f, 11));
        entries.add(new BarEntry(0f, 9));
        entries.add(new BarEntry(0f, 8));

        ArrayList<BarEntry> entries2 = new ArrayList<>();

        entries2.add(new BarEntry(16f, 4));
        entries2.add(new BarEntry(14f, 5));
        entries2.add(new BarEntry(18f, 6));
        entries2.add(new BarEntry(14f, 7));
        entries2.add(new BarEntry(15f, 1));
        entries2.add(new BarEntry(13f, 0));
        entries2.add(new BarEntry(11f, 2));
        entries2.add(new BarEntry(9f, 3));
        entries2.add(new BarEntry(0f, 10));
        entries2.add(new BarEntry(0f, 11));
        entries2.add(new BarEntry(0f, 9));
        entries2.add(new BarEntry(0f, 8));

        ArrayList<BarEntry> entries3 = new ArrayList<>();
        entries3.add(new BarEntry(4f, 4));
        entries3.add(new BarEntry(5f, 5));
        entries3.add(new BarEntry(4f, 6));
        entries3.add(new BarEntry(2f, 7));
        entries3.add(new BarEntry(5f, 3));
        entries3.add(new BarEntry(2f, 2));
        entries3.add(new BarEntry(2f, 1));
        entries3.add(new BarEntry(1f, 0));
        entries3.add(new BarEntry(0f, 10));
        entries3.add(new BarEntry(0f, 11));
        entries3.add(new BarEntry(0f, 9));
        entries3.add(new BarEntry(0f, 8));


        BarDataSet bardataset = new BarDataSet(entries, "Cells");
        BarDataSet bardataset2 = new BarDataSet(entries2, "Cells");
        BarDataSet bardataset3 = new BarDataSet(entries3, "Cells");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Jan");
        labels.add("Feb");
        labels.add("Mar");
        labels.add("Apr");
        labels.add("May");
        labels.add("Jun");
        labels.add("Jul");
        labels.add("Aug");
        labels.add("Sep");
        labels.add("Oct");
        labels.add("Nov");
        labels.add("Dec");

        BarData data = new BarData(labels, bardataset);
        BarData data2 = new BarData(labels, bardataset2);
        BarData data3 = new BarData(labels, bardataset3);
        barChart.setData(data);
        barChart2.setData(data2);
        barChart3.setData(data3);
        // set the data and list of lables into chart


        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        bardataset2.setColors(ColorTemplate.COLORFUL_COLORS);
        bardataset3.setColors(ColorTemplate.COLORFUL_COLORS);

        barChart.animateY(5000);
        barChart2.animateY(5000);
        barChart3.animateY(5000);


    }
}
