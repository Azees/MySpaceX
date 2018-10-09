package com.space.myspacex.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.space.myspacex.Activity.AppUtils;
import com.space.myspacex.R;
import com.space.myspacex.model.Core;
import com.space.myspacex.model.Links;
import com.space.myspacex.model.MasterJson;
import com.space.myspacex.model.Payload;
import com.space.myspacex.model.Rocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RocketDetails extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private Rocket rocketDetails;
    private MasterJson masterJson;
    private List<Core> LandingLegsDetails;

    private TextView txtRocketId;
    private TextView txtRocketName;
    private Links rocktLinks;
    private TextView txtRocketType;
    // Engine Type  & Engine Version
   // private TextView txtMissionId;
// Landing Legs Number & Landing Legs Material
    private TextView txtLandSuccess;
    private TextView txtLandingIntent;
    private TextView txtLandingType;
    private TextView txtLandingVehicle;
    private Spinner list_links;
    ArrayList<Links> links_list;
    HashMap<String,String> hashMapLinks;
    String video_link;
    View view;
    String loadsearchkeyID;
    public RocketDetails() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.layout_rocket_details, container, false);
        txtRocketId = view.findViewById(R.id.txt_rocket_id);
        txtRocketName = view.findViewById(R.id.txt_rocket_name);
        txtRocketType = view.findViewById(R.id.txt_rocket_type);
      //  txtMissionId = view.findViewById(R.id.txt_mission_id);
        txtLandSuccess = view.findViewById(R.id.txt_land_success);
        txtLandingIntent = view.findViewById(R.id.txt_landing_intent);
        txtLandingType = view.findViewById(R.id.txt_landing_type);
        txtLandingVehicle = view.findViewById(R.id.txt_landing_vehicle);
        list_links = view.findViewById(R.id.links_list);
        Bundle bundle = getArguments();
        if (bundle != null) {
            masterJson =bundle.getParcelable(AppUtils.DETAILS);
            rocketDetails=masterJson.getRocket();
            rocktLinks=masterJson.getLinks();
            LandingLegsDetails= (List<Core>) masterJson.getRocket().getFirstStage().getCores();
        }
       /* if(masterJson!= null){
            txtMissionId.setText("MissionId   : " + masterJson.getMissionId());
        }*/
        if (rocketDetails != null) {
            txtRocketId.setText("RocketId : " + rocketDetails.getRocketId());
            txtRocketName.setText("RocketName : " + rocketDetails.getRocketName());
            txtRocketType.setText("RocketType : " + rocketDetails.getRocketType());
            }
        links_list=new ArrayList<Links>();
        links_list.add(rocktLinks);
        if(LandingLegsDetails!= null){
            for(int i=0;i<LandingLegsDetails.size();i++){
                txtLandSuccess.setText("LandSuccess : " + LandingLegsDetails.get(i).getLandSuccess());
                txtLandingIntent.setText("LandingIntent : " + LandingLegsDetails.get(i).getLandingIntent());
                txtLandingType.setText("LandingType : " + LandingLegsDetails.get(i).getLandingType());
                txtLandingVehicle.setText("LandingVehicle : " + LandingLegsDetails.get(i).getLandingVehicle());
            }

        }
       /* String mission_patch=rocktLinks.getMissionPatch();
        String mission_patch_small=rocktLinks.getMissionPatchSmall();
        String reddit_campaign=rocktLinks.getRedditCampaign();
        String reddit_launch=rocktLinks.getRedditLaunch();
        String reddit_recovery=rocktLinks.getRedditLaunch();
        String reddit_media=rocktLinks.getRedditMedia();
        String presskit=rocktLinks.getPresskit();
        String article_link=rocktLinks.getArticleLink();
        String wikipedia=rocktLinks.getWikipedia();
        String video_link=rocktLinks.getVideoLink();*/
        hashMapLinks=new HashMap<String,String>();
       /* hashMapLinks.put("mission_patch",rocktLinks.getMissionPatch());
        hashMapLinks.put("mission_patch_small",rocktLinks.getMissionPatchSmall());
        hashMapLinks.put("reddit_campaign",rocktLinks.getRedditCampaign());
        hashMapLinks.put("reddit_launch",rocktLinks.getRedditLaunch());
        hashMapLinks.put("reddit_recovery",rocktLinks.getRedditLaunch());
        hashMapLinks.put("reddit_media",rocktLinks.getRedditMedia());
        hashMapLinks.put("presskit",rocktLinks.getPresskit());
        hashMapLinks.put("article_link",rocktLinks.getArticleLink());*/
        hashMapLinks.put("wikipedia",rocktLinks.getWikipedia());
      //  hashMapLinks.put("video_link",rocktLinks.getVideoLink());

        List<StringWithTag> itemList = new ArrayList<StringWithTag>();
        for (Map.Entry<String, String> entry : hashMapLinks.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.d("hashmap values","hashmap values"+key+"  :"+ value);

           //  Build the StringWithTag List using these keys and values.
           // itemList.add(new StringWithTag("Select your favorite Link",""));
            itemList.add(new StringWithTag(key,value));
        }
        ArrayAdapter<StringWithTag> spinnerAdapter = new ArrayAdapter<StringWithTag>(getActivity(), android.R.layout.simple_spinner_item, itemList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list_links.setPrompt("Select your favorite Link!");
        list_links.setAdapter(spinnerAdapter);

        list_links.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setText("select Link");
                    tv.setVisibility(View.GONE);
                }else{
                    StringWithTag swt = (StringWithTag) parent.getItemAtPosition(position);
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
        return view;
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
   private static class StringWithTag {
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

       public StringWithTag(String name, String uri) {
           this.name = name;
           this.uri = uri;
       }

       @Override
       public String toString() {
           return name;
       }
       @Override
       public boolean equals(Object obj) {
           if(obj instanceof StringWithTag){
               StringWithTag c = (StringWithTag )obj;
               if(c.getName().equals(name) && c.getUri()==uri ) return true;
           }

           return false;
       }
   }
}
