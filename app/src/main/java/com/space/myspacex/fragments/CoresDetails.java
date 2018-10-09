package com.space.myspacex.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.space.myspacex.Activity.AppUtils;
import com.space.myspacex.R;
import com.space.myspacex.model.Core;
import com.space.myspacex.model.MasterJson;
import com.space.myspacex.model.Payload;

import java.util.ArrayList;
import java.util.List;


public class CoresDetails extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private List<Core> coresDetails;
    private TextView txtCoreSerial;
    private TextView txtFlight;
    private TextView txtblock;
    private TextView txtReused;
    private TextView txtLandSuccess;
    private TextView txtLandingIntent;
    private TextView txtLandingType;
   private TextView txtLandingVehicle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.layout_cores_details, container, false);
        txtCoreSerial = view.findViewById(R.id.txt_core_serial);
        txtFlight = view.findViewById(R.id.txt_flight);
        txtblock = view.findViewById(R.id.txt_block);
        txtReused = view.findViewById(R.id.txt_reused);
        txtLandSuccess = view.findViewById(R.id.txt_land_success);
        txtLandingIntent = view.findViewById(R.id.txt_landing_intent);
        txtLandingType = view.findViewById(R.id.txt_landing_type);
        txtLandingVehicle = view.findViewById(R.id.txt_landing_vehicle);

        Bundle bundle = getArguments();
        if (bundle != null) {
            MasterJson masterJson = (MasterJson) bundle.getParcelable(AppUtils.DETAILS);
            coresDetails = masterJson.getRocket().getFirstStage().getCores();
        }
        if (coresDetails != null) {
            for(int i=0;i<coresDetails.size();i++){
                txtCoreSerial.setText("CoreSerial : " + coresDetails.get(i).getCoreSerial());
                txtFlight.setText("Flight : " + coresDetails.get(i).getFlight());
                txtblock.setText("Block : " + coresDetails.get(i).getBlock());
                txtReused.setText("Reused : " + coresDetails.get(i).getReused());
                txtLandSuccess.setText("LandSuccess : " + coresDetails.get(i).getLandSuccess());
                txtLandingIntent.setText("LandingIntent : " + coresDetails.get(i).getLandingIntent());
                txtLandingType.setText("LandingType : " + coresDetails.get(i).getLandingType());
                txtLandingVehicle.setText("LandingVehicle : " + coresDetails.get(i).getLandingVehicle());

            }

        }
        return view;
    }


}
