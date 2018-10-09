package com.space.myspacex.fragments;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.space.myspacex.Activity.AppUtils;
import com.space.myspacex.R;
import com.space.myspacex.model.Links;
import com.space.myspacex.model.MasterJson;
import com.space.myspacex.model.Payload;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LaunchDetails extends Fragment {
    private MasterJson masterJson;
    private ArrayList<Payload> cusomerDetails;
    private Links broswertLinks;
    ArrayList<Links> links_list;
    // flignt
    private TextView txtFlightNumber;
    private TextView txtmissionName;

    // Launch
    private TextView txtLaunchYear;
    private TextView txtLaunchDateUnix;
    private TextView txtLaunchDateUtc;
    private TextView txtLaunchDateLocal;
    private TextView txtIsTentative;
    private TextView txtTentativeMaxPrecision;
    // rocket  .. reuse count and status of rocket cores
    private TextView txtCustomers;
    private Spinner list_links;
    String video_link;
    HashMap<String,String> hashMapLinks;
    String loadsearchkeyID;
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_lanch_details, container, false);
        txtFlightNumber = view.findViewById(R.id.txt_flight_number);
        txtmissionName = view.findViewById(R.id.txt_mission_name);
        // txtMissionId = view.findViewById(R.id.txt_mission_id);
        txtLaunchYear = view.findViewById(R.id.txt_launch_year);
        txtLaunchDateUnix = view.findViewById(R.id.txt_launch_date_unix);
        txtLaunchDateUtc = view.findViewById(R.id.txt_launch_date_utc);
        txtLaunchDateLocal = view.findViewById(R.id.txt_launch_date_local);
        list_links = view.findViewById(R.id.links_LaunchList);
       // txtIsTentative = view.findViewById(R.id.txt_is_tentative);
//        txtTentativeMaxPrecision = view.findViewById(R.id.txt_tentative_max_precision);
        txtCustomers = view.findViewById(R.id.txt_customers);
        // txtLaunchYear = view.findViewById(R.id.txt_launch_year);
        Bundle bundle = getArguments();
        if (bundle != null) {
            masterJson = bundle.getParcelable(AppUtils.DETAILS);
            cusomerDetails = (ArrayList<Payload>) masterJson.getRocket().getSecondStage().getPayloads();
            broswertLinks = masterJson.getLinks();
        }
        if (masterJson != null) {
            txtFlightNumber.setText("FlightNumber  : " + masterJson.getFlightNumber());
            txtmissionName.setText("MissionName  : " + masterJson.getMissionName());
            //  txtMissionId.setText("MissionId   : " + masterJson.getMissionId());
            txtLaunchYear.setText("LaunchYear : " + masterJson.getLaunchYear());
            txtLaunchDateUnix.setText("LaunchDateUnix : " + getDate(masterJson.getLaunchDateUnix(), "dd/MM/yyyy hh:mm:ss.SSS"));
            txtLaunchDateUtc.setText("LaunchDateUtc : " + Date.from(Instant.parse(masterJson.getLaunchDateUtc())));
            txtLaunchDateLocal.setText("LaunchDateLocal : " +OffsetDateTime.parse( masterJson.getLaunchDateLocal()));
          //  txtIsTentative.setText("IsTentative : " + masterJson.getIsTentative());
            //txtTentativeMaxPrecision.setText("TentativeMaxPrecision : " + masterJson.getTentativeMaxPrecision());
        }
        if (cusomerDetails != null) {
            for (int i = 0; i < cusomerDetails.size(); i++) {
                txtCustomers.setText("Customers : " + cusomerDetails.get(i).getCustomers());
            }
        }
        links_list=new ArrayList<Links>();
        links_list.add(broswertLinks);
        hashMapLinks=new HashMap<String,String>();
        hashMapLinks.put("wikipedia",broswertLinks.getWikipedia());
        hashMapLinks.put("video_link",broswertLinks.getVideoLink());
        List<StringWithUrl> itemList = new ArrayList<StringWithUrl>();
        for (Map.Entry<String, String> entry : hashMapLinks.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.d("hashmap values","hashmap values"+key+"  :"+ value);

            //  Build the StringWithTag List using these keys and values.
            // itemList.add(new StringWithTag("Select your favorite Link",""));
            itemList.add(new StringWithUrl(key,value));
        }
        ArrayAdapter<StringWithUrl> spinnerAdapter = new ArrayAdapter<StringWithUrl>(getActivity(), android.R.layout.simple_spinner_item, itemList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        list_links.setAdapter(spinnerAdapter);

        list_links.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                }else{
                    StringWithUrl swt = (StringWithUrl) parent.getItemAtPosition(position);
                    loadsearchkeyID = swt.uri;
                    Log.d("hashmap values","swt.uri"+swt.uri+"  :");
                    if(loadsearchkeyID==video_link){
                        redirecttoApp(loadsearchkeyID);
                    }else{
                        if(loadsearchkeyID!=null){
                            callActionView(loadsearchkeyID);
                        }

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private String getDate(Integer milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    private static class StringWithUrl {
        private String uri;
        private String name;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public StringWithUrl(String name, String uri) {
            this.name = name;
            this.uri = uri;
        }

        @Override
        public String toString() {
            return name;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof StringWithUrl){
                StringWithUrl c = (StringWithUrl)obj;
                if(c.getName().equals(name) && c.getUri()==uri ) return true;
            }

            return false;
        }
    }
    //action for url
    private   void callActionView(String url) {
        Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        viewIntent.setData(Uri.parse(url));
        startActivity(viewIntent);
    }

    //action for redirecting app
    private  void redirecttoApp(String videoUrl) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoUrl));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + videoUrl));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
